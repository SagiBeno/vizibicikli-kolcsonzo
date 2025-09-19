package org.example;

public class Kolcsonzes {
    private String nev;
    private char jarmu;
    private int elvitelOra;
    private int elvitelPerc;
    private int VisszaOra;
    private int visszaPerc;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setJarmu(char jarmu) {
        this.jarmu = jarmu;
    }

    public char getJarmu() {
        return jarmu;
    }

    public int getElvitelOra() {
        return elvitelOra;
    }

    public void setElvitelOra(int elvitelOra) {
        this.elvitelOra = elvitelOra;
    }

    public int getElvitelPerc() {
        return elvitelPerc;
    }

    public void setElvitelPerc(int elvitelPerc) {
        this.elvitelPerc = elvitelPerc;
    }

    public void setVisszaOra(int visszaOra) {
        VisszaOra = visszaOra;
    }

    public int getVisszaOra() {
        return VisszaOra;
    }

    public int getVisszaPerc() {
        return visszaPerc;
    }

    public void setVisszaPerc(int visszaPer) {
        this.visszaPerc = visszaPer;
    }

    public Kolcsonzes() {
        // TODO - test field value
    }

    public Kolcsonzes(
            String nev,
            char jarmu,
            int elvitelOra,
            int elvitelPerc,
            int visszaOra,
            int visszaPerc
    ) {
        setNev(nev);
        setJarmu(jarmu);
        setElvitelOra(elvitelOra);
        setElvitelPerc(elvitelPerc);
        setVisszaOra(visszaOra);
        setVisszaPerc(visszaPerc);
    }

    public Kolcsonzes(String fileLine) {
        // parse read line
        String[] split = fileLine.split(";");
        setNev(split[0]);
        setJarmu(split[1].charAt(0));
        setElvitelOra(Integer.parseInt(split[2]));
        setElvitelPerc(Integer.parseInt(split[3]));
        setVisszaOra(Integer.parseInt(split[4]));
        setVisszaPerc(Integer.parseInt(split[5]));
    }

    public static String kolcsonzesLekerdezes(String nev) {

        String kiiras = "    " + nev + " kölcsönzései:\n";
        String eredmeny = "";
        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

            if (Main.kolcsonzesek.get(i).getNev().toLowerCase().equals(nev.toLowerCase())) {
                eredmeny += "    " + Main.kiegeszites(Main.kolcsonzesek.get(i).getElvitelOra()) + ":" + Main.kiegeszites(Main.kolcsonzesek.get(i).getElvitelPerc()) + " - " + Main.kiegeszites(Main.kolcsonzesek.get(i).getVisszaOra()) + ":" + Main.kiegeszites(Main.kolcsonzesek.get(i).getVisszaPerc()) + "\n";
            }
        }

        if (eredmeny.length() > 0) {
            kiiras += eredmeny;
            return kiiras;
        } else {
            kiiras = "Nem volt ilyen nevű kölcsönző!";
            return kiiras;
        }
    }
}

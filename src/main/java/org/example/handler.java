package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class handler {

    public static void fileBeolvasas(String fileName) throws FileNotFoundException {
        Main.kolcsonzesek = new ArrayList<>();

        File fbe = new File("sourceFiles/kolcsonzesek.txt");
        Scanner sbe = new Scanner(fbe);
        sbe.nextLine(); // fejléc kihagyása
        while (sbe.hasNextLine()) {
            String fileLine = sbe.nextLine();
            Main.kolcsonzesek.add(new Kolcsonzes(fileLine));
        }
    }

    public static String kiegeszites(int szam) {

        String eredmeny = "";
        if (szam < 10) {
            eredmeny = "0" + String.valueOf(szam);
            return eredmeny;
        }

        else {
            eredmeny = String.valueOf(szam);
            return eredmeny;
        }
    }

    public static String kolcsonzesLekerdezes(String nev) {

        String kiiras = "    " + nev + " kölcsönzései:\n";
        String eredmeny = "";
        for (Kolcsonzes k : Main.kolcsonzesek) {

            if (k.getNev().equalsIgnoreCase(nev)) {
                eredmeny += "    " + kiegeszites(k.getElvitelOra()) + ":" + kiegeszites(k.getElvitelPerc()) + " - " + kiegeszites(k.getVisszaOra()) + ":" + kiegeszites(k.getVisszaPerc()) + "\n";
            }
        }

        if (!eredmeny.isEmpty()) {
            kiiras += eredmeny;
            return kiiras;
        } else {
            kiiras = "Nem volt ilyen nevű kölcsönző!";
            return kiiras;
        }
    }

    public static String vizenlevoJarmuvek(String idopont) {

        String[] idopontTomb = idopont.split(":");
        int ora = Integer.parseInt(idopontTomb[0]);
        int perc = Integer.parseInt(idopontTomb[1]);
        int idoPerben = ora * 60 + perc;
        String eredmeny = "";

        for (Kolcsonzes k : Main.kolcsonzesek) {
            int kezdet = k.getElvitelOra() * 60 + k.getElvitelPerc();
            int veg   = k.getVisszaOra()  * 60 + k.getVisszaPerc();

            if (kezdet <= idoPerben && idoPerben < veg) {
                eredmeny += "    " + kiegeszites(k.getElvitelOra()) + ":" + kiegeszites(k.getElvitelPerc()) + " - " + kiegeszites(k.getVisszaOra()) + ":" + kiegeszites(k.getVisszaPerc()) + " : " + k.getNev() + "\n";
            }
        }
        return eredmeny;
    }

    public static int bevetel() {
        int bevetel = 0;
        return 1;
    }

    public static void FJarmu(String filename) throws IOException {
        File fki = new File(filename);
        FileWriter fwki = new FileWriter(fki);
        for (Kolcsonzes k : Main.kolcsonzesek) {

            if (k.getJarmu() == 'F') {
                fwki.write(kiegeszites(k.getElvitelOra()) + ":" + kiegeszites(k.getElvitelPerc()) + " - " + kiegeszites(k.getVisszaOra()) + ":" + kiegeszites(k.getVisszaPerc()) + " - " + k.getNev() + "\n");
            }
        }
        fwki.close();
    }

    public static List<Character> jarmuTipusok() {
        List<Character> jarmuTipusok = new ArrayList<>();
        for (Kolcsonzes k : Main.kolcsonzesek) {

            if (!jarmuTipusok.contains(k.getJarmu())) {
                jarmuTipusok.add(k.getJarmu());
            }
        }
        Collections.sort(jarmuTipusok);
        return jarmuTipusok;
    }

    public static int statisztika(Character jarmuTipus) {

        int szamlalo = 0;
        for (Kolcsonzes k : Main.kolcsonzesek) {
            if (k.getJarmu() == jarmuTipus) {
                szamlalo++;
            }
        }
        return szamlalo;
    }
}

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
        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

            if (Main.kolcsonzesek.get(i).getNev().toLowerCase().equals(nev.toLowerCase())) {
                eredmeny += "    " + kiegeszites(Main.kolcsonzesek.get(i).getElvitelOra()) + ":" + kiegeszites(Main.kolcsonzesek.get(i).getElvitelPerc()) + " - " + kiegeszites(Main.kolcsonzesek.get(i).getVisszaOra()) + ":" + kiegeszites(Main.kolcsonzesek.get(i).getVisszaPerc()) + "\n";
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

    public static String vizenlevoJarmuvek(String idopont) {

        String[] idopontTomb = idopont.split(":");
        int ora = Integer.parseInt(idopontTomb[0]);
        int perc = Integer.parseInt(idopontTomb[1]);

        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

        }
        return null;
    }

    public static int bevetel() {
        int bevetel = 0;
        return 1;
    }

    public static void FJarmu(String filename) throws IOException {
        File fki = new File(filename);
        FileWriter fwki = new FileWriter(fki);
        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

            if (Main.kolcsonzesek.get(i).getJarmu() == 'F') {
                fwki.write(kiegeszites(Main.kolcsonzesek.get(i).getElvitelOra()) + ":" + kiegeszites(Main.kolcsonzesek.get(i).getElvitelPerc()) + " - " + kiegeszites(Main.kolcsonzesek.get(i).getVisszaOra()) + ":" + kiegeszites(Main.kolcsonzesek.get(i).getVisszaPerc()) + " : " + Main.kolcsonzesek.get(i).getNev() + "\n");
            }
        }
        fwki.close();
    }

    public static List<Character> jarmuTipusok() {
        List<Character> jarmuTipusok = new ArrayList<>();
        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

            if (!jarmuTipusok.contains(Main.kolcsonzesek.get(i).getJarmu())) {
                jarmuTipusok.add(Main.kolcsonzesek.get(i).getJarmu());
            }
        }
        Collections.sort(jarmuTipusok);
        return jarmuTipusok;
    }

    public static int statisztika(Character jarmuTipus) {

        int szamlalo = 0;
        for (int i = 0; i < Main.kolcsonzesek.size(); i++) {

            if (Main.kolcsonzesek.get(i).getJarmu() == jarmuTipus) {
                szamlalo++;
            }
        }

        return szamlalo;
    }
}

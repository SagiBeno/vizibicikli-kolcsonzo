package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class handler {

    public static void fileBeolvasas(String fileName) throws FileNotFoundException {
        Main.kolcsonzesek = new ArrayList<>();

        File fbe = new File(fileName);
        Scanner sbe = new Scanner(fbe);
        sbe.nextLine(); // fejléc kihagyása
        while (sbe.hasNextLine()) {
            String fileLine = sbe.nextLine();
            Main.kolcsonzesek.add(new Kolcsonzes(fileLine));
        }
    }

    public static String kiegeszites(int szam) {

        String eredmeny;
        if (szam < 10) {
            eredmeny = "0" + szam;
        }

        else {
            eredmeny = String.valueOf(szam);
        }
        return eredmeny;
    }

    public static String kolcsonzesLekerdezes(String nev) {

        String kiiras = "    " + nev + " kölcsönzései:\n";
        StringBuilder eredmeny = new StringBuilder();
        for (Kolcsonzes k : Main.kolcsonzesek) {

            if (k.getNev().equalsIgnoreCase(nev)) {
                eredmeny.append("    ").append(kiegeszites(k.getElvitelOra())).append(":").append(kiegeszites(k.getElvitelPerc())).append(" - ").append(kiegeszites(k.getVisszaOra())).append(":").append(kiegeszites(k.getVisszaPerc())).append("\n");
            }
        }

        if (!eredmeny.isEmpty()) {
            kiiras += eredmeny;
        } else {
            kiiras = "    Nem volt ilyen nevű kölcsönző!";
        }
        return kiiras;
    }

    public static String vizenlevoJarmuvek(String idopont) {

        String[] idopontTomb = idopont.split(":");
        int ora = Integer.parseInt(idopontTomb[0]);
        int perc = Integer.parseInt(idopontTomb[1]);
        int idoPerben = ora * 60 + perc;
        StringBuilder eredmeny = new StringBuilder();

        for (Kolcsonzes k : Main.kolcsonzesek) {
            int kezdet = k.getElvitelOra() * 60 + k.getElvitelPerc();
            int veg   = k.getVisszaOra()  * 60 + k.getVisszaPerc();

            if (kezdet <= idoPerben && idoPerben < veg) {
                eredmeny.append("    ").append(kiegeszites(k.getElvitelOra())).append(":").append(kiegeszites(k.getElvitelPerc())).append(" - ").append(kiegeszites(k.getVisszaOra())).append(":").append(kiegeszites(k.getVisszaPerc())).append(" : ").append(k.getNev()).append("\n");
            }
        }

        if (eredmeny.isEmpty()) {
            eredmeny = new StringBuilder("    Nincs jármű a megadott időpontban!");
        }
        return eredmeny.toString();
    }

    public static int bevetel() {
        int bevetel = 0;
        for (Kolcsonzes k : Main.kolcsonzesek) {
            int perc = Math.abs((k.getVisszaOra() * 60 + k.getVisszaPerc()) - (k.getElvitelOra() * 60 + k.getElvitelPerc()));
            bevetel += ((perc + 29) / 30 * 2400); // +29 -> félórák felfele kerekítése (1 + 29) / 30 = 1 --> 2400 Ft
        }
        return bevetel;
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

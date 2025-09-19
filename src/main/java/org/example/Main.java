package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    1. feladat:
    @description Vizibicikli kölcsönző
 */
public class Main {
    private static List<Kolcsonzes> kolcsonzesek;

    private static void debugger () {
        int i = 0;
    }

    private static String kiegeszites(int szam) {

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

    public static void main(String[] args) throws FileNotFoundException {
        kolcsonzesek = new ArrayList<>();
        // 4. feladat:
        File fbe = new File("sourceFiles/kolcsonzesek.txt");
        Scanner sbe = new Scanner(fbe);
        sbe.nextLine(); // fejléc kihagyása
        while (sbe.hasNextLine()) {
            String fileLine = sbe.nextLine();
            kolcsonzesek.add(new Kolcsonzes(fileLine));
        }

        System.out.println("5. feladat: Napi kölcsönzések száma: " + kolcsonzesek.size());

        Scanner input = new Scanner(System.in);
        System.out.print("6. feladat: Kérek egy nevet: ");
        String nev = input.nextLine();

        String idopont = "";
        for (int i = 0; i < kolcsonzesek.size(); i++) {

            if (kolcsonzesek.get(i).getNev().toLowerCase().equals(nev.toLowerCase())) {
                idopont += "    " + kiegeszites(kolcsonzesek.get(i).getElvitelOra(i)) + ":" + kiegeszites(kolcsonzesek.get(i).getElvitelPerc(i)) + " - " + kiegeszites(kolcsonzesek.get(i).getVisszaOra(i)) + ":" + kiegeszites(kolcsonzesek.get(i).getVisszaPerc(i)) + "\n";
            }
        }

        if (idopont.length() > 0) {
            System.out.println("    Kata kölcsönzései: ");
            System.out.println(idopont);
        } else {
            System.out.println("Nem volt ilyen nevű kölcsönző!");
        }

        debugger();
    }
}
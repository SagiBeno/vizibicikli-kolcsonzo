package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/*
    1. feladat:
    @description Vizibicikli kölcsönző
 */
public class Main {
    public static boolean isRunningTest = false;
    private static final String testNev = "Kata";
    private static final String testIdopont = "10:9";

    public static List<Kolcsonzes> kolcsonzesek;

    private static void debugger () {
        int i = 0;
    }

    public static void main(String[] args) throws IOException {
        // 4. feladat:
        handler.fileBeolvasas("sourceFiles/kolcsonzesek.txt");

        System.out.println("5. feladat: Napi kölcsönzések száma: " + kolcsonzesek.size());

        Scanner input = new Scanner(System.in);
        System.out.print("6. feladat: Kérek egy nevet: ");
        String nev = isRunningTest ? testNev : input.nextLine();
        System.out.println(handler.kolcsonzesLekerdezes(nev));

        System.out.print("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String idopont = isRunningTest ? testIdopont : input.nextLine();
        System.out.println("    A vízen lévő járművek:\n" + handler.vizenlevoJarmuvek(idopont));

        handler.FJarmu("sourceFiles/F.txt");

        System.out.println("10. feladat: Statisztika");
        List<Character> jarmuTipusok = handler.jarmuTipusok();
        for (int i = 0; i < jarmuTipusok.size(); i++) {
            System.out.println("    " + jarmuTipusok.get(i) + " - " + handler.statisztika(jarmuTipusok.get(i)));
        }
        debugger();
    }
}
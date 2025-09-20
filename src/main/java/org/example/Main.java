package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    1. feladat:
    @description Vizibicikli kölcsönző
 */
public class Main {
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
        String nev = input.nextLine();
        System.out.println(handler.kolcsonzesLekerdezes(nev));

        System.out.print("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String idopont = input.nextLine();
        //handler.vizenlevoJarmuvek(idopont);

        handler.FJarmu("sourceFiles/F.txt");
        debugger();
    }
}
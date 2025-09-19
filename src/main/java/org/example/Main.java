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

        debugger();
    }
}
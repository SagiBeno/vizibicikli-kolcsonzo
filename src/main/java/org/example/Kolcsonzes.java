package org.example;

public class Kolcsonzes {
    private String nev;
    private char jarmu;
    private int elvitelOra;
    private int elvitelPerc;
    private int VisszaOra;
    private int visszaPer;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public char getJarmu() {
        return jarmu;
    }

    public void setJarmu(char jarmu) {
        this.jarmu = jarmu;
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

    public int getVisszaPer() {
        return visszaPer;
    }

    public void setVisszaPer(int visszaPer) {
        this.visszaPer = visszaPer;
    }
}

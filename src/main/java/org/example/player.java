package org.example;

public class player {
    private final String nev;
    private final char jel;

    public player(String nev, char jel) {
        this.nev = nev;
        this.jel = jel;
    }

    public String getNev() {
        return nev;
    }

    public char getJel() {
        return jel;
    }
}

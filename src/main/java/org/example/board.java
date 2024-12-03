package org.example;

public class board {
    private final char[][] grid;
    private final int sor = 6;
    private final int oszlop = 7;
    private final char cella = '_';

    public board() {
        grid = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                grid[i][j] = cella;
            }
        }
    }

    public boolean lepes(int col, char szimbolum) {
        if (col < 0 || col >= oszlop || grid[0][col] != cella) {
            return false; //ha nem ertelmezheto a lepes akkor false visszateresi ertek
        }

        for (int i = sor - 1; i >= 0; i--) {
            if (grid[i][col] == cella) {
                grid[i][col] = szimbolum;
                return true;
            }
        }
        return false;
    }

    public void tablaKiir() {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean tablaMegtelt() {
        for (int j = 0; j < oszlop; j++) {
            if (grid[0][j] == cella) {
                return false;
            }
        }
        return true;
    }

    public boolean nyeresEll(char szimbolum) {
        return vizszintesEll(szimbolum) || fuggolegesEll(szimbolum) || atloEll(szimbolum);
        //nyeres ellenorzes
    }

    private boolean vizszintesEll(char szimbolum) {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == szimbolum && grid[i][j + 1] == szimbolum && grid[i][j + 2] == szimbolum && grid[i][j + 3] == szimbolum) {
                    return true;//letezik 3egymas melletti szimbolum (nyert)
                }
            }
        }
        return false;
        //nyeres ellenorzes vizszintes
    }

    private boolean fuggolegesEll(char szimbolum) {
        for (int i = 0; i <= sor - 4; i++) {
            for (int j = 0; j < oszlop; j++) {
                if (grid[i][j] == szimbolum && grid[i + 1][j] == szimbolum && grid[i + 2][j] == szimbolum && grid[i + 3][j] == szimbolum) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean atloEll(char szimbolum) {
            // /
        for (int i = 3; i < sor; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == szimbolum && grid[i - 1][j + 1] == szimbolum && grid[i - 2][j + 2] == szimbolum && grid[i - 3][j + 3] == szimbolum) {
                    return true;
                }
            }
        }
        // \
        for (int i = 0; i <= sor - 4; i++) {
            for (int j = 0; j <= oszlop - 4; j++) {
                if (grid[i][j] == szimbolum && grid[i + 1][j + 1] == szimbolum && grid[i + 2][j + 2] == szimbolum && grid[i + 3][j + 3] == szimbolum) {
                    return true;
                }
            }
        }
        return false;
    }
}

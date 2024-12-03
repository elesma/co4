import org.example.player;
import org.example.board;

import java.util.Scanner;


public void main() {
    mainst game = new mainst();
    game.inditas();
}


public class mainst {
    private final board board;
    private final player player1;
    private final player player2;

    public mainst() {
        board = new board();
        player1 = new player("Jatekos 1", 'X');
        player2 = new player("Jatekos 2", 'O');
    }

    public void inditas() {
        Scanner scanner = new Scanner(System.in);
        player currentPlayer = player1;

        while (true) {
            board.tablaKiir();
            System.out.println(currentPlayer.getNev() + " kovetkezik. Jele: " + currentPlayer.getJel() + " Irj be egy szamot 0-6 kozott");
            int col = scanner.nextInt();

            if (!board.lepes(col, currentPlayer.getJel())) {
                System.out.println("Helytelen mezo, nem sikerult lepni!");
                continue;
            }

            if (board.nyeresEll(currentPlayer.getJel())) {
                board.tablaKiir();
                System.out.println(currentPlayer.getNev() + " gyozott!");
                break;
            }

            if (board.tablaMegtelt()) {
                board.tablaKiir();
                System.out.println("Dontetlen!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        scanner.close();
    }


}

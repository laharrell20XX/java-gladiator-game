import java.util.Scanner;

public class GladiatorGameRunner {

    public static void main(String[] args) {
        Gladiator bob = new Gladiator("attacker", 100, 0, 5, 15);
        Gladiator bill = new Gladiator("defender", 100, 0, 5, 15);
        GladiatorGame game = new GladiatorGame(bob, bill);
        while (!game.isGameOver()) {
            System.out.println(bill);
            System.out.println(bob);
            run(game);
        }
        System.out.println(game.getDefender().getName() + " wins!");
    }
    private static void run(GladiatorGame game) {
        TurnResult result = game.attack();
        System.out.println(result);
        game.swapTurns();
    }

}

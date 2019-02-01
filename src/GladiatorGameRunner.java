import java.util.Scanner;

public class GladiatorGameRunner {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        Gladiator bob = new Gladiator(getName(), 100, 0, 5, 15);
        Gladiator bill = new Gladiator(getName(), 100, 0, 5, 15);
        GladiatorGame game = new GladiatorGame(bob, bill);
        while (!game.isGameOver()) {
            System.out.println(bill);
            System.out.println(bob);
            run(game);
        }
        System.out.println(game.getDefender().getName() + " wins!");
    }
    private static void run(GladiatorGame game) {
        String resultStr = processDecision(game, getDecision(game.getAttacker().getName()));
        System.out.println(resultStr);
        game.swapTurns();
    }

    private static String processDecision(GladiatorGame game, int decision) {
        TurnResult result = new TurnResult(game.getAttacker(), game.getDefender());
        String resultStr = "";
        if (decision == 1) {
            game.attack();
            resultStr=result.attackTurnResult();
        }
        if (decision == 2) {
            if (game.heal()) {resultStr = result.healTurnResult();}
            else {resultStr = result.failHealTurnResult();}
        }
        if (decision == 3) {
            resultStr = result.passTurnResult();
        }
        return resultStr;
    }

    private static String getName() {
        System.out.println("Player, what is your gladiator name?\n>>> ");
        String playerName = stdin.nextLine();
        System.out.println(playerName + " has entered the arena\n");
        return playerName;
    }
    private static int getDecision(String attackerName) {
        boolean isValidDecision = false;
        int decision = 0;
        while (!isValidDecision) {
            System.out.println(attackerName + ", what do you want to do?");
            System.out.println("1: attack");
            System.out.println("2: heal");
            System.out.println("3: pass\n>>>");
            decision = stdin.nextInt();
            if (isValidDecision(decision)) {isValidDecision = true;}
        }
        return decision;
    }

    private static boolean isValidDecision(int decision) {
        return decision >= 1 && decision <= 3;
    }
}

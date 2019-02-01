public class TurnResult {
    private Gladiator attacker;
    private Gladiator defender;

    public TurnResult(Gladiator ag, Gladiator dg) {
        attacker = ag;
        defender = dg;
    }

    public String attackTurnResult() {
        int lastDamageDealt = attacker.getLastDamageDealt();
        return String.format("\n %s attacked %s for %s damage\n", attacker.getName(), defender.getName(), lastDamageDealt);
    }
    public String healTurnResult() {
        int lastHeal = attacker.getLastHeal();
        return String.format("\n %s healed by %s ", attacker.getName(), lastHeal);
    }
    public String passTurnResult() {
        return String.format("\n %s took a nice nap and missed a turn", attacker.getName());
    }
    public String failHealTurnResult() {
        return String.format("\n %s's shouting didn't make anybody feel better (0 points healed)", attacker.getName());
    }
}

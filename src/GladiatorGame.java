 class GladiatorGame {
    private Gladiator attacker;
    private Gladiator defender;

    GladiatorGame(Gladiator gladiator1, Gladiator gladiator2){
        attacker = gladiator1;
        defender = gladiator2;
    }

    Gladiator getAttacker() {
        return attacker;
    }

    Gladiator getDefender() {
        return defender;
    }

    void attack() {
        int damageToDeal = attacker.getAttackDmg();
        int defenderHealth = defender.getCurHealth();
        if (attacker.canCrit()) {
            damageToDeal = damageToDeal * 2;
            attacker.setRage(0);
        }
        else {
            attacker.setRage(attacker.getRage() + 15);
        }
        defender.setCurHealth(defenderHealth - damageToDeal);
        attacker.setLastDamageDealt(damageToDeal);
    }
    boolean heal() {
        int attackerCurHealth = attacker.getCurHealth();
        if (attacker.canHeal()) {
            attacker.setCurHealth(Math.min(attackerCurHealth + 10, attacker.getMaxHealth()));
            attacker.setLastHeal(10);
            attacker.setRage(attacker.getRage() - 15);
            return true;
        }
        return false;
    }

    boolean isGameOver() {
        return defender.getCurHealth() <= 0 || attacker.getCurHealth() <= 0;
    }
    void swapTurns() {
        Gladiator temp;
        temp = defender;
        defender = attacker;
        attacker = temp;

    }
}

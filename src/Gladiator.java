import jdk.jshell.execution.Util;

public class Gladiator {
    private String name;
    private int curHealth;
    private int maxHealth;
    private int rage;
    private int damageLow;
    private int damageHigh;
    private int lastDamageDealt = 0;
    private int lastHeal = 0;


    public Gladiator(String setName,int setMaxHealth, int setRage, int setDL, int setDH){
        name = setName;
        maxHealth = setMaxHealth;
        curHealth = maxHealth;
        rage = setRage;
        damageLow = setDL;
        damageHigh = setDH;
    }

    public String getName() {
        return name;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getCurHealth() {
        return curHealth;
    }
    public void setCurHealth(int h) {
        this.curHealth = h;
    }
    public int getRage() {
        return rage;
    }
    public void setRage(int r) {
        this.rage = r;
    }

    @Override
    public String toString() {
        return String.format("%s: %s/%s HP ||| %s Rage", name, curHealth, maxHealth, rage);
    }
    public int getAttackDmg() {
        return Utility.randInt(damageLow, damageHigh + 1);
    }

    public int getLastDamageDealt() {
        return lastDamageDealt;
    }
    public void setLastDamageDealt(int lastDamageDealt) {
        this.lastDamageDealt = lastDamageDealt;
    }

    public boolean canCrit() {
//        checks to see if the gladiator has the ability to crit
        int critChance = Utility.randInt(1, 100);
        return critChance <= rage;
    }

    public boolean canHeal() {
//        checks to see if the gladiator can heal
        if (curHealth == maxHealth) {
            return false;
        }
        else if (curHealth + 10 >= maxHealth && rage >= 15) {
            return true;
        }
        return rage >= 15;
    }
    public int getLastHeal() {
        return lastHeal;
    }

    public void setLastHeal(int lastHeal) {
        this.lastHeal = lastHeal;
    }
}

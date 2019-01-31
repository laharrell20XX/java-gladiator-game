public class Gladiator {
    private String name;
    private int health;
    private int rage;
    private int damage_low;
    private int damage_high;


    public Gladiator(String setName,int setHealth, int setRage, int setDL, int setDH){
        name = setName;
        health = setHealth;
        rage = setRage;
        damage_low = setDL;
        damage_high = setDL;
    }

    public String getName() {
        return name;
    }
    public int getDamage_low() {
        return damage_low;
    }
    public int getDamage_high() {
        return damage_high;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int h) {
        health = h;
    }
    public int getRage() {
        return rage;
    }
    public void setRage(int r) {
        rage = r;
    }

    @Override
    public String toString() {
        return String.format("%s: %s HP ||| %s Rage", name, health, rage);
    }
}

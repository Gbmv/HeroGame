public class Characters  {

    // Atributs
    private int health ;
    private int maxHealth ;
    private int level ;
    private int experience ;
    private static int attack;

    // Getters
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }

    public int getAttack() {
        return attack;
    }



    // Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAttack(int attack) {
        this.attack  = attack;
    }


}

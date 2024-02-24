public class Characters {

    // Atributs
    protected int health;
    protected int maxHealth;
    protected int experience;
    protected int attack;

    //Constrctor
    public Characters( int maxHealth, int experience, int attack ) {
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.experience = experience;
        this.attack = attack;
    }


    // Getters
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

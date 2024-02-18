public class Enemy extends Characters{
    // Atributs
    private int health = 100;
    private int maxHealth = 100;
    private int experience = 35;
    private int attack = 25;

    public Enemy(int health, int maxHealth, int experience, int attack){
        this.health = health;
        this.maxHealth = maxHealth;
        this.experience = experience;
        this.attack = attack;
    }

}

public class Hero extends Characters {
    
    protected int level = 1;
    protected double xpRequise;



    public Hero(int maxHealth, int attack) {
        super(maxHealth, 0, attack);
        this.level = 1;
        this.attack = attack;
    }

    // Getters
    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    // Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Functions

    // Calcul of the damage to the enemy
    public void Attack(Enemy enemy, int attack) {
        enemy.setHealth( enemy.getHealth() - ( attack ));
    }

    // Calcule the damage to the hero
    public void Hurt(int attack) {
        health -= attack ;
    }

    public void Heal(int n) {
        health += n;
        if (health > maxHealth){
            FullHeal();
        }
    }

    public void FullHeal() {
        health = maxHealth;
    }

    public void Training(int n) {
        attack = attack + n;
    }

    public void LevelUp(int XpGotten) {

        experience += XpGotten; 

        xpRequise = 50 + (level + 1) * 20 * Math.pow(1.1, level + 1);

        if (experience >= xpRequise) {
            
            experience = 0;


            if (level < 99) {

                level++;
                attack += 6;
                maxHealth += 12;
                FullHeal();

            }
        }
        //return level;
    }
}

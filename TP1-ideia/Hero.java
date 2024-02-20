public class Hero extends Characters {
    ;
    private int level = 1;
    private double xpRequise;
    private int experience = 0;
    private int attack = 0;



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
        if (health > maxHealth);{
            FullHeal();
        }
    }

    public void FullHeal() {
        health = maxHealth;
    }

    public void Training(int n) {
        attack = attack + n;
    }

    public int LevelUp() {

//        experience += 12;

        xpRequise = 50 + (level + 1) * 20 * Math.pow(1.1, level + 1);
        System.out.println("Xp requise hero " + xpRequise);

        if (experience >= xpRequise) {

            System.out.println("Hero level increase");
            experience = 0;


            if (level < 99) {

                level++;
                attack += 6;
                maxHealth += 12;
                FullHeal();

            }
        }
        return level;
    }
}

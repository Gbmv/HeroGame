public class Hero extends Characters {
;
    private int level = 1;
    private double xpRequise;
    private int experience = 0; 
    private int attack = 0;

    // char primeiraLetra = Character.toLowerCase(frase.charAt(0)); Pra sabe se o
    // primeiro é letra a
    // if (priemiraLetra == 'a'){
    // }else if (primeiraLetra == 'd'){
    // }

    public Hero(int maxHealth, int attack) {
        super(maxHealth, 0, attack);
        this.level = 1;
        this.attack = attack;
      //this.xpRequise = xpRequise;  // ???
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

    public void Attack(Enemy enemy, int attack) {
        enemy.setHealth( enemy.getHealth() - ( attack ));
    }

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
        experience += 12;        //TODO: enemy experience is 12 by defaul, then changes LevelUP( enemy XP )

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

        return level;

    }
}

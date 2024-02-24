/*----------------------------------------------------------------------------
  Last Update: 24/02/2024
  Autors: Gabriel Barroso Magno Viana ( 20283304 )
          Pablo Hidalgo Etienne ( 20266668 )
----------------------------------------------------------------------------*/
public class Hero extends Characters {
    
    // Attributes
    protected int level = 1;
    protected double xpRequise;

    // Constructor
    public Hero( int maxHealth, int attack ) {
        super( maxHealth, 0, attack );
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
    public void setHealth( int health ) {
        this.health = health;
    }

    public void setLevel( int level ) {
        this.level = level;
    }


    // Methods

    // This method calculates the damage inflicted to an enemy during 
    //an attack and reduces the enemy's health by the same amount.
    public void Attack( Enemy enemy, int attack ) {
        enemy.setHealth( enemy.getHealth() - ( attack ) );
    }

    // This method calculates the damage taken by the hero and reduces 
    // the hero's health by the same amount.
    public void Hurt( int attack ) {
        health -= attack ;
    }

    // This method heals the hero by the specified amount.
    public void Heal( int n ) {
        health += n;
        if ( health > maxHealth ) {
            FullHeal();
        }
    }

    // This method fully heals the hero.
    public void FullHeal() {
        health = maxHealth;
    }

    // This method increases the hero's attack by the specified amount.
    public void Training( int n ) {
        attack = attack + n;
    }

    // This method level-Up the hero based on the experience gained 
    // and increases hero's maxHealth, attack and fully heals him.
    public void LevelUp( int XpGotten ) {
        experience += XpGotten; 
        xpRequise = 50 + ( level + 1 ) * 20 * Math.pow( 1.1, level + 1 );

        if ( experience >= xpRequise ) { 
            experience = 0;

            if ( level < 99 ) {
                level++;
                attack += 6;
                maxHealth += 12;
                FullHeal();
            }
        }
    }
}

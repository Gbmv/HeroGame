/*----------------------------------------------------------------------------
  Last Update: 24/02/2024
  Autors: Gabriel Barroso Magno Viana ( 20283304 )
          Pablo Hidalgo Etienne ( 20266668 )
----------------------------------------------------------------------------*/
public class Combat {

    // Attributes
    private Hero hero;
    private Enemy enemy;
    public static int enemiesDefeat;

    // Constructor
    public Combat( Hero hero, Enemy enemy ) {
        this.hero = hero;
        this.enemy = enemy;
    }


    // Methodes

    // This method simulates a fight between the hero and the enemy for a specified number of loops.
    // return true if the hero survives the fight, false if he dies.
    public boolean fight( int numLoop ) {

        for ( int i=0; i < numLoop; i++ ) {

            // Repeats while the hero is still alive or breaks if the enemy dies
            while ( hero.getHealth() > 0 ) {

                hero.Attack( enemy, hero.getAttack() );

                // if enemy is alive
                if ( enemy.getHealth() > 0 ) {

                    // Updates hero's health
                    hero.Hurt( enemy.getAttack() );


                }

                // if enemy is dead
                else {

                    enemiesDefeat++;

                    // Increase the enemy's attack points
                    enemy.setAttack( enemy.getAttack() + 5 );

                    // Increase the enemy's max health
                    enemy.setMaxHealth( enemy.getMaxHealth() + 10 );

                    // Getts the enemy's health to it's max to prepare the next combat
                    enemy.setHealth( enemy.getMaxHealth() );

                    // Increases the xp of the hero and checks if he leveled-Up
                    hero.LevelUp( enemy.getExperience() );

                    // Increases the xp of the enemy
                    enemy.setExperience( enemy.getExperience() + 8 );

                    break;
                }
            }
        }

        // Return false if the hero is dead
        // and true if he's alive
        if ( hero.getHealth() <= 0 ) {
            return false;

        } else {
            return true;
        }
    }
}

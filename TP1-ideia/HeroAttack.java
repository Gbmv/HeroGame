/*----------------------------------------------------------------------------
  Last Update: 24/02/2024
  Autors: Gabriel Barroso Magno Viana ( 20283304 )
          Pablo Hidalgo Etienne ( 20266668 )
----------------------------------------------------------------------------*/
public class HeroAttack extends Hero {

    // Attributes
    // no attributes

    // Constructor
    public HeroAttack( int level, int attack ) {
        super( level, attack );
    }
    
    // Overriding of the methode Attack froms Hero's class when hero's name start with the letter 'A'.
    @Override
    public void Attack( Enemy enemy, int attack ) {
        enemy.setHealth( enemy.getHealth() - ( attack * 2 ) );
    }

    // Overriding of the methode Hurt froms Hero's class when hero's name start with the letter 'A'.
    @Override
    public void Hurt( int attack ) {
        health -= attack * 2 ;
    }
}

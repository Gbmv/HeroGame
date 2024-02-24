public class HeroDefend extends Hero {
    
    // Attributes
    // no attributes

    // Constructor
    public HeroDefend( int level, int attack ) {
        super( level, attack );
    }
    
    // Overriding of the methode Attack froms Hero's class when hero's name start with the letter 'D'.
    @Override
    public void Attack( Enemy enemy, int attack ) {
        enemy.setHealth( enemy.getHealth() - ( attack / 2 ) );
    }

    // Overriding of the methode Hurt froms Hero's class when hero's name start with the letter 'D'.
    @Override
    public void Hurt( int attack ) {
        health -= attack / 2;
    }
}

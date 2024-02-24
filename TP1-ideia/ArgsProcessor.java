/*----------------------------------------------------------------------------
  Last Update: 24/02/2024
  Autors: Gabriel Barroso Magno Viana ( 20283304 )
          Pablo Hidalgo Etienne ( 20266668 )
----------------------------------------------------------------------------*/
public class ArgsProcessor {

    // Attributes
    private static final Enemy enemy = new Enemy();

    public static void process( String[] args ) {
        String[] phrase = makePhrase( args[0] );

        // Analise what is the first letter of the name of the Hero
        char firstLetter = phrase[0].charAt(0);

        // Hero health points
        int health = Integer.parseInt( phrase[1] );

        // Hero attack points
        int attack = Integer.parseInt( phrase[2] );

        // Creates a certain type of hero depending on the First Character ' ' on his name 
        Hero hero;
        if ( firstLetter == 'A' ) {
            // attack type hero
            hero = new HeroAttack( health, attack );
        } else if ( firstLetter == 'D' ) {
            // defend type hero
            hero = new HeroDefend( health, attack );
        } else {
            // normal Type hero
            hero = new Hero( health, attack );
        }

        // Repeats for the amount of actions on the input phrase
        for ( int i = 3; i < phrase.length; i++ ) {
            if ( !doAction( phrase[i], hero, enemy ) ) {
                System.out.println( "In his quest, " + phrase[0] + " died after beating " + Combat.enemiesDefeat +
                        " enemies and attaining level " + hero.getLevel() + "!" );
                return;
            }
        }
        System.out.println( "In his quest, " + phrase[0] + " beat " + Combat.enemiesDefeat + " enemies, attained level "
                + hero.getLevel() + " and survived with " + hero.getHealth() + " HP!" );
    }

    // Splits the input string into an array of phrases
    private static String[] makePhrase( String args ) {
        return args.trim().split( "," );
    }

    // Methode that takes the fragment of the phrase that describes the hero's action
    // and executes that action. Finaly returns true if the hero survives to the action.
    private static boolean doAction( String action, Hero hero, Enemy enemy ) {

        // Here we transform the String action in an array of Strings dividing words using spaces.
        String[] phrase = action.trim().split( " " );
        
        // The type of action is determined by the first word of the phrase
        switch ( phrase[0] ) {
            // Start the fight simulaation between the hero and a certain amount of enemies
            case "fought":
                Combat combat = new Combat( hero, enemy );
                if ( !combat.fight( Integer.parseInt( phrase[1] ) ) ) {
                    return false;
                }
                break;

            // Fully heals the hero
            case "rested":
                hero.FullHeal();
                break;
                
            // Add a certain amount of health points to the hero    
            case "healed":
                int healthAdded = Integer.parseInt( phrase[1] );
                hero.Heal( healthAdded );
                break;
            
            // Add a certain amount of attack points to the hero
            case "trained":
                int attackAdded = Integer.parseInt( phrase[3] );
                hero.setAttack( hero.getAttack() + attackAdded );
                break;
        }
        return true;
    }
}
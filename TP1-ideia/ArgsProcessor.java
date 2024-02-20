public class ArgsProcessor {
    private static final Enemy enemy = new Enemy();
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);

        // TODO : Handle the phrase and output the result

        // Analise what is the first letter of the name of the Hero
        char firstLetter = phrase[0].charAt(0);
        System.out.println(firstLetter); // debugger first letter




        // Hero health points
        int health = Integer.parseInt(phrase[1]);

        // Hero attack points
        int attack = Integer.parseInt(phrase[2]);

        Hero hero;
        if (firstLetter == 'A') {
            // Type attack
            hero = new HeroAttack(health, attack);
        } else if (firstLetter == 'D') {
            // Type defend
            hero = new HeroDefend(health, attack);
        } else {
            hero = new Hero(health, attack);
        }








//        Enemy enemy = new Enemy();

        for (int i = 3; i < phrase.length; i++) {
            if (!doAction(phrase[i], hero, enemy)) {
                System.out.println( "In his quest " + phrase[0]  +" died after beating " + Combat.enemiesDefeat +
                        " enemies and attaining level " + hero.getLevel() + "!");
                return;
            }
        }
        System.out.println("In his quest," + phrase[0] + " beat  " + Combat.enemiesDefeat + " enemies , attained level "
                + hero.getLevel() + " and survived with " + hero.getAttack() + "HP" );
    }


    //         Une façon de verifier si a une case fought, mais ne donne pas son valeur correct au final


    //        boolean anyFoughtAction = false;
//
//        for (String action : phrase) {
//            if (action.startsWith("fought")) {
//                anyFoughtAction = true;
//            } else {
//                if (!doAction(action, hero, enemy)) {
//                    System.out.println("In his quest " + phrase[0] + " died after beating " + Combat.enemiesDefeat +
//                            " enemies and attaining level " + hero.getLevel() + "!");
//                    return;
//                }
//            }
//        }
//
//        // If any "fought" action was found, process them now
//        if (anyFoughtAction) {
//            for (String action : phrase) {
//                if (action.startsWith("fought")) {
//                    if (!doAction(action, hero, enemy)) {
//                        System.out.println("In his quest " + phrase[0] + " died after beating " + Combat.enemiesDefeat +
//                                " enemies and attaining level " + hero.getLevel() + "!");
//                        return;
//                    }
//                }
//            }
//        }

    private static String[] makePhrase(String args) {
        return args.trim().split(",");
    }

    // méthode qui prend la partie de la phrase qui décrit l'action et le héros,
    // puis effectue l'action correspondante
    // retourne true si le joueur survit à l'action, false sinon
    private static boolean doAction(String action, Hero hero, Enemy enemy) {


        // ici, on transforme le String action en un tableau de String, en séparant les
        // mots par des espaces
        String[] phrase = action.trim().split(" ");
        // le type d'action est déterminé par le premier mot de la phrase
        System.out.println("action:  " + action);
        System.out.println("phrase:  " + phrase);
        System.out.println("------------------------------");




        switch (phrase[0]) {
            // System.out.println("switch: " + phrase [0]);
            case "fought":
                int enemies = Integer.parseInt(phrase[1]);
                for (int i = 0; i < enemies; i++) {
                    Combat combat = new Combat(hero, enemy);
                    if (!combat.fight(phrase)) {
                        return false;
                    }
                }
                break;
            case "rested":
                hero.FullHeal();
                System.out.println("hero status:   FULL_HEAL");
                break;
            case "healed":
                int healthAdded = Integer.parseInt(phrase[1]);
                hero.Heal(healthAdded);
                System.out.println("hero status: HEALED " + healthAdded + " HP!");
                break;
            case "trained":
                int attackAdded = Integer.parseInt(phrase[3]);
                hero.setAttack(hero.getAttack() + attackAdded);
//                hero.Training(attackAdded);
                System.out.println("hero status: TRAINED to get" + attackAdded + " Att!");
                break;
        }
        return true;
    }
}

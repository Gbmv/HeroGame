public class ArgsProcessor {
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);

        // TODO : Handle the phrase and output the result

        // Analise what is the first letter of the name of the Hero
        char firstLetter = phrase[0].charAt(0);
        System.out.println(firstLetter); // debugger first letter

        /*if (firstLetter == 'A') {
            // Type attack
            HeroAttack.toAttack();
        } else if (firstLetter == 'D') {
            // Type defend
            HeroDefend.toDefend();
        } else {
            //
        }*/

        
        // Hero health points
        int health = Integer.parseInt(phrase[1]);
        //System.out.println("SET: " + health);
        // Hero attack points
        int attack = Integer.parseInt(phrase[2]);

        // Giving the health points to the hero
        //hero.setHealth(health);
        //System.out.println("GET: " + hero.getHealth());

        // Giving the attack points to the hero
        //hero.setAttack(attack);
        
        
        Hero hero = new Hero(health, health, 1, 0, attack);

        //Enemy enemy = new Enemy(100, 35, 25);

        // Concertar
        for (int i = 0; i < phrase.length; i++) {
            // System.out.println(phrase[i] + "");
            // System.out.println("------------------------------");

            doAction(phrase[i], hero);
            // this loop must pick all the do allctions and give a full message in the end.
        }

    }

    private static String[] makePhrase(String args) {
        return args.trim().split(",");
    }

    // méthode qui prend la partie de la phrase qui décrit l'action et le héros,
    // puis effectue l'action correspondante
    // retourne true si le joueur survit à l'action, false sinon
    private static boolean doAction(String action, Hero hero) {
        
        Enemy enemy = new Enemy(100, 100, 35, 25);
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
                Combat combat = new Combat(hero, enemy);
                System.out.println(combat.fight(phrase));
                // TODO : Handle the fight
                break;
            case "rested":
                hero.FullHeal();
                System.out.println("hero status:   FULL_HEAL");
                // TODO : Handle the resting
                break;
            case "healed":
                int healthAdded = Integer.parseInt(phrase[1]);
                // Change for give an message
                hero.Heal(healthAdded);
                System.out.println("hero status: HEALED " + healthAdded + " HP!");
                // TODO : Handle the healing
                break;
            case "trained":
                int attackAdded = Integer.parseInt(phrase[3]);
                hero.Training(attackAdded);
                System.out.println("hero status: TRAINED to get" + attackAdded + " Att!");

                // TODO : Handle the training
                break;
        }
        return true;
    }
}

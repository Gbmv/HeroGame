public class ArgsProcessor {
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);

        //TODO : Handle the phrase and output the result

        // Analise what is the first letter of the name of the Hero
        char firstLetter = Character.toLowerCase(phrase[0].charAt(0));

        if (firstLetter == 'a') {
            // Type attack
            HeroAttack.toAttack();
        } else if (firstLetter == 'd') {
            // Type defend
            HeroDefend.toDefend();
        } else{
            //
        }

        Hero hero = new Hero();
        Enemy enemy = new Enemy();


        // Hero health points
        int health = Integer.parseInt(phrase[1]);

        // Hero attack points
        int attack = Integer.parseInt(phrase[2]);

        // Giving the health points to the hero
        hero.setHealth(health);
        // Giving the attack points to the hero
        hero.setAttack(attack);

        // Concertar
        for (int i = 0; i < phrase.length; i++ ){
            doAction(phrase[i],hero );
            // this loop must pick all the do allctions and give a full message in the end.
        }

    }

    private static String[] makePhrase(String args) {
        return args.trim().split(",");
    }

    // méthode qui prend la partie de la phrase qui décrit l'action et le héros, puis effectue l'action correspondante
    // retourne true si le joueur survit à l'action, false sinon
    private static boolean doAction(String action, Hero hero) {
        // ici, on transforme le String action en un tableau de String, en séparant les mots par des espaces
        String[] phrase = action.trim().split(" ");
        // le type d'action est déterminé par le premier mot de la phrase




        switch (phrase[0]) {
            case "fought":
                Combat combat  = new Combat();
                System.out.println(combat.fight(phrase));
                //TODO : Handle the fight
                break;
            case "rested":
                hero.fullHeal();
                //TODO : Handle the resting
                break;
            case "healed":
                int healthAdded = Integer.parseInt(phrase[1]);
                // Change for give an message
                hero.heal(healthAdded);
                //TODO : Handle the healing
                break;
            case "trained":
                int attackAdded = Integer.parseInt(phrase[3]);
                hero.training(attackAdded);
                //TODO : Handle the training
                break;
        }
        return true;
    }
}



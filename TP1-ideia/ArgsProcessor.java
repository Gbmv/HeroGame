public class ArgsProcessor{
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);

        char firstLetter = Character.toLowerCase(phrase[0].charAt(0));
        //TODO : Handle the phrase and output the result

        Hero hero = new Hero();
        Enemy enemy = new Enemy();

        if (firstLetter == 'a'){
            HeroAttack.toAttack();
        } else if (firstLetter == 'd') {
            HeroDefend.toDefend();
        }else{
        }

        int health = Integer.parseInt(phrase[1]);
        int attack =  Integer.parseInt(phrase[2]);

        hero.setHealth(health);
        hero.setAttack(attack);

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

                Enemy enemy = new Enemy();
                int heroAttack = hero.getAttack();
                int enemyAttack = enemy.getAttack();

               
            


                while (hero.getHealth()>0) {

                    int damageToEnemy = heroAttack; // Calcula o dano que o herói inflige
                    int damageToHero = enemyAttack; // Calcula o dano que o inimigo inflige

                    int newEnemyHealth = enemy.getHealth() - damageToEnemy;
                    int newHeroHealth = hero.getHealth() - damageToHero;

                    enemy.setHealth(newEnemyHealth); // Atualiza a saúde do inimigo
                    hero.setHealth(newHeroHealth); // Atualiza a saúde do herói

                    if ()

                }



                // hero.Attack()
                //TODO : Handle the fight
                break;
            case "rested":
                //TODO : Handle the resting
                break;
            case "healed":
                //TODO : Handle the healing
                break;
            case "trained":
                //TODO : Handle the training
                break;
        }
        return true;
    }

}

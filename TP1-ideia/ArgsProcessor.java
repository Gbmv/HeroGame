public class ArgsProcessor{
    public static void process(String[] args) {
        String[] phrase = makePhrase(args[0]);



        //TODO : Handle the phrase and output the result

        // Analise what is the first letter of the name of the Hero
        char firstLetter = Character.toLowerCase(phrase[0].charAt(0));

        if (firstLetter == 'a'){
            // Type attack
            HeroAttack.toAttack();
        } else if (firstLetter == 'd') {
            // Type defend
            HeroDefend.toDefend();
        }else{
        }

        Hero hero = new Hero();
        Enemy enemy = new Enemy();

        // Hero health points
        int health = Integer.parseInt(phrase[1]);

        // Hero attack points
        int attack =  Integer.parseInt(phrase[2]);

        // Giving the health points to the hero
        hero.setHealth(health);
        // Giving the attack points to the hero
        hero.setAttack(attack);

        doAction("fought", hero);

        

       
        
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

        Enemy enemy = new Enemy();
        int heroAttack = hero.getAttack();
        int enemyAttack = enemy.getAttack();

        
        
        
        boolean live = true;
        int enemiesDefeat = 0;
        String text = ""; 

    
        switch (phrase[0]) {
            case "fought":


                while(live) {
                    int numberEnemies = Integer.parseInt(phrase[1]);
                    for (int i = 0; i < numberEnemies; i++) {
                        



                        int damageToEnemy = heroAttack;
                        int damageToHero = enemyAttack;

                        

                        // Calcule of the damage to the enemy
                        int newEnemyHealth = enemy.getHealth() - damageToEnemy;
                        // Calculate the damage to the hero
                        int newHeroHealth = hero.getHealth() - damageToHero;


                        // Update the enemy health
                        enemy.setHealth(newEnemyHealth);
                        // Update the hero health
                        hero.setHealth(newHeroHealth);


                        // Enemy death
                        if (newEnemyHealth <= 0) {

                            // Reduce the number of enemies
                            numberEnemies--;

                            // No more Enemies alive
                            if (numberEnemies <= 0 ) {
                                live= false;
                                System.out.print("In his quest " + phrase[0] + " fought" +  enemiesDefeat);
                                //    System.out.print(text1););
                                
                                /*if (newHeroHealth >= 0) {
                                    // Hero survived in battle
                                    return live;
                                } else {
                                    // Hero died in battle
                                    return live  = false;
                                }*/
                                break;
                            }
                            // There are still enemies alive
                            else{
                                // Increase the attack point of the enemy
                                enemy.setAttack(enemy.getAttack() + 5);
                                // Increase the live point of the enemy
                                enemy.setHealth(enemy.getHealth() + 10);
                                // Increases the xp of the enemy
                                enemy.setExperience(enemy.getExperience() + 8);

                                // Increases the xp of the hero
                                hero.setExperience(hero.getExperience() + 10);
                                // Increases the number of enemies killed
                                enemiesDefeat++;
                            }
                        }

                        // Hero is death
                        else if (newHeroHealth<=0) {
                            live= false;
                            System.out.println( "In his quest, " + phrase[0] + "died after beating "+ enemiesDefeat + " enemies");
                            break;

                        }


                        // We need to make a logic to the level


                        /*
                        if (newHeroHealth <= 0) {
                            // Hero is death
                            return  live = false;
                        }

                         */

                         

                    }
                  if (live){
                    text = "In his quest " + phrase[0] + " fought" +  enemiesDefeat;
                  }
                  else{
                    text =  "In his quest, " + phrase[0] + "died after beating " + enemiesDefeat + " enemies";
                  }

                
                }break;

                // if (live) {
                //     System.out.print("In his quest, " + phrase[0] + " fought and survived after beating " + enemiesDefeat + " enemies");
                // } else {
                //     System.out.print("In his quest, " + phrase[0] + " died after beating " + enemiesDefeat + " enemies");
                // }   

                
                //return live;
                
              

                






                // hero.Attack()
                //TODO : Handle the fight
               
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
        System.out.println(text);
        return true;
        
    }
    

}


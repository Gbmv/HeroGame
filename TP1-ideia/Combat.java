public class Combat {
    
   private Hero hero;
   private Enemy enemy;

  public Combat(Hero hero, Enemy enemy) {
    this.hero = hero;
    this.enemy = enemy;
  }

    
  //int heroAttack = hero.getAttack();
  //int enemyAttack = enemy.getAttack();
  //int enemiesDefeat = 0; // counter of enemies defeted

    // Output
    String output;
    static int enemiesDefeat;
    

    public boolean fight(String[] phrase) {


        int heroAttack = hero.getAttack();
        int enemyAttack = enemy.getAttack();
        //int enemiesDefeat = 0; // counter of enemies defeted



        int numberEnemies = Integer.parseInt(phrase[1]);
        System.out.println("pre While 1 ");
        System.out.println("Hero Health: " + hero.getHealth());
        System.out.println("Number enemies: " + numberEnemies);

        for (int i=0; i < numberEnemies; i++   ){
        //while (hero.getHealth() > 0 && numberEnemies > 0) {
            System.out.println("While 1");

            //int damageToEnemy = heroAttack;
            System.out.println(hero.getAttack());
            //int damageToHero = enemyAttack;
            System.out.println(enemy.getAttack());


            while (hero.getHealth() > 0) {
                System.out.println("While 2 ");

                // Calcule of the damage to the enemy
                int newEnemyHealth = enemy.getHealth() - hero.getAttack();
                // Calculate the damage to the hero
                int newHeroHealth = hero.getHealth() - enemy.getAttack();

                // Update the enemy health
                enemy.setHealth(newEnemyHealth);
                System.out.println("enemyHP: " + newEnemyHealth);

                // Enemy death
                if (newEnemyHealth > 0) {

                    hero.setHealth(newHeroHealth);
                    System.out.println("heroHP: "+newHeroHealth);

                }

                else {

                    // Reduce the number of enemies
                    numberEnemies--;
                    System.out.println("#enemies: "+ numberEnemies);

                    // Increases the number of enemies killed
                    enemiesDefeat++;
                    System.out.println("enemies defeated: "+ enemiesDefeat);

                    // Increase the attack point of the enemy
                    enemy.setAttack(enemy.getAttack() + 5);
                    System.out.println("enemies attack: "+ enemy.getAttack());

                    // Increase the live point of the enemy
                    enemy.setMaxHealth(enemy.getMaxHealth() + 10);
                    System.out.println("enemies MaxHP: "+ enemy.getMaxHealth());

                    enemy.setHealth(enemy.getMaxHealth());
                    // Increases the xp of the enemy
                    enemy.setExperience(enemy.getExperience() + 8);
                    System.out.println("enemies XP: "+ enemy.getExperience());


                    // Increases the xp of the hero
                    hero.LevelUp();
                    System.out.println("pre BREAK ");
                    break;
                }
                System.out.println("inside");
            }
            System.out.println("outside");

        }

        if (hero.getHealth() <= 0) {
            output = "died after beating " + enemiesDefeat + " enemies and attaining level " + hero.getLevel() + "!"; // TODO:
            return false;                                                                                                          // did
                                                                                                                      // he
                                                                                                                      // Lv.
                                                                                                                      // UP?
        } else {
            output = "beat " + enemiesDefeat + " enemies,";
            return true;
        }

        }
}
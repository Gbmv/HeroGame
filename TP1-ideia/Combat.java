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

    

    public String fight(String[] phrase) {


        int heroAttack = hero.getAttack();
        int enemyAttack = enemy.getAttack();
        int enemiesDefeat = 0; // counter of enemies defeted



        int numberEnemies = Integer.parseInt(phrase[1]);
        System.out.println("pre While 1 ");
        System.out.println("Hero Health: " + hero.getHealth());
        System.out.println("Number enemies: " + numberEnemies);

        while (hero.getHealth() > 0 && numberEnemies > 0) {
            System.out.println("While 1");

            int damageToEnemy = heroAttack;
            int damageToHero = enemyAttack;

            while (hero.getHealth() > 0) {
                System.out.println("While 2 ");

                // Calcule of the damage to the enemy
                int newEnemyHealth = enemy.getHealth() - damageToEnemy;
                // Calculate the damage to the hero
                int newHeroHealth = hero.getHealth() - damageToHero;

                // Update the enemy health
                enemy.setHealth(newEnemyHealth);

                // Enemy death
                if (newEnemyHealth >= 0) {

                    hero.setHealth(newHeroHealth);
                }

                else {

                    // Reduce the number of enemies
                    numberEnemies--;

                    // Increases the number of enemies killed
                    enemiesDefeat++;

                    // Increase the attack point of the enemy
                    enemy.setAttack(enemy.getAttack() + 5);
                    // Increase the live point of the enemy
                    enemy.setHealth(enemy.getHealth() + 10);
                    // Increases the xp of the enemy
                    enemy.setExperience(enemy.getExperience() + 8);

                    // Increases the xp of the hero
                    hero.LevelUp();
                    System.out.println("pre BREAK ");
                    break;
                }
            }

        }

        if (hero.getHealth() <= 0) {
            output = "died after beating " + enemiesDefeat + " enemies and attaining level " + hero.getLevel() + "!"; // TODO:
                                                                                                                      // did
                                                                                                                      // he
                                                                                                                      // Lv.
                                                                                                                      // UP?
        } else {
            output = "beat " + enemiesDefeat + " enemies,";
        }
        System.out.println("enemies Defeated:  " + enemiesDefeat);
        System.out.println("experience:  " + hero.getExperience());

        return output;
    }
}
public class Combat extends Characters  {

    Hero hero  = new Hero();
    Enemy enemy = new Enemy();
    int heroAttack = hero.getAttack();
    int enemyAttack = enemy.getAttack();

    //The hero starts alive
    boolean live = true;
    // Counter of lifes of enemies killed
    int enemiesDefeat = 0;

    // Output
    String output;

    public String fight(String[] phrase) {
        while (live) {
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
                    if (numberEnemies <= 0) {
                        live = false;
                        output = "In his quest the hero fought  " +  enemiesDefeat + "enemies";
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
                    else {
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
                else if (newHeroHealth <= 0) {
                    live = false;
                    output = "In his quest, " + phrase[0] + "died after beating " + enemiesDefeat + " enemies";
                    break;
                }
            }
        }
        return output;
    }
}

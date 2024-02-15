public class Combat extends Characters  {

    Hero hero  = new Hero();
    Enemy enemy = new Enemy();
    int heroAttack = hero.getAttack();
    int enemyAttack = enemy.getAttack();
    int enemiesDefeat = 0; // counter of enemies defeted
   

    // Output
    String output;

    public String fight(String[] phrase) {
        int numberEnemies = Integer.parseInt(phrase[1]);
        while ( numberEnemies > 0 && hero.getHealth() > 0 ) {
            
            int damageToEnemy = heroAttack;
            int damageToHero = enemyAttack;

            while (hero.getHealth() > 0 ) {

                // Calcule of the damage to the enemy
                int newEnemyHealth = enemy.getHealth() - damageToEnemy;
                // Calculate the damage to the hero
                int newHeroHealth = hero.getHealth() - damageToHero;


                // Update the enemy health
                enemy.setHealth(newEnemyHealth);


                // Enemy death
                if (newEnemyHealth >= 0) {

                    hero.setHealth(newHeroHealth);}

                else{

                
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
                    break;
                }
            }

        }

        if (hero.getHealth() <= 0){
            output = "died after beating " + enemiesDefeat + " enemies and attaining level " + hero.getLevel() + "!";
        }
        else{
            output = "beat " + enemiesDefeat +" enemies,";
        }
     
        return output;
    }
}
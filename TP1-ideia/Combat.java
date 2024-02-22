public class Combat {

    private Hero hero;
    private Enemy enemy;

    public Combat(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }



    static int enemiesDefeat;


    public boolean fight(String[] phrase) {

        int numberEnemies = Integer.parseInt(phrase[1]);

        //while (numberEnemies>0 && hero.getHealth() > 0) {
        for (int i=0; i < numberEnemies; i++ ){
            //while (hero.getHealth() > 0 && numberEnemies > 0) {

            //int damageToEnemy = heroAttack;

            //int damageToHero = enemyAttack;



            while (hero.getHealth() > 0) {




                // Calcule of the damage to the enemy
                //int newEnemyHealth = enemy.getHealth() - hero.getAttack();
                // Calculate the damage to the hero
                //int newHeroHealth = hero.getHealth() - enemy.getAttack();

                // Update the enemy health

                //enemy.setHealth(newEnemyHealth);
                hero.Attack(enemy, hero.getAttack());

                // Enemy alive
                if (enemy.getHealth() > 0) {
                    //hero.setHealth(newHeroHealth);
                    hero.Hurt(enemy.getAttack());


                }
                // Enemy death
                else {
                    // Reduce the number of enemies

                    // Increases the number of enemies killed
                    enemiesDefeat++;

                    // Increase the attack point of the enemy
                    enemy.setAttack(enemy.getAttack() + 5);

                    // Increase the live point of the enemy
                    enemy.setMaxHealth(enemy.getMaxHealth() + 10);

                    enemy.setHealth(enemy.getMaxHealth());
                  

                   // Increases the xp of the hero
                   // hero.setExperience(hero.getExperience()+12);//
                    
                    //hero.setExperience(enemy.getExperience());
                    hero.LevelUp(enemy.getExperience());

                  
                    
                    // Increases the xp of the enemy
                    enemy.setExperience(enemy.getExperience() + 8);




                    


                    
                    break;
                }
            }


        }
        if (hero.getHealth() <= 0) {
            return false;

        } else {
            return true;
        }
    }
}

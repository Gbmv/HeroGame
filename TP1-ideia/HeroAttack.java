public class HeroAttack extends Hero {

    static Hero myHero = new Hero();
    // static Enemy myEnemy = new Enemy();

    public static void toAttack() {
        myHero.setAttack(myHero.getAttack()*2); 


        // int heroAttack = myHero.getAttack();
        // int newAttackHero = 2*heroAttack;
        // // int enemyAttack = myEnemy.getAttack();

        // return newAttackHero;
        // // myEnemy.setAttack(2 * enemyAttack);
    }
}

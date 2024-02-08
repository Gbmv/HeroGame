public class HeroDefend extends Hero{
    static Hero myHero = new Hero();
    // static Enemy myEnemy = new Enemy();

    public static void toDefend(){
        myHero.setAttack(myHero.getAttack()/2);    
    }
        // int heroAttack = myHero.getAttack();
        // int newAttackHero = heroAttack / 2;
        // return newAttackHero;
        // myEnemy.setAttack(myEnemy.getAttack()/2);
    
}

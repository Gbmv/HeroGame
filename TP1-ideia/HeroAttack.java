public class HeroAttack extends Hero {

    public HeroAttack(int level, int attack) {
        super(level, attack);
    }
    
    @Override
    public void Attack(Enemy enemy, int attack) {
        enemy.setHealth( enemy.getHealth() - ( attack * 2 ));
    }

    @Override
    public void Hurt( int attack) {
        health -= attack * 2 ;
    }

}

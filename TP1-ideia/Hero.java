
public class Hero extends Characters{
    
    private int health = 1000;
    private int maxHealth = 10000;
    private int level = 0;
    private double xpRequise;
    private int experience = 0;
    private int attack = 0;



//    char primeiraLetra = Character.toLowerCase(frase.charAt(0)); Pra sabe se o primeiro é letra a
//   if  (priemiraLetra  == 'a'){
//   }else if (primeiraLetra == 'd'){
//   }

    // Getters
    public int getLevel(){
        return level;
    }




    public void Heal(int n){
        health = health + n;
        if (health > maxHealth);{
            FullHeal();
        }
    }


    public void FullHeal(){
        health = maxHealth;
    }


    public void Training(int n){
        attack = attack + n;
    }

    public int LevelUp(){
        experience += 12;

        xpRequise = 50 + (level + 1) * 20 * Math.pow(1.1, level + 1);
        
        if ( experience >= xpRequise ) {

            experience = 0;
           
            if (level < 99) {

              level++;
              attack += 6;
              maxHealth += 12;
              FullHeal();

            }
        }
        
        return level;
    
    }
}


public class Hero extends Characters{
    
    private int health = 1000;
    private int maxHealth = 10000;
    private int level = 0;
    private int experience = 0;
    private int attack = 0;



//    char primeiraLetra = Character.toLowerCase(frase.charAt(0)); Pra sabe se o primeiro é letra a
//   if  (priemiraLetra  == 'a'){
//   }else if (primeiraLetra == 'd'){
//   }

    // Getters

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
}

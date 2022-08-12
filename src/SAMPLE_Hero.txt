public class Hero {
    String name;
    String attack_msg;
    float HP;
    float currentHP;
    float MP;
    float currentMana;
    float damage;
    float armor;
    float ultimate_cost;
    float ultimate_damage;

    public Hero(String name, String attack_msg, float HP, float currentHP, float MP, float currentMana,
                float damage, float armor, float ultimate_cost, float ultimate_damage) {
        this.name = name;
        this.attack_msg = attack_msg;
        this.HP = HP;
        this.currentHP = currentHP;
        this.MP = MP;
        this.currentMana = currentMana;
        this.damage = damage;
        this.armor = armor;
        this.ultimate_cost = ultimate_cost;
        this.ultimate_damage = ultimate_damage;
    }

    //GETTER
    public String getName() {
        return name;
    }
    public String getAttack_msg() {
        return attack_msg;
    }
    public float getHP() {
        return HP;
    }
    public float getCurrentHP() {
        return currentHP;
    }
    public float getMP() {
        return MP;
    }
    public float getCurrentMana() {
        return currentMana;
    }
    public float getDamage() {
        return damage;
    }
    public float getArmor() {
        return armor;
    }
    public float getUltimate_cost() {
        return ultimate_cost;
    }
    public float getUltimate_damage() {
        return ultimate_damage;
    }

    //SETTER
    public void setName(String name) {
        this.name = name;
    }
    public void setAttack_msg(String attack_msg) {
        this.attack_msg = attack_msg;
    }
    public void setHP(float HP) {
        this.HP = HP;
    }
    public void setCurrentHP(float currentHP) {
        this.currentHP = currentHP;
    }
    public void setMP(float MP) {
        this.MP = MP;
    }
    public void setCurrentMana(float currentMana) {
        this.currentMana = currentMana;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }
    public void setArmor(float armor) {
        this.armor = armor;
    }
    public void setUltimate_cost(float ultimate_cost) {
        this.ultimate_cost = ultimate_cost;
    }
    public void setUltimate_damage(float ultimate_damage) {
        this.ultimate_damage = ultimate_damage;
    }

    // instance methods working on data:
    void attack(String attackMessage){
        System.out.println(attackMessage);
    }

    boolean ultimate(){
        if(currentMana >= ultimate_cost){
            currentMana -= ultimate_cost;
            return true;
        } else {
            return false;
        }
    }

    void ultimateBy(Hero hero){
        currentHP = currentHP - ((hero.ultimate_damage * 5) / (armor + 3));
    }

    void attackBy (Hero hero){
        currentHP = currentHP - ((hero.damage * 5) / (armor + 3));
    }

    boolean isAlive (){
        if (currentHP > 0){
            return true;
        } else {
            return false;
        }
    }

    void addMana (){
        currentMana += 200;
    }
}

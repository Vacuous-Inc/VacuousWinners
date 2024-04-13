public class Player {
    private int weapon, armor, skill, points, level, coins;
    
    private final int DEF_WEAPON = 1;
    private final int DEF_ARMOR = 1;
    private final int DEF_SKILL = 1;
    private final int DEF_POINTS = 3;
    private final int DEF_LEVEL = 1;
    private final int DEF_COINS = 0;
    private String name;

    public Player(String name) {
        weapon = DEF_WEAPON;
        armor = DEF_ARMOR;
        skill = DEF_SKILL;
        points = DEF_POINTS;
        level = DEF_LEVEL;
        coins = DEF_COINS;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getArmor() {
        return armor;
    }

    public int getSkill() {
        return skill;
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
        return level;
    }

    public int getCoins() {
        return coins;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addCoins(int coins){
        this.coins += coins;
    }

    public boolean levelUp() {
        if (points == 3) {
            points = 0;
            return true;
        }
        else {
            return false;
        }
    }
}

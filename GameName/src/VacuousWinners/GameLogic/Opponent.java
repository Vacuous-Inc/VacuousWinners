package VacuousWinners.GameLogic;

public class Opponent {
    private int weapon, armor, skill, level, points;
    private String tip;

    private final int DEF_WEAPON = 1;
    private final int DEF_ARMOR = 1;
    private final int DEF_SKILL = 1;

    public Opponent(int level, String tip) {
        this.level = level;
        points = 3*level;
        this.tip = tip;
    }

    public void setWeapon() {
        if (level > 1) {
            if (points >= level +1) {
                int max = level + 1;
                int min = level - 1;
                weapon = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= weapon;
            }
            else if (points == level) {
                int max = level;
                int min = level - 1;
                weapon = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= weapon;
            }
            else {
                weapon = points;
                points -= weapon;
            }
        }
        else {
            weapon = DEF_WEAPON;
        }
    }

    public void setArmor() {
        if (level > 1) {
            if (points >= level +1) {
                int max = level + 1;
                int min = level - 1;
                armor = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= armor;
            }
            else if (points == level) {
                int max = level;
                int min = level - 1;
                armor = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= armor;
            }
            else {
                armor = points;
                points -= armor;
            }
        }
        else {
            armor = DEF_ARMOR;
        }
    }

    public void setSkill() {
        if (level > 1) {
            if (points >= level +1) {
                int max = level + 1;
                int min = level - 1;
                skill = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= skill;
            }
            else if (points == level) {
                int max = level;
                int min = level - 1;
                skill = (int)Math.floor(Math.random() * (max - min + 1) + min);
                points -= skill;
            }
            else {
                skill = points;
                points -= skill;
            }
        }
        else {
            skill = DEF_SKILL;
        }
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

    public int getLevel() {
        return level;
    }

    public String getTip() {
        return tip;
    }
}

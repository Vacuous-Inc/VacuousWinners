public class Shop { 
    private int weaponPrice, armorPrice, skillPrice;

    public Shop(Player p) {
        weaponPrice = p.getWeapon() * 10;
        armorPrice = p.getArmor() * 10;
        skillPrice = p.getSkill() * 10;
    }

    public int upgradeWeapon(Player p) {
        if (weaponPrice > p.getCoins()) {
            return -1;
        }
        else {
            p.setWeapon(p.getWeapon() + 1);
            p.setCoins(p.getCoins() - weaponPrice);
            p.setPoints(p.getPoints() + 1);
            if (p.levelUp() == true) {
                p.setLevel(p.getLevel() + 1);
            }
            return p.getCoins();
        }
    }

    public int upgradeArmor(Player p) {
        if (armorPrice > p.getCoins()) {
            return -1;
        }
        else {
            p.setArmor(p.getArmor() + 1);
            p.setCoins(p.getCoins() - armorPrice);
            p.setPoints(p.getPoints() + 1);
            if (p.levelUp() == true) {
                p.setLevel(p.getLevel() + 1);
            }
            return p.getCoins();
        }
    }

    public int upgradeSkill(Player p) {
        if (skillPrice > p.getCoins()) {
            return -1;
        }
        else {
            p.setSkill(p.getSkill() + 1);
            p.setCoins(p.getCoins() - skillPrice);
            p.setPoints(p.getPoints() + 1);
            if (p.levelUp() == true) {
                p.setLevel(p.getLevel() + 1);
            }
            return p.getCoins();
        }
    }
}

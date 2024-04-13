package VacuousWinners.GameLogic;

public class Battle {
    private int playerHealth, opponentHealth;

    public Battle(Player p, Opponent o) {
        playerHealth = p.getSkill() * 15;
        opponentHealth = o.getSkill() * 15;
    }

    public boolean pHit(Player p, Opponent o) {
        double pRoll = p.getWeapon() * Math.floor(Math.random() * (20) + 1);
        double oRoll = o.getArmor() * Math.floor(Math.random() * (20) + 1);
        return pRoll > oRoll;
    }

    public boolean oHit(Opponent o, Player p) {
        double pRoll = p.getArmor() * Math.floor(Math.random() * (20) + 1);
        double oRoll = o.getWeapon() + Math.floor(Math.random() * (20) + 1);
        return oRoll > pRoll;
    }

    public int pAttack(Player p) {
        int max = 6;
        int min = 0;
        int damage = p.getWeapon() * (int)Math.floor(Math.random() * (max - min + 1) + min) + 2 * p.getWeapon();
        opponentHealth -= damage;
        if (opponentHealth < 0) {
            opponentHealth = 0;
        }
        return opponentHealth;
    }

    public int oAttack(Opponent o) {
        int max = 6;
        int min = 0;
        int damage = o.getWeapon() * (int)Math.floor(Math.random() * (max - min + 1) + min) + 2 * o.getWeapon();
        playerHealth -= damage;
        if (playerHealth < 0) {
            playerHealth = 0;
        }
        return playerHealth;
    }
}

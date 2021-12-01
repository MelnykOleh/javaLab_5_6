package lab5;

public class Character {
    private int id;
    private String name;
    private String nameOfAttack;
    private double health;
    private double attack;
    private double protection;
    private int gameId;

    public Character(int id, String name, String nameOfAttack, double health, double attack, double protection, int gameId) {
        this.id = id;
        this.name = name;
        this.nameOfAttack = nameOfAttack;
        this.health = health;
        this.attack = attack;
        this.protection = protection;
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfAttack() {
        return nameOfAttack;
    }

    public void setNameOfAttack(String nameOfAttack) {
        this.nameOfAttack = nameOfAttack;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameOfAttack='" + nameOfAttack + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", protection=" + protection +
                ", gameId=" + gameId +
                '}';
    }
}

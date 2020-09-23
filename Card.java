public class Card {
    private String name;
    private Atribute strength;
    private Atribute agility;
    private Atribute charisma;
    private Atribute speed;
    private Atribute weigth;

    public Card(String name, Atribute strength, Atribute agility, Atribute charisma, Atribute speed, Atribute weigth) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.charisma = charisma;
        this.speed = speed;
        this.weigth = weigth;
    }

    public Atribute selectAtribute(int i) {
        switch (i) {
            case 1:
                return getStrength();

            case 2:
                return getAgility();

            case 3:
                return getCharisma();

            case 4:
                return getSpeed();

            case 5:
                return getWeigth();

            default:
                return null;
        }


    }

    public String getName() {
        return name;
    }

    public Atribute getStrength() {
        return strength;
    }

    public Atribute getAgility() {
        return agility;
    }

    public Atribute getCharisma() {
        return charisma;
    }

    public Atribute getSpeed() {
        return speed;
    }

    public Atribute getWeigth() {
        return weigth;
    }

}


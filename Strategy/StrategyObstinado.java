package Strategy;

import Game.Card;

public class StrategyObstinado implements Strategy {

    private String atributeName = null;

    @Override
    public String selectAtribute(Card c) {
        if (atributeName == null) {
            int choice = (int) Math.floor(Math.random() * c.getNumberOfAtributes());
            atributeName = c.getAtribute(choice).getName();
        }
        return atributeName;
    }

}

package Strategy;

import Game.Card;

public class StrategyTimbero implements Strategy {
    @Override
    public String selectAtribute(Card c) {
        int randomNumber = (int) Math.floor(Math.random() * c.getNumberOfAtributes());
        return c.getAtribute(randomNumber).getName();
    }
}

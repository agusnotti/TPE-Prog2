package Strategy;

import Game.Card;

public class StrategyAmbicioso implements Strategy {
    @Override
    public String selectAtribute(Card c) {
        return this.selectBestAtribute(c);
    }

    private String selectBestAtribute(Card c) {
        String best = "";
        int higherValue = 0;
        for (int i = 0; i < c.getNumberOfAtributes(); i++) {
            if (c.getAtribute(i).getValue() > higherValue) {
                best = c.getAtribute(i).getName();
                higherValue = c.getAtribute(i).getValue();
            }
        }
        return best;
    }
}

package Potions;

import java.util.ArrayList;

public class CockTail implements ElementPotion {

    private ArrayList<ElementPotion> potions;

    public CockTail() {
        this.potions = new ArrayList<>();
    }

    public void addPotion(ElementPotion p) {
        potions.add(p);
    }

    @Override
    public int applyEffects(String atributeName, int atributeValue) {
        for(ElementPotion elem:potions){
            atributeValue=elem.applyEffects(atributeName,atributeValue);
        }
        return atributeValue;
    }

    @Override
    public String getAppliedPotions(String atributeName) {
        String potionsName="";
        for(ElementPotion elem: potions){
            potionsName+= elem.getAppliedPotions(atributeName);
        }
        return potionsName;
    }
}

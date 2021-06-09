package marconymous.dev.classes;

import marconymous.dev.enums.SpecialRule;

import java.util.HashMap;

public class GlobalContainer {
    private HashMap<SpecialRule, Boolean> rules = new HashMap<>();

    public GlobalContainer() {
        rules.put(SpecialRule.INSTADEATH, false);
        rules.put(SpecialRule.NOFALLDAMAGE, false);
    }

    public HashMap<SpecialRule, Boolean> getRules() {
        return rules;
    }

    public void setRules(HashMap<SpecialRule, Boolean> rules) {
        this.rules = rules;
    }
}

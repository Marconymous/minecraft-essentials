package marconymous.dev.enums;

public enum SpecialRule {
    NOFALLDAMAGE(0, "noFallDamage"),
    INSTADEATH(1, "instaDeath"),
    NOHUNGER(2, "noHunger"),
    NOHEAL(3, "noHeal");

    private final int code;
    private final String name;
    SpecialRule(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

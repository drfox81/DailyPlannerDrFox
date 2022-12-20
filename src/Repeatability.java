public enum Repeatability {
    ONCE(0),// без повторения
    DAILY(1),//ежедневно
    WEEKLY(7),//еженедельно
    MONTHLY(31),//ежемесячно
    ANNUALLY(365);//ежегодно

    private int repeatability;

    public int getRepeatability() {
        return repeatability;
    }

    Repeatability(int repeatability) {
        this.repeatability = repeatability;
    }
}

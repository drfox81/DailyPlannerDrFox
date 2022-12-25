public enum Type {
    PERSONAL_TASK("Личная"),
    WORKING_TASK("Рабочая");

    private String type;

    public String getType() {
        return type;
    }

    Type(String type) {
        this.type = type;
    }
}

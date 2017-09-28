public enum Direction {
    North("North", "Norte"),
    West("West", "Oeste"),
    South("South", "Sur"),
    East("East", "Este");

    private final String english;
    private final String spanish;

    Direction(String english, String spanish) {
        this.english = english;
        this.spanish = spanish;
    }

    public String getEnglish() {
        return english;
    }

    public String getSpanish() {
        return spanish;
    }
}

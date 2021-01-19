public enum Temperature {
    MIN_SICK(32.0),
    MAX_SICK(40.0),
    MIN_HEALTHY(36.2),
    MAX_HEALTHY(36.9);

    private double value;

    Temperature(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}

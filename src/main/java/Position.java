public class Position {
    private static final int MIN_RACE_VALUE = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    public void go(int randomValue) {
        if(randomValue >= MIN_RACE_VALUE) {
            position++;
        }
    }

    public boolean isFurtherMoreThan(Position position) {
        return this.position >= position.getPosition();
    }
}

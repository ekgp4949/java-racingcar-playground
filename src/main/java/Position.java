public class Position {
    private final int MIN_RACE_VALUE = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    public void go(int randomValue) {
        if(randomValue >= 4) {
            position++;
        }
    }

    public boolean isFurtherMoreThan(Position position) {
        return this.position >= position.getPosition();
    }
}

import java.util.List;

public class RacingCar {

    private CarName name;
    private Position position;

    public RacingCar(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public Position race(int randomValue) {
        position.go(randomValue);
        return position;
    }

    boolean isWinningTo(RacingCar car) {
        return this.position.isFurtherMoreThan(car.position);
    }

    public boolean isWinningToAll(List<RacingCar> cars) {
        return cars.stream()
                .allMatch(this::isWinningTo);
    }

    public CarName getName() {
        return name;
    }

    public String getStringName() {
        return name.getName();
    }
}

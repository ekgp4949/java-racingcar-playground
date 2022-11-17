import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<RacingCar> cars;
    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public List<RacingCar> findWinners() {
        return cars.stream()
                       .filter(racingCar -> racingCar.isWinningToAll(cars))
                       .collect(Collectors.toList());
    }

    public List<String> findWinnersName() {
        return findWinners().stream()
                       .map(RacingCar::getStringName)
                       .collect(Collectors.toList());
    }

    public RaceResults race(int attempt) {
        List<RaceResult> results = new ArrayList<>();
        while(attempt-- > 0) {
            results.add(race());
        }
        return new RaceResults(results, findWinnersName());
    }

    private RaceResult race() {
        Map<CarName, Integer> resultMap = new HashMap<>();
        for (RacingCar car : cars) {
            Position position = car.race((int) (Math.random() * 10));
            resultMap.put(car.getName(), position.getPosition());
        }
        return new RaceResult(resultMap);
    }
}

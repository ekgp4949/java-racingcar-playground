import java.util.Map;
import java.util.Set;

public class RaceResult {
    private final Map<CarName, Integer> results;
    public RaceResult(Map<CarName, Integer> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        Set<CarName> carNames = results.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (CarName carName : carNames) {
            Integer position = results.get(carName);
            stringBuilder.append(carName.getName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(position));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

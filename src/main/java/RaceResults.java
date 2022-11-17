import java.util.List;

public class RaceResults {
    private List<RaceResult> results;
    private List<String> winners;

    public RaceResults(List<RaceResult> results, List<String> winners) {
        this.results = results;
        this.winners = winners;
    }

    public int getRaceCount() {
        return results.size();
    }

    public List<String> getWinners() {
        return winners;
    }

    public RaceResult getResultInfoWhen(int attempt) {
        return results.get(attempt);
    }

    @Override
    public String toString() {
        String winnersStr = String.join(", ", getWinners());
        if(getWinners().size() != 1) {
            winnersStr = winnersStr.substring(0, winnersStr.length());
        }
        return winnersStr + "가 최종 우승했습니다.";
    }
}

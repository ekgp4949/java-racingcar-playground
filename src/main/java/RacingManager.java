public class RacingManager {
    private final InputView inputView;
    private final ResultView resultView;
    private final ScannerUtils scannerUtils;

    public RacingManager(InputView inputView, ResultView resultView, ScannerUtils scannerUtils) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.scannerUtils = scannerUtils;
    }

    public void playGame() {
        inputView.start();
        String[] carNames = scannerUtils.getCarsName();
        Cars cars = new Cars(carNames);

        inputView.getAtteptInfo();
        int raceAttempt = scannerUtils.getRaceAttempt();
        RaceResults raceResults = cars.race(raceAttempt);

        inputView.printEmpty();

        resultView.printResult(raceResults);
    }
}

public class ResultView {
    public void printResult(RaceResults results) {
        System.out.println("실행 결과");
        int raceCount = results.getRaceCount();
        for (int attempt = 0; attempt < raceCount; attempt++) {
            RaceResult result = results.getResultInfoWhen(attempt);
            System.out.println(result.toString());
        }

        System.out.println(results.toString());

    }

    //실행 결과
    //pobi : -
    //crong : -
    //honux : -
    //
    //pobi : --
    //crong : -
    //honux : --
    //
    //pobi : ---
    //crong : --
    //honux : ---
    //
    //pobi : ----
    //crong : ---
    //honux : ----
    //
    //pobi : -----
    //crong : ----
    //honux : -----
    //
    //pobi : -----
    //crong : ----
    //honux : -----
    //
    //pobi, honux가 최종 우승했습니다.
}

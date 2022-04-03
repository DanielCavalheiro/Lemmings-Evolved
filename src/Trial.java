
public class Trial {

    private long maxPoints;
    private long minPairs;

    public Trial(Lemming[] line1, Lemming[] line2, int numOfLemmingsInLine1, int numOfLemmingsInLine2) {

        long[][] score = new long[numOfLemmingsInLine1 + 1][numOfLemmingsInLine2 + 1];
        long[][] pairs = new long[numOfLemmingsInLine1 + 1][numOfLemmingsInLine2 + 1];

        for (int i = 0; i <= numOfLemmingsInLine1; i++) { // Column 0: base case, line1=()
            score[i][0] = 0;
            pairs[i][0] = 0;
        }

        for (int j = 0; j <= numOfLemmingsInLine2; j++) {// Line 0: base case, line2=()
            score[0][j] = 0;
            pairs[0][j] = 0;
        }

        long leftScore, upScore, leftPairs, upPairs, bestScore;

        for (int j = 1; j <= numOfLemmingsInLine2; j++) {

            for (int i = 1; i <= numOfLemmingsInLine1; i++) {

                leftScore = score[i - 1][j];
                upScore = score[i][j - 1];

                leftPairs = pairs[i - 1][j];
                upPairs = pairs[i][j - 1];

                if (line1[i - 1].getTribe() == line2[j - 1].getTribe()) {
                    score[i][j] = (line1[i - 1].getPower() + line2[j - 1].getPower());
                    pairs[i][j]++;
                }

                score[i][j] += score[i - 1][j - 1];
                pairs[i][j] += pairs[i - 1][j - 1];

                bestScore = Math.max(leftScore, upScore);

                if (score[i][j] <= bestScore) {

                    score[i][j] = bestScore;

                    if (bestScore == leftScore)
                        pairs[i][j] = leftPairs;
                    else
                        pairs[i][j] = upPairs;
                }
            }

        }

        maxPoints = score[numOfLemmingsInLine1][numOfLemmingsInLine2];
        minPairs = pairs[numOfLemmingsInLine1][numOfLemmingsInLine2];

    }

    @Override
    public String toString() {
        return maxPoints + " " + minPairs;
    }

}

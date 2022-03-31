import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int numOfTrials = Integer.parseInt(in.readLine());
        // Array where we keep all game trials to later print
        Trial[] trials = new Trial[numOfTrials];

        // read input one trial at a time and plays it
        for (int trialNum = 0; trialNum < numOfTrials; trialNum++) {
            int numOfLemmingsInLine1 = Integer.parseInt(in.readLine());
            Lemming[] line1 = processLine(numOfLemmingsInLine1);

            int numOfLemmingsInLine2 = Integer.parseInt(in.readLine());
            Lemming[] line2 = processLine(numOfLemmingsInLine2);

            trials[trialNum] = new Trial(line1, line2, numOfLemmingsInLine1, numOfLemmingsInLine2);
        }
        in.close();

        for (int trialNum = 0; trialNum < numOfTrials; trialNum++) {

            System.out.println(trials[trialNum].toString());

        }
    }

    private static Lemming[] processLine(int numOfLemmings) throws IOException {
        Lemming[] line = new Lemming[numOfLemmings];

        for (int i = 0; i < numOfLemmings; i++) {
            String[] tokens = in.readLine().split(" ");
            char tribe = tokens[0].toCharArray()[0];
            int power = Integer.parseInt(tokens[1]);
            line[i] = new Lemming(tribe, power);
        }

        return line;
    }
}

import java.util.*;

class PROBLEMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        int subtasks = sc.nextInt();
        ArrayList<Integer> difficulty = new ArrayList<>();
        Map<Integer, Integer> problemData = new HashMap<>();

        for (int p = 0; p < problems; p++) {
            Integer[] scores = new Integer[subtasks];
            for (int s = 0; s < subtasks; s++) {
                scores[s] = sc.nextInt();
            }
            Integer[] participants = new Integer[subtasks];
            for (int s = 0; s < subtasks; s++) {
                participants[s] = sc.nextInt();
            }

            for (int s = 0; s < subtasks; s++) {
                problemData.put(scores[s], participants[s]);
            }

            difficulty.add(p, calcDefficulty(problemData));
            problemData.clear();
        }

        printProblemIndexWrtoDifficulty(difficulty);
        sc.close();
    }

    public static int calcDefficulty(Map<Integer, Integer> problemData) {
        int difficulty = 0;
        TreeMap<Integer, Integer> sortedProblemData = new TreeMap<>();
        sortedProblemData.putAll(problemData);
        int i = 0;
        Integer prevValue = 0, currValue;
        for (Map.Entry<Integer, Integer> entry : sortedProblemData.entrySet()) {
            if (i == 0) {
                i = 1;
                prevValue = entry.getValue();
                continue;
            }
            currValue = entry.getValue();
            if (prevValue > currValue) {
                difficulty++;
            }
            prevValue = currValue;
        }

        sortedProblemData.clear();
        return difficulty;
    }

    public static void printProblemIndexWrtoDifficulty(ArrayList<Integer> difficulty) {
        int problemCount = difficulty.size();
        Integer max = Collections.max(difficulty);
        Integer placeHolder = max + 1;
        Integer min, currMinIndex;
        while (problemCount != 0) {
            min = Collections.min(difficulty);
            currMinIndex = difficulty.indexOf(min);
            System.out.format("%d ", currMinIndex + 1);
            difficulty.set(currMinIndex, placeHolder);
            problemCount--;
        }
        System.out.println();
    }
}
import java.util.*;

class PROBLEMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        int subtasks = sc.nextInt();
        Map<Integer,Integer> difficulty = new TreeMap<>();
        Map<Integer, Integer> problemData = new TreeMap<>();
        Integer increment = 0;
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
            Integer diff = calcDefficulty(problemData);
            while( difficulty.containsKey(diff + increment) ){
                increment++;
            }
            
            difficulty.put( diff + increment, p+1);
            // difficulty.add(p, calcDefficulty(problemData));
            problemData.clear();
        }
        // System.out.println(difficulty.toString());
        printProblemIndexWrtoDifficulty(difficulty.values());
        sc.close();
    }

    public static int calcDefficulty(Map<Integer, Integer> sortedProblemData) {
        int difficulty = 0;
        // System.out.println(sortedProblemData.toString());
        Set<Integer> keys = sortedProblemData.keySet();
        Integer prevValue = 0, currValue;
        
        int i = 0;
        for (Integer key : keys) {
            if(i == 0){
                i = 1;
                prevValue = sortedProblemData.get(key);
                continue;
            }
            currValue = sortedProblemData.get(key);
            if(prevValue > currValue){
                difficulty++;
            }

            prevValue = currValue;
        }
        // System.out.println(sortedProblemData.toString());
        return difficulty;
    }

    public static void printProblemIndexWrtoDifficulty(Collection<Integer> difficulty) {
        for (Integer val: difficulty) {
            System.out.println(val);
        }
    }
}
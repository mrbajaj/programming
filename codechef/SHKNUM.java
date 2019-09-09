import java.util.*;

class SHKNUM{
    static Map<Integer,Integer> powerMap = new HashMap<>();
    static List<Integer> sumList = new ArrayList<>();
    
    public static void main(String[] args) {
        initializeHigherPowerOfTwo();
        initializeSumList();
        
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int t=0; t < testCases; t++){
            int N = sc.nextInt(); //Integer.parseInt(sc.nextLine());//
            Integer nearestNeighbourDist;
            nearestNeighbourDist = Math.abs(getNearestNeighbourDist(N));
            System.out.println(nearestNeighbourDist);
        }
        sc.close();
    }
    public static Integer getNearestNeighbourDist(int N){
        Integer sum1 = sumList.get(0), sum2= sumList.get(sumList.size()-1);
        
        for (int i=0; i< sumList.size()-1; i++) {
            if(sumList.get(i) > N){
                break;
            }
            sum1 = sumList.get(i);
        }
        for (int i=sumList.size()-1; i >= 0; i--) {
            if(sumList.get(i) < N){
                break;
            }
            sum2 = sumList.get(i);
        }
        // System.out.format("%d %d %d\n",sum1,sum2,N);
        if( (N - sum2) < (sum1 - N)){
            // System.out.print("Case1: ");
            return N - sum1;
        }else{
            // System.out.print("Case2: ");
            return sum2 - N;
        }
    }
    
    public static void initializeHigherPowerOfTwo(){
        powerMap.put(30, 1073741824);
        powerMap.put(29, 536870912); powerMap.put(28, 268435456); powerMap.put(27, 134217728); powerMap.put(26, 67108864);
        powerMap.put(25, 33554432);  powerMap.put(24, 16777216);  powerMap.put(23, 8388608);   powerMap.put(22, 4194304);   
        powerMap.put(21, 2097152);   powerMap.put(20, 1048576);   powerMap.put(19, 524288);    powerMap.put(18, 262144);   
        powerMap.put(17, 131072);    powerMap.put(16, 65536);     powerMap.put(15, 32768);     powerMap.put(14, 16384);    
        powerMap.put(13, 8192);      powerMap.put(12, 4096);      powerMap.put(11, 2048);      powerMap.put(10, 1024);   
        powerMap.put(9, 512);        powerMap.put(8, 256);        powerMap.put(7, 128);        powerMap.put(6, 64);   
        powerMap.put(5, 32);         powerMap.put(4, 16);         powerMap.put(3, 8);          powerMap.put(2, 4);
        powerMap.put(1, 2);          powerMap.put(0, 1);
    }

    public static void initializeSumList(){
        List<Integer> powerValues = new ArrayList<Integer>(powerMap.values());

        for(int i=0; i < powerValues.size(); i++){
            for(int j=i+1; j < powerValues.size(); j++){
                sumList.add(powerValues.get(i) + powerValues.get(j));
            }
        }
        Collections.sort(sumList);
        // System.out.println(sumList);
    }
}
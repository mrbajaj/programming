import java.util.*;


class SHKNUM{
    static Map<Integer,Integer> powerMap = new HashMap<>();
    
    public static void main(String[] args) {
        initializeHigherPowerOfTwo();
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int x=0,y=0, check;
        int fPerNum, rPerNum, fDiff, rDiff;
        for(int t=0; t < testCases; t++){
            int N = sc.nextInt();
            
            x =0;
            y = getMaxPower(N);
            
            //forward check
            check = N;
            while(true){
                if(isPerfectNumber(x,y,check)){
                    break;
                }
                check++;
            }
            fPerNum = check;
            
            if(fPerNum != N){
                //reverse check
                check = N;
                while(true && check != 0){
                    if(isPerfectNumber(x,y,check)){
                        break;
                    }
                    check--;
                }
                rPerNum = check;
            }else{
                rPerNum = 0;
            }
            
            fDiff = fPerNum - N;
            rDiff = N - rPerNum;
            // System.out.println(fPerNum);
            // System.out.println(rPerNum);
            if(fDiff < rDiff){
                System.out.println(fDiff);
            }else{
                System.out.println(rDiff);
            }
        }
        // System.out.println(powerMap.toString());
        sc.close();
    }
    public static boolean isPerfectNumber(int x, int y, int checkMe){
        boolean isPerfectNumber = false;
        int tmp;
        while(x<y){
            if(x > 29 || y > 29){
                return false;
            }
            if(x==y){
                x++;
                continue;
            }
            
            // tmp = (int)Math.pow(2, x) +(int) Math.pow(2, y);
            tmp = getTowsPower(x) + getTowsPower(y);
            if(tmp == checkMe){
                isPerfectNumber = true;
                break;
            }else if(tmp > checkMe){
                y--;
            }else{
                x++;
            }
        }

        return isPerfectNumber;
    }
    public static int getMaxPower(int N){
        int pow = 1;
        while(N != 1){
            pow++;
            N = N/2;
        }
        return pow;
    }

    public static int getTowsPower(int p){
        if(powerMap.containsKey(p)){
            return powerMap.get(p);
        }
        // int value = (int)Math.pow(2,p);
        int value = 1 << p;
        powerMap.put(p, value);
        return value;
    }
    public static void initializeHigherPowerOfTwo(){
        powerMap.put(29, 536870912);
        powerMap.put(28, 268435456);
        powerMap.put(27, 134217728);
        powerMap.put(26, 67108864);
        powerMap.put(25, 33554432);
        powerMap.put(24, 16777216);   
        powerMap.put(23, 8388608);   
        powerMap.put(22, 4194304);   
        powerMap.put(21, 2097152);   
        powerMap.put(20, 1048576);   
        powerMap.put(19, 524288);   
        powerMap.put(18, 262144);   
        powerMap.put(17, 131072);   
        powerMap.put(16, 65536);   
    }
}
class Problem172{

    public static void main(String[] args) {
        
        Problem172 obj = new Problem172();
        
        System.out.println(obj.trailingZeroes(3));

        for(int i = 1; i <= 25; i++){
            // obj.trailingZeroes(i);

            System.out.println("i = " + i + "\t:: " + obj.trailingZeroes(i));
        }
        
        System.out.println("i = 124\t:: " + obj.trailingZeroes(124));
        System.out.println("i = 125\t:: " + obj.trailingZeroes(125));
        System.out.println("i = 125\t:: " + obj.trailingZeroes(126));

        System.out.println("i = 124\t:: " + obj.trailingZeroes(124));
        System.out.println("i = 125\t:: " + obj.trailingZeroes(125));
        System.out.println("i = 125\t:: " + obj.trailingZeroes(126));

        System.out.println("i = 3124\t:: " + obj.trailingZeroes(3124));
        System.out.println("i = 3125\t:: " + obj.trailingZeroes(3125));
        System.out.println("i = 3126\t:: " + obj.trailingZeroes(3126));

        System.out.println("i = 1808548329\t:: " + obj.trailingZeroes(1808548329));

        
    }

    public int trailingZeroes(int n){
        int count=0;
        while(n>1){
            n=n/5;
            count+=n;
        }
        return count;
    }


    public int trailingZeroesOtherSolution(int n){

        // failed for n = 1808548329
        int count = 0; 
  
        for (int i = 5; n / i >= 1; i *= 5) 
            count += n / i; 
   
        return count; 
    }

    
    public int trailingZeroesAttamptThree(int n){

        // failed for n = 1808548329
        int count = 0;
        for(int i = 5; i < n; i *= 5){
            count = count + n/i;
        }
        return count;
    }

    public int trailingZeroesFirstAttempt(int n) {
        
        // failed for n >= 25

        if(n > 5){
            if(n % 10 == 0 || n % 5 == 0){
                return n / 5;
            } 
            int r = n % 5;
            n  = n - r;

            return n / 5;
            
        }

        return 0;
    }

    public int trailingZeroesSecondAttempt(int n) {

        // failed for n >= 3125

        return (int)Math.floor(n/5) + (int)Math.floor(n/25) + (int)Math.floor(n/625);
    }
}
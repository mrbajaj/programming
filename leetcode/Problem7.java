/**
 * URL:
 * 
 */

 class Problem7 {

    public static void main(String[] args) {
        Problem7 obj = new Problem7();

        System.out.println("Ans: " + obj.reverse(1234) + "\n");
        // System.out.println("Ans: " + obj.reverse(1));
        // System.out.println("Ans: " + obj.reverse(999));
        // System.out.println("Ans: " + obj.reverse(1100));
        // System.out.println("Ans: " + obj.reverse(-123));
        // System.out.println("Ans: " + obj.reverse(-2147483648));
        System.out.println("Ans: " + obj.reverse(2147483647));
        // System.out.println("Ans: " + obj.reverse(2147483641));

    }

    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        x = sign * x;

        int r, y = 0, prev_y = 0;

        while( x > 0){
            r = x % 10;
            x = x / 10;
            y = y*10 + r;

            if ((y - r)/10 != prev_y) 
            { 
                // overflow
                return 0; 
            } 
            System.out.println("Y: " + y + ", r:" + r + ", x:" + x + ", prev_y:" + prev_y) ;
            prev_y = y;
            
        }

        return y * sign;
        
    }
 }
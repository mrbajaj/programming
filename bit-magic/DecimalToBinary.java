class DecimalToBinary{
    public static void main(String[] args) {
        DecimalToBinary obj = new DecimalToBinary();
        
        int n = 1;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));

        n = 2;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));
        
        n = 4;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));
        

        n = 16;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));

        n = 128;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));

        n = 444;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));

        n = 1023;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));

        n = 1024;
        System.out.println("n = " + n + "\t binary:" + obj.decimalToBinary(n));
    }

    public String decimalToBinary(int n){
        StringBuilder binary = new StringBuilder();

        while(n != 0){
            int r = n & 1;
            if( r == 1){
                binary.insert(0, "1");
            }else{
                binary.insert(0, "0");
            }
            n = n >> 1;
        }
        
        return binary.toString();
    }


}
/**
 * 
 * 
 */
class BinaryToDecimal{

    public static void main(String[] args) {
        BinaryToDecimal obj = new BinaryToDecimal();

        System.out.println(obj.binaryToDecimal("101001") ==  41);

        System.out.println(obj.binaryToDecimal("1") ==  1);

        System.out.println(obj.binaryToDecimal("100") ==  4);

        System.out.println(obj.binaryToDecimal("111") ==  7);

        System.out.println(obj.binaryToDecimal("0") ==  0);

        System.out.println(obj.binaryToDecimal("1010") ==  10);
        
    }

    public int binaryToDecimal(String binary){
        int decimal = 0;
        int len = binary.length();
        for(int i = len-1; i >= 0; i--){
            if(binary.charAt(i) == '1'){
                decimal += (int) Math.pow(2, len - i -1);
            }
            
        }

        return decimal;
    }
}
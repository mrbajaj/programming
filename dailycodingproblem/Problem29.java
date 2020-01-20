/**
 * Good morning! Here's your coding interview problem for today.
 * 
 * This problem was asked by Amazon.
 * 
 * Run-length encoding is a fast and simple method of encoding strings. 
 * The basic idea is to represent repeated successive characters as a single count and character. 
 * 
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * 
 * Implement run-length encoding and decoding. 
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 * 
 */

 class Problem29{

    public static void main(String[] args) {
        
        Problem29 obj = new Problem29();

        System.out.println("Actual : " + "AAAABBBCCDAA");
        System.out.println("Encoded: " + obj.encoder("AAAABBBCCDAA"));
        System.out.println("Decoded: " + obj.decoder("4A3B2C1D2A"));
    }

    public String encoder(String str){
        if(str.length() == 0){
            return str;
        }
        int n = str.length();
        StringBuilder encoded = new StringBuilder();

        
        for(int i=0; i<n; ){
            char ch = str.charAt(i);
            int count = 0;
            while(i<n && ch == str.charAt(i)){
                i++;
                count++;
            }

            encoded.append(String.valueOf(count) + ch);

        }


        return encoded.toString();

    }

    public String decoder(String str){

        if(str.length() == 0){
            return str;
        }
        int n = str.length();

        StringBuilder decoded = new StringBuilder();

        for(int i=0; i<n; ){
            int count = Character.getNumericValue(str.charAt(i));
            char ch = str.charAt(i+1);
            while(count != 0){
                decoded.append(ch);
                count--;
            }


            i+=2;
        }


        return decoded.toString();
        
    }

 }
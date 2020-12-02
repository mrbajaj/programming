/**
 * URL: https://leetcode.com/problems/encode-and-decode-tinyurl/
 * 
 */
import java.util.Map;
import java.util.HashMap;

public class Problem535 {

    public static void main(String[] args) {
        Codec codec = new Codec();

        System.out.println("Ans: " + codec.encode("https://leetcode.com/problems/url-zero"));
        System.out.println("Ans: " + codec.encode("https://leetcode.com/problems/url-one"));
        System.out.println("Ans: " + codec.encode("https://leetcode.com/problems/url-two"));

        System.out.println("Ans: " + codec.decode("http://tinyurl.com/0"));
        System.out.println("Ans: " + codec.decode("http://tinyurl.com/1"));
        System.out.println("Ans: " + codec.decode("http://tinyurl.com/2"));

    }
}
class Codec{
    private Map<String,String> longToShort;
    private Map<String,String> shortToLong;
    private Integer encodedValue;
    private final String serviceDomain = "http://tinyurl.com/";

    Codec(){
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();
        encodedValue = 0;
    }

    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)){
            return longToShort.get(longUrl);
        }
        String shortUrl = serviceDomain + String.valueOf(encodedValue);
        encodedValue++;
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortToLong.containsKey(shortUrl)){
            return shortToLong.get(shortUrl);
        }else{
            return null;
        }
    }

}
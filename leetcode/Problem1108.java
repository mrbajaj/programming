/**
 * URL: https://leetcode.com/problems/defanging-an-ip-address/
 */
class Problem1108{

    public static void main(String[] args) {
        Problem1108 obj = new Problem1108();
        System.out.println("Ans: " + obj.defangIPaddr("1.1.1.1"));
        System.out.println("Ans: " + obj.defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
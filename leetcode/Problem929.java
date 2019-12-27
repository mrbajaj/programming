import java.util.HashSet;
import java.util.Set;

/**
 * URL:
 * 
 */

 class Problem929{

    public static void main(String[] args) {
    
        Problem929 obj = new Problem929();

        // String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        
        // String[] emails = new String[]{"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};

        

        System.out.println("Ans: " + obj.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqValidEmails = new HashSet<>();

        for (String email : emails) {
            int firstPlusIndex = email.indexOf('+');
            int atIndex = email.indexOf('@');

            String validEmail;
            if(firstPlusIndex != -1){
                validEmail = email.substring(0, firstPlusIndex).replace(".", "").concat( email.substring(atIndex));
                uniqValidEmails.add(validEmail);
            }else{
                validEmail = email.substring(0, atIndex).replace(".", "").concat( email.substring(atIndex));
                uniqValidEmails.add(validEmail);
            }
            
            
            
            
        }

        System.out.println(uniqValidEmails);

        return uniqValidEmails.size();
        
    }
 }
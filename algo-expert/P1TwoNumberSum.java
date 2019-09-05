import java.util.Scanner;

class P1TwoNumberSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A:");
        int A = sc.nextInt();
        System.out.print("Enter B:");
        int B = sc.nextInt();
        int C = A+B;
        System.out.println("Sum of A & B: " + C);

        sc.close();
        
    }
}
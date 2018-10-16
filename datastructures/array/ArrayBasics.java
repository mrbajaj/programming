import java.io.*;
import java.util.*;

public class ArrayBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N:");
        int N = sc.nextInt();
        System.out.print("Enter M:");
        int M = sc.nextInt();
        System.out.print("Enter P:");
        int P = sc.nextInt();

        HelperClass helper = new HelperClass();
        System.out.print("-----------One D Array--------------\n");
        helper.ArrayProcesser(N,sc);
        
        System.out.print("-----------Two D Array--------------\n");
        helper.ArrayProcesser(N,M,sc);

        System.out.print("-----------Three D Array--------------\n");
        helper.ArrayProcesser(N,M,P,sc);
        
        System.out.print("-----------Array of objects--------------\n");
        helper.ArrayProcesser(sc);

        sc.close();
    }
}

class HelperClass{
    public void ArrayProcesser(int N, Scanner sc){
        // Process one Dimentional array
        int[] arr = new int[N];
        
        // iterate using normal for loop
        System.out.print("Enter " + N + " Values\n");
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        
        // print array using for each
        System.out.print("Using for-each:\t");    
        for(int x : arr){
            System.out.print(x + " ");    
        }
        System.out.println();    

        // print reverse in reverse
        System.out.print("Reverse:\t");    
        for(int i=N-1; i>=0; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void ArrayProcesser(int N, int M, Scanner sc){
        // Process two Dimentional array
        int[][] mat = new int[N][M];   

        System.out.print("Enter " + N*M + " Values\n");
        
        // iterate using normal for loop
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        // print matrix using normal for loop
        System.out.print("Given Matrix\n");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    
    public void ArrayProcesser(int N, int M, int P, Scanner sc){
        // Process three Dimentional array
        int[][][] space = new int[N][M][P];   

        System.out.print("Enter " + N*M*P + " Values\n");
        // iterate using normal for loop
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<P; k++){
                    space[i][j][k] = sc.nextInt();
                }
            }
        }

        System.out.println();
    }

    public void ArrayProcesser(Scanner sc){
        // Process array of user defined type
        Employee[] emps = new Employee[5];
        emps[0]= new Employee(11, "Alice");
        emps[1]= new Employee(22, "Bob");
        emps[2]= new Employee(33, "Jim");
        // emps[4]= new Employee(55, "Hyderabad");

        for(Object o: emps){
            if(o instanceof Employee){ // to avoid NullPointerException
                Employee emp = (Employee)o;
                System.out.println(emp.id+" "+emp.name);
            }else if(o == null){
                System.out.println(o);
            }
        }
    }
}

class Employee{
    int id;
    String name;
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}
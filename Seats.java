import java.util.*;
class SeatsArangement{
    Integer count,maxrow,maxcol;
    List<Integer> inputMAT = new ArrayList<Integer>();
    SeatsArangement(){
        this.count = 0; this.maxrow = 0; this.maxcol = 0;
    }

    public void getInput(){
        Scanner sc = new Scanner(System.in);
        Integer val;
        while(true)
        {
            String line = new String(sc.nextLine());
            if(line.length()==0)
            {
                break;
            }else{
                String[] integerStrings = line.split(" "); 
                for (int i = 0; i < integerStrings.length; i++){
                    val = Integer.parseInt(integerStrings[i]);
                    this.inputMAT.add(val);
                    count++;
                }
            }
        }
        System.out.println(this.inputMAT.toString());
        if(count%2 != 0){
            this.count=this.count-1; 
            this.inputMAT.remove(this.count.intValue());
        }
        for(int i =0; i < this.count ; i++){
            val = this.inputMAT.get(i);
            if(i%2 == 0 && this.maxrow < val){
                this.maxrow = val; 
            }
            if(i%2 == 1 && this.maxcol < val){
                this.maxcol = val;
            }
        }

        System.out.println(this.inputMAT.toString());
        System.out.println(this.maxrow);
        System.out.println(this.maxcol);
        
        sc.close();
    }

    // public void getBluePrintofMAP(){
    //     var actualCols = (this.count / 2 ) + this.count - 1;
    //     var actualRows = this.maxrow;
        

    // }
}

public class Seats{
    public static void main(String args[]){
        SeatsArangement sa = new SeatsArangement();
        sa.getInput();
    }

}
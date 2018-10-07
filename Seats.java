import java.util.*;


class Seats{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        List<Integer> mat = new ArrayList<Integer>();
        Integer val,count=0,maxrow=0,maxcol=0;
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
                    mat.add(val);
                    count++;
                }
            }
        }
        System.out.println(mat.toString());
        if(count%2 != 0){
            count=count-1; 
            mat.remove(count.intValue());
        }
        for(int i =0; i < count ; i++){
            val = mat.get(i);
            if(i%2 == 0 && maxrow < val){
               maxrow = val; 
            }
            if(i%2 == 1 && maxcol < val){
                maxcol = val;
            }
        }


        System.out.println(mat.toString());
        System.out.println(maxrow);
        System.out.println(maxcol);
        
        sc.close();
    }

}
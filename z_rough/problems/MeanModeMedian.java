import java.io.*;
import java.util.*;

import javax.xml.bind.Element;

public class MeanModeMedian {
    public static ArrayList getListOfKeysForAValue(Map<Long,Integer> countMap, Integer value){
        ArrayList<Long> keys = new ArrayList<Long>();
        Iterator it = countMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue() == value){
                keys.add( (Long)pair.getKey() );
            }
        }
        return keys;
    }
    public static double getMean(long sum, long n){
        return (double) sum / n;
    }
    public static double getMedian(Long[] arr,int n){
        ArrayList<Long> arrayList = new ArrayList<Long>(Arrays.asList(arr));
        int mid = (int)Math.floor(n/2);
        Collections.sort(arrayList);
        return (double) (arrayList.get(mid-1) + arrayList.get(mid) ) / 2;
    }
    public static Long getMode(Map<Long,Integer> countMap){
        Integer minCount =  Collections.min(countMap.values());
        ArrayList<Long> al =  getListOfKeysForAValue(countMap,minCount);
        return Collections.min(al);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Long,Integer> countMap = new HashMap<>();
        long sum =0;
        int n = sc.nextInt();
        Long arr[] = new Long[n];
        Integer curr;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextLong();
            sum += arr[i];
            curr = (countMap.get(arr[i]) == null)? 0 : countMap.get(arr[i]);
            countMap.put(arr[i], curr + 1);
        }
        System.out.println(getMean(sum,n));
        System.out.println(getMedian(arr,n));
        System.out.println(getMode(countMap));
        
        // System.out.println(countMap.values());
    }
}
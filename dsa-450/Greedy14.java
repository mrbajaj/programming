/**
 * URL: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Greedy14{

    public static void main(String[] args) {
        Solution sol = new Solution();

        // System.out.println(sol.maxMeetings(new int[]{1,3,0,5,8,5}, new int[]{2,4,6,7,9,9}, 6));

        System.out.println(sol.maxMeetings(new int[]{5,1,0,3,5,8}, new int[]{9,2,6,4,7,9}, 6));

        System.out.println(sol.maxMeetings(new int[]{75250, 50074, 43659, 8931, 11273,
            27545, 50879, 77924}, new int[]{112960, 114515, 81825, 93424, 54316,
                35533, 73383, 160252}, 8));

    }
}

class Meeting{
    int start;
    int end;
    int index;
    Meeting(int s, int e, int i){
        start = s;
        end = e;
        index = i;
    }

    public String toString(){
        return "start=" + start + ", end=" + end + ", index=" + index + "\n";
    }
}

class MeetingComparator implements Comparator<Meeting> {
    
    public int compare(Meeting a, Meeting b) {
        // if a > b return +ve
        // if a < b return -ve
        // if a == b return 0
        return a.end - b.end;
    }
}

class Solution {
    
   public static int maxMeetings(int start[], int end[], int n) {
       int maxMeetings = 0;
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Meeting meeting = new Meeting(start[i], end[i], i);
            meetings.add(meeting);
        }
        Collections.sort(meetings, new MeetingComparator());

        int lastEndTime = 0;
        for(Meeting meeting : meetings){
            if(lastEndTime < meeting.start){
                lastEndTime = meeting.end;
                maxMeetings++;
            }
        }

        System.out.println(meetings);
        return maxMeetings;
    }

}
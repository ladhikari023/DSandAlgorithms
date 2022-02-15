package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Activity{
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}
class MyCmp implements Comparator<Activity>{
    @Override
    public int compare(Activity a1, Activity a2) {
        return a1.finish - a2.finish;
    }
}
public class GreedyProblems {
    public static void main(String[] args) {
        Activity[] arr = {new Activity(12,25),new Activity(10,20),new Activity(20,30)};
        System.out.println(maxActivity(arr).get(1).finish);
    }

    private static ArrayList<Activity> maxActivity(Activity[] arr) {
        Arrays.sort(arr,new MyCmp());
        ArrayList<Activity> solution = new ArrayList<>();
        Activity prev = arr[0];
        solution.add(prev);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].start >= prev.finish){
                solution.add(arr[i]);
                prev = arr[1];
            }
        }
        return solution;
    }
}

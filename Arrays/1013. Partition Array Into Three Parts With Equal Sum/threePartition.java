import java.util.*;
public class threePartition {
    public static boolean threePart(int arr[]){
        int sum = Arrays.stream(arr).sum(), average = sum/3, counter = 0, partSum = 0;
        for(int a: arr){
            partSum += a;
            if(partSum == average){
                counter++;
                partSum = 0;
            }
        }
        return counter >= 3 && sum%3 == 0;
    }

    public static void main(String[] args) {
        int arr[] = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(threePart(arr));
    }
}
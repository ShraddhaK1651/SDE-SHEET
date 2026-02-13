You are given an array.
At each step:
If array length > 1 → remove any two different elements (X ≠ Y) in one step.
If only one element remains → remove it in one step
👉 We must minimize number of steps to remove all elements.

=>WE CAN SOLVE THIS USING SORTING OR USING HASHMAP.
  
  import java.util.*;                  //USING HASHMAP    Time Complexity O(n) Space Complexity O(n)
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    HashMap<Integer,Integer>map=new HashMap<>();       
    for(int num:arr){
      map.put(num,map.getOrDefault(num,0)+1);
    }
    int maxFreq=0;
    for(int freq:map.values()){
      maxFreq=Math.max(maxFreq,freq);
    }
    int result=Math.max(maxFreq,(n+1)/2);
  }
}


(Without HashMap)=>
  
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        int maxFreq = 1;
        int currentFreq = 1;

        for(int i = 1; i < n; i++) {

            if(arr[i] == arr[i - 1]) {
                currentFreq++;
            } else {
                maxFreq = Math.max(maxFreq, currentFreq);
                currentFreq = 1;
            }
        }

        // Final update for last group
        maxFreq = Math.max(maxFreq, currentFreq);

        int result = Math.max(maxFreq, (n + 1) / 2);

        System.out.println(result);
    }
}


If interviewer asks:
Why max(maxFreq, ceil(n/2))?

You say:
"We try to remove two different elements at every step.
The limiting factor is the element with maximum frequency.
If its frequency is more than half of the array size, it cannot be fully paired, so answer becomes maxFreq.
Otherwise, we can pair most elements, so answer becomes ceil(n/2)."















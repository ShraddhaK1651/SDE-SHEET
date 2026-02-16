You have a certain number of processors, each having 4 cores. The number of tasks to be executed is four times the number of processors. Each task must be assigned to a unique core, and each core can only be used once.
You are given an array processorTime representing the time each processor becomes available and an array tasks representing how long each task takes to complete. Return the minimum time needed to complete all tasks.
Example 1:
Input: processorTime = [8,10], tasks = [2,2,3,1,8,7,4,5]
Output: 16
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int k=0;
        int Max=0;
        int Sum=0;
        for(int i=0; i<processorTime.size(); i++){
            int sum=0;
            int max=0;
            
            int pt=processorTime.get(i);
            int j=0;
            
            while(j<4){
                sum=pt+tasks.get(k);
                max=Math.max(sum,max);
                j++;
                k++;
            }
            Sum=max;
            Max=Math.max(Max,Sum);
        }
        return Max;
    }
}

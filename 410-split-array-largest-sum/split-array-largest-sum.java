class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<=high){
            int mid=low+(high-low)/2;
            int p=cansplit(nums,mid);
            if(p>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public int cansplit(int a[],int maxSum){
         int partitions = 1; // at least one partition
        long subarraySum = 0; // sum of current subarray
          for (int num : a) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }
        return partitions;
    }
}
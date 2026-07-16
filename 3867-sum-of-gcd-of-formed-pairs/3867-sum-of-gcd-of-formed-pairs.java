import java.util.Arrays;

class Solution {
    public long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long arr[]=new long[n];
        long l=nums[0];
        for(int i=0; i<n; i++){
            if(nums[i]>l){
                l=nums[i];
            }
            long x=gcd(nums[i],l);
            arr[i]=x;
        }
        long sum = 0;
        int start = 0;
        int end = n-1;
        Arrays.sort(arr);
        while(start < end){
            sum+= gcd(arr[start],arr[end]);
            start++;
            end--;
        }     
        return sum;
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int n=arr.length;

        int left=0;
        int right=n-1;
        int mid;

        while(left<right){
            mid=left+(right-left)/2;
            int val=arr[mid];

            if( mid-1>=0 && mid+1<n && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
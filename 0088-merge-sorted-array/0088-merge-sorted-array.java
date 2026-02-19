class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int arr[]=new int[m+n];
        int i=0,j=0,k=0;

        while(j<m && k<n){
            if(nums1[j]<nums2[k]){
                arr[i++]=nums1[j++];
            }else{
                arr[i++]=nums2[k++];
            }
        }

        while(j<m){
            arr[i++]=nums1[j++];
        }

        while(k<n){
            arr[i++]=nums2[k++];
        }

       //dont need the merged array rather the sorted 
       //form to be copied in num1(it actually has length m+n but only m is filled)
       //

       for(int p=0; p<m+n; p++){
        nums1[p]=arr[p];
       }
    }
}
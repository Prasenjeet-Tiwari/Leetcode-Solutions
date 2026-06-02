class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low= 0;
        int high= arr.length;
        while(low<high){
            int mid= low + (high-low)/2;
            if(arr[mid]-mid-1 < k){
                low=mid+1;
            }else{
                high=mid;
            }
        }        

        return low+ k;
    }
}

// Assume the final result is x,
// And there are m number not missing in the range of [1, x].
// Binary search the m in range [0, A.size()].

// If there are m number not missing,
// that is A[0], A[1] .. A[m-1],
// the number of missing under A[m] is A[m] - 1 - m.

// If A[m] - 1 - m < k, m is too small, we update left = m.
// If A[m] - 1 - m >= k, m is big enough, we update right = m.

// Note that, we exit the while loop, l = r,
// which equals to the number of missing number used.
// So the Kth positive number will be l + k.

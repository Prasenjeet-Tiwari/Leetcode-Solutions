class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        Stack<Integer> st=new Stack<>();
        int n=nums2.length;

        int nextGreat[]=new int[nums2.length];

        for(int i=n-1; i>=0; i--){
            int curr= nums2[i];
            while(!st.isEmpty() && st.peek()<curr){
                st.pop();
            }
            if( st.isEmpty()){
                nextGreat[i]=-1;

            }else{
                nextGreat[i]=st.peek();
            }
            st.push(curr);
        }

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums2[j]==nums1[i]){
                    nums1[i]=nextGreat[j];
                    break;
                }
            }
        }

        return nums1;        
    }
}
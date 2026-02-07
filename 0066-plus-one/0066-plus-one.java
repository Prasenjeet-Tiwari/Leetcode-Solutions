class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry =1; //for initial addition at end of array,(will keep on updating)

        for(int i=digits.length-1; i>=0; i--){

            int curr = digits[i] + carry;
           
            if(curr>9){
                digits[i]=curr%10;  //i.e. 1
                carry=1;
            }else{
                digits[i]=curr;
                carry=0;   //No need for this line still for understanding to tell no more carry left
                break;
            }
        }

        //if in end carry exist
        //we need new array with length +1 then digits(to add 1 in front)
        if(carry==1){
            int arr[]=new int[digits.length+1];
            arr[0]=1;
            for(int j=1; j<arr.length; j++){
                arr[j]=digits[j-1];
            }

            return arr;
        }

        return digits;
    }
}
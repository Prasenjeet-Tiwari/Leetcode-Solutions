class Solution {
    public int reverseBits(int n) {

        String curr = Integer.toBinaryString(n);

        // make it 32 bits
        while(curr.length() < 32){
            curr = "0" + curr;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = curr.length()-1; i >= 0; i--){
            sb.append(curr.charAt(i));
        }

        String str=sb.toString();

        return (int)Long.parseLong(str, 2);
    }
}
//Optimized ans below

/*class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for(int i = 0; i < 32; i++){
            result <<= 1;        // shift left
            result |= (n & 1);   // take last bit
            n >>= 1;             // move to next bit
        }

        return result;
    }
}*/ 

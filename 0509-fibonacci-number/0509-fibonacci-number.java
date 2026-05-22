class Solution {

    public int tabulation(int n){
        if(n==0 || n==1) return n;
        int arr[]=new int[n+1];
        arr[0]=0; arr[1]=1;

        for(int i=2; i<n+1; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n]; //it n+1 index value(in terms of 1 based indx)
    }
    public int fib(int n) {
        return tabulation(n);
    }
}
class Solution {
    public int maxProduct(int n) {
        
        int arr[]=new int[10];

        while(n>0){
            int rem=n%10;
            n/=10;
            arr[rem]=arr[rem]+1;
        }
        int a=0,b=0;
        int i=9;
        while(i>=0 && (a==0 || b==0)){
            if(arr[i]!=0){
                if(a==0){
                    a=i;
                }else if(b==0){
                    b=i;

                }else{
                    break;
                }
                
                arr[i]=arr[i]-1;
                continue;
            }else{
                i--;
            }
        }
        return a*b;
    }
}
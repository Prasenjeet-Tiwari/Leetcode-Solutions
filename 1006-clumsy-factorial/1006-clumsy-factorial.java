class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();

        stack.push(n);
        int idx = 1;
        for(int i = n-1; i>0; i--){
            if(idx == 1){   //multiply
                stack.push(stack.pop() * i);
            }
            else if(idx == 2){  //divide
                stack.push(stack.pop() / i);
            }
            else if(idx == 3){  //add
                stack.push(i);
            }
            else{   //sub
                stack.push(-i);
                idx = 0;
            }
            idx++;
        }
        int ans = 0;

        //do add and sub at last;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

}
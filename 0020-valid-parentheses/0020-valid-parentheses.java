class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(c==']' || c=='}' || c==')'){
                if(st.isEmpty()){
                    return false;
                }else{
                    if(st.peek()=='(' && c==')'){
                        st.pop();
                    }else if(st.peek()=='[' && c==']'){
                        st.pop();
                    }else if(st.peek()=='{' && c=='}'){
                        st.pop();
                    }else{
                        return false;
                    }
                }

            }else{
                st.push(c);
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
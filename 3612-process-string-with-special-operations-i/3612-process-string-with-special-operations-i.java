class Solution {

    public String processStr(String s) {
        String output="";
        for(char c : s.toCharArray()){
            char curr= c;
            if(c=='*'){
                if(output.length()>=1){
                   output= output.substring(0, output.length()-1);
                }
                
            }else if(c=='#'){
                output=output+output;
            }else if(c=='%'){
               output= new StringBuilder(output).reverse().toString();
            }else{
                output=output+c;
            }
        }
        return output;
    }
}
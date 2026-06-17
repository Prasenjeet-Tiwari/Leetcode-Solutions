class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> boys= new LinkedList<>();
        Queue<Integer> sand= new LinkedList<>();
        for(int i=0; i<students.length; i++){
            boys.offer(students[i]);
            sand.offer(sandwiches[i]);
        }
        int count=0;
        int size=boys.size();

        while( !boys.isEmpty()){
            if(boys.peek()==sand.peek()){
                boys.poll();
                sand.poll();
                count=0;
            }else{
                boys.offer( boys.poll());
                count++;
                size= boys.size();
            }
            if(count>=size){
                break;
            }
        }

        return boys.size();
        
    }
}
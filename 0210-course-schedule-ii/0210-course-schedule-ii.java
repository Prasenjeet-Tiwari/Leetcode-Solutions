class Solution {
    public boolean directeddfs(int i,List<List<Integer>> list, boolean[] vist, boolean[] pathVist, List<Integer> ansList){

        vist[i]=true;
        pathVist[i]=true;

        for(int child : list.get(i)){
            if(!vist[child]){
                if(directeddfs(child, list, vist,pathVist, ansList)){
                    return true;
                }
            }else if(pathVist[child]==true){
                return true;
            }
        }
        pathVist[i]=false;
        ansList.add(i);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            list.get(pre).add(course);
        }
        

        //dfs cycle detection
        boolean[] vist = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<Integer> ansList = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            if(!vist[i]){
                if(directeddfs(i, list, vist, pathVisited, ansList)){
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ansList.get(numCourses - 1 - i);
        }
        return result;
    }
}
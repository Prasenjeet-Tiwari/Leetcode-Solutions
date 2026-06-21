class Solution {

    public boolean cycleDetect( List<List<Integer>> graph, int src, boolean[] vist, boolean[] pathVist){
        //Note directed graph hai so need pathVisited logic
        //dfs logic +  cycle detection logic(return true false) + diercte dso (pathVist)

        vist[src]=true;
        pathVist[src]=true;

        for(int child: graph.get(src)){
            if( !vist[child]){
                if( cycleDetect(graph, child, vist, pathVist)){
                    return true;
                }
            }else if( pathVist[child]){
                return true;
            }
        }

        pathVist[src]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //make directed grapg and check for cycle detection
        //if found then completing that course is not possible

        int v=numCourses; //no of vertices;

        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int src= prerequisites[i][0];       //to take this course
            int dest= prerequisites[i][1];      //need to finish this first
            graph.get(src).add(dest);
        }

        //basic dfs cycle detection logic util

        boolean[] vist=new boolean[v];
        boolean[] pathVist=new boolean[v];

        for(int i=0; i<v; i++){
            if( !vist[i]){
                if(cycleDetect(graph, i, vist, pathVist)){    //if cycle exist
                    return false;                       //then return false;
                }
            }
        }   

        return true;
    }
}
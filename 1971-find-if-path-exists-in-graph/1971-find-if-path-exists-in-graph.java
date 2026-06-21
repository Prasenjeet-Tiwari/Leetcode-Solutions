class Solution {
    public boolean hasPath(List<List<Integer>> graph, boolean[] vist, int source, int dest){

        if(source==dest) return true;

        vist[source]=true;

        for(int child : graph.get(source)){
            if( !vist[child]){
                if( hasPath(graph, vist, child, dest)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int v = n;

        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i< edges.length; i++){
            int a=edges[i][0];
            int b=edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        //basic dfs path detection 
        boolean[] vist=new boolean[v];

        if(hasPath(graph, vist, source, destination)){
            return true;
        }
        return false;
    }
}
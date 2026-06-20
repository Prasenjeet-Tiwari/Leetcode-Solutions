class Solution {
    public void dfs(int src, List<List<Integer>> graph, boolean vis[]){

        vis[src]=true;
        //System.out.println(src);

        for(int child: graph.get(src)){
          if(!vis[child]){
            dfs(child, graph, vis);
          }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        List<List<Integer>> graph= new ArrayList<>();
        int v=isConnected[0].length;    //no. of nodes or vertices

        for(int i=0; i< v; i++){
            graph.add(new ArrayList<>());
        }

        // Array to keep track of visited nodes and add connected nodes of each vertex
        for(int src=0; src < v; src++){
            int sizeDest = isConnected[0].length;
            for(int dest=0; dest<sizeDest; dest++){
                if(src!=dest && isConnected[src][dest]==1){
                    graph.get(src).add(dest);
                }
            }
        }

    //basic dfs call with util func
        boolean[] vis=new boolean[v];
        int components=0;

        for(int i=0; i<v; i++){
            if(!vis[i]){    //whenever not found increment components
                components++;
                dfs(i,graph,vis);
            }

        }

        // Return the total number of provinces(disconnected vertices as a group)
        return components;
    }
}
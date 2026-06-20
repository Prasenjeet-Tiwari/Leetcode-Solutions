class Solution {
    public int findCircleNum(int[][] isConnected) {

        //dfsUtil func structure

        int count =0;
        int n = isConnected.length; //total no. of vertices
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }

    private void dfs(int index,int[][] isConnected,boolean[] visited){
        visited[index]=true;

        //finding the neigbours
        for(int nei=0;  nei<isConnected[index].length;  nei++){ //similar to for(int child : list.get(src))
            if(isConnected[index][nei]==1){                        //imp. add only if is connected (condition)
                //neighbour 
                if(!visited[nei]) dfs(nei,isConnected,visited);
            }
        }
    }
}
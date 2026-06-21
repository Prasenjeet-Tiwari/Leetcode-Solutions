class Solution {

    public void dfs(int[][] image, int x, int y, int colour, int startColour){
        int xCord[]={ 1, -1, 0, 0};
        int yCord[]={ 0, -0, -1, 1};

        int m=image.length;
        int n=image[0].length;

        image[x][y]=colour;

        for(int i=0; i<4; i++){
            int xNew= x + xCord[i];
            int yNew= y + yCord[i];
            if( xNew<0 || xNew>=m || yNew<0 || yNew>=n){
                continue;
            }
            if( image[xNew][yNew]== startColour){
                //System.out.print( xNew+ " : "+yNew+"  ");
                dfs(image, xNew, yNew, colour, startColour);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int colour) {

        int startColour=image[sr][sc];

        if(colour== startColour) return image;

        //dfs(int[][] image, int x, int y, int colour, int startColour)

        dfs(image, sr, sc, colour, startColour);

        return image;      
        
    }
}
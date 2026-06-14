class Solution {
    int idx=0;

    public TreeNode construct(int[] inorder,int[] postorder,HashMap<Integer,Integer> hm,int start,int end){
        
        if(start>end){
            return null;
        }

        int val=postorder[idx++];
        TreeNode root=new TreeNode(val);
        int mid=hm.get(val);

        root.right=construct(inorder,postorder,hm,mid+1,end);
        root.left=construct(inorder,postorder,hm,start,mid-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder){

        //reverse post order
        for(int i=0;i<postorder.length/2;i++){

            int temp=postorder[i];
            postorder[i]=postorder[postorder.length-1-i];
            postorder[postorder.length-1-i]=temp;
        }

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        return construct(inorder,postorder,hm,0,inorder.length-1);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void elements(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        elements(root.left,list);
        list.add(root.val);
        elements(root.right,list);

    }  

    public TreeNode BuildBST(List<Integer> list,int start,int end){
        if(start>end){
             return null;
        }
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=BuildBST(list, start, mid-1);
        root.right=BuildBST(list, mid+1, end);
        return root;
    
    }
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> list=new ArrayList<>();
        elements(root,list);

        int size=list.size();
        int start=0; int end=size-1;

        TreeNode newRoot=BuildBST(list,start,end);

        return newRoot;
        
    }
}
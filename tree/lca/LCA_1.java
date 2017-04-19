//	Reference: https://www.youtube.com/watch?v=13m9ZCB8gjw
//	Return Lowest Common Ancestor in O(n) time and O(1) space
static public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
	if(root == null)
		return null;
	
	if(root == p || root == q)
		return root;
	
	//	1. Will return p or q if either of them is present on left subtree
	//	2. Will return LCA of p & q (which will be != p or q) if both are present on left subtree
	//	3. Will return null if none are present
	TreeNode fromLeft = LCA(root.left, p, q);
	//	For condition 2, above
	if(fromLeft != null && fromLeft != p && fromLeft != q)
		return fromLeft;
	
	//	Same explanation as for left subtree
	TreeNode fromRight = LCA(root.right, p, q);
	if(fromRight != null && fromRight != p && fromRight != q)
		return fromRight;
	
	//	If both are not null, it means each node is present on either subtrees and hence root is the LCA
	if(fromLeft != null && fromRight != null)
		return root;
	
	//	If one node is present on left subtree or right subtree, return that
	if(fromLeft != null)
		return fromLeft;
	if(fromRight != null)
		return fromRight;
	
	// If no node is present on left subtree or right subtree, return null
	return null;
}
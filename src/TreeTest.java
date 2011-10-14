public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println("lca for 1 & 3 is " + lca(root, root.left.left, root.left.right));
        System.out.println("lca for 1 & 7 is " + lca(root, root.left.left, root.right.right));
        System.out.println("lcaR for 1 & 3 is " + lcaR(root, root.left.left, root.left.right));
        System.out.println("lcaR for 1 & 7 is " + lcaR(root, root.left.left, root.right.right));

//        checkPrime(13);
//        checkPrime(4);
//        checkPrime(3);


    }

    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
        // Check if one and two are in the root tree.
        while (root != null) {
            if (root.data < one.data && root.data < two.data) {
                root = root.right;
            } else if (root.data > one.data && root.data > two.data) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }

    private static TreeNode lcaR(TreeNode root, TreeNode one, TreeNode two) {
        // Check if one and two are in the root tree.
        if(root == null)
            return null;
        if (root.data < one.data && root.data < two.data) {
            return lcaR(root.right, one, two);
        } else if (root.data > one.data && root.data > two.data) {
            return lcaR(root.left, one, two);
        } else {
            return root;
        }

    }

//    private TreeNode findLCA(TreeNode root, int p, int q) {
//
//        // no root no LCA.
//        if (root == null) {
//            return null;
//        }
//
//        // if either p or q is the root then root is LCA.
//        if (root.data == p || root.data == q) {
//            return root;
//        } else {
//            // get LCA of p and q in left subtree.
//            TreeNode l = findLCA(root.left, p, q);
//
//            // get LCA of p and q in right subtree.
//            TreeNode r = findLCA(root.right, p, q);
//
//            // if one of p or q is in leftsubtree and other is in right
//            // then root it the LCA.
//            if (l && r) {
//                return root;
//            }
//            // else if l is not null, l is LCA.
//            else if (l != null) {
//                return l;
//            } else {
//                return r;
//            }
//        }
//    }
}

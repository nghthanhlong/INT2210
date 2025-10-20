public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    private TreeNode searchRecursion(TreeNode root, int key) {
        if (root == null) return null;
        if (root.key == key) return root;
        if (key < root.key) {
            return searchRecursion(root.left, key);
        } else {
            return searchRecursion(root.right, key);
        }
    }

    public boolean search(int key) {
        TreeNode res = searchRecursion(root, key);
        return res != null;
    }

    private TreeNode insertRecursion(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.key) {
            root.left = insertRecursion(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursion(root.right, key);
        }
        return root;
    }

    public void insert(int key) {
        root = insertRecursion(root, key);
    }

    private TreeNode deleteRecursion(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.key) {
            root.left = deleteRecursion(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursion(root.right, key);
        } else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode successorNode = findMin(root.right);
                root.key = successorNode.key;
                root.right = deleteRecursion(root.right, successorNode.key);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void delete(int key) {
        root = deleteRecursion(root, key);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        System.out.println("Inserting");
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inOrder();

        System.out.println("\nSearching");
        System.out.println("Found 40: " + bst.search(40)); // Expected: true
        System.out.println("Found 99: " + bst.search(99)); // Expected: false

        System.out.println("\nDeleting leaf node");
        bst.delete(20);
        bst.inOrder();

        System.out.println("\nDeleting one child node");
        bst.delete(30);
        bst.inOrder();

        System.out.println("\nDeleting two children node");
        bst.delete(50); // Replaced by successor 60
        bst.inOrder();

    }
}

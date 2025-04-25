package Classes;
import java.util.Comparator;
import java.util.function.Function;

public class AVL_Trees<T> {
    public static class TreeNode <T> {
        protected T value;
        protected TreeNode<T> left;
        protected TreeNode<T> right;
        protected int height;

        public TreeNode(T value) {
            this.value = value;
            this.height = 0;
        }
    }

    private final Comparator<T> comparator;
    private TreeNode<T> root;

    public AVL_Trees(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public void insert(T value) {
        /*Update root to add new values*/
        root = insert(root, value);
    }

    private TreeNode<T> insert(TreeNode<T> root, T value) {
        /*root null equal to new root*/
        if (root == null) {
            root = new TreeNode<>(value);
        }
        /*If value is min than root, value is going to be inserted at theleft */
        if (comparator.compare(value, root.value) < 0) {
            root.left = insert(root.left, value);
            /*If value is max than root, value is going to be inserted at right */
        } else if (comparator.compare(value, root.value) > 0) {
            root.right = insert(root.right, value);
        }

        /*Update each root height and rebalanced Binary Tree*/
        updateHeight(root);
        return rebalanced(root);
    }


    private void updateHeight(TreeNode<T> root) {
        if (root != null) {
            /*Get left and right height, compare and get max height, then add 1*/
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    private int getHeight(TreeNode<T> root) {
        if (root == null) { return 0; }
        return root.height;
    }

    private int getRealHeight(TreeNode<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(getRealHeight(node.left), getRealHeight(node.right));
    }

    /*Return balanceFactor of the current root*/
    private int balanceFactor(TreeNode<T> root) {
        if (root == null) { return 0; }
        return getHeight(root.left) - getHeight(root.right);
    }

    private TreeNode<T> rotateRight(TreeNode<T> root) {
        /*Create new leftNode*/
        TreeNode<T> left = root.left;
        /*left of root now is right of left root*/
        root.left = left.right;
        /*right of left now is the root*/
        left.right = root;

        /*Update each height*/
        updateHeight(root);
        updateHeight(left);

        return left;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> root) {
        /*Create new rightNode*/
        TreeNode<T> right = root.right;
        /*The right of root now is left of the right root*/
        root.right = right.left;
        /*left of right now is the root*/
        right.left = root;

        /*Update each height*/
        updateHeight(root);
        updateHeight(right);

        return right;
    }

    private TreeNode<T> rebalanced(TreeNode<T> root) {
        if (root == null) return null;

        /*Get the balance factor of the current disbalanced root*/
        int balance = balanceFactor(root);

        // Disbalanced at the left
        if (balance > 1) {
            if (balanceFactor(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);
        }

        // Disbalanced at right
        if (balance < -1) {
            if (balanceFactor(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        }

        updateHeight(root);
        return root;
    }


    public int size() {
        return size(root);
    }

    private int size(TreeNode<T> root) {
        if (root == null) { return 0; }

        /*Recursive code to get left and right sizes*/
        int left = size(root.left);
        int right = size(root.right);

        /*return both sizes plus 1, that represent root new size*/
        return left + right + 1;
    }


    public void traverseByLevels(Function<T, ?> extractor) {
        int height = getRealHeight(root);
        for (int level = 0; level < height; level++) {
            printLevel(root, level, extractor);
        }
        System.out.println();
    }


    private void printLevel(TreeNode<T> root, int level, Function<T, ?> extractor) {
        if (level == 0) {
            if (root == null) {
                System.out.print("null ");
            } else {
                System.out.printf("%s ", extractor.apply(root.value));
            }
        } else {
            if (root == null) {
                printLevel(null, level - 1, extractor);
                printLevel(null, level - 1, extractor);
            } else {
                printLevel(root.left, level - 1, extractor);
                printLevel(root.right, level - 1, extractor);
            }
        }
    }
}

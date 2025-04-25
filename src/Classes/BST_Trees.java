package Classes;

import java.util.*;
import java.util.function.Function;

public class BST_Trees<T> {
    private static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    private TreeNode<T> root;
    private final Comparator<T> comparator;

    public BST_Trees(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private TreeNode<T> insert(TreeNode<T> root, T value) {
        if (root == null)
            return new TreeNode<>(value);

        if (comparator.compare(value, root.value) < 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }


    public void traverseByLevels(Function<T, ?> extractor) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        Queue<TreeNode<T>> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);

        boolean realElement = true;

        while (!q.isEmpty() && realElement) {
            realElement = false;
            int actualLevel = q.size();
            List<String> levelResult = new ArrayList<>();

            for (int i = 0; i < actualLevel; i++) {
                TreeNode<T> curr = q.poll();
                if (curr != null) {
                    levelResult.add(extractor.apply(curr.value).toString());
                    q.add(curr.left);
                    q.add(curr.right);
                    // Si hay hijos no nulos, marcar como significativo
                    if (curr.left != null || curr.right != null) {
                        realElement = true;
                    }
                } else {
                    levelResult.add("null");
                }
            }

            // Agregar el resultado del nivel actual al resultado total
            result.append(String.join(",", levelResult)).append(",");
        }

        // Elimina la última coma y muestra el resultado
        if (!result.isEmpty()) {
            result.setLength(result.length() - 1); // Eliminar la coma final
        }
        System.out.println(result);
    }


}

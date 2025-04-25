package Classes;
import java.util.HashMap;
import java.util.Map;

public class TreeStorage {
    public static class TreePair<T> {
        public AVL_Trees<T> AVL;
        public BST_Trees<T> BST;

        public TreePair() {
            this.AVL = null;
            this.BST = null;
        }
    }

    private Map<String, TreePair<?>> Trees = new HashMap<>();

    public Map<String, TreePair<?>> getTrees() {
        return Trees;
    }
    // Registrar un AVL
    public <T> boolean registerAVL(String sortFactor, AVL_Trees<T> AVL) {
        TreePair<T> pair;
        if (Trees.containsKey(sortFactor)) {
            pair = (TreePair<T>) Trees.get(sortFactor);
            if (pair.AVL != null) {
                System.out.println("Ya existe un AVL con este criterio.");
                return false;
            }
            if (pair.BST != null) { // Verifica si ya existe un BST
                System.out.println("No se puede agregar un AVL si ya existe un BST para este criterio.");
                return false;
            }
            pair.AVL = AVL;
        } else {
            pair = new TreePair<>();
            pair.AVL = AVL;
            Trees.put(sortFactor, pair);
        }
        System.out.printf("Arbol AVL ordenado por %s creado con exito!", sortFactor);
        System.out.println();
        return true;
    }

    // Registrar un BST
    public <T> boolean registerBST(String sortFactor, BST_Trees<T> BST) {
        TreePair<T> pair;
        if (Trees.containsKey(sortFactor)) {
            pair = (TreePair<T>) Trees.get(sortFactor);
            if (pair.AVL != null) {
                System.out.println("No se puede agregar un BST si ya existe un AVL para este criterio.");
                return false;
            }
            pair.BST = BST;
        } else {
            pair = new TreePair<>();
            pair.BST = BST;
            Trees.put(sortFactor, pair);
        }
        System.out.printf("Arbol BST ordenado por %s creado con exito!", sortFactor);
        System.out.println();
        return true;
    }
}

import Produse.*;
public class bstClass {
    class Node {
        Audio a;
        Node left, right;
        public Node(Audio data){
            a = data;
            left = right = null;
        }
    }
    Node root;

    bstClass(){
        root = null;
    }

    Node stergere(Node root, double key)  {
        if (root == null)  return root;

        if (key < root.a.getPret())
            root.left = stergere(root.left, key);
        else if (key > root.a.getPret())
            root.right = stergere(root.right, key);
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.a.setPret(minValue(root.right));

            root.right = stergere(root.right, root.a.getPret());
        }
        return root;
    }
    static double minValue(Node root)  {
        double minVal = root.a.getPret();
        while (root.left != null)  {
            minVal = root.left.a.getPret();
            root = root.left;
        }
        return minVal;
    }

    static double maxValue(Node root)  {
        double maxVal = root.a.getPret();
        while (root.right != null)  {
            maxVal = root.right.a.getPret();
            root = root.right;
        }
        return maxVal;
    }

    void insert(Audio key)  {
        root = insertRecursiv(root, key);
    }

    Node insertRecursiv(Node root, Audio key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key.getPret() < root.a.getPret())
            root.left = insertRecursiv(root.left, key);
        else if (key.getPret() > root.a.getPret())
            root.right = insertRecursiv(root.right, key);
        return root;
    }

    void inorder() {
        inorderRecursiv(root);
    }

    void inorderRecursiv(Node root) {
        if (root != null) {
            inorderRecursiv(root.left);
            System.out.println(root.a + " ");
            inorderRecursiv(root.right);
        }
    }

    static Node cautareRecursiva(Node root, double key)  {
        if (root==null || root.a.getPret()==key)
            return root;
        if (root.a.getPret() > key)
            return cautareRecursiva(root.left, key);

        return cautareRecursiva(root.right, key);
    }

    public static void main(String[] args){
        bstClass bst = new bstClass();
        bst.insert(new Audio("boxe", "hama", 100));
        bst.insert(new Audio("casti", "apple", 200));
        bst.insert(new Audio("boxe", "logitech", 11));
        bst.insert(new Audio("sistem", "sony", 1));
        bst.insert(new Audio("boxe", "logitech", 401));
        bst.insert(new Audio("sistem", "sony", 52));
        System.out.println("Afisare functionala:");
        bst.inorder();
        System.out.println();
        System.out.println("Minim: " + minValue(bst.root));
        System.out.println();
        System.out.println("Maxim: " + maxValue(bst.root));
        System.out.println();
        System.out.println("Cautare functionala: " + cautareRecursiva(bst.root, 11).a);
        System.out.println();
        bst.stergere(bst.root, 1);
        System.out.println("Stergere functionala:");
        bst.inorder();
    }
}

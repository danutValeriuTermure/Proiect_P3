import Produse.*;
public class bstClass {
    class Node {
        Produs a;
        Node left, right;
        public Node(Produs data){
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

        if (key < root.a.getNrComenzi())
            root.left = stergere(root.left, key);
        else if (key > root.a.getNrComenzi())
            root.right = stergere(root.right, key);
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.a.setNrComenzi(minValue(root.right));

            root.right = stergere(root.right, root.a.getNrComenzi());
        }
        return root;
    }
    int minValue(Node root)  {
        int minVal = root.a.getNrComenzi();
        while (root.left != null)  {
            minVal = root.left.a.getNrComenzi();
            root = root.left;
        }
        return minVal;
    }

    Node minValueNode(Node root)  {
        int minVal = root.a.getNrComenzi();
        while (root.left != null)  {
            minVal = root.left.a.getNrComenzi();
            root = root.left;
        }
        return root;
    }

    int maxValue(Node root)  {
        int maxVal = root.a.getNrComenzi();
        while (root.right != null)  {
            maxVal = root.right.a.getNrComenzi();
            root = root.right;
        }
        return maxVal;
    }

    Node maxValueNode(Node root)  {
        int maxVal = root.a.getNrComenzi();
        while (root.right != null)  {
            maxVal = root.right.a.getNrComenzi();
            root = root.right;
        }
        return root;
    }

    void insert(Produs key)  {
        root = insertRecursiv(root, key);
    }

    Node insertRecursiv(Node root, Produs key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key.getNrComenzi() < root.a.getNrComenzi())
            root.left = insertRecursiv(root.left, key);
        else if (key.getNrComenzi() > root.a.getNrComenzi())
            root.right = insertRecursiv(root.right, key);
        return root;
    }

    void inorder() {
        inorderRecursiv(root);
    }

    void inorderRecursiv(Node root) {
        if (root != null) {
            inorderRecursiv(root.left);
            inorderRecursiv(root.right);
        }
    }

    Node cautareRecursiva(Node root, double key)  {
        if (root==null || root.a.getNrComenzi()==key)
            return root;
        if (root.a.getNrComenzi() > key)
            return cautareRecursiva(root.left, key);

        return cautareRecursiva(root.right, key);
    }

}

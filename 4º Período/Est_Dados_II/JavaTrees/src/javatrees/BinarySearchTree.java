package javatrees;

public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    public void add(T newData) {
        Node<T> newNode = new Node<T>(newData);
        root = insert(root, newNode);
    }

    private Node<T> insert(Node<T> root, Node<T> newNode) {
        return null;
    }
}

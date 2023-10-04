package javatrees;

public class Node<T extends Comparable<T>> {

    T data;
    Node<T> left, right;

    public Node(T newData) {
        this.data = newData;

        /* java já faz isso sozinho
        this.left = null;
        this.right = null;
         */
    }
}

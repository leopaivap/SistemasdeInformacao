package javatreesremove;

public class Node<T extends Comparable<T>> {

    T dado;
    Node<T> esquerda;
    Node<T> direita;
    int fb;

    public Node(T novoDado) {
        this.dado = novoDado;
        this.esquerda = null;
        this.direita = null;
        this.fb = 0;
    }
}

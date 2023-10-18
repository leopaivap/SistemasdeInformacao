package javatreesaula;

import javax.swing.JTextArea;

public class BinarySearchTree<T extends Comparable<T>> {

    Node raiz = null;
    int cont;

    public int add(T novoDado) {
        Node<T> novoNo = new Node<T>(novoDado);
        cont = 0;
        raiz = inserir(raiz, novoNo);
        return cont;
    }

    private Node<T> inserir(Node<T> raiz, Node<T> novo) {
        cont++;
        if (raiz == null) {
            return novo;
        }

        if (novo.dado.compareTo(raiz.dado) >= 0) {
            raiz.direita = inserir(raiz.direita, novo);
        } else {
            raiz.esquerda = inserir(raiz.esquerda, novo);
        }

        return raiz; // retorna a raiz atualizada
    }

    // mostrar no terminal
    public void preOrder() {
        preOrder(raiz);
    }

    private void preOrder(Node<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.dado + ", ");
            preOrder(raiz.esquerda);
            preOrder(raiz.direita);
        }// fim 
    }

    public void inOrder() {
        inOrder(raiz);
    }

    private void inOrder(Node<T> raiz) {
        if (raiz != null) {
            inOrder(raiz.esquerda);
            System.out.print(raiz.dado + ", ");
            inOrder(raiz.direita);
        }// fim 
    }

    public void postOrder() {
        postOrder(raiz);
    }

    private void postOrder(Node<T> raiz) {
        if (raiz != null) {
            postOrder(raiz.esquerda);
            postOrder(raiz.direita);
            System.out.print(raiz.dado + ", ");
        }// fim 
    }
    //----------------------

    // mostrar no JTEXTAREA
    public void preOrderList(JTextArea list) {
        preOrderList(raiz, list);
    }

    private void preOrderList(Node<T> raiz, JTextArea list) {
        if (raiz != null) {

            list.append(raiz.dado + "\n");
            preOrderList(raiz.esquerda, list);
            preOrderList(raiz.direita, list);
        }// fim 
    }

    public void inOrderList(JTextArea list) {
        inOrderList(raiz, list);
    }

    private void inOrderList(Node<T> raiz, JTextArea list) {
        if (raiz != null) {
            inOrderList(raiz.esquerda, list);
            list.append(raiz.dado + "\n");
            inOrderList(raiz.direita, list);
        }// fim 
    }

    public void postOrderList(JTextArea list) {
        postOrderList(raiz, list);
    }

    private void postOrderList(Node<T> raiz, JTextArea list) {
        if (raiz != null) {
            postOrderList(raiz.esquerda, list);
            postOrderList(raiz.direita, list);
            list.append(raiz.dado + "\n");
        }// fim 
    }

    //----------------------------
    // buscar na arvore
    public boolean contains(T dado) {
        return contains(raiz, dado);
    }

    private boolean contains(Node<T> raiz, T dado) {
        if (raiz == null) {
            return false;
        }

        int comparacao = dado.compareTo(raiz.dado);
        if (comparacao == 0) {
            return true;
        } else if (comparacao < 0) {
            return contains(raiz.esquerda, dado);
        } else {
            return contains(raiz.direita, dado);
        }
    }

}

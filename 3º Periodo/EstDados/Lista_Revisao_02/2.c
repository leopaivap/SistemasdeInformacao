#include <stdio.h>

int verificarOrdemCrescente(No* head) {
    if (head == NULL || head->prox == NULL) {
        return 1;
    }

    No* atual = head;
    while (atual->prox != NULL) {
        if (atual->dado > atual->prox->dado) {
            return 0;  
        }
        atual = atual->prox;
    }

    return 1;  
}
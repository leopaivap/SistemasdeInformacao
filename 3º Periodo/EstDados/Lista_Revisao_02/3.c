#include <stdio.h>

void removerElementosPares(No** head) {
    if (*head == NULL) {
        return;
    }

    No* atual = *head;
    No* anterior = NULL;

    while (atual != NULL) {
        if (atual->dado % 2 == 0) {
            if (anterior == NULL) {
                *head = atual->prox;
                free(atual);
                atual = *head;
            } else {    
                anterior->prox = atual->prox;
                free(atual);
                atual = anterior->prox;
            }
        } else {
            anterior = atual;
            atual = atual->prox;
        }
    }
}

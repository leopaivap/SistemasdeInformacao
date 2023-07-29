#include <stdio.h>

int pesquisa(No* vet, int dado) {
    No* atual = vet;

    while (atual != NULL) {
        if (atual->dado == dado) {
            return 1;
        }
        atual = atual->prox;
    }

    return 0;
}


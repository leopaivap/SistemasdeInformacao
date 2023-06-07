#include <stdio.h>
#include <stdlib.h>

typedef struct{
	char processo[40];
	int tempo;
}tdado;

typedef struct no{
	tdado dado;
	struct no *prox;
}tno;

typedef struct{
	tno *ini,*fim;
	int tamanho;
}tfila;
//--------------------------
void inicializa(tfila *f){
	f->ini = NULL;
	f->fim = NULL;
	f->tamanho = 0;
	//
}
//--------------------------
int enqueue(tfila *f, tdado x){
	if(f->tamanho == MAX)
}
//---------------------------
tdado dequeue(tfila *f){
	tdado removido = f->ini->dado;
	tno *aux = f->ini;
	f->ini = f->ini->prox; // deslocando ponteiro
	
	if(f->ini == NULL)// ultimo elemento
		f->fim = NULL;
		
	free(aux);
	f->tamanho--;
	return removido;
}
//------------------------------
tdado first(tfila *f){
	if(!isEmpty(f))
		return f->ini->dado;
}
//----------------------------
tdado last(tfila *f){
	if(!isEmpty(f))
		return f->fim->dado;
}
//----------------------------
int isEmpty(tfila f){
	if(f.ini == NULL)
		return 1;
	return 0;
}
//--------------------------
void mostra(tfila f){
	while(f.ini != NULL){
		printf("%s : %d |->", f.ini->dado.processo, f.ini->dado.tempo);
		
		f.ini = f.ini->prox; //deslocando
	}
	printf("\n");
}
//----------------------------
int menu(){
	int op;
	printf("*** Estrutura de Dados I - Fila Encadeada ****\n");
	printf("1-Enqueue (Inserir)\n");
	printf("2-Dequeue (Remover)\n");
	printf("3-Inicio e Fim\n");
	printf("0-Sair\n");
	scanf("%d",&op);
	return op;
}
//------------------
int main(){
	tfila f1;
	tdado x, y;
	int op;
	inicializa(&f1);
	do{
		mostra(f1);
		op = menu();
		switch(op){
			case 1: printf("Entre com o processo e tempo:");
					fflush(stdin);
					gets(x.processo);
					scanf("%d",&x.tempo);
					enqueue(&f1, x);
			break;
			case 2: if(!isEmpty(f1)) {
				      x = dequeue(&f1);
				      printf("%s:%d\n", x.processo, x.tempo);
				     }// fim if vazio
				     else
				       printf("Process Queue empty :(\n");
				break;
			case 3:
				x = first(&f1);
				y = last(&f1);
				printf("Inicio: %s:%d\n", x.processo, x.tempo);
				printf("Fim: %s:%d\n", y.processo, y.tempo);
			 break;	
			case 0: printf("Saindo .... ;)\n");	    
		}// fim switch
	    getch(); // system("pause");
	    system("cls");
	}while(op!=0);

	return 0;
}

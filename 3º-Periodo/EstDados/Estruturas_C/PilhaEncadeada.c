#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct{
	int x, y; //cordenadas Labirinto
}tdado;

typedef struct no{
	tdado dado;
	struct no *prox;
}tno;

typedef struct pilha{
	tno *topo;
}tPilha;

//---------------------------
void inicializa(tPilha *p){
	p->topo = NULL;	
}
//---------------------------
int push(tPilha *p ,tdado novoDado){
	tno *novo;
	novo = malloc(sizeof(tno));
	if(novo == NULL)
		return 0;
	novo->dado = novoDado; //atribui o valor
	novo->prox	= p->topo; //proximo é quem era o topo
	p->topo = novo;
	return 1;
}
//-----------------------------
tdado peek(tPilha *p){
	return p->topo->dado;	
}
//-----------------------------
tdado pop(tPilha *p){
	tdado removido = p->topo->dado;
	tno *aux = p->topo; //guardar enderço para liberar memoria
	p->topo = p->topo->prox;
	free(aux);
	return removido;
}
//---------------------------------
int isEmpty(tPilha p){
	if(p.topo == NULL)
		return 1;
	return 0;
	//return p.topo==NULL?1:0;
}
//---------------------------------
void mostraPilha(tPilha p){
	while(p.topo != NULL){
		printf("(%x)[%d, %d] ->%x ", p.topo, p.topo->dado.x, p.topo->dado.y, p.topo->prox);
		p.topo = p.topo->prox;
	}//fim while
	printf("\n");
}
//-------------------------------
int menu(){
	int op;
	printf("*** Estrutura de Dados I - Pilha Encadeada ****\n");
	printf("1-Push (Inserir)\n");
	printf("2-Pop (Remover)\n");
	printf("3-Peek (Olhar Topo)\n");
	printf("4-Trava Windows\n");
	printf("0-Sair\n");
	scanf("%d",&op);
	return op;
}
//------------------------
int main(){
	tPilha p1;
	inicializa(&p1);
	tdado dado; // 
	int op;
	do{
		printf("Endereco do Topo:[%x]\n",p1.topo);
		mostraPilha(p1);
		op = menu();
		switch(op){
			case 1: printf("Dados para pilha[x, y]:");
					scanf("%d",&dado.x);
					scanf("%d",&dado.y);
					if(push(&p1, dado)==1)
						printf("Inserido com sucesso\n");
					else
						printf("Pilha cheia - Stack Overflow\n");	
			break;
			case 2:	if(!isEmpty(p1)){//se nao for vazio
						dado = pop(&p1);
						printf("Dado removido:[%d, %d]\n", dado.x, dado.y);
					}
					else
						printf("Pilha vazia\n");
				break;
			case 3:	if(!isEmpty(p1)){//se nao for vazio
						dado = peek(&p1);
						printf("Dado do topo:[%d, %d]\n", p1.topo->dado.x, p1.topo->dado.y);
					}
					else
						printf("Pilha vazia\n");
				break;
			case 4: 
					srand(time(NULL));
					while(1){
						dado.x = rand()%10;
						dado.y = rand()%10;
					//	printf("Dado Inserido:[%d, %d]\n", dado.x, dado.y);
						push(&p1, dado);
					}
				
					break;					
		}// fim switch
	    getch();// pausa
		system("cls");// limpa tela	
	}while(op!=0);
	return 0;                                
}



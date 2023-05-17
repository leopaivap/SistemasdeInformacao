#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
  char nome[40];
  float media;
  int idade;	
} tdado;
typedef struct no{
	tdado dado;
	struct no *prox,*ant;
}tno;
typedef struct lista{
	tno *head,*tail;
	int qtd;
}tlista;
//---------------------------------------
void inicializaLista(tlista *lista){
	lista->head=NULL;
	lista->tail=NULL;
	lista->qtd=0;
}
//-------------------------------------
void inicializa(tlista v[],int m) 
{ 
    int i;
        for(i = 0; i < m; i++) 
            inicializaLista(&v[i]);
		   
}
//------------------------------------
int insertTail(tlista *l, tdado v){
	tno *novo;
	novo = malloc(sizeof(tno));
	novo->dado = v;
	novo->prox=NULL;
	novo->ant = l->tail;
	if(l->head==NULL)
	  l->head = novo;
	  else
	    l->tail->prox= novo;
	l->tail=novo;  
	l->qtd++;  
	return 1;
}
//----------------------------------
int insertHead(tlista *l, tdado v){
	tno *novo;
	novo = malloc(sizeof(tno));
	novo->dado = v;
	novo->ant = NULL;
	if(l->tail == NULL)
	   l->tail = novo;
	   else
	     l->head->ant = novo;
	novo->prox = l->head;
	l->head= novo;
	l->qtd++;
	return 1;	
}//-----------------------------------
int insereOrdenado(tlista *l, tdado x){
	tno *aux,*novo;
	if(l->head==NULL)
		return insertHead(l,x);
	if(strcmp(x.nome, l->head->dado.nome) <0)	
		return insertHead(l,x);
	if(strcmp(x.nome,l->tail->dado.nome)>0)
		return insertTail(l,x);	
	
	novo = malloc(sizeof(tno));
	novo->dado = x;	
	aux = l->head;// variavel auxiliar para percurso na lista
	while(aux->prox!=NULL){
		if(strcmp(x.nome, aux->dado.nome)>=0 &&
		    strcmp(x.nome, aux->prox->dado.nome)<0){
		    	novo->ant = aux;
		    	novo->prox = aux->prox;
		    	aux->prox->ant = novo;
		    	aux->prox = novo;
		    	l->qtd++;
		    	return 1;
			}
		aux = aux->prox;
	}// fim while
}
//------------------------------------
int removeHead(tlista *l){
	tno *aux; 
	aux=l->head;
	l->head=l->head->prox;
	if(l->head==NULL)
	  l->tail=NULL;
	  else
	   l->head->ant=NULL;
	free(aux);
	l->qtd--;
	return 1;     
}
//------------------------
int removeTail(tlista *l){
	tno *aux; tdado removido;
	aux=l->tail;
	removido = aux->dado;
	l->tail = l->tail->ant;  
	if(l->tail==NULL)
	   l->head=NULL;
	   else
	    l->tail->prox=NULL;
	free(aux);
	l->qtd--;
	return 1;    
}// fim 
//-----------------------------------
int removeNo(tlista *l, tdado v){
	tno *aux;
	if(l->head==NULL)
	  return 0;
	if(strcmp(v.nome,l->head->dado.nome)==0){
		removeHead(l);
		return 1;
	}
	if(strcmp(v.nome,l->tail->dado.nome)==0){
		removeTail(l);
		return 1;
	}
	aux=l->head;
	while(aux->prox!=NULL){
		if(strcmp(v.nome, aux->dado.nome)==0){
			aux->ant->prox = aux->prox;
			aux->prox->ant = aux->ant;
			free(aux);
			l->qtd--;
			return 1;
		}// fim if
		aux=aux->prox; // caminha na lista
	}// fim while
	 return 0; 
}// fim remove
//---------------------------------
void printList(tlista l){
	while(l.head!=NULL){
		printf("%s -> ", l.head->dado.nome);
		l.head = l.head->prox;
	}
}// fim
//-----------------------------------
float buscaList(tlista lista,tdado x){
	while(lista.head != NULL){
		if(strcmp(lista.head->dado.nome, x.nome)==0)
			return x.media;
		lista.head = lista.head->prox;
	}
	return -1;
    
}

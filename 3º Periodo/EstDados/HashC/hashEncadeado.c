#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "hashLista.h"
//-----------------------
int qtd = 0;
int funcaoHash(int k){
	// key ou chave vai ser o primeiro caractere do nome
	return k%65; // 65? é o código ASCII do A
}
//-----------------------
int insereHash(tlista tabHash[],tdado x){
    int map = funcaoHash(x.nome[0]);
	insereOrdenado(&tabHash[map],x);	
	return map;	
	qtd++;
}
//-------------------------
int removeHash(tlista tabHash[], tdado x){
	int removido;
	int map = funcaoHash(x.nome[0]);
	removido = removeNo(&tabHash[map], x);
	return removido;
}
//-------------------------
void printHash(tlista vet[], int n){
	int i;
	for(i=0;i<n;i++){
	   if(vet[i].head!=NULL){ // nao esta vazia	
		printf("[%d]->",i);
		printList(vet[i]);
		printf("\n");
	 }// fim if
	}// fim for
}
//-------------------------
float buscaHash(tlista tabHash[],tdado x){
	float med = -1;
	int map = funcaoHash(x.nome[0]);
	med = buscaList(tabHash[map], x);
	return med;
}
//--------------------------
void salvaArq(tlista tabHash[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosHash.txt","wb");
	fwrite(&tabHash[i], sizeof(tabHash), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}

void carregaArq(tlista tabHash[]){
	FILE *arq;
	arq = fopen("dadoslista.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&tabHash[qtd], sizeof(tlista), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

//--------------------------
int menu(){
	int op;
	printf("*** IFSULDEMINAS - Campus Machado ***\n");
	printf("*** Linked Hash *** \n");
	printf("1-Inserir\n");
	printf("2-Buscar\n");
	printf("3-Remover\n");
	printf("4-Carregar\n");
	printf("0-Sair\n");
	scanf("%d",&op);
	return op;
}
//-----------------------------------------
int main() 
{ 

   int op, r;
   tdado x;
   float med = -1;
   tlista tabHash[26]; // cada posicao tem uma lista que ira guardar uma inicial de nome
   inicializa(tabHash,26);
   do{
   	printHash(tabHash,26);
   	op = menu();
   	switch(op){
   		case 1: printf("Dados: Nome:");
   				fflush(stdin); gets(x.nome);
   				x.nome[0] = toupper(x.nome[0]);
   				printf("Idade:");
   				scanf("%d",&x.idade);
   				printf("Media:");
   				scanf("%f",&x.media);
   				r=insereHash(tabHash, x);
   				printf("Inserido na posicao :%d\n",r);
   			break;
   			
   		case 2:
   			printf("Busca: ");
   			fflush(stdin);
   			gets(x.nome);
   			x.nome[0] = toupper(x.nome[0]);
   			med = buscaHash(tabHash, x);
   			if(med > 0)
   				printf("Encontrado!\nMedia: %.2f", med);
   			else
   				printf("Nao encontrado!");
   		break;
   		
   		case 3:
   			printf("Remover: ");
   			fflush(stdin);
   			gets(x.nome);
   			x.nome[0] = toupper(x.nome[0]);
   			r = removeHash(tabHash, x);
   			if(r > 0)
   				printf("Removido com sucesso!");
   			else
   				printf("Nao encontrado!");
   		break;
   		
   		case 4:
   			carregaArq(tabHash);
   		break;
   		
   		case 0:
   			salvaArq(tabHash);
		break;   
		
		default:
			printf("Opcao Invalida!");
		break;	
	}// fim switch
   	getch();
   	system("cls");
   }while(op!=0);
} 

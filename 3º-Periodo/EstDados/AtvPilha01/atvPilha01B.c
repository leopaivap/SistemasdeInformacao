#include <stdio.h>
#include "bibliotecaPilhav2.h"
#include <stdlib.h>
#include <string.h>

int menu(){
	int op;
	system("cls");
	printf("1- Adicionar\n");
	printf("2- Desfazer\n");
	printf("0- Sair\n");
	scanf("%d", &op);
	return op;
}

int main(){
	tPilha p1;
	inicializa(&p1);
	int op;
	tdado dado, rem;
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Descricao: ");
				fflush(stdin);
				gets(dado.desc);
				printf("Data(DD-MM-YYYY): ");
				fflush(stdin);
				gets(dado.data);
				push(&p1, dado);
				break;
			
			case 2:
				rem = pop(&p1);
				printf("Descricao da acao a ser desfeita: %s\n", rem.desc);
				printf("Data da acao a ser desfeita: %s\n", rem.data);
				printf("Removido com sucesso!");
				break;
				
			case 0:
				printf("Saindo...");
				break;
			
			default:
				printf("Opcao Invalida!");
				break;
				
		}
		getch();
		system("cls");
	}while(op != 0 );
}

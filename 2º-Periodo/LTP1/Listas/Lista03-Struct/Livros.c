#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char titulo[30], autor[15];
	int ano, prateleira;
}livros;

int qtd = 0;

void addLivro(livros l[]){
	
	printf("Titulo: ");
	fflush(stdin);
	gets(l[qtd].titulo);
	
	printf("Autor: ");
	fflush(stdin);
	gets(l[qtd].autor);
	
	printf("Ano: ");
	scanf("%d", &l[qtd].ano);
	
	printf("Prateleira: ");
	scanf("%d", &l[qtd].prateleira);
	
	printf("\nLivro cadastrado com sucesso! :)");
	
	qtd++;
}

void listaLivro(livros l[]){
	int i, j = -1;
	for(i = 0; i < qtd; i++){
		printf(" -- Livro %2d --\n", i+1);
		printf("Titulo: %s\n", l[i].titulo);
		printf("Autor: %s\n", l[i].autor);
		printf("Ano: %d\n", l[i].ano);
		printf("Prateleira: %d\n", l[i].prateleira);
		printf("---------------------------\n\n");
		j = 1;
	}
	if(j == -1)
		printf("\nNenhum livro cadastrado!");
}

void buscaLivro(livros l[], char busca[]){
	int i, j = -1;
	char aux[30];
	strlwr(busca);
	
	for(i = 0; i < qtd; i++){
		strcpy(aux, l[i].titulo);
		strlwr(aux);
		if(strcmp(aux, busca) == 0){
			j = 1;
			printf("\n-- Livro %2d --\n", i+1);
			printf("Titulo: %s\n", l[i].titulo);
			printf("Prateleira: %d\n", l[i].prateleira);
			break;
		}
	}
	
	if(j == -1)
		printf("Livro Nao Encontrado!");

}

void filtrarAno(livros l[], int busca){
	int i, j = -1, cnt = 0;
	for(i = 0; i < qtd; i++){
		if(l[i].ano >= busca){
			printf(" -- Livro %2d --\n", i+1);
			printf("Titulo: %s\n", l[i].titulo);
			printf("Autor: %s\n", l[i].autor);
			printf("Ano: %d\n", l[i].ano);
			printf("Prateleira: %d\n", l[i].prateleira);
			printf("---------------------------\n\n");
			j = 1;
			cnt++;	
		}
	}
	if(j == -1)
		printf("Nenhum livro lancado apos o ano informado!");
	else
		printf("Existem %d livros lancados apos o ano informado!", cnt);
}

int menu(){
	int op;
	
	printf("*** Livraria ***\n\n");
	printf("1- Cadastrar\n");
	printf("2- Listar Livros\n");
	printf("3- Busca Livro\n");
	printf("4- Filtro Ano\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}
	
	
int main(){
	
	int i, op;
	char aux[30];
	
	livros livro[100];
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addLivro(livro);
				break;
				
			case 2:
				printf("Lista de Livros:\n");
				listaLivro(livro);
				break;
				
			case 3:
				printf("Busca Livro:\n");
				fflush(stdin);
				gets(aux);
				buscaLivro(livro, aux);
				break;
				
			case 4: 
				printf("Filtro ano:\n");
				printf("Informe o ano: ");
				scanf("%d", &i);
				filtrarAno(livro, i);
				break;
				
			case 0:
				printf("Saindo...\n");
				break;
				
			default:
				printf("\nOpcao invalida!");
				break;		
		}
		getch();
		system("cls");
	}while(op != 0);
}

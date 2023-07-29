#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char nome[40], genero[40];
	int integrantes, ranking;
}tbanda;

int qtd = 0;

int menu(){
	int op;

	printf("*** Sistema de Cadastro Rock4You ***\n");
	printf("1- Cadastrar\n");
	printf("2- Listar\n");
	printf("3- Filtro Ranking\n");
	printf("4- Filtro Genero\n");
	printf("5- Buscar Banda\n");
	printf("6- Excluir\n");
	printf("7- Alterar\n");
	printf("0- Sair\n");
	scanf("%d", &op);
	
	return op;
}

void addbanda(tbanda b[]){
	printf("Nome da banda: ");
	fflush(stdin);
	gets(b[qtd].nome);
	
	printf("Genero da banda: ");
	fflush(stdin);
	gets(b[qtd].genero);
	
	printf("Qtde de integrantes: ");
	scanf("%d", &b[qtd].integrantes);
	
	printf("Ranking da banda: ");
	scanf("%d", &b[qtd].ranking);
	qtd++;
}

void excluir(tbanda b[], char busca[]){
	int i, j = -1, op1;
	char exclui[50];
	strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(exclui, b[i].nome);
		strlwr(exclui);
		if(strcmp(busca, exclui) == 0) {
			printf("** Banda %d: **\n ", i+1);
			printf("Nome: %s\n", b[i].nome);
			printf("Genero: %s\n", b[i].genero);
			printf("Integrantes: %d\n", b[i].integrantes);
			printf("Ranking: %d\n", b[i].ranking);
			printf("\nTem certeza que deseja remover a banda? (1 - Sim | 2 - Nao ): ");
			scanf("%d", &op1);
			j = i;
			break;
		}
	}
	if( j != -1 && op1 == 1){
		b[j] = b[qtd-1];
		qtd--;
		printf("Banda Deletada com Sucesso!\n");
	} else if( j != -1 && op1 != 1)
		printf("Banda Nao foi Deletada!\n");
	else
		printf("Banda Nao Encontrada!\n");
}

void alterabanda(tbanda b[], char busca[]){
	int i;
	char altera[50];
	strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(altera, b[i].nome);
		strlwr(altera);
		if(strcmp(busca, altera) == 0) {
			printf("** Banda %d: **\n ", i+1);
			printf("Nome: %s\n", b[i].nome);
			printf("Genero: %s\n", b[i].genero);
			printf("Integrantes: %d\n", b[i].integrantes);
			printf("Ranking: %d\n", b[i].ranking);
			
			printf("\n** Nova Banda %d: **\n" , i+1);
			printf("Nome: ");
			fflush(stdin);
			gets(b[i].nome);
			printf("Genero: ");
			fflush(stdin);
			gets(b[i].genero);
			printf("Integrantes: ");
			scanf("%d", &b[i].integrantes);
			printf("Ranking: ");
			scanf("%d", &b[i].ranking);
			printf("\nBanda Alterada com Sucesso!\n");
			break;
		}
	}
}

void buscabanda(tbanda b[], char busca[]){
	int i, cnt = 0;
	char buscaux[50];
	busca = strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(buscaux, b[i].nome);
		strlwr(buscaux);
		if(strcmp(busca, buscaux) == 0) {
		cnt = 1;
		printf("** Banda %d: **\n ", i+1);
		printf("Nome: %s\n", b[i].nome);
		printf("Genero: %s\n", b[i].genero);
		printf("Integrantes: %d\n", b[i].integrantes);
		printf("Ranking: %d\n", b[i].ranking);
		printf("-------------------------\n");
		}
	}
	if(cnt == 0)
		printf("Banda Nao Encontrada!\n");
	
}

void listabandas(tbanda b[]){
	int i;
	for(i = 0; i < qtd; i++){
		printf("** Banda %d: **\n ", i+1);
		printf("Nome: %s\n", b[i].nome);
		printf("Genero: %s\n", b[i].genero);
		printf("Integrantes: %d\n", b[i].integrantes);
		printf("Ranking: %d\n", b[i].ranking);
		printf("-------------------------\n");
	}
}

void salvaArq(tbanda bandas[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosBandas.txt","wb");
	fwrite(&bandas[i], sizeof(bandas), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}

void carregaArq(tbanda bandas[]){
	FILE *arq;
	arq = fopen("dadosBandas.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&bandas[qtd], sizeof(tbanda), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

void listaRanking(tbanda b[], int busca){
	int i;
	for(i = 0; i< qtd; i++){
		if(busca == b[i].ranking){
		printf("** Banda %d: **\n ", i+1);
		printf("Nome: %s\n", b[i].nome);
		printf("Genero: %s\n", b[i].genero);
		printf("Integrantes: %d\n", b[i].integrantes);
		printf("Ranking: %d\n", b[i].ranking);
		printf("-------------------------\n");
		}
	}
}

void listaGenero(tbanda b[], char gen[]){
	int i;
	char genteste[20];
	gen = strlwr(gen);
	for(i = 0; i< qtd; i++){
		strcpy(genteste, b[i].genero);
		strlwr(genteste);
		if(strcmp(gen, genteste)==0) {
		printf("** Banda %d: **\n ", i+1);
		printf("Nome: %s\n", b[i].nome);
		printf("Genero: %s\n", b[i].genero);
		printf("Integrantes: %d\n", b[i].integrantes);
		printf("Ranking: %d\n", b[i].ranking);
		printf("-------------------------\n");
		}
	}
}

int main(){
	tbanda bandas[100];
	carregaArq(bandas);
	
	int op, busca;
	char gen[20], buscastr[50];
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastrar\n");
				addbanda(bandas);
				break;
			case 2:
				printf("Listar\n");
				listabandas(bandas);
				break;
			case 3:
				printf("Filtro Ranking: ");
				scanf("%d", &busca);
				listaRanking(bandas, busca);
				break;
			case 4:
				printf("Filtro Genero: ");
				fflush(stdin);
				gets(gen);
				listaGenero(bandas, gen);
				break;
			case 5:
				printf("Buscar Banda: ");
				fflush(stdin);
				gets(buscastr);
				buscabanda(bandas, buscastr);
				break;
			case 6:
				printf("Excluir: ");
				fflush(stdin);
				gets(buscastr);
				excluir(bandas, buscastr);
				break;
			case 7:
				printf("Alterar: ");
				fflush(stdin);
				gets(buscastr);
				alterabanda(bandas, buscastr);
				break;
			case 0:
				printf("Saindo...\n");
				salvaArq(bandas);
				break;
			default:
				printf("\nOpcao Invalida!");
				break;
		}
		getch();
		system("cls");
	}while(op != 0);
	return 0;
}

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
	char nomePessoa[30], data[11], emprestado;
	
}emprestimos;

typedef struct{
	char titulo[30], console[15];
	int ano, ranking;
	emprestimos emprestimo[100];
}jogos;

int qtd = 0;

void addJogo(jogos j[]){
	
	printf("Titulo: ");
	fflush(stdin);
	gets(j[qtd].titulo);
	
	printf("Console: ");
	fflush(stdin);
	gets(j[qtd].console);
	
	printf("Ano: ");
	scanf("%d", &j[qtd].ano);
	
	printf("Ranking: ");
	scanf("%d", &j[qtd].ranking);
	
	j[qtd].emprestimo->emprestado = 'N';
	
	printf("\nJogo cadastrado com sucesso! :)");
	
	qtd++;
}

void listaJogos(jogos j[]){
	int i, jj = -1;
	
	for(i = 0; i < qtd; i++){
		printf("\n -- Jogo %2d --\n", i+1);
		printf("Titulo: %s\n", j[i].titulo);
		printf("Console: %s\n", j[i].console);
		printf("Ano: %d\n", j[i].ano);
		printf("Ranking: %d\n", j[i].ranking);
		
		if(j[i].emprestimo->emprestado == 'S')
			printf("Emprestado: Sim\n");
		else
			printf("Emprestado: Nao\n");
		
		jj = 1;
	}
	
	if(jj == -1)
		printf("\nNenhum Jogo cadastrado!");

}

void buscaJogo(jogos j[]){
	int i, jj = -1;
	char busca[50], aux[50];
	
		printf("Informe o nome: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, j[i].titulo);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Jogo %2d --\n", i+1);
				printf("Titulo: %s\n", j[i].titulo);
				printf("Console: %s\n", j[i].console);
				printf("Ano: %d\n", j[i].ano);
				printf("Ranking: %d\n", j[i].ranking);
				
				if(j[i].emprestimo->emprestado == 'S')
					printf("Emprestado: Sim\n");
				else
					printf("Emprestado: Nao\n");
					
				jj = 1;
				break;
			}
		}

	
	if(jj == -1)
		printf("Jogo Nao Encontrado!");

}

void filtroConsole(jogos j[]){
int i, jj = -1;
	char busca[30], aux[30];
	
		printf("Informe o console: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, j[i].console);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Jogo %2d --\n", i+1);
				printf("Titulo: %s\n", j[i].titulo);
				printf("Console: %s\n", j[i].console);
				printf("Ano: %d\n", j[i].ano);
				printf("Ranking: %d\n", j[i].ranking);
				
				if(j[i].emprestimo->emprestado == 'S')
					printf("Emprestado: Sim\n");
				else
					printf("Emprestado: Nao\n");
					
				jj = 1;
			}
		}
					
	if(jj == -1)
		printf("\nNenhum Jogo cadastrado do console %s!", busca);
}

void emprestimosJogo(jogos j[], int op){
	int i, jj = -1, op2;
	char busca[30], aux[30];
	
	if(op == 1){
		printf("\nInforme qual jogo deseja pegar emprestado: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, j[i].titulo);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Jogo %2d --\n", i+1);
				printf("Titulo: %s\n", j[i].titulo);
				printf("Console: %s\n", j[i].console);
				printf("Ano: %d\n", j[i].ano);
				printf("Ranking: %d\n", j[i].ranking);
				
				jj = 1;
				
				if(j[i].emprestimo->emprestado == 'S')
					printf("Emprestado: Sim\n");
				else
					printf("Emprestado: Nao\n");
					
				if(j[i].emprestimo->emprestado == 'S')
					printf("Este Jogo ja esta sendo emprestado!");
					
				else{
					printf(" -- Preencher Dados Emprestimo --\n");
					printf("Nome: ");
					fflush(stdin);
					gets(j[i].emprestimo->nomePessoa);
					
					printf("Data(DD/MM/AAAA): ");
					fflush(stdin);
					gets(j[i].emprestimo->data);
					
					j[i].emprestimo->emprestado = 'S';
					
					printf("Jogo emprestado com sucesso! :)\n");
					
					break;
				}
			}
			
		}
		
		if(jj == -1)
			printf("Jogo Nao Encontrado!");
		
	} else if(op == 2){
		printf("\nInforme qual jogo deseja devolver: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, j[i].titulo);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Jogo %2d --\n", i+1);
				printf("Titulo: %s\n", j[i].titulo);
				printf("Console: %s\n", j[i].console);
				printf("Ano: %d\n", j[i].ano);
				printf("Ranking: %d\n", j[i].ranking);
				
				jj = 1;
				
				if(j[i].emprestimo->emprestado == 'S')
					printf("Emprestado: Sim\n");
				else
					printf("Emprestado: Nao\n");
					
				if(j[i].emprestimo->emprestado == 'N')
					printf("Este Jogo nao esta sendo emprestado!");	
				else{
					printf("\nDados do emprestimo: \n");
					printf("Nome: %s\n", j[i].emprestimo->nomePessoa);
					printf("Data(DD/MM/AAAA): %s\n", j[i].emprestimo->data);

					printf("Deseja realmente devolver?(1- Sim | 2- Nao): ");
					scanf("%d", &op2);
					
					if(op2 == 2)
						printf("Jogo nao foi devolvido!\n");
					else if( op2 == 1){	
						j[i].emprestimo->emprestado = 'N';
						printf("Jogo devolvido com sucesso! :)\n");
						
					} else
						printf("Opcao Invalida!\n");
				}
			}
		}
	} else if(op == 3){
		for(i = 0; i < qtd; i++){
			if(j[i].emprestimo->emprestado == 'S'){
				printf("\n -- Jogo %2d --\n", i+1);
				printf("Titulo: %s\n", j[i].titulo);
				printf("Console: %s\n", j[i].console);
				printf("Ano: %d\n", j[i].ano);
				printf("Ranking: %d\n", j[i].ranking);
				printf("\nDados do emprestimo: \n");
				printf("Nome: %s\n", j[i].emprestimo->nomePessoa);
				printf("Data(DD/MM/AAAA): %s\n", j[i].emprestimo->data);
				jj = 1;
			}
		}
		
		if(jj == -1)
			printf("Nenhum jogo sendo emprestado! :(\n");

	} else
		printf("Opcao Invalida!\n");
}

int menu(){
	int op;
	
	printf("*** Catalogo de Jogos ***\n\n");
	printf("1- Cadastrar\n");
	printf("2- Listar Jogos\n");
	printf("3- Buscar Jogo\n");
	printf("4- Filtro Console\n");
	printf("5- Emprestimos\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}

void salvaArq(jogos j[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosJogos.txt","wb");
	fwrite(&j[i], sizeof(j), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}
	
void carregaArq(jogos j[]){
	FILE *arq;
	arq = fopen("dadosJogos.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&j[qtd], sizeof(jogos), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

int main(){
	
	int i, op, op2;
	char aux[30];

	
	jogos jogo[100];
	
	printf("Deseja carregar dados de um arquivo?(1- Sim | 2- Nao): ");
	scanf("%d", &op);
	if(op == 1)
		carregaArq(jogo);
	else if(op != 2)
		printf("\nOpcao Invalida, reinicie o app!");
		
	getch();
	system("cls");
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addJogo(jogo);
				break;
				
			case 2:
				printf("Lista de Jogos:\n");
				listaJogos(jogo);
				break;
				
			case 3:
				printf("Buscar Jogo:\n");
				buscaJogo(jogo);
				break;
			
			case 4:
				printf("Filtro Console:\n");
				filtroConsole(jogo);
				break;	
				
			case 5:
				printf("Emprestimos:\n");
				printf("1- Fazer um emprestimo\n");
				printf("2- Devolver um jogo\n");
				printf("3- Listar jogos emprestados\n");
				printf("Digite uma opcao: ");
				scanf("%d", &op2);
				emprestimosJogo(jogo, op2);
				break;
							
			case 0:
				printf("Saindo...\n");
				salvaArq(jogo);
				break;
				
			default:
				printf("\nOpcao invalida!");
				break;		
		}
		getch();
		system("cls");
	}while(op != 0);
	
	return 0;
}



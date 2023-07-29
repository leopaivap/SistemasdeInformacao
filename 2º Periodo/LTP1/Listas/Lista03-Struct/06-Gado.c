#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
	int mes, ano;
	
}nascs;

typedef struct{
	int cod;
	float leite, alim;
	char abate;
	nascs nasc[100];
}gados;

int qtd = 0;

void addGado(gados g[]){
	int aux;
	
	printf("Codigo: ");
	scanf("%d", &g[qtd].cod);
	
	printf("Producao de Leite por semana: ");
	scanf("%f", &g[qtd].leite);
	
	printf("Alimento por semana(kg): ");
	scanf("%f", &g[qtd].alim);
	
	printf("Data de Nascimento(Mes): ");
	scanf("%d", &g[qtd].nasc->mes);
	
	printf("Ano: ");
	scanf("%d", &g[qtd].nasc->ano);
	
	aux = g[qtd].nasc->ano;
	
	if( 2022-aux > 5 || g[qtd].leite < 40 )
		g[qtd].abate = 'S';
	else
		g[qtd].abate = 'N';
	
	printf("\nGado cadastrado com sucesso! :)");
	
	qtd++;
}

void listaGados(gados g[]){
	int i, jj = -1;
	
	for(i = 0; i < qtd; i++){
		printf("\n -- Gado %2d --\n", i+1);
		printf("Codigo: %d\n", g[i].cod);
		printf("Leite por semana: %.1fL\n", g[i].leite);
		printf("Alimento por semana: %.1fkg\n", g[i].alim);
		printf("Data de Nascimento: %d/%d\n", g[i].nasc->mes, g[i].nasc->ano);
		
		if(g[i].abate == 'S')
			printf("Abate: Sim\n");
		else
			printf("Abate: Nao\n");
			
		jj = 1;
	}
	
	if(jj == -1)
		printf("\nNenhum Gado cadastrado!");

}

void listaAbate(gados g[]){
	int i, jj = -1;
	
	for(i = 0; i < qtd; i++){
		if(g[i].abate == 'S'){
			printf("\n -- Gado %2d --\n", i+1);
			printf("Codigo: %d\n", g[i].cod);
			printf("Leite por semana: %.1fL\n", g[i].leite);
			printf("Alimento por semana: %.1fkg\n", g[i].alim);
			printf("Data de Nascimento: %d/%d\n", g[i].nasc->mes, g[i].nasc->ano);
			
			if(g[i].abate == 'S')
				printf("Abate: Sim\n");
			else
				printf("Abate: Nao\n");
	
			jj = 1;
		}
	}
	
	if(jj == -1)
		printf("\nNenhum Gado na lista para Abate!");
}

float qtdAlimento(gados g[]){
	int i;
	float soma = 0.0;
	
	for(i = 0; i < qtd; i++)
		soma += g[i].alim;
		
	return soma;
}

float qtdLeite(gados g[]){
	int i;
	float soma = 0.0;
	
	for(i = 0; i < qtd; i++)
		soma += g[i].leite;
		
	return soma;
}

int menu(){
	int op;
	
	printf("*** Gados ***\n\n");
	printf("1- Cadastrar\n");
	printf("2- Listar Gados\n");
	printf("3- Listar Gados para o abate\n");
	printf("4- Quantidade de Leite\n");
	printf("5- Quantidade de Alimento\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}

void salvaArq(gados g[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosGados.txt","wb");
	fwrite(&g[i], sizeof(g), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}
	
void carregaArq(gados g[]){
	FILE *arq;
	arq = fopen("dadosGados.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&g[qtd], sizeof(gados), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

int main(){
	
	int i, op;

	
	gados gado[100];
	
	printf("Deseja carregar dados de um arquivo?(1- Sim | 2- Nao): ");
	scanf("%d", &op);
	if(op == 1)
		carregaArq(gado);
	else if(op != 2)
		printf("\nOpcao Invalida, reinicie o app!");
		
	getch();
	system("cls");
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addGado(gado);
				break;
				
			case 2:
				printf("Lista de Gados:\n");
				listaGados(gado);
				break;
				
			case 3:
				printf("Gados que irao pro abate:\n");
				listaAbate(gado);
				break;
				
			case 4:
				printf("Producao de Leite por semana: %.1fL\n", qtdLeite(gado));
				break;
			
			case 5:
				printf("Quantidade de Alimento por semana: %.1fkg\n", qtdAlimento(gado));
				break;	
							
			case 0:
				printf("Saindo...\n");
				salvaArq(gado);
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
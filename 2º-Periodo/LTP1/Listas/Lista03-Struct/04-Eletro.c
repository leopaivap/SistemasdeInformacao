#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char nome[50];
	float potencia, tempo;
}eletro;

int qtd = 0;

void addEletro(eletro e[]){
	
	printf("Nome: ");
	fflush(stdin);
	gets(e[qtd].nome);
	
	printf("Potencia em Watts: ");
	scanf("%f", &e[qtd].potencia);
	
	printf("Tempo medio ativo por dia: ");
	scanf("%f", &e[qtd].tempo);
	
	printf("\nEletrodomestico cadastrado com sucesso! :)");
	
	qtd++;
}

void listaEletro(eletro e[]){
	int i, j = -1;
	
	for(i = 0; i < qtd; i++){
		printf("\n -- Eletro %2d --\n", i+1);
		printf("Nome: %s\n", e[i].nome);
		printf("Potencia: %.1fW\n", e[i].potencia);
		printf("Tempo Ativo(dia): %.1fh\n", e[i].tempo);
		j = 1;
	}
	
	if(j == -1)
		printf("\nNenhum Eletrodomestico cadastrado!");

}

void buscaEletro(eletro e[]){
	int i, j = -1;
	char busca[50], aux[50];
	
		printf("Informe o nome: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, e[i].nome);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Eletro %2d --\n", i+1);
				printf("Nome: %s\n", e[i].nome);
				printf("Potencia: %.1fW\n", e[i].potencia);
				printf("Tempo Ativo(dia): %.1fh\n", e[i].tempo);
				j = 1;
				break;
			}
		}

	
	if(j == -1)
		printf("Eletrodomestico Nao Encontrado!");

}

void filtroEletro(eletro e[], float valor, float busca){
	int i, j = -1;
	float gasto;
	
	for(i = 0; i < qtd; i++){
		gasto = ((e[i].potencia * e[i].tempo * 1)/1000)*valor;
		  if(gasto*30 >= busca){
			printf("\n -- Eletro %2d --\n", i+1);
			printf("Nome: %s\n", e[i].nome);
			printf("Potencia: %.1f W\n", e[i].potencia);
			printf("Tempo Ativo(dia): %.1f h\n", e[i].tempo);
			printf("O %s gasta R$%.1f por mes ou R$%.1f por dia!\n", e[i].nome, gasto*30, gasto);
			j = 1;
		}
	}
	if(j == -1)
		printf("\nNenhum Eletrodomestico com gasto superior a R$%.1f por mes!", busca);
}

void gastosEletro(eletro e[], float kwh){
	int i;
	float res;
	

	for(i = 0; i < qtd; i++)
		res += (e[i].potencia * e[i].tempo * 1)/1000;



	printf("Diario: %.1fkH/h | R$%.1f\n", res, res*kwh);
	printf("Mensal: %.1fkH/h | R$%.1f", res*30, (res*kwh)*30);
	
}

int menu(){
	int op;
	
	printf("*** Sistema Eletro ***\n\n");
	printf("1- Cadastrar\n");
	printf("2- Listar Eletrodomesticos\n");
	printf("3- Busca Eletrodomestico\n");
	printf("4- Filtro R$\n");
	printf("5- Gastos\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}

void salvaArq(eletro e[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosEletro.txt","wb");
	fwrite(&e[i], sizeof(e), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}
	
void carregaArq(eletro e[]){
	FILE *arq;
	arq = fopen("dadosEletro.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&e[qtd], sizeof(eletro), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

int main(){
	
	int i, op;
	char aux[30];
	float kwh, busca;
	
	eletro eletrodom[100];
	
	printf("Deseja carregar dados de um arquivo?(1- Sim | 2- Nao): ");
	scanf("%d", &op);
	if(op == 1)
		carregaArq(eletrodom);
	else if(op != 2)
		printf("\nOpcao Invalida, reinicie o app!");
		
	getch();
	system("cls");
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addEletro(eletrodom);
				break;
				
			case 2:
				printf("Lista de Eletrodomesticos:\n");
				listaEletro(eletrodom);
				break;
				
			case 3:
				printf("Busca Eletrodomesticos:\n");
				buscaEletro(eletrodom);
				break;
			
			case 4:
				printf("Filtro R$:\n");
				printf("Informe o valor do kW/h: ");
				scanf("%f", &kwh);
				printf("\nInforme o valor do Filtro(R$ por mes): ");
				scanf("%f", &busca);
				filtroEletro(eletrodom, kwh, busca);
				break;	
				
			case 5:
				printf("Gastos:\n");
				printf("Informe o valor do kW/h: ");
				scanf("%f", &kwh);
				gastosEletro(eletrodom, kwh);
				break;
							
			case 0:
				printf("Saindo...\n");
				salvaArq(eletrodom);
				break;
				
			default:
				printf("\nOpcao invalida!");
				break;		
		}
		getch();
		system("cls");
	}while(op != 0);
}
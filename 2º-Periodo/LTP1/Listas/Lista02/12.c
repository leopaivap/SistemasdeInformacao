#include <stdio.h>
#include <stdlib.h>

void gera(int i, int j, int mt[][100]){
	int k, l;
	srand(time(NULL));
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt[k][l] = rand()%10;
}

void gera2(int i, int j, int mt[][100]){
	int k, l;
	srand(time(NULL));
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt[k][l] = rand()%9+1;
}

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}

void soma(int i, int j, int mt[][100], int mt2[][100], int mt3[][100]){
	int k, l;
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt3[k][l] = mt[k][l] + mt2[k][l];
}

void sub(int i, int j, int mt[][100], int mt2[][100], int mt3[][100]){
	int k, l;
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt3[k][l] = mt2[k][l] - mt[k][l];
}

void cons(int i, int j, int cns,int mt[][100], int mt2[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		for(l = 0; l < j; l++){
			mt[k][l] += cns;
			mt2[k][l] += cns;
		}
	}		
}

void printms(int i, int j, int mt[][100], int mt2[][100], int mt3[][100]){
		printf("Matriz 01:");
		printm(i, j, mt);
		printf("\n\nMatriz 02:");
		printm(i, j, mt2);
		if(mt3[0][0] != NULL){
			printf("\n\nMatriz Resultante:");
			printm(i, j, mt3);
		}
}


int main(){
	
	int mt[100][100], mt2[100][100], mt3[100][100], i, j, n, m, op, cns;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	system("cls");

	gera(n, m, mt);
	gera2(n, m, mt2);
	
	printf("*** Menu ***");
	printf("\n1- Soma Matrizes");
	printf("\n2- Subtracao Matrizes");
	printf("\n3- Adicionar Constante");
	printf("\n4- Imprimir Matrizes");
	
	printf("\nEscolha uma Opcao: ");
	scanf("%d", &op);
	system("cls");
	
	switch(op){
		case 1:
			soma(n, m, mt, mt2, mt3);
			printms(n, m, mt, mt2, mt3);
			break;
		case 2:
			sub(n, m, mt, mt2, mt3);
			printms(n, m, mt, mt2, mt3);
			break;
		case 3: 
			printf("Informe o valor da Constante: ");
			scanf("%d", &cns);
			printms(n, m, mt, mt2, mt3);
			printf("\n\nMatrizes Resultantes(+%d):\n", cns);
			cons(n, m, cns, mt, mt2);
			printms(n, m, mt, mt2, mt3);
			break;
		case 4:
			printms(n, m, mt, mt2, mt3);
			break;
		default:
			printf("\nOpcao Invalida!");
			break;
	}
		
	return 0;
}

#include <stdio.h>
#include <stdlib.h>

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}

int main(){
	
	int mt[100][100], mt2[100][100], mt3[100][100], i, j, n, m;

	printf("*** Soma de Matrizes *** ");
	printf("\nInforme o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	printf("\nInforme Valores para Matriz 01: \n");
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			scanf("%d", &mt[i][j]);
			
	printf("\nInforme Valores para Matriz 02: \n");
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			scanf("%d", &mt2[i][j]);
			
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)	
			mt3[i][j] = mt[i][j] + mt2[i][j];
			
	system("cls");
	
	printf("Matriz 01:");
	printm(n, m, mt);
	printf("\nMatriz 02:");
	printm(n, m, mt2);        
	printf("\n\nMatriz Somada:");
	printm(n, m, mt3);
	
	return 0; 
}
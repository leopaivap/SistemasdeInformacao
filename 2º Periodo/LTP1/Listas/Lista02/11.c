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
	
	int mt[100][100], mt2[100][100], i, j, n, m, x;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	system("cls");
	printf("Informe Valores para a Matriz: \n");
	
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			scanf("%d", &mt[i][j]);
	
	system("cls");
	printf("Informe um valor Escalar: ");
	scanf("%d", &x);
	
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			mt2[i][j] = mt[i][j] * x;
			
	system("cls");
	printf("Matriz Inicial:");
	printm(i, j, mt);
	printf("\n\nMatriz Escalar(x%d): ", x);
	printm(i, j, mt2);
		
	return 0;
}

#include <stdio.h>
#include <stdlib.h>

void printm(int i, int j, int mt[4][3]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}

void printm2(int i, int j, int mt[3][4]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}

int main(){
	
	int mt[4][3], mt2[3][4], i, j;

			
	printf("Informe Valores para Matriz: \n");
	for(i = 0; i < 4; i++)
		for(j = 0; j < 3; j++)
			scanf("%d", &mt[i][j]);
		
	for(i = 0; i < 4; i++)
		for(j = 0; j < 3; j++)
			mt2[j][i] = mt[i][j];
			
	system("cls");
	
	printf("Matriz 01:");
	printm(4, 3, mt);
	printf("\nMatriz 02:");
	printm2(3, 4, mt2);

	return 0;
}
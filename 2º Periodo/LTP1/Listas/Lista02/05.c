#include <stdio.h>

void gera(int i, int j, int mt[][100]){
	int k, l;
	srand(time(NULL));
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt[k][l] = rand()%10;
}

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}


int main(){
	
	int mt[100][100], i, j, n, m, x;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	gera(n, m, mt);
	printf("\n");
	printm(n, m, mt);
	
	printf("\n\nDiagonal Principal: \n\n");
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			if(i == j)
				printf("%d | ", mt[i][j]);

	return 0;
}

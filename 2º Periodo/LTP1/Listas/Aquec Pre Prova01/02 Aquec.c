#include <stdio.h>
#include <time.h>

void gera(int i, int j, int mt[][100]){
	int k, l;
	srand(time(NULL));
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt[k][l] = rand()%100;
}

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%2d | ", mt[k][l]);
	}
}

int main(){
	int mt[100][100], i, j, n, m, par = 0, imp = 0;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	
	printf("\nInforme o numero de colunas:");
	scanf("%d", &m);
	
	gera(n, m, mt);
	printm(n, m, mt);
	
	for(i = 0; i < n; i++){
		for(j = 0; j < m; j++){
			if(mt[i][j]%2 == 0)
				par++;
			else
				imp++;
		}
	}
	
	printf("\n\nPares: %d\nImpares: %d\n", par, imp);
}
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
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
}

int main(){
	
	int mt[100][100], i, j, n, m, maior;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	gera(n, m, mt);
	printf("\n");
	printm(n, m, mt);
	
	maior = mt[0][0];
	
	for(i = 0; i < n; i++){
		for(j = 0; j < m; j++){
			if(mt[i][j] > maior)
				maior = mt[i][j];
		}
	}
	
	printf("\nMaior Valor: %d", maior);

	return 0;
}

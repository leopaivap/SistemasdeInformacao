#include <stdio.h>

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
	}
}


int main(){
	
	int mt[100][100], i, j, n;
	
	printf("Informe um numero: ");
	scanf("%d", &n);
	
	for(i = 0; i < n; i++){
		for(j = 0; j < n; j++){
			if(i == j)
				mt[i][j] = 1;
			else
				mt[i][j] = 0;
		}
	}

	printf("\n\nMatriz identidade de %d: \n\n", n);
	printm(n, n, mt);

	return 0;
}

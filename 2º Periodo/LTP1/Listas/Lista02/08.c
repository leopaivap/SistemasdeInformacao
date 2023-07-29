#include <stdio.h>
#include <stdbool.h>

bool bit(int mt[][100], int n , int m){
	int i, j;
	bool bits = true;
	for(i = 0; i < n; i++){
		for(j = 0; j < m; j++){
			if(mt[i][j] != 0 && mt[i][j] != 1)
				bits = false;
		}
	}
	return bits;
}


int main(){
	
	int mt[100][100], i, j, n, m;
	bool bits;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	for(i = 0; i < n; i++)
		for(j = 0; j < m; j++)
			scanf("%d", &mt[i][j]);
		
	bits = bit(mt, n, m);
	
	if(bits)
		printf("\nMatriz de Bits!");
	else
		printf("\nMatriz nao eh de Bits!");
		

	return 0;
}
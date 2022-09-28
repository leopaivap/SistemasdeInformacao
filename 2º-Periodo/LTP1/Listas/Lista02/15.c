#include <stdio.h>
#include <stdlib.h>

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++){
		printf("\n");
		for(l = 0; l < j; l++)
			printf("%2d | ", mt[k][l]);
	}
}

int main(){
	int n, x1, x2, y1, y2, i, j, m, sm = 0, mt[100][100];
	
	printf("Informe o número de redes: ");
	scanf("%d", &n);
	
	for(i = 0; i < 100; i++){
		for(j = 0; j < 100; j++){
			mt[i][j] = 0;
		}
	}
		
	for(m = 0; m < n; m++){
		scanf("%d", &x1);
		scanf("%d", &x2);
		scanf("%d", &y1);
		scanf("%d", &y2);
		

		for(i = x1; i < x2+1; i++){
			for(j = y1; j < y2+1; j++){
				if(i >= x1 && j >= y1)
					mt[i][j] = 1;
			}
		}
	}
	
	for(i = 0; i < 100; i++)
		for(j = 0; j < 100; j++)
			if(mt[i][j] == 1)
				sm++;
	
	//printm(100, 100, mt);
	
	printf("\nArea coberta por rede de pesca: %d", sm);
	
	return 0;
}
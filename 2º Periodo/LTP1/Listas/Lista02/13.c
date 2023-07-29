#include <stdio.h>
#include <stdlib.h>

int main(){

	int M[2][3], N[3][2], mult[2][2], i, j, aux, k = 0, mi = 0, mj, l;


	 printf("Informe Valores para Matriz 01: \n");
	 for(i = 0; i < 2; i++)
	 	for(j = 0; j < 3; j++)
	 		scanf("%d", &M[i][j]);
	
	
	 printf("\nInforme Valores para Matriz 02: \n");
	 for(i = 0; i < 3; i++)
	 	for(j = 0; j < 2; j++)
	 		scanf("%d", &N[i][j]);

	system("cls");
	
	while(k != 2){
		l = 0;
		mj = 0;
		while(l != 2){
			aux = 0;
			j = 0;
			i = 0;
			while(j != 3){
				aux += (M[k][j] * N[i][l]); 
				i++;
				j++;	
			}
			mult[mi][mj] = aux;	
			mj++;
			l++;
		}
		mi++;	
		k++;
	}
	 
	for(i = 0; i < 2; i++){
		printf("\n");
		for(j = 0; j < 2; j++)
				printf("%d | ", mult[i][j]);
	}

	return 0;
}


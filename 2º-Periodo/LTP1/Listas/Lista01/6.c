#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

void geravet(int v[],int n){
	int i;
	srand(time(NULL));
	for(i=0;i<n;i++)
		v[i]=rand()%100;
}

void printv(int vet[],int n){
	int i;
	for(i=0;i<n;i++)
		printf(" %d |",vet[i]);
	printf("\n");

}

int num (int v[], int j, int n){
	int i;
	for (i = 0; i < n; i++){
		if( j == v[i])
			return i;	
	}
	return 0;
}


int main(){
	int n, v[100], j, k;
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	geravet(v, n);
	printf("\nDigite um Valor:\n");
	bool t = true;
	
	do{
		scanf("%d", &j);
		k  = num(v, j, n);
		if(k == 0)
			printf("Valor nao esta no Vetor!\n");
		else{
			printf("Valor presente no vetor na posicao [%d]", k);
			t = false;
		}	
	}while(t);
	
	printf("\nVetor:\n");
	printv(v, n); 
	
	return 0;
}
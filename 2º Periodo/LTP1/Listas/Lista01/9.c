#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

int main(){
	int n, v[100], j, cnt = 0, i;
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	geravet(v, n);
	printf("\nPesquisar Valor: ");
	scanf("%d", &j);
	
	for(i = 0; i < n; i++){
		if(v[i] == j)
			cnt++;
	}

	printf("\n O valor aparece %d vezes no vetor\nVetor: \n", cnt);
	printv(v, n);
	return 0;
}

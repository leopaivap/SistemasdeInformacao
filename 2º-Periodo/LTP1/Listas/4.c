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
		printf("%d |",vet[i]);
	printf("\n");

}

int contimp(int v[], int n){
	int i, cnt = 0;
	for(i = 0; i < n; i++){
		if(v[i]%2 != 0)
			cnt++;
	}
	return cnt;
}


int main(){
	int n, v[100];
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	geravet(v, n);
	printf("\nQuantidade de Impares: %.d\n", contimp(v,n));
	printf("Vetor: \n");
	printv(v, n); 
	
	return 0;
}

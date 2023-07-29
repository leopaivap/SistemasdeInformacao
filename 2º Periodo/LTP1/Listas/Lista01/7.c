#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geravet(int v[],int n){
	int i;
	srand(time(NULL));
	for(i=0;i<n;i++)
		v[i]=rand()%100;
}

void geravet2(int v[],int n){
	int i;
	srand(time(NULL));
	for(i=0;i<n;i++)
		v[i]=rand()%10;
}

void printv(int vet[],int n){
	int i;
	for(i=0;i<n;i++)
		printf(" %d |",vet[i]);
	printf("\n");

}

void mult( int v[], int m[], int r[], int n ){
	int i;
	for(i = 0; i < n; i++)
		r[i] = v[i] * m[i];
}


int main(){
	int n, v[100], m[100], r[100];
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	geravet(v, n);
	geravet2(m, n);

	mult(v, m, r, n);

	printf("\nVetor 1:\n");
	printv(v, n); 
	printf("\nVetor 2:\n");
	printv(m, n); 
	printf("\nVetor 3:\n");
	printv(r, n); 
	
	return 0;
}
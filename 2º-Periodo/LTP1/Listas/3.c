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

float menor(int v[], int n){
	int i;
	float menor;
	menor = v[0];
	
	for(i = 0; i < n; i++){
		if(v[i] < menor)
			menor = v[i];
	}	
	return menor;
}

int main(){
	int n;
	float v[100];
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	geravet(v, n);
	printf("\nMaior Valor: %.2f\n", menor(v,n));
	printv(v, n); 
	
	return 0;
}

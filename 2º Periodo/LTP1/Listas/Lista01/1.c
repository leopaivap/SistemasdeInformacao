#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int soma(int v[], int n){
	int i, sm = 0;
	srand(time(NULL));
	for (i = 0; i < n; i++){
		v[i] = rand()%10;
		printf("\n %d", v[i]);
		sm += v[i];
	}
	return sm;	
}

int main(){
	int n, v[100];
	printf("Qtd de valores: ");
	scanf("%d", &n);
	
	printf("\nSoma dos valores: %d", soma(v, n)); 
	
	return 0;
}
#include <stdio.h>

long long int cont = 0;
int fibonacci(int n){
	int r;
	cont++;
	//printf("fibonacci(%d)\n", n); getch();
	
	if(n == 0){
	//	printf("fibonacci(%d) = 0\n", n); getch();
		return 0;
	}
	if(n == 1){
	//	printf("fibonacci(%d) = 1\n", n); getch();
		return 1;
	}
	
	r = fibonacci(n - 1) + fibonacci(n - 2);
	//printf("fibonacci(%d) = %d\n", n, r); getch();
	return r;
}

int main(){
	int n;
	
	printf("Termo: ");
	scanf("%d", &n);
	printf("Fibonacci: %d", fibonacci(n));
	printf("\nNumero de processos: %lld", cont);
	
	return 0;
}

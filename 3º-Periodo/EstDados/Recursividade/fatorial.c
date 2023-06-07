#include <stdio.h>

int fat(int n){
	int r;
	printf("fat(%d)\n", n); getch();
	if(n == 0){
		printf("fat(0) = 1\n");
		return 1;
	}
	
		
	r =  n * fat(n-1);
	printf("fat(%d) = %d \n", n, r); getch();
	return r;
}

int main(){
	int n, r;
	
	printf("Valor: ");
	scanf("%d", &n);
	printf("Fatorial de %d eh: %d", n, fat(n));
	
	return 0;
}

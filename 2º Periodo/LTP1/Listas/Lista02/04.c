#include <stdio.h>

void gera(int i, int j, int mt[][100]){
	int k, l;
	srand(time(NULL));
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			mt[k][l] = rand()%10;
}

void printm(int i, int j, int mt[][100]){
	int k, l;
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			printf("%d | ", mt[k][l]);
}

int conta(int i, int j, int mt[][100], int x){
	int k, l, cnt = 0;
	for(k = 0; k < i; k++)
		for(l = 0; l < j; l++)
			if(mt[k][l] == x)
				cnt++;
	return cnt;
}

int main(){
	
	int mt[100][100], i, j, n, m, x;
	
	printf("Informe o numero de linhas: ");
	scanf("%d", &n);
	printf("\nInforme o numero de colunas: ");
	scanf("%d", &m);
	
	gera(n, m, mt);
	printf("\n");
	printm(n, m, mt);
	
	printf("\nValor: ");
	scanf("%d", &x);
	printf("\nO numero %d aparece %dx na matriz", x, conta(n, m, mt, x));

	return 0;
}

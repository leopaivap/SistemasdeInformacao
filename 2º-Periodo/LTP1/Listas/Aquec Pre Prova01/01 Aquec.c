#include <stdio.h>
#include <string.h>

int startcodon(char dna[], int n){
	int i, p = -1;
	toupper(dna);
	for(i = 0; i < n-2; i++){
		if(dna[i] == 'A' && dna[i+1] == 'T' && dna[i+2] == 'G'){
			p = i;
			break;
		}
	}
	return p;
}


int main(){
	int res, n;
	char dna[100];
	
	printf("Informe a sequencia de DNA: ");
	fflush(stdin);
	gets(dna);
	n = strlen(dna);
	res = startcodon(dna, n);
	
	if(res == -1)
		printf("\nInexistente");
	else
		printf("\nExiste na posicao %d", res);
		
	return 0;
}
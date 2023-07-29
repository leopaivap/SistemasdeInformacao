#include <stdio.h>
#include "bibliotecaPilha.h"


int main(){
	tPilha p1;
	int dec;
	inicializa(&p1);
	
	printf("*** Conversor Decimal para Binario ***\n");
	printf("\nDigite um numero para converter: ");
	scanf("%d", &dec);
	
	while(dec >= 2){
		push(&p1, dec%2);
		dec = dec/2;
	}
	if(dec == 1)
		push(&p1, 1);

	mostraPilha(p1);
	
}

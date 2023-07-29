#include <stdio.h>
#include <stdlib.h>

float arrecada(float valor){
	float r;
	printf("Preciso arrecadar %.2f\n",valor); getch();
	if(valor <=100){ // caso base
		return valor;
	}//fim if
	valor-=100;
	r=100+ arrecada(valor/2) + arrecada(valor/2);
	printf("Retornando %.2f\n",r); getch();
	return r;
}// fim funcao

int main(){
	float valor;
	printf("Valor para arrecadar:");
	scanf("%f",&valor);
	printf("Valor arrecadado:%.2f",arrecada(valor));
	return 0;
}


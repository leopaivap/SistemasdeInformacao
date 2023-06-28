#include <stdio.h>

int somaRecursiva(int v[], int tamanho){
	
	if(v[tamanho-1] == NULL)
		return 0;
	
	tamanho--;
	return v[tamanho] + somaRecursiva(v, tamanho);
}

int main(){
	int v[20], i, resp;

	for(i = 0; i < 20; i++)
		v[i] = i;
	

	resp = somaRecursiva(v, 20);
	printf("Soma: %d", &resp);
}
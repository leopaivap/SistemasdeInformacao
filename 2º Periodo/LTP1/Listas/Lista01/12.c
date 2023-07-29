#include <stdio.h>

void printv(float vet[],int n){
	int i;
	for(i=1;i<n+1;i++)
		printf("%.2f |",vet[i]);
	printf("\n");
}

int main(){
	
	float v[5], aux, med;
	int i, j, l;
	
	printf("Informe o valor das notas:\n");
	for(i = 0; i < 5; i++)
		scanf("%f", &v[i]);
		
	for(i = 5; i > 0; i--){
		for( j = 0; j < i ; j++){
			if(v[j] > v[j+1]){		
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
	}
			
	med = v[4] + v[3]  + v[2];
	printf("\nMedia: %.2f\n", med);
	
	return;
}

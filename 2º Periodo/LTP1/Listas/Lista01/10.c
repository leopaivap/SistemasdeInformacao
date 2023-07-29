#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geravet(int v[],int n){
	int i;
	srand(time(NULL));
	for(i=0;i<n;i++)
		v[i]=rand()%6+1;
}

int main(){
	int n, v[100], j, cnt1 = 0, i, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0;
	printf("Qtd de vezes jogadas: ");
	scanf("%d", &n);
	
	geravet(v, n);
	
	for( i = 0; i < n; i++){
		if(v[i] == 1)
			cnt1++;
		else if(v[i] == 2)
			cnt2++;
		else if(v[i] == 3)
			cnt3++;
		else if(v[i] == 4)
			cnt4++;
		else if(v[i] == 5)
			cnt5++;
		else if(v[i] == 6)
			cnt6++;	
	}
	 
	printf("\nFace 1: %d", cnt1);
	printf("\nFace 2: %d", cnt2);
	printf("\nFace 3: %d", cnt3);
	printf("\nFace 4: %d", cnt4);
	printf("\nFace 5: %d", cnt5);
	printf("\nFace 6: %d", cnt6);
						
	return 0;
}

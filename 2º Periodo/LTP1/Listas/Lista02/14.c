#include <stdio.h>
#include <stdlib.h>

int main(){
	
	int m[5][8], i, j, cnt = 0, r, x, y;
	
	printf("Informe o numero de raios: ");
	scanf("%d", &r);
	
	for(i = 0; i < 5; i++)
		for(j = 0; j < 8; j++)
			m[i][j] = 0;
	
	i = 0;
	do{
		scanf("%d%d", &x, &y);
		m[x][y] += 1;
		i++;
	}while(i != r);
	
	for(i = 0; i < 5; i++)
		for(j = 0; j < 8; j++)
			if(m[i][j] > 1)
				cnt = 1;
	
	printf("\n%d", cnt);

	return 0;
}


#include <stdio.h>
#include <string.h>

int main(){
	char v[101], aux[101];
	int i, n, j;
	
	gets(v);
	n = strlen(v);
	j = n - 1;
	
	for(i = 0; i < n; i++){
		aux[i] = v[j];
		j--;
	}
	printf("%s", aux);
}


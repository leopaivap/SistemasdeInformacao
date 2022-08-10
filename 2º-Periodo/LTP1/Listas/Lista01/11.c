#include <stdio.h>
#include <string.h>

int main(){
	char p[100] , v[100];
	int i, cnt = 0, n;
	
	gets(p);
	n = strlen(p);
	
	for( i = 0; i < n; i++){
		if(p[i] == 'p' && p[i+1] == 'p'){
			v[cnt] = p[i];
			cnt++;
			i+=2;
		}else if(p[i] != 'p'){
			v[cnt] = p[i];
			cnt++;
		}	 
	}
		
	printf("\nMensagem decodificada: %s", v);

	return 0;
}
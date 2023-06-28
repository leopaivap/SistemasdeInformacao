#include <stdio.h>

long long int num_calls = -1;

int fibonacci(int n){
	int r;
	num_calls++;
	
	if(n == 0)
		return 0;
	
	if(n == 1)
		return 1;
	

	r = fibonacci(n - 1) + fibonacci(n - 2);
	
	return r;	
}

int main(){
	int n, i, fib, result;
	scanf("%d", &n);
	
	for(i = 0; i < n; i++){
		scanf("%d", &fib);
		printf("fib(%d) = %lld calls = %d\n", fib, num_calls, fibonacci(fib));
		num_calls = -1;
	}
	
	
	return 0;
}

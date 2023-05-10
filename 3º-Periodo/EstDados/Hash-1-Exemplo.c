int funcaoHash(unsigned long long chave, int n){
	return (chave%n); 
}
int main(){
	unsigned long long chave;
  while(1){
	scanf("%llu",&chave);
	int r = funcaoHash(chave, 10);
	printf("Chave:%llu Hash:%d\n",chave,r);
	}
}

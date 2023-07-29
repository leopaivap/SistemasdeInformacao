#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int m[][100],int lin,int cols){
	
	int i,j;
	
	srand(time(NULL));
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			m[i][j]=rand()%10;
			printf("%d|",m[i][j]);
		}
		printf("\n");
	}	
	
}

void det2(int m[][100],int lin,int cols){
	
	int i,j,t=cols,det=1,det2=1;

	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			if(i==j){
				det*=m[i][j];
			}
		}
	}
	
	for(i=0;i<3;i++){
		t--;
		for(j=0;j<5;j++){
			if(j==t){
				det2*=m[i][j];
			}
		}				
	}
	
	printf("O determinante eh: %d",det-det2);
}

void detnew3(int m[][100],int lin, int cols){
	
	int i,j,k=0;
	cols+=2;

	for(i=0;i<lin;i++){
		for(j=3;j<cols;j++){
			m[i][j]=m[i][k];
			k++;
		}
		k=0;
	}
	
}

void det3(int m[][100],int lin,int cols){
	
	int t=cols,i,j,k=0,res=0,det[100];

	for(i=0;i<3;i++)
		det[i]=1;
	
	for(k=0;k<3;k++){
		for(i=0;i<lin;i++){		
			for(j=0;j<cols;j++){	
				if(i==j){
					det[k]=det[k]*m[i][j+k];
				}
			}	
		}
	}
	
	for(i=0;i<3;i++){
		res+=det[i];
		det[i]=1;
	}
	
	for(k=0;k<3;k++){
		t=5;
		for(i=0;i<3;i++){
			t--;
			for(j=0;j<5;j++){
				if(j==t){
					det[k]=det[k]*m[i][j-k];
				}
			}				
		}
	
	}
	
	for(i=0;i<3;i++)
		res-=det[i];
	
	
	printf("O determinante eh: %d",res);
	
}


int main(){
	
	int m[100][100],o,lin,cols;
	
	
	printf("Digite a ordem da matriz: ");
	scanf("%d",&o);
	
	lin  = o;
	cols = o;
	
	geraMat(m,lin,cols);
	
	switch(o){
		
		case 2:
			det2(m,lin,cols);
		break;
		
		case 3:
			detnew3(m,lin,cols);
			det3(m,lin,cols);
		break;
		
	}

	return 0;
}
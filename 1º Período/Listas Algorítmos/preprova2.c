#include <stdio.h>
#include <stdlib.h>

float desc(int q, float v){
	if( q < 3)
		return q*v;
	else if( q >= 3 && q <= 5)
		return (q*v)/0.95;
	else if(q >= 6 && q <= 10)
		return (q*v)/0.9;
	else if (q >= 11)
		return (q*v)/0.85;
}

int main(){
	int op = 1, cnt = 0, q, i;
	float v, cntvd, vp, vd[100];
	
	do{
	system("cls");
	printf("*** Sistema de Vendas Ratanaba ***\n");
	printf("1- Realiza Venda\n2- Mostra Venda\n0- Sair\n");
	
	scanf("%d", &op);
	
	switch(op){
		case 1:
			printf("\nQtde de itens e valor unitario: ");
			scanf("%d%f", &q, &v);
			vp = desc(q, v);
			printf("Valor da compra: R$%.2f", vp);
			vd[cnt] = vp;
			cntvd += vp;
			cnt++;
			break;
		case 2:
			for( i = 0; i < cnt; i++)
				printf("R$ %.2f |", vd[i]);
			printf("\nTotal de vendas: R$%.2f", cntvd);
			break;
		case 0:
			break;
		default:
			printf("\nOpcao Invalida!");
			break;
	}
	if( op != 0){
		printf("\n\nPressione um botao para continuar...\n");
		getch();
	}
	
	}while(op != 0);
	 

	return 0;
}
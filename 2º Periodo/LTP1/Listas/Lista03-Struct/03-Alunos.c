#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char nome[50];
	int matricula, n1, n2, n3;
}alunos;

int qtd = 0;

void addAluno(alunos a[]){
	
	printf("Nome: ");
	fflush(stdin);
	gets(a[qtd].nome);
	
	printf("Matricula: ");
	scanf("%d", &a[qtd].matricula);
	
	printf("Nota Prova 01: ");
	scanf("%d", &a[qtd].n1);
	
	printf("Nota Prova 02: ");
	scanf("%d", &a[qtd].n2);
	
	printf("Nota Prova 03: ");
	scanf("%d", &a[qtd].n3);
	
	printf("\nAluno cadastrado com sucesso! :)");
	
	qtd++;
}

void listaAlunos(alunos a[]){
	int i, j = -1;
	float med = 0.0, maior;
	for(i = 0; i < qtd; i++){
		printf(" -- Aluno %2d --\n", i+1);
		printf("Nome: %s\n", a[i].nome);
		printf("Matricula: %d\n", a[i].matricula);
		printf("Nota Provas: %2d | %2d | %2d\n", a[i].n1, a[i].n2, a[i].n3);
		med = (a[i].n1 + a[i].n2 + a[i].n3)/3;
		printf("Media: %.2f\n", med);
		
		if(i == 0)
			maior = med;
		else{
			if(med > maior){
				maior = med;
				j = i;
			}
		}
		
		if(med >= 6)
			printf("Aluno Aprovado! :)\n");
		else
			printf("Aluno Reprovado! :(\n");
		printf("---------------------------\n\n");
	}
	
	if(j == -1)
		printf("\nNenhum Aluno cadastrado!");
	else
		printf("O Aluno com maior media eh o(a) %s, com %.2f de media!\n", a[j].nome, maior);
}

void buscaAluno(alunos a[], int op){
	int i, j = -1, mat;
	char aux[50], busca[50];
	float med = 0.0;
	
	if(op == 1){
		printf("Informe o nome: ");
		fflush(stdin);
		gets(busca);
		strlwr(busca);
		
		for(i = 0; i < qtd; i++){
			strcpy(aux, a[i].nome);
			strlwr(aux);
			
			if(strcmp(aux, busca) == 0){
				printf("\n -- Aluno %2d --\n", i+1);
				printf("Nome: %s\n", a[i].nome);
				printf("Matricula: %d\n", a[i].matricula);
				printf("Nota Provas: %2d | %2d | %2d\n", a[i].n1, a[i].n2, a[i].n3);
				med = (a[i].n1 + a[i].n2 + a[i].n3)/3;
				printf("Media: %.2f\n", med);
				
				if(med >= 6)
					printf("Aluno Aprovado! :)\n");
				else
					printf("Aluno Reprovado! :(\n");
					
				j = 1;
				break;
			}
		}
	} else if(op == 2){
		printf("Informe a matricula: ");
		scanf("%d", &mat);
		
		for(i = 0; i < qtd; i++){
			if(mat == a[i].matricula)
				printf("\n -- Aluno %2d --\n", i+1);
				printf("Nome: %s\n", a[i].nome);
				printf("Matricula: %d\n", a[i].matricula);
				printf("Nota Provas: %2d | %2d | %2d\n", a[i].n1, a[i].n2, a[i].n3);
				med = (a[i].n1 + a[i].n2 + a[i].n3)/3;
				printf("Media: %.2f\n", med);
								
				if(med >= 6)
					printf("Aluno Aprovado! :)\n");
				else
					printf("Aluno Reprovado! :(\n");
					
				j = 1;
				break;
		}
	} else
		printf("Opcao Invalida!");
	
	if(j == -1)
		printf("aluno Nao Encontrado!");

}

int menu(){
	int op;
	
	printf("*** Sistema Alunos ***\n\n");
	printf("1- Cadastrar\n");
	printf("2- Listar Alunos\n");
	printf("3- Busca Aluno\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}

void salvaArq(alunos a[]){
	FILE *arq;
	int i = 0;
	arq = fopen("dadosAlunos.txt","wb");
	fwrite(&a[i], sizeof(a), qtd, arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
}
	
void carregaArq(alunos a[]){
	FILE *arq;
	arq = fopen("dadosAlunos.txt","rb");
	if(arq == NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}
	while(fread(&a[qtd], sizeof(alunos), 1, arq) > 0)
		qtd++;
		
	printf("Dados carregados com sucesso! \n");
	fclose(arq);
}

int main(){
	
	int i, op;
	char aux[30];
	
	alunos aluno[100];
	
	printf("Deseja carregar dados de um arquivo?(1- Sim | 2- Nao): ");
	scanf("%d", &op);
	if(op == 1)
		carregaArq(aluno);
	else if(op != 2)
		printf("\nOpcao Invalida, reinicie o app!");
		
	getch();
	system("cls");
	
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addAluno(aluno);
				break;
				
			case 2:
				printf("Lista de alunos:\n");
				listaAlunos(aluno);
				break;
				
			case 3:
				printf("Busca aluno:\n");
				printf("Deseja realizar a busca por nome ou matricula(1- Nome | 2- Matricula): ");
				scanf("%d", &i);
				buscaAluno(aluno, i);
				break;
				
			case 0:
				printf("Saindo...\n");
				salvaArq(aluno);
				break;
				
			default:
				printf("\nOpcao invalida!");
				break;		
		}
		getch();
		system("cls");
	}while(op != 0);
}

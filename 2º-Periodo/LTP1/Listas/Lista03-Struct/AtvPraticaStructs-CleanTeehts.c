//Sistema de um Consultorio de Dentista
//O sistema deve guardar o nome, genero, endereco e idade do paciente a ser cadastrado/consultado na clinica
//Grupo: Joao Luis Cardoso, Leonardo Paiva e Pedro Valentim


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	char nome[40], gen[20], end[80]; 
	int idade;
}dentes;

qtd = 0;

int menu(){
	int op;

	printf("*** Consultorio CleanTeeths ***\n");
	printf("1- Cadastrar\n");
	printf("2- Listar\n");
	printf("3- Buscar Paciente\n");
	printf("4- Filtro Genero\n");
	printf("5- Excluir\n");
	printf("6- Alterar\n");
	printf("0- Sair\n");
	printf("Digite uma opcao: ");
	scanf("%d", &op);
	printf("\n");
	
	return op;
}

void addPaciente(dentes d[]){
	printf("Nome do Paciente: ");
	fflush(stdin);
	gets(d[qtd].nome);
	
	printf("Genero do Paciente(M/F): ");
	fflush(stdin);
	gets(d[qtd].gen);
	
	printf("Endereco do Paciente: ");
	fflush(stdin);
	gets(d[qtd].end);
	
	printf("Idade: ");
	scanf("%d", &d[qtd].idade);
	qtd++;
}

void listaPacientes(dentes d[]){
	int i, j = -1;
	for(i = 0; i < qtd; i++){
		j = 1;
		strlwr(d[i].gen);
		printf("** Paciente %d: **\n ", i+1);
		printf("Nome: %s\n", d[i].nome);
		if(strcmp(d[i].gen, "m") == 0) 
			printf("Genero: Masculino\n");
		else if(strcmp(d[i].gen, "f") == 0)
			printf("Genero: Feminino\n");
		else
			printf("Genero: %s\n", d[i].gen);

		printf("Endereco: %s\n", d[i].end);
		printf("Idade: %d\n", d[i].idade);
		printf("-------------------------\n");
	}
	if(j == -1)
		printf("\nLista de Pacientes Vazia!");
}

void buscaNome(dentes d[], char busca[]){
	int i, cnt = 0;
	char buscaux[50];
	busca = strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(buscaux, d[i].nome);
		strlwr(buscaux);
		if(strcmp(busca, buscaux) == 0) {
		cnt = 1;
		printf("** Paciente %d: **\n ", i+1);
		printf("Nome: %s\n", d[i].nome);
		printf("Genero: %s\n", d[i].gen);
		printf("Endereco: %s\n", d[i].end);
		printf("Idade: %d\n", d[i].idade);
		printf("-------------------------\n");
		}
	}
	if(cnt == 0)
		printf("Paciente Nao Encontrado!\n");	
}

void buscaGen(dentes d[], int busca){
	int i, j = -1;
	for(i = 0; i< qtd; i++){
		if(strcmp(busca, strlwr(d[i].gen)) == 0){
		j = 1;
		printf("** Paciente %d: **\n ", i+1);
		printf("Nome: %s\n", d[i].nome);
		if(strcmp(d[i].gen, "m") == 0) 
			printf("Genero: Masculino\n");
		else if(strcmp(d[i].gen, "f") == 0)
			printf("Genero: Feminino\n");
		else
			printf("Genero: %s\n", d[i].gen);

		printf("Endereco: %s\n", d[i].end);
		printf("Idade: %d\n", d[i].idade);
		printf("-------------------------\n");
		}
	}
	if(j == -1)
		printf("\nGenero nao encontrado na lista!");
}

void alteraPaciente(dentes d[], char busca[]){
	int i;
	char aux[80];
	strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(aux, d[i].nome);
		strlwr(aux);
		if(strcmp(aux, busca) == 0){
			printf("** Paciente %d: **\n ", i+1);
			printf("Nome: %s\n", d[i].nome);
			if(strcmp(d[i].gen, "m") == 0) 
				printf("Genero: Masculino\n");
			else if(strcmp(d[i].gen, "f") == 0)
				printf("Genero: Feminino\n");
			else
				printf("Genero: %s\n", d[i].gen);	
	
			printf("Endereco: %s\n", d[i].end);
			printf("Idade: %d\n", d[i].idade);
			printf("-------------------------\n");
			
			printf("Novo nome: ");
			fflush(stdin);
			gets(d[i].nome);
			
			
			printf("Novo Genero: ");
			fflush(stdin);
			gets(d[i].gen);
			
			printf("Novo Endereco: ");
			fflush(stdin);
			gets(d[i].end);
			
			printf("Nova Idade: ");
			scanf("%d", &d[i].idade);
		
			printf("\nPaciente alterado(a) com sucesso! :)");
			break;
		} else 
			printf("\nPaciente Nao Encontrado!");
	}
}

void removePaciente(dentes d[], char busca[]){
	int i, op2, j = -1;
	char aux[80];
	strlwr(busca);
	for(i = 0; i < qtd; i++){
		strcpy(aux, d[i].nome);
		strlwr(aux);
		if(strcmp(aux, busca) == 0){
			printf("** Paciente %d: **\n ", i+1);
			printf("Nome: %s\n", d[i].nome);
			if(strcmp(d[i].gen, "m") == 0) 
				printf("Genero: Masculino\n");
			else if(strcmp(d[i].gen, "f") == 0)
				printf("Genero: Feminino\n");
			else
				printf("Genero: %s\n", d[i].gen);	
	
			printf("Endereco: %s\n", d[i].end);
			printf("Idade: %d\n", d[i].idade);
			printf("-------------------------\n");
			
			printf("Deseja realmente excluir esse paciente?(1- Sim | 2- Nao): ");
			scanf("%d", &op2);
			j = i;
			break;	
		}
	}
		
		if( j != -1 && op2 == 1){
				d[j] = d[qtd-1];
				qtd--;
				printf("Paciente Deletado(a) com Sucesso!\n");
		} else if( j != -1 && op2 != 1)
			printf("Paciente Nao foi Deletado(a)!\n");
		else
			printf("Paciente Nao Encontrado(a)!\n");
			
}
	
	
int main(){
	char s[80];
	int op;
	
	dentes pacientes[100]; 
		
	do{
		op = menu();
		switch(op){
			case 1:
				printf("Cadastro:\n");
				addPaciente(pacientes);
				break;
				
			case 2:
				printf("Lista de Pacientes\n");
				listaPacientes(pacientes);
				break;
				
			case 3:
				printf("Busca Paciente:\n");
				fflush(stdin);
				gets(s);
				buscaNome(pacientes, s);
				break;
				
			case 4:
				printf("Filtro Genero(M/F):\n");
				fflush(stdin);
				gets(s);
				buscaGen(pacientes, s);
				break;
				
			case 5:
				printf("Excluir: \n");
				printf("Informe o nome do paciente que deseja remover: ");
				fflush(stdin);
				gets(s);
				removePaciente(pacientes, s);
				break;
			
			case 6:
				printf("Alterar: \n");
				printf("Informe o nome do paciente que deseja alterar: ");
				fflush(stdin);
				gets(s);
				alteraPaciente(pacientes, s);
				break;
				
			case 0:
				printf("Saindo...\n");
				break;
				
			default:
				printf("\nOpcao Invalida!");
				break;
		}
		getch();
		system("cls");
	}while(op != 0);
}


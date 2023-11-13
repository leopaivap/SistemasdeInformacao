#include <stdio.h>
#define MAX 10
typedef struct{
	int grafo[MAX][MAX];
	int arestas;
}tGrafo;
int cont=0;
int visit[MAX];
//---------------------------------------
void inicializa(tGrafo *g){
	int i,j;
	for(i=0;i<MAX;i++)
	   for(j=0;j<MAX;j++)
	       g->grafo[i][j]=0;
	       
	g->arestas=0;       
}
//--------------------------------------
void addAresta(tGrafo *g, int origem, int dest){ // insere aresta - conecta vertices
	g->grafo[origem][dest]=1;
	g->grafo[dest][origem]=1; 
	g->arestas++;
}
//------------------------------------
void removeAresta(tGrafo *g, int origem, int dest){
	g->grafo[origem][dest]=0;
	g->grafo[dest][origem]=0; 
	g->arestas--;
}
//------------------------------------
void printGrafo(tGrafo g){
	int i,j;
	printf("   ");
	for(i=0;i<MAX;i++)
	   printf("%3d",i); // mostra identificador da coluna
	printf("\n");
	for(i=0;i<MAX;i++){
		printf("%3d",i);// mostra identificador da linha
		for(j=0;j<MAX;j++)
		   printf("%3d",g.grafo[i][j]);   
		printf("\n");
	}// fim for i   
}// fim funcao print
//----------------------------
void saveGrafo(tGrafo *g){
	FILE *arq;
	arq=fopen("grafoAtividade.txt","wb");
	fwrite(g,sizeof(tGrafo),1,arq);
	printf("Salvo com sucesso!:)");
	fclose(arq);
}//fim funcao
//------------------------------
void loadGrafo(tGrafo *g){
	FILE *arq;
	arq=fopen("grafoAtividade.txt","rb");
	if(arq==NULL){
		printf("Arquivo nao encontrado :(\n");
		return;
	}// fim if
	fread(g,sizeof(tGrafo),1,arq);
	printf("Carregado com sucesso!:)");
	fclose(arq);
}
//----------------------------

//-----------------------------
int menu(){
	int op;
	printf("***Digrafo***\n");
	printf("1- Inserir\n");
	printf("2- Remover\n");
	printf("3- Alcance\n");
	printf("4- DFS\n");
	printf("5- BFS\n");
	printf("0- Sair\n");
	scanf("%d",&op);
	return op;
}// fim menu
//-------------------------
int main(){
	tGrafo g1;
	int op, ori, dest;
	inicializa(&g1);
	//loadGrafo(&g1);
	do{
		printf("Grafo\n");
		printGrafo(g1);
		op=menu();
		switch(op){
			case 1: printf("Vertices para conectar:");
					scanf("%d%d",&ori,&dest);
					addAresta(&g1,ori,dest);
				break;
			case 2: printf("Vertices para desconectar:");
					scanf("%d%d",&ori,&dest);
					removeAresta(&g1,ori,dest);
				break;
			case 0: printf("Saindo\n");
					//saveGrafo(&g1);
				break;			
		}// fim switch
		getch();
		system("cls");
	}while(op!=0);
	return 0;
}// fim main

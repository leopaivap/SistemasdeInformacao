#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>


int main(){
	char dna[51], rna[51], teste[3];
	int i;
	
	gets(dna);
	
	for( i = 0; i < 50; i++ ){
		if(dna[i] == 'A')
			rna[i] = 'T';
		else if(dna[i] == 'T')
			rna[i] = 'A';
		else if(dna[i] == 'C')
			rna[i] = 'G';
		else if(dna[i] == 'G')
			rna[i] = 'C';
	}
	
	printf("\nDNA: %s\nRNA: %s\n", dna, rna);

}
	

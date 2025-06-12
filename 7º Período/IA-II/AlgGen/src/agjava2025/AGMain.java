package agjava2025;

public class AGMain {

    public static void main(String[] args) {
        // AGBruteForce meuBruteForce = new AGBruteForce(8);
        // meuBruteForce.carregaArquivo("dados.csv");
        // meuBruteForce.resolver();
        // meuBruteForce.mostrarMelhorSolucao();

        double capacidadeMochila = 8;
        int numeroGeracoes = 20;
        int tamanhoPopulacao = 100;
        int probabilidadeMutacao = 5;
        int quantidadeCruzamentos = 10;

        AlgoritmoGenerico algoritmoGenerico = new AlgoritmoGenerico(numeroGeracoes, tamanhoPopulacao,
                probabilidadeMutacao, quantidadeCruzamentos, capacidadeMochila);
        algoritmoGenerico.carregaArquivo("dados.csv");

    }

}

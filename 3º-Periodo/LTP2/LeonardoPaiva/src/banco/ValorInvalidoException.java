package banco;

public class ValorInvalidoException extends Exception{

    public ValorInvalidoException(double valor) {
        super("Valor inválido: " + valor);
    }
    
}

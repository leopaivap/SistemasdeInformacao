package banco;

abstract public class Conta {
// atributos ou variáveis de instância
    Cliente objCliente1 = new Cliente(); 
    Cliente objCliente2; 
    private double saldo;
    private double  limite;
    private int numero;
    private static int totalDeContas; 

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
        
    public double getSaldo(){
        return this.saldo;
    }
    
    Conta(){ // construtor padrão modificado
        System.out.println("Construindo uma conta");
        Conta.totalDeContas = Conta.totalDeContas+1;
    }
    
    Conta(double saldo){
        this(); // invoca o construtor padrão
        this.saldo = saldo;
    }
    Conta(double saldo, int numero){
        this(saldo); //invoca o construtor anterior
        this.numero = numero;   
    }

    public void deposita(double saldo) throws ValorInvalidoException { 
        if(saldo < 0){
            throw new ValorInvalidoException(saldo);
        } else {        
            this.saldo = this.saldo + saldo;
            System.out.println("Depósito realizado para: "+objCliente1.getNome());
        }
    }

    public boolean saca(double saldo) { 
        if (this.saldo >= saldo) {
            this.saldo = this.saldo - saldo;
            System.out.println("Saque realizado com sucesso");
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    boolean transfere(Conta destino, double saldo) {
        if (this.saca(saldo) == true) {
            try {
                destino.deposita(saldo);
            } catch(ValorInvalidoException e){
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
    abstract void atualiza(double taxa);
    
}

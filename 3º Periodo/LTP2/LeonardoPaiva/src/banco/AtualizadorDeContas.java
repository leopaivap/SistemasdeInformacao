package banco;

public class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }
    
    void roda(Conta c){
        System.out.println("\nSaldo Anterior: R$" + c.getSaldo());
        c.atualiza(selic);
        System.out.println("Saldo Atual: R$" + c.getSaldo());
        this.saldoTotal = this.saldoTotal + c.getSaldo();
    }
    
}

package banco;

public class TestaAtualizadorDeContas {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente();
        Conta cp = new ContaPoupanca();
        
        
        cc.deposita(1000);
        cp.deposita(1000);
        
        AtualizadorDeContas adc = new AtualizadorDeContas(0.10);
        adc.roda(cc);
        adc.roda(cp);
        
        System.out.println("\nSaldo Total: R$" + adc.getSaldoTotal());
    }
   
}

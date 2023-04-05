package banco;

public class ContaPoupanca extends Conta{
    
    @Override
    void atualiza(double taxa){
        deposita(this.getSaldo() * (taxa*3));
    }
}

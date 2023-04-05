package banco;

public class ContaCorrente extends Conta{

@Override
void atualiza(double taxa){
    deposita(this.getSaldo() * (taxa*2));
}    

@Override
public void deposita(double saldo){
    super.deposita(saldo - 1.0);
}

}

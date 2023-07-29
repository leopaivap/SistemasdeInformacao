package banco;

public class ContaCorrente extends Conta implements Tributavel{

@Override
void atualiza(double taxa){
    deposita(this.getSaldo() * (taxa*2));
}    

@Override
public void deposita(double saldo){
    try {
        super.deposita(saldo - 1.0);
    } catch(ValorInvalidoException e){
        System.out.println(e.getMessage());
    }
   
}

@Override
public double calculaTributos(){
    return this.getSaldo() * 0.01;
}

}

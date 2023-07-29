package banco;

public class ContaPoupanca extends Conta{
    
    @Override
    void atualiza(double taxa){
        try {
            deposita(this.getSaldo() * (taxa*3));
        } catch(ValorInvalidoException e){
            System.out.println(e.getMessage());
     }
    }
}

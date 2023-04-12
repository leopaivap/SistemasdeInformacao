package banco;

public class TestaTributavel {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(100);
        
        System.out.println(cc.calculaTributos());
        //testando  o polimorfismo;
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
        
       // System.out.println(t.getSaldo()); erro
       /*
       Isso acontece porque a interface Tributavel não define o método getSaldo(),
       e sim apenas o método calculaTributos(), que é implementado pela classe ContaCorrente.
       Quando a referência cc é atribuída à referência t, ocorre uma conversão de tipos implícita,
       permitindo que o objeto cc seja tratado como um Tributavel. No entanto, como Tributavel
       não tem um método getSaldo(), essa operação não é possível.
       */
    }
}

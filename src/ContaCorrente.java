
public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente); 
    }


    @Override
    public void imprimirExtrato(){
        System.out.println("==Extrato Conta Corrente =="); 
        super.infosComum();
    }

    @Override
    public String toString() {
    return "ContaCorrente{" +
           "numero=" + numero +
           ", cliente=" + cliente +
           '}';
    }
}

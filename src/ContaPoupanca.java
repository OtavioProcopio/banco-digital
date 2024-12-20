public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente); 
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("==Extrato Conta Poupança =="); 
        super.infosComum();
    }

    @Override
    public String toString() {
    return "ContaPoupanca{" +
           "numero=" + numero +
           ", cliente=" + cliente +
           '}';
    }
}
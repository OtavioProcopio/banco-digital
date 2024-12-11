public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected Cliente cliente;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta(Cliente cliente){
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public Cliente getCliente(){
        return cliente;
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
    if (valor <= saldo) {
        saldo -= valor;
        System.out.println("Saque realizado com sucesso!");
    } else {
        System.out.println("Saldo insuficiente.");
    }
}

    @Override
    public void depositar(double valor) {
        this.saldo+=valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void infosComum() {
        System.out.println(String.format("Agencia : %d", this.agencia));
        System.out.println(String.format("Numero : %d", this.numero));
        System.out.println(String.format("Saldo : %.2f", this.saldo));
    }

}

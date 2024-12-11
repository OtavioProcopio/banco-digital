public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private int idade;

    
    public Cliente(String nome, String email, String telefone, int idade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

    public Cliente(){
        
    }

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
    return "Cliente{" +
           "nome='" + nome + '\'' +
           ", email='" + email + '\'' +
           ", telefone='" + telefone + '\'' +
           ", idade=" + idade +
           '}';
    }   

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        
        Scanner scan = new Scanner(System.in);
        
        int opcao;
        
        createFile("Clientes");
        createFile("Contas");
        
        do { 

            System.out.print("##-- Menu --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Novo Cadastro     |\n");
            System.out.print("| Opção 2 - Clientes          |\n");
            System.out.print("| Opção 3 - Produtos          |\n");
            System.out.print("| Opção 4 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = scan.nextInt();

            switch(opcao){
                case 1:
                    
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scan.next();
                    System.out.print("Digite o e-mail do cliente: ");
                    String email = scan.next();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scan.next();
                    System.out.print("Digite a idade do cliente: ");
                    int idade = scan.nextInt();
            
                    Cliente cliente = new Cliente(nome, email, telefone, idade);

                    Conta contaCorrente = new ContaCorrente(cliente);
                    Conta contaPoupanca = new ContaPoupanca(cliente);

                    List <Conta> contas = new ArrayList<>();
                    contas.add(contaCorrente);
                    contas.add(contaPoupanca);
            
                    System.out.println("Contas criadas com sucesso para " + cliente.getNome());
                    System.out.println("Conta Corrente - Número: " + contaCorrente.getNumero());
                    System.out.println("Conta Poupança - Número: " + contaPoupanca.getNumero());

                    salvarCliente(cliente);
                    salvarContas(contas);

                    break;

                case 2:
                    try {
                       List<Cliente> data =  mostrarDados(); 
                       for(Cliente c : data){
                        System.out.println(data);
                       }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
                        
                    } catch (Exception e) {
                        System.out.println("Falha ao buscar Clientes");
                    }
                    break;
                
                
                
                
                   

                case 3:
                    break;
                
                case 4:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Opção invalida, por favor escolha novamente");
                    break;
                
            }



        } while (opcao != 4);
    }

    public static void createFile(String nome){ 
        File file = new File(nome + ".txt");
        if(file.exists()){
            System.out.println("O arquivo " + nome + ".txt ja existe");
        }else{
            try {
                PrintWriter pw = new PrintWriter(file);
                pw.println("Arquivo de: " + nome );
                pw.close();
                System.out.println("Arquivo criado com sucesso: " + nome + ".txt");
    
            } catch (Exception e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }                    
    }

    public static void salvarCliente(Cliente cliente){
        try (FileWriter fw = new FileWriter("Clientes.txt",true);
            PrintWriter pw = new PrintWriter(fw)){
            pw.println(cliente.getNome() + "," + cliente.getEmail() + "," + cliente.getTelefone() + "," + cliente.getIdade());
            System.out.println("Cliente salvo com sucesso.");
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar");
        }
    }

    public static void salvarContas(List<Conta> contas){
        try (FileWriter fw = new FileWriter("Contas.txt", true);
            PrintWriter pw = new PrintWriter(fw)){

            for(Conta conta : contas){
                pw.println(conta);
            }

        }catch (IOException e){
            System.out.println("Erro ao salvar Contas");
        }
    }

    public static List<Cliente> mostrarDados() throws FileNotFoundException {
        File file = new File("Clientes.txt");
        Scanner scan = new Scanner(file);
        List<Cliente> clientes = new ArrayList<>();
    
        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            String[] partes = linha.split(","); 
            if (partes.length == 4) { 
                String nome = partes[0];
                String email = partes[1];
                String telefone = partes[2];
                int idade = Integer.parseInt(partes[3]);
                clientes.add(new Cliente(nome, email, telefone, idade));
            }
        }
        scan.close();
        return clientes;
    }
    


}

class Conta{
    int NumConta; // Número da conta
    Cliente DonoConta; // Objeto Cliente que é o dono da conta
    double SaldoConta; // Saldo da conta
    double LimiteConta; // Limite da conta
    
    // Construtor padrão da classe Conta
    public Conta(){
        this.NumConta = -1; // Inicializa o número da conta com -1
        this.DonoConta = new Cliente(); // Instanciando um novo objeto Cliente
        this.DonoConta.Nome = "<INEXISTENTE>"; // Define o nome do dono como "<INEXISTENTE>"
        this.SaldoConta = 0.0; // Inicializa o saldo como 0
        this.LimiteConta = 0.0; // Inicializa o limite como 0
    }
    
    // Classe interna Cliente
    class Cliente{
        String Nome; // Nome do cliente
        String CPF; // CPF do cliente
        String Endereço; // Endereço do cliente
        int Idade; // Idade do cliente
        char Sexo; // Sexo do cliente
    }
    
    // Método para realizar um depósito
    public void deposito(Double valor){
        this.SaldoConta = this.SaldoConta + valor; // Adiciona o valor ao saldo
    }
    
    // Método para realizar um saque
    public boolean saque(double valor){
        if (valor <= this.SaldoConta){ // Verifica se há saldo suficiente para o saque
            this.SaldoConta = this.SaldoConta - valor; // Subtrai o valor do saldo
            return true; // Retorna verdadeiro indicando que o saque foi realizado com sucesso
        }else{
            return false; // Retorna falso indicando que o saque não foi possível
        }
    }
    
    // Método para transferir um valor para outra conta
    public boolean transferir(Conta contaDestino, double valor){
        boolean retirar = this.saque(valor); // Tenta realizar o saque na conta de origem
        
        if(retirar){ // Se o saque foi realizado com sucesso
            contaDestino.deposito(valor); // Deposita o valor na conta de destino
            return true; // Retorna verdadeiro indicando que a transferência foi realizada com sucesso
        }else{
            return false; // Retorna falso indicando que a transferência não foi possível
        }
    }
    
    // Método para imprimir os detalhes de uma conta
    public void imprimir(Conta contaQualquer){
        System.out.println(contaQualquer.NumConta); // Imprime o número da conta
        System.out.println(contaQualquer.DonoConta.Nome); // Imprime o nome do dono da conta
        System.out.println(contaQualquer.SaldoConta); // Imprime o saldo da conta
        System.out.println(contaQualquer.LimiteConta); // Imprime o limite da conta
    }
}

// Classe principal do programa
public class conta{
    
    public static void main(String[] args) {
        
        // Criando instâncias das contas
        Conta contaIcaro = new Conta();
        Conta contaMaria = new Conta();
        
        // Criando instâncias dos clientes e associando às contas
        Conta.Cliente clienteIcaro = contaIcaro.new Cliente();
        clienteIcaro.Nome = "Icaro";
        contaIcaro.DonoConta = clienteIcaro;

        Conta.Cliente clienteMaria = contaMaria.new Cliente();
        clienteMaria.Nome = "Maria";
        contaMaria.DonoConta = clienteMaria;
        
        // Imprimindo saldo e dono da conta de Icaro
        System.out.println(contaIcaro.SaldoConta);
        System.out.println(contaIcaro.DonoConta);
        
        System.out.println();
        
        // Definindo os detalhes das contas
        contaIcaro.NumConta = 15;
        contaIcaro.DonoConta = "Icaro";
        contaIcaro.SaldoConta = 15000;
        contaIcaro.LimiteConta = 25000.0;
        
        contaMaria.NumConta = 25;
        contaMaria.DonoConta = "Maria";
        contaMaria.SaldoConta = 3500;
        contaMaria.LimiteConta = 45000.0;
        
        // Imprimindo detalhes das contas
        System.out.println(contaIcaro.DonoConta);
        System.out.println(contaMaria.DonoConta);
        
        System.out.println("Saldo icaro: " + contaIcaro.SaldoConta);
        System.out.println("Saldo Maria: " + contaMaria.SaldoConta);
        
        System.out.println();
        
        // Realizando operações na conta de Icaro
        contaIcaro.deposito(700.0);
        System.out.println("Novo saldo: " + contaIcaro.SaldoConta);
        
        boolean saqueRealizado = contaIcaro.saque(800);
        
        if(saqueRealizado){
            System.out.println("Saque realizado com sucesso!");
            System.out.printf("Sacando %d reais...\n", 800);
            System.out.println("novo Saldo: " + contaIcaro.SaldoConta);
        }else{
            System.out.println("Nao foi possivel fazer o saque!");
        }
        
        System.out.println();
        
        // Transferindo valor da conta de Icaro para a conta de Maria
        contaIcaro.transferir(contaMaria, 3100);
        System.out.println("Saldo de Icaro: " + contaIcaro.SaldoConta);
        System.out.println("Novo saldo de maria: " + contaMaria.SaldoConta);
        
        // Imprimindo detalhes da conta de Icaro
        contaIcaro.imprimir(contaIcaro);
        
    }
}

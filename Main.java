import java.util.Scanner;
public class Main {
    static void selecaoMesa(Mesa[] table){
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();
        int d=5;
        System.out.println("Selecione a Mesa: \n");
            for(int contador=0;contador<5;contador++){
                if(table[contador].statusMesa == "Mesa Livre"){
                    message.append("Mesa " + (contador+1) + "\n");
                }else{
                    message.append("Mesa " + (contador+1) + " Ocupada\n");
                }
            }
            String resposta = message.toString();
            System.out.println(resposta);
            System.out.println("0- Voltar");
            d = scanner.nextInt();
            if(d==0){
                return;
            }else{
                table[d-1].statusMesa="Mesa Ocupada";
                cardapio(table[d-1]);
            }
    }
    static void cardapio(Mesa table){
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();
        String[] opcoes = {"Iscas de Picanha", "Pão de Alho", "Cesta de Batata Frita", "Salada do Chef", "Filé Argentino (Bife Ancho)", "Pudim L´creme","Palha Italiana de Chocolate", "Refrigerante", "Suco de Laranja"};
        double[] precos = {72.80, 14.90, 29.90, 41.00, 75.00, 24.90, 29.00, 8.70, 15.50};
        int a=5, q;
        double total=0;
        message.append("---COMANDA---\n\n");
        while(a!=0){
            System.out.println("Cardapio:\n1- Iscas de Picanha - R$ 72,80\n2- Pão de Alho - R$ 14,90\n3- Cesta de Batata Frita - R$ 29,90\n4- Salada do Chef - R$ 41,00\n5- Filé Argentino (Bife Ancho) - R$ 75,00\n6- Pudim L´creme - R$ 24,90\n7- Palha Italiana de Chocolate - R$ 29,00\n8- Refrigerante - R$ 8,70\n9- Suco de Laranja - R$ 15,50");
            a = scanner.nextInt();
            System.out.println("Insira quantidade: ");
            q = scanner.nextInt();
            message.append(q + " - " + opcoes[a-1] + " - " + precos[a-1]*q + "\n");
            total += precos[a-1]*q;
            System.out.println("Algo mais?\n1-Sim\n0-Não");
            a = scanner.nextInt();
        }
        message.append("Total = " + total + "\n");
        String comanda = message.toString();
        System.out.println(comanda);
        table.preco=total;
    }
    public static void main(String[] args) {
        Mesa[] table;
        table = new Mesa[5];
        table[0] = new Mesa("Mesa Livre");
        table[1] = new Mesa("Mesa Livre");
        table[2] = new Mesa("Mesa Livre");
        table[3] = new Mesa("Mesa Livre");
        table[4] = new Mesa("Mesa Livre");
        Scanner scanner = new Scanner(System.in);
        int c=5;
        while(c!=0){
            System.out.println("Menu - Selecione uma opção: \n1- Criar Pedido\n2- Entregar Pedido\n3- Realizar Pagamento\n0- Sair");
            c = scanner.nextInt();

            switch(c){
                case 1:
                    selecaoMesa(table);
                    break;

            }
        }
    }
}

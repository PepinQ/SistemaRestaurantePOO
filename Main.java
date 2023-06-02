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
            if(d<=0 || d>5){
                return;
            }else if(table[d-1].statusMesa=="Mesa Ocupada"){
                System.out.println("Mesa escolhida encontra-se ocupada");
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
        table.pedido = comanda;
        System.out.println(comanda);
        table.preco=total;
        table.statusPedido="Em Andamento";
    }

    static void entregarMesa(Mesa[] table){
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();
        int d=5, a;
        System.out.println("Mesas disponíveis para entrega: \n");
        for(int contador=0;contador<5;contador++){
            if(table[contador].statusMesa == "Mesa Livre"){
                continue;
            }else{
                message.append("Mesa " + (contador+1) + "\n");
            }
        }
        String resposta = message.toString();
        System.out.println(resposta);
        System.out.println("0- Voltar");
        d = scanner.nextInt();
        if(d<=0 || d>5){
            return;
        }else if(table[d-1].statusPedido!="Completo"){
            System.out.println("Mesa Escolhida Inválida");
            return;
        }else{
            System.out.println("Pedido da Mesa " + d + ":\n" + table[d-1].pedido + "Declarar esse pedido como entregue? (1-Sim/0-Não)\n");
            a = scanner.nextInt();
            if(a==1){
                System.out.println("Pedido Entregue com Sucesso!\n");
                table[d-1].statusPedido="Entregue";
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        Chef cozinheiro = new Chef();
        Caixa caixa = new Caixa();
        Mesa[] table;
        table = new Mesa[5];
        table[0] = new Mesa("Mesa Livre", "Não Realizado");
        table[1] = new Mesa("Mesa Livre", "Não Realizado");
        table[2] = new Mesa("Mesa Livre", "Não Realizado");
        table[3] = new Mesa("Mesa Livre", "Não Realizado");
        table[4] = new Mesa("Mesa Livre", "Não Realizado");
        Scanner scanner = new Scanner(System.in);
        int c=5;
        while(c!=0){
            System.out.println("Menu - Selecione uma opção: \n1- Criar Pedido\n2- Entregar Pedido\n3- Realizar Pagamento\n0- Sair");
            c = scanner.nextInt();

            switch(c){
                case 1:
                    selecaoMesa(table);
                    for(int y=0;y<=4;y++){
                        if(table[y].statusPedido=="Em Andamento") {
                            table[y].statusPedido=cozinheiro.cozinhar();
                        }
                    }
                    break;
                case 2:
                    entregarMesa(table);
                    break;
                case 3:
                    caixa.pagar(table[1]);
            }
        }
    }
}

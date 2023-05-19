import java.util.Scanner;
public class Main {
    static void selecaoMesa(Mesa[] table){
        Scanner scanner = new Scanner(System.in);
        int d=5;
            System.out.println("Selecione a Mesa: \nMesa 1\nMesa 2\nMesa 3\nMesa 4\nMesa 5\nMesa 6\nMesa 7\nMesa 8\nMesa 9\nMesa 10\n0- Voltar");
            d = scanner.nextInt();
            if(d==0){
                return;
            }else{
                table[d-1] = new Mesa();
                cardapio(table[d]);
            }
    }
    static void cardapio(Mesa table){
        int a=5;
        while(a!=0){
            System.out.println("Cardapio:\n1- Iscas de Picanha - R$ 72,80\n2- Pão de Alho - R$ 14,90\n3- Cesta de Batata Frita - R$ 29,90\n4- Salada do Chef - R$ 41,00\n5- Filé Argentino (Bife Ancho) - R$ 75,00\n6- Pudim L´creme - R$ 24,90\n7- Palha Italiana de Chocolate - R$ 29,00\n8- Refrigerante - R$ 8,70\n9- Suco de Laranja - R$ 15,50");
        }
    }
    public static void main(String[] args) {
        Mesa[] table;
        table = new Mesa[10];
        Scanner scanner = new Scanner(System.in);
        int c=5;
        while(c!=0){
            System.out.println("Menu - Selecione uma opção: \n1- Criar Pedido\n2- Entregar Pedido\n3- Realizar Pagamento\n0- Sair");
            c = scanner.nextInt();

            switch(c){
                case 1:
                    selecaoMesa(table);
            }
        }
    }
}
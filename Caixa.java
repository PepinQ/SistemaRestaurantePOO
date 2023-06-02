public class Caixa extends Mesa{
    public double valortotal = preco;
    public void pagar(Mesa table){
        table.statusMesa="Mesa Livre";
        table.statusPedido="Não Realizado";
        table.preco=0.00;
        table.pedido="";
    }
}

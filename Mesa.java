public class Mesa {
    public double preco;
    public String statusMesa = "Mesa Livre";
    public String statusPedido = "Não Realizado";
    public String pedido;
    public Mesa(String statusMesa, String statusPedido){
        this.statusMesa = statusMesa;
        this.statusPedido = statusPedido;
    }
    public Mesa(){

    }
}

public class Chef extends Mesa{
    String comanda = pedido;
    public String cozinhar(){
        statusPedido = "Completo";
        return statusPedido;
    }
    public Chef(){

    }
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> orderItems = new ArrayList<>();

    SimpleDateFormat formatOrderTime = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
    SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyy");

    public Order() {}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    //getters and setters

    public List<OrderItem> getItems() {
        return orderItems;
    }

    public Client getClient() {
        return client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    //other methods

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for(OrderItem item : orderItems) {
            sum+=item.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Order Sumary: " + "\n");
        sb.append("Order moment: " + formatOrderTime.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + " " + formatBR.format(client.getBirthDate()) + " - " + client.getEmail() + "\n");
        sb.append("Order items: \n");
        for(OrderItem item : orderItems) {
            sb.append(item.getProduct().getName() + ", $" + item.getPrice() + ", " + "Quantity: " + item.getQuantity() + ", Subtotal: $" + item.subTotal() + "\n");
        }
        sb.append("Total Price: $" + this.total());
        return sb.toString();
    }
}

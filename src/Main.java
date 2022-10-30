import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        String name = input.next();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("birth date (DD/MM/YYYY): ");
        Date birthDate = formatBR.parse(input.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        String status = input.next();

        Date date = new Date();

        Order order = new Order(date, OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order: ");
        Integer itemsQuantity = input.nextInt();

        for(int i = 0; i < itemsQuantity; i++) {
            System.out.printf("Enter #%d item data: \n", (i + 1));
            System.out.print("Product name: ");
            String productName = input.next();
            System.out.print("Product price: ");
            Double productPrice = input.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = input.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println(order);


    }
}
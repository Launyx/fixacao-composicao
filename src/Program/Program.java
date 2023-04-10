package Program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.Enums.OrderStatus;

public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner tec = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = tec.nextLine();

        System.out.print("Email:");
        String email = tec.nextLine();

        System.out.println("Birth date (DD/MM/YYYY): ");
        String birthDate = tec.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localdate = LocalDate.parse(birthDate, formatter);

        Client c1 = new Client(name, email, localdate);

        LocalDate moment = localdate.now();
        OrderStatus status = OrderStatus.PROCESSING;

        Order order = new Order(moment, status, c1);

        System.out.println("How many items to this order? ");
        int n = Integer.parseInt(tec.nextLine());

        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String pName = tec.nextLine();

            System.out.print("Product price: ");
            Double pPrice = Double.parseDouble(tec.nextLine());

            Product product = new Product(pName, pPrice);

            System.out.print("Quantity: ");
            int pQuantity = Integer.parseInt(tec.nextLine());

            OrderItem orderItem = new OrderItem(pQuantity, pPrice, product);

            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY: ");


        System.out.println("Enter order data: ");
        System.out.print("Status: ");




        System.out.println(localdate);
        System.out.println(formatter.format(localdate));
        tec.close();
    }
}

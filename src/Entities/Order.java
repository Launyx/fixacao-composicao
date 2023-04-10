package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entities.Enums.OrderStatus;

public class Order {
    
    private LocalDate moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order(){

    }

    public Order(LocalDate moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public Double total(){
        Double sum = 0.00;

        for (OrderItem x: items){
            sum += x.subTotal();
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: " + moment);
        sb.append("\nOrder status: " + status);
        sb.append("\nClient: " + client.getName() + " " + client.getBirthDate() + " - " + client.getEmail());
        sb.append("\nOrder items: \n");
        
    }
    
}

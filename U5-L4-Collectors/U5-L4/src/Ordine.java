import java.time.LocalDate;
import java.util.List;

public class Ordine {
    int id;
    Status status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List <Prodotto> prodotti ;
    Cliente customer;

    public Ordine(int id, Status status, LocalDate orderDate, LocalDate deliveryDate, List<Prodotto> prodotti, Cliente customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.prodotti = prodotti;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public Cliente getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", prodotti=" + prodotti +
                ", customer=" + customer +
                '}';
    }
}





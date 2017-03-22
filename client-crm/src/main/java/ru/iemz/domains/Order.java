package ru.iemz.domains;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by stas on 04/03/17.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

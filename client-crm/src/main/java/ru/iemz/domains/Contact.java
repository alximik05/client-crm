package ru.iemz.domains;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by stas on 04/03/17.
 */
@Entity
@Table(name = "CONTACTS")
public class Contact {

    @Id
    @Column(name = "CONTACT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERS_CONTACTS_BINDING",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private Set<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

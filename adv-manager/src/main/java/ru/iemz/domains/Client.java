package ru.iemz.domains;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stas on 04/03/17.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long idAdvertisement;
    @OneToMany
    private List<Contact> contacts;
    @OneToMany
    private List<Order> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getIdAdvertisement() {
        return idAdvertisement;
    }

    public void setIdAdvertisement(long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }
}

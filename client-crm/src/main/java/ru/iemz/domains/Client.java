package ru.iemz.domains;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stas on 04/03/17.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADVERTISEMENTID")
    private long advertisementId;

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

    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }
}

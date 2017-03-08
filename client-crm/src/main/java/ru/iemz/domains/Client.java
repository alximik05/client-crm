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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
//    @Column(name = "idAdvertisement")
//    private long idAdvertisement;

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

//    public long getIdAdvertisement() {
//        return idAdvertisement;
//    }
//
//    public void setIdAdvertisement(long idAdvertisement) {
//        this.idAdvertisement = idAdvertisement;
//    }
}

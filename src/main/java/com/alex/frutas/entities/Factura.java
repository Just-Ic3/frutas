package com.alex.frutas.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Factura {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE }
    )
    @JoinTable(name = "factura_frutas",
            joinColumns = { @JoinColumn(name = "factura_id")},
            inverseJoinColumns = { @JoinColumn(name = "fruta_id") })
    private List<Fruta> frutaList;
}

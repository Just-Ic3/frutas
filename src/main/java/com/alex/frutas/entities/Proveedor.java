package com.alex.frutas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Proveedor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @NotEmpty(message = "El nombre no puede estar vacio.")
    private String nombre;
    @NotEmpty(message = "La descripcion no puede estar vacia.")
    private String descripcion;

    private String direccion;
    private String rfc;

    @Size(min = 10, message = "Ingrese minimo 10 digitos")
    private String telefono;

    private String email;

    @OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("proveedor")
    private List<Fruta> frutas;
}

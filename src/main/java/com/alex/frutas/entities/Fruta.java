package com.alex.frutas.entities;

import com.alex.frutas.dtos.FrutaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Fruta {

    public Fruta(FrutaDTO frutaDTO) {
        nombre = frutaDTO.getNombre();
        descripcion = frutaDTO.getDescripcion();
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @NotEmpty(message = "El nombre no puede estar vacio.")
    private String nombre;
    @NotEmpty(message = "La descripcion no puede estar vacia.")
    private String descripcion;

    private Integer cantidad;
    private Double precio;

    public void setCampos(Fruta fruta) {
        this.nombre = fruta.nombre;
        this.descripcion = fruta.descripcion;
        this.cantidad = fruta.cantidad;
        this.precio = fruta.precio;
    }

    public Boolean getEnEspecial() {
        if(precio <=  5) {
            return true;
        }
        return false;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("frutas")
    private Proveedor proveedor;

}

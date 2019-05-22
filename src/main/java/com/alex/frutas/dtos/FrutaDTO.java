package com.alex.frutas.dtos;

import com.alex.frutas.entities.Fruta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class FrutaDTO {

    private String id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;

    public FrutaDTO(Fruta fruta) {
        id = fruta.getId();
        nombre = fruta.getNombre();
        descripcion = fruta.getDescripcion();
    }
}

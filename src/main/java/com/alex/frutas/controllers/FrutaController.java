package com.alex.frutas.controllers;

import com.alex.frutas.dtos.FrutaDTO;
import com.alex.frutas.entities.Fruta;
import com.alex.frutas.services.FrutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/frutas")
@RequiredArgsConstructor
@CrossOrigin
public class FrutaController {
    private final FrutaService frutaService;

    @GetMapping("/all")
    public List<FrutaDTO> getAllFrutas() {
        return frutaService.getFrutas().stream().map(FrutaDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public FrutaDTO getFrutaById(@PathVariable("id") String id) {
        return new FrutaDTO(frutaService.findById(id));
    }

    @GetMapping()
    public Page<Fruta> getFrutaPage(@RequestParam("pagina") Long pagina,
                                    @RequestParam("tamano") Long tamano) {
        return frutaService.getFrutaPage(pagina, tamano);
    }

    @PostMapping(consumes = "application/json")
    public Fruta saveFruta(@RequestBody @Valid FrutaDTO fruta) {
        return frutaService.saveFruta(fruta);
    }

}

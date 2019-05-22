package com.alex.frutas.services;

import com.alex.frutas.dtos.FrutaDTO;
import com.alex.frutas.entities.Fruta;
import com.alex.frutas.repositories.FrutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FrutaService {

    private final FrutaRepository frutaRepository;

    @Transactional
    public Fruta saveFruta(FrutaDTO fruta) {
        return frutaRepository.save(new Fruta(fruta));
    }

    public List<Fruta> getFrutas() {
        return frutaRepository.findAll();
    }

    public Page<Fruta> getFrutaPage(Long pagina, Long tamano) {
        return frutaRepository.findAll(PageRequest.of(pagina.intValue(),tamano.intValue()));
    }

    public Fruta findById(String id) {
         Fruta fruta = frutaRepository.findByIdEquals(id);
         if(fruta == null) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro la fruta ingresada.");
         }
         return fruta;
    }

    public Fruta editarFruta(Fruta fruta) {
        Fruta frutaEncontrada = frutaRepository.findByIdEquals(fruta.getId());
        if(frutaEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Fruta no encontrada.");
        }
        frutaEncontrada.setCampos(fruta);
        return frutaRepository.save(frutaEncontrada);
    }

    public void deleteFruta(String id) {
        frutaRepository.deleteById(id);
    }


}

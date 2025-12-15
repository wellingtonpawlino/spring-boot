
package com.example.apiagenda.controller;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import com.example.apiagenda.dto.PasseioDTO;
import com.example.apiagenda.entity.Passeio;
import com.example.apiagenda.service.PasseioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/passeios")
public class PasseioController {

    private final PasseioService service;

    public PasseioController(PasseioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passeio> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Passeio> criar(@Valid @RequestBody PasseioDTO dto) {
        Passeio passeio = new Passeio(
                dto.getNome(),
                dto.getDescricao(),
                dto.getLocal(),
                dto.getCategoria(),
                dto.getDataHora()
        );
        Passeio salvo = service.salvar(passeio);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public Passeio buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}




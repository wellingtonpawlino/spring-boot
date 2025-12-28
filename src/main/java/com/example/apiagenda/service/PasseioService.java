
package com.example.apiagenda.service;

import com.example.apiagenda.dto.PasseioDTO;
import com.example.apiagenda.entity.Passeio;
import com.example.apiagenda.repository.PasseioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasseioService {

    private final PasseioRepository repository;

    public PasseioService(PasseioRepository repository) {
        this.repository = repository;
    }

    public List<Passeio> listarTodos() {
        return repository.findAll();
    }

    public Passeio salvar(Passeio passeio) {
        return repository.save(passeio);
    }

    public Passeio buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ✅ Método atualizar dentro da classe
    public Passeio atualizar(Long id, PasseioDTO dto) {
        return repository.findById(id).map(passeio -> {
            passeio.setNome(dto.getNome());
            passeio.setDescricao(dto.getDescricao());
            passeio.setLocal(dto.getLocal());
            passeio.setCategoria(dto.getCategoria());
            passeio.setDataHora(dto.getDataHora());
            return repository.save(passeio);
        }).orElse(null);
    }
}

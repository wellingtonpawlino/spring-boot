

package com.example.apiagenda.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "passeios")
@AllArgsConstructor
@NoArgsConstructor
public class Passeio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String local;
    private String categoria;
    private LocalDateTime dataHora;

    // Construtor customizado sem o ID (útil para criar novos registros)
    public Passeio(String nome, String descricao, String local, String categoria, LocalDateTime dataHora) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.categoria = categoria;
        this.dataHora = dataHora;
    }
}


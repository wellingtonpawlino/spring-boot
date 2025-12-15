
package com.example.apiagenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PasseioDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "O local é obrigatório")
    private String local;

    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    @NotNull(message = "A data e hora são obrigatórias")
    private LocalDateTime dataHora;
}

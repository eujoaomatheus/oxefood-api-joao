package br.com.ifpe.oxefood.api.promocao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.promocao.Promocao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromocaoRequest {

    @NotNull(message = "O Titulo é de preenchimento obrigatório")
    @NotBlank(message = "O Titulo é de preenchimento obrigatório")
    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @NotNull(message = "A Regra é de preenchimento obrigatório")
    @NotBlank(message = "A Regra é de preenchimento obrigatório")
    private String regra;
    private Double valorDesconto;

    public Promocao build(){
        
        return Promocao.builder()
            .titulo(titulo)
            .dataInicio(dataInicio)
            .dataFim(dataFim)
            .regra(regra)
            .valorDesconto(valorDesconto)
            .build();

    }
} 

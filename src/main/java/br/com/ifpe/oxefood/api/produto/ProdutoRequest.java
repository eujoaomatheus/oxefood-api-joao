package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
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
public class ProdutoRequest {

    @NotNull(message = "O Codigo é de preenchimento obrigatório")
    @NotBlank(message = "O Codigo é de preenchimento obrigatório")
    private String codigo;

    @NotNull(message = "O Titulo é de preenchimento obrigatório")
    @NotBlank(message = "O Titulo é de preenchimento obrigatório")
    private String titulo;
    private String descricao;

    @NotNull(message = "O Valor Unitario é de preenchimento obrigatório")
    @NotBlank(message = "O Unitario é de preenchimento obrigatório")
    private Double valorUnitario;

    @NotNull(message = "O Tempo de Enetrega Minino é de preenchimento obrigatório")
    @NotBlank(message = "O Tempo de Enetrega Minino é de preenchimento obrigatório")
    private Integer tempoEntregaMinimo;

    @NotNull(message = "O Tempo de Enetrega Máximo é de preenchimento obrigatório")
    @NotBlank(message = "O Tempo de Enetrega Máximo é de preenchimento obrigatório")
    private Integer tempoEntregaMaximo;

    @NotNull(message = "O ID da Categoria é de preenchimento obrigatório")
    @NotBlank(message = "O ID da Categoria é de preenchimento obrigatório")
    private Long idCategoria;

    public Produto build() {

        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();

    }
}


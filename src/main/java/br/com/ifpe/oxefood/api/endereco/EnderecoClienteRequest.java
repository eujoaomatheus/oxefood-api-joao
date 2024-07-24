package br.com.ifpe.oxefood.api.endereco;

import br.com.ifpe.oxefood.modelo.endereco.EnderecoCliente;
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
public class EnderecoClienteRequest {

    @NotNull(message = "A rua é de preenchimento obrigatório")
    @NotBlank(message = "A rua é de preenchimento obrigatório")
    private String rua;

    @NotNull(message = "O Número é de preenchimento obrigatório")
    @NotBlank(message = "O Número é de preenchimento obrigatório")
    private String numero;

    @NotNull(message = "O Bairro é de preenchimento obrigatório")
    @NotBlank(message = "O Bairro é de preenchimento obrigatório")
    private String bairro;

    @NotNull(message = "O Cep é de preenchimento obrigatório")
    @NotBlank(message = "O Cep é de preenchimento obrigatório")
    private String cep;

    @NotNull(message = "A Cidade é de preenchimento obrigatório")
    @NotBlank(message = "A Cidade é de preenchimento obrigatório")
    private String cidade;

    @NotNull(message = "O Estado é de preenchimento obrigatório")
    @NotBlank(message = "O Estado é de preenchimento obrigatório")
    private String estado;

    private String complemento;

    public EnderecoCliente build() {

        return EnderecoCliente.builder()
                .rua(rua)
                .numero(numero)
                .bairro(bairro)
                .cep(cep)
                .cidade(cidade)
                .estado(estado)
                .complemento(complemento)
                .build();
    }
}

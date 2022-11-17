package br.com.altec.api.medico;

import br.com.altec.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//onde chega os dados da requisição

public record DadosCadastroMedicos(

        @NotBlank // campo não pode ser nulo e nem vazio
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank //obrigatorio
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //passando uma expressão regular d{4,6}
        String crm,
        @NotNull //não pode ser nulo
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {


}

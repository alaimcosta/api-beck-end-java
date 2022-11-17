package br.com.altec.api.medico;


import br.com.altec.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

//dadaos atualizáveis
public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}

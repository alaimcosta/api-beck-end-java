package br.com.altec.api.medico;

import br.com.altec.api.endereco.DadosEndereco;

public record DadosCadastroMedicos(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {


}

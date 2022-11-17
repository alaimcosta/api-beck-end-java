package br.com.altec.api.medico;

//dados que devo devolver para o controller
public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade ) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

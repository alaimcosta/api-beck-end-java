package br.com.altec.api.controller;

import br.com.altec.api.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //injeção de pedendencias
    @Autowired //vai instanciar e passar como parametro os atributos
    private MedicoRepository repository;

    @PostMapping
    @Transactional //transação ativa com o banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados) {
        repository.save(new Medico(dados));

    }

    @GetMapping                                                                                  //Apenas de leitura
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {                                //objeto do tipo Pageable do spring
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);    //acessar o bando de dados e converter para uma Lista no final. | .map - faz o mapeamento
    }

    @PutMapping
    @Transactional //transação com o BD
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){
        var medico = repository.getReferenceById(dados.id());    //primeiro carrega o objeto no banco de dados
        medico.atualizarInformacoes(dados);                             //criar metodo para atualizar dados do médico
    }

    @DeleteMapping("/{id}") //parametro dinâmico /{}
    @Transactional //transação com o BD
    public void excluir(@PathVariable Long id){        // @PathVariable para equivaler ao id passado como parametro
        var medico = repository.getReferenceById(id);    //primeiro carrega o objeto no banco de dados
        medico.excluir();
    }


}

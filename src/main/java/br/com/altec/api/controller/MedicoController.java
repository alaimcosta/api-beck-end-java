package br.com.altec.api.controller;

import br.com.altec.api.medico.DadosCadastroMedicos;
import br.com.altec.api.medico.Medico;
import br.com.altec.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

package br.com.altec.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> { //tipo de atributo da chave primaria

}

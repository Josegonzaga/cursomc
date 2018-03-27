package com.eclodir.cursomc.repositories;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eclodir.cursomc.domain.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	@Transactional(readOnly=true) //Nào necessita de ser envolvida com uma transação de banco de dados
	Cliente findByEmail(String email);

}

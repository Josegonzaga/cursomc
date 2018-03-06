package com.eclodir.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eclodir.cursomc.domain.Cliente;
import com.eclodir.cursomc.repositories.ClienteRepository;
import com.eclodir.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {
		
		Cliente cliente = clienteRepository.findOne(id);
		
		if (cliente == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", referente a classe "+ Cliente.class.getName());
		}
		
		return cliente;
		
	}
	
}

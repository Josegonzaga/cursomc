package com.eclodir.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eclodir.cursomc.domain.Categoria;
import com.eclodir.cursomc.domain.Pedido;
import com.eclodir.cursomc.repositories.PedidoRepository;
import com.eclodir.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", referente a classe "+ Categoria.class.getName());
		}
		
		return obj;
		
	}

}

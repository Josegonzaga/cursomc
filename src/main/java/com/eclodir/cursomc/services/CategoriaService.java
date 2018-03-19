package com.eclodir.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eclodir.cursomc.domain.Categoria;
import com.eclodir.cursomc.repositories.CategoriaRepository;
import com.eclodir.cursomc.services.exceptions.DataIntegrityException;
import com.eclodir.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", referente a classe "+ Categoria.class.getName());
		}
		
		return obj;
		
	}

	public Categoria insert(Categoria obj) {
	
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível excluir categorias que possuem produtos");
		}
		
		
	}

}

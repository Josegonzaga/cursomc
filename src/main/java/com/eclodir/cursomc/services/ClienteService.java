package com.eclodir.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eclodir.cursomc.domain.Cidade;
import com.eclodir.cursomc.domain.Cliente;
import com.eclodir.cursomc.domain.Endereco;
import com.eclodir.cursomc.domain.enums.TipoCliente;
import com.eclodir.cursomc.dto.ClienteDTO;
import com.eclodir.cursomc.dto.ClienteNewDTO;
import com.eclodir.cursomc.repositories.CidadeRepository;
import com.eclodir.cursomc.repositories.ClienteRepository;
import com.eclodir.cursomc.repositories.EnderecoRepository;
import com.eclodir.cursomc.services.exceptions.DataIntegrityException;
import com.eclodir.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Integer id) {
		Cliente cliente = repo.findOne(id);
		if (cliente == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", referente a classe "+ Cliente.class.getName());
		}
		return cliente;
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		repo.save(obj);
		enderecoRepository.save(obj.getEnderecos());
		return obj;
		
	}


	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	
	}

	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), TipoCliente.toEnum(objDTO.getTipo()));
		Cidade cid = cidadeRepository.findOne(objDTO.getCidadeId());
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), cli,cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDTO.getTelefone1());
		if (objDTO.getTelefone2() != null) {
			cli.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			cli.getTelefones().add(objDTO.getTelefone3());
		}
		
		return cli;
	
		
	}
	
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getEmail());
		newObj.setEmail(obj.getEmail());
	}
}

package com.eclodir.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eclodir.cursomc.domain.Pedido;
import com.eclodir.cursomc.services.PedidoService;

@RestController
@RequestMapping (value="/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService service;
	
	@RequestMapping (value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Pedido obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);

	}
	
}
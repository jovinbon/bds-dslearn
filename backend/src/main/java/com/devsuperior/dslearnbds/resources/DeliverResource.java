package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {
	
	@Autowired
	private DeliverService service;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')") // esta anotation pode ser colocada na camada de serviço
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
		service.saveRevision(id, dto);
		return ResponseEntity.noContent().build();
	}

}

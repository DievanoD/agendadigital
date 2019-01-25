package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeRest {

	@Autowired
	private CidadeBusiness business;

	// create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Cidade cidade) {

		try {
			cidade = business.create(cidade);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(cidade);
	}

	// read
	@GetMapping
	public ResponseEntity<?> read() {
		try {
			return ResponseEntity.ok(business.read());
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// read by estado
	@GetMapping("/filtro/estado")
	public ResponseEntity<?> readyByEstado(@PathParam("estado") Estado estado) {
		try {
			List<Cidade> listaRetorno = business.readByEstado(estado);

			if (listaRetorno == null || listaRetorno.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(listaRetorno);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cidade cidade) {

		try {
			cidade = business.update(cidade);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(cidade);
	}

	// delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {
			business.delete(id);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok().build();
	}
}

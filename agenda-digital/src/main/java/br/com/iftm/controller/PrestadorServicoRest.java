package br.com.iftm.controller;

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
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.entity.PrestadorServico;

@RestController
@RequestMapping("/prestadorservico")
public class PrestadorServicoRest {

	@Autowired
	private PrestadorServicoBusiness business;

	// create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody PrestadorServico prestador) {

		try {
			prestador = business.create(prestador);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(prestador);
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
			return ResponseEntity.badRequest().body(e);
		}
	}

	// read by estado
//	@GetMapping("/filtro/servico")
//	public ResponseEntity<?> readyByEstado(@PathParam("servico") PrestadorServico prestador) {
//		return null;
//	}

	// update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico prestador) {
		try {
			prestador = business.update(prestador);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(prestador);
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
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok().build();
	}

}

package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.business.impl.TipoServicoBusinessImpl;
import br.com.iftm.entity.TipoServico;

@RestController // Habilita classe como um serviço rest.
@RequestMapping(value = "/tiposervico") // Nome do Servico.
public class TipoServicoRest {

//	private List<TipoServico> lista = new ArrayList<>();
//	private int indice = 0;

	private TipoServicoBusiness business = new TipoServicoBusinessImpl();

	// create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico) {

		try {
			tipoServico = business.create(tipoServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(tipoServico);
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

	// read by name
	@GetMapping("/filtro/nome")
	public ResponseEntity<?> readyByName(@PathParam("nome") String nome) {
		try {
			List<TipoServico> listaRetorno = business.readByName(nome);

			if (listaRetorno.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(listaRetorno);
			}

		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	// update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico) {

		try {
			tipoServico = business.update(tipoServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}

		return ResponseEntity.ok(tipoServico);
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

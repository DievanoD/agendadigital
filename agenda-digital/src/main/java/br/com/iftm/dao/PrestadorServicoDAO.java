package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico prestador);

	List<PrestadorServico> read();

//	List<PrestadorServico> readByNome(String nome);

	PrestadorServico update(PrestadorServico prestador);

	void delete(Integer id);
}

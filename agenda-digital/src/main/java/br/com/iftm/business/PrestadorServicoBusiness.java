package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoBusiness {

	PrestadorServico create(PrestadorServico prestador) throws BusinessException;

	List<PrestadorServico> read() throws BusinessException;

//	List<PrestadorServico> readBynome(String nome) throws BusinessException;

	PrestadorServico update(PrestadorServico prestador) throws BusinessException;

	void delete(Integer id) throws BusinessException;

	List<PrestadorServico> readByFiltros(FiltroPrestadorDTO FiltroPrestadorDTO) throws BusinessException;
}

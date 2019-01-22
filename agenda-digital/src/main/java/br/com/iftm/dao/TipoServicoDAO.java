package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoDAO {
	
	/**
	 * Metodo responsavel por persistir o objeto {@link TipoServico} na base de dados.
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 */
	TipoServico create(TipoServico tipoServico);
	
	/**
	 * Metodo reponsavel por recuperar da base de dados todos os objeto {@link TipoServico}
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> read();
	
	
	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * @param nome Parte do nome a ser buscado
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> readByName(String name);
	
	/**
	 * Metodo reponsavel por persistir (atualizar) na base de dados o objeto {@link TipoServico}
	 * @param tipoServico objeto a ser persistido
	 * @return Objeto persistido
	 */
	TipoServico update(TipoServico tipoServico);
	
	/**
	 * Metodo responsavel por deletar na base de dados o objeto {@link TipoServico}
	 * @param id Codigo a ser buscado
	 */
	void delete(Integer id);
}

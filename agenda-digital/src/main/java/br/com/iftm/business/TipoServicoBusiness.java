package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoBusiness {

	/**
	 * Metodo responsavel por garantir os parametros obrigatorios, bem como
	 * solicitar a camada dea acesso a dados que persista a Objeto
	 * {@link TipoServico}
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 * @throws BusinessException
	 */
	TipoServico create(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link TipoServico}
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> read() throws BusinessException;

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param name Parte do nome a ser buscado
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> readByName(String name) throws BusinessException;

	/**
	 * Metodo reponsavel por persistir (atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * 
	 * @param tipoServico objeto a ser persistido
	 * @return Objeto persistido
	 * @throws BusinessException
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo responsavel por deletar na base de dados o objeto {@link TipoServico}
	 * 
	 * @param id Codigo a ser buscado
	 * @throws BusinessException
	 */
	void delete(Integer id) throws BusinessException;
}

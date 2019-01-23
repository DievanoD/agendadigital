package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

public interface CidadeBusiness {

	/**
	 * Metodo responsavel por garantir os parametros obrigatorios, bem como
	 * solicitar a camad dea acesso a dados que persista a Objeto {@link Cidade}
	 * 
	 * @param cidade Objeto a ser persistido.
	 * @return Objeto persistido.
	 * @throws BusinessException
	 */
	Cidade create(Cidade cidade) throws BusinessException;

	/**
	 * Metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link Cidade}
	 * 
	 * @return Lista de {@link Cidade}
	 * @throws BusinessException
	 */
	List<Cidade> read() throws BusinessException;

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link Cidade}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome Parte do nome a ser buscado
	 * @return Lista de {@link Cidade}
	 * @throws BusinessException
	 */
	List<Cidade> readByEstado(Estado estado) throws BusinessException;

	/**
	 * Metodo reponsavel por persistir (atualizar) na base de dados o objeto
	 * {@link Cidade}
	 * 
	 * @param cidade Objeto a ser persistido
	 * @return Objeto persistido
	 * @throws BusinessException
	 */
	Cidade update(Cidade cidade) throws BusinessException;

	/**
	 * Metodo responsavel por deletar na base de dados o objeto {@link Cidade}
	 * 
	 * @param id Codigo a ser buscado
	 * @throws BusinessException
	 */
	void delete(Integer id) throws BusinessException;
}

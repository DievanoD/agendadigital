package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

public interface CidadeDAO {
	/**
	 * Metodo responsavel por persistir o objeto {@link Cidade} na base de dados.
	 * 
	 * @param cidade Objeto a ser persistido.
	 * @return Objeto persistido.
	 */
	Cidade create(Cidade cidade);

	/**
	 * Metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link Cidade}
	 * 
	 * @return Lista de {@link Cidade}
	 */
	List<Cidade> read();

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link Cidade}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome Parte do nome a ser buscado
	 * @return Lista de {@link Cidade}
	 */
	List<Cidade> readByEstado(Estado estado);

	/**
	 * Metodo reponsavel por persistir (atualizar) na base de dados o objeto
	 * {@link Cidade}
	 * 
	 * @param cidade Objeto a ser persistido
	 * @return Objeto persistido
	 */
	Cidade update(Cidade cidade);

	/**
	 * Metodo responsavel por deletar na base de dados o objeto {@link Cidade}
	 * 
	 * @param id Codigo a ser buscado
	 */
	void delete(Integer id);
}

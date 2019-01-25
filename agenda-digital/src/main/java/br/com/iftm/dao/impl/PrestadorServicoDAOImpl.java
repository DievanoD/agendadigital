package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private List<PrestadorServico> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public PrestadorServico create(PrestadorServico prestador) {
		sessionFactory.getCurrentSession().save(prestador);
		sessionFactory.getCurrentSession().flush();

		return prestador;
	}

	@Override
	public List<PrestadorServico> read() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);

		return criteria.list();
	}

//	@Override
//	public List<PrestadorServico> readByNome(String nome) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public PrestadorServico update(PrestadorServico prestador) {
		sessionFactory.getCurrentSession().update(prestador);
		sessionFactory.getCurrentSession().flush();

		return prestador;
	}

	@Override
	public void delete(Integer id) {
		PrestadorServico prestador = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);

		sessionFactory.getCurrentSession().delete(prestador);
	}

}

package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
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

	@Override
	public List<PrestadorServico> readByFiltros(FiltroPrestadorDTO filtroPrestadorDTO) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		Criteria criteriaCidade = criteria.createCriteria("cidade");

		if (!StringUtils.isEmpty(filtroPrestadorDTO.getNome())) {
			criteria.add(Restrictions.like("nome", filtroPrestadorDTO.getNome(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (filtroPrestadorDTO.getEstado() != null) {
			criteria.add(Restrictions.eq("estado", filtroPrestadorDTO.getEstado()));
		}

		if (filtroPrestadorDTO.getCidade() != null && filtroPrestadorDTO.getCidade().getCodigo() != null) {
			criteria.add(Restrictions.eq("cidade", filtroPrestadorDTO.getCidade()));
		}

		if (filtroPrestadorDTO.getTiposServicos() != null && filtroPrestadorDTO.getTiposServicos().isEmpty()) {
			criteria.add(Restrictions.in("tipoServicos", filtroPrestadorDTO.getTiposServicos()));
		}

		return criteria.list();
	}

}

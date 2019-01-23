package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.dao.impl.PrestadorServicoDAOImpl;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.TipoServico;

@Service
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	private PrestadorServicoDAO dao = new PrestadorServicoDAOImpl();

	@Override
	public PrestadorServico create(PrestadorServico prestador) throws BusinessException {
		if (StringUtils.isEmpty(prestador.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestador.getCidade() == null || prestador.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido");
		}

		if (prestador.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo Logradouro Requerido");
		}

		if (prestador.getLogradouro() == null || StringUtils.isEmpty(prestador.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido");
		}

		if (prestador.getTelefones() == null || prestador.getTelefones().isEmpty()) {
			throw new BusinessException("Telefone Requerido");
		}

		for (Telefone telefone : prestador.getTelefones()) {
			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD requerido");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero requerido");
			}
		}

		if (prestador.getTipoServicos() == null || prestador.getTipoServicos().isEmpty()) {
			throw new BusinessException("Tipo Servico Requerido");
		}

		for (TipoServico tipoServico : prestador.getTipoServicos()) {
			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Codigo tipo de serviço Requerido");
			}
		}

		return dao.create(prestador);
	}

	@Override
	public List<PrestadorServico> read() throws BusinessException {
		return dao.read();
	}

	@Override
	public PrestadorServico update(PrestadorServico prestador) throws BusinessException {
		if (prestador.getCodigo() == null) {
			throw new BusinessException("Codigo Requerido");
		}

		if (StringUtils.isEmpty(prestador.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestador.getCidade() == null || prestador.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido");
		}

		if (prestador.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo Logradouro Requerido");
		}

		if (prestador.getLogradouro() == null || StringUtils.isEmpty(prestador.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido");
		}

		if (prestador.getTelefones() == null || prestador.getTelefones().isEmpty()) {
			throw new BusinessException("Telefone Requerido");
		}

		for (Telefone telefone : prestador.getTelefones()) {
			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD requerido");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero requerido");
			}
		}

		if (prestador.getTipoServicos() == null || prestador.getTipoServicos().isEmpty()) {
			throw new BusinessException("Tipo Servico Requerido");
		}

		for (TipoServico tipoServico : prestador.getTipoServicos()) {
			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Codigo tipo de serviço Requerido");
			}
		}

		return dao.update(prestador);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Codigo Requerido");
		}

		dao.delete(id);
	}

}

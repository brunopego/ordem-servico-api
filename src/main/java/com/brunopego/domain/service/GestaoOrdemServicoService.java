package com.brunopego.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunopego.domain.model.OrdemServico;
import com.brunopego.domain.model.StatusOrdemServico;
import com.brunopego.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		return ordemServicoRepository.save(ordemServico);
	}
	
}

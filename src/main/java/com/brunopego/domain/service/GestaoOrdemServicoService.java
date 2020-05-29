package com.brunopego.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunopego.domain.exception.NegocioException;
import com.brunopego.domain.model.Cliente;
import com.brunopego.domain.model.OrdemServico;
import com.brunopego.domain.model.StatusOrdemServico;
import com.brunopego.domain.repository.ClienteRepository;
import com.brunopego.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		return ordemServicoRepository.save(ordemServico);
	}
	
}

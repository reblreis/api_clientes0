package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClientePostDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	@PostMapping
	public String post(@RequestBody ClientePostDTO dto) {

		try {
			Cliente cliente = new Cliente();

			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setTelefone(dto.getTelefone());
			cliente.setObservacoes(dto.getObservacoes());
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			return "Cliente cadastrado com sucesso!";
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}

	@PutMapping
	public String put() {
		// TODO
		return null;
	}

	@DeleteMapping
	public String delete() {
		// TODO
		return null;
	}

	@GetMapping
	public String getAll() {
		// TODO
		return null;
	}
}

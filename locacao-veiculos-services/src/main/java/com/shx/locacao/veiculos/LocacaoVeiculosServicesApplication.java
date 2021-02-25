package com.shx.locacao.veiculos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shx.locacao.veiculos.model.AluguelVeiculo;
import com.shx.locacao.veiculos.model.Cliente;
import com.shx.locacao.veiculos.model.Veiculo;
import com.shx.locacao.veiculos.repositories.AluguelRepository;
import com.shx.locacao.veiculos.repositories.ClienteRepository;
import com.shx.locacao.veiculos.repositories.VeiculoRepository;

@SpringBootApplication
public class LocacaoVeiculosServicesApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private AluguelRepository aluguelRepository;

	public static void main(String[] args) {
		SpringApplication.run(LocacaoVeiculosServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Cliente cliente1 = new Cliente("Raul Avezu", "2020-02-15", "987.654.321-00", "Ativo");
//		Cliente cliente2 = new Cliente("Eder Matos", "1954-08-23", "123.456.789-00", "Inativo");
//		Cliente cliente3 = new Cliente("Betinho", "1968-05-10", "105.375.318-74", "Ativo");
//
//		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
//
//		Veiculo veiculo1 = new Veiculo(1, "Chevrolet", "Onix", 2015, "Hatch", "Flex", 40, "Disponivel");
//		Veiculo veiculo2 = new Veiculo(2, "Audi", "A3", 2018, "Sedan", "Gasolina", 70.5, "Disponivel");
//
//		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));
//
//		AluguelVeiculo aluguel1 = new AluguelVeiculo(null, LocalDate.of(2020, 4, 10), cliente1, veiculo1, null,
//				BigDecimal.TEN);
//		AluguelVeiculo aluguel2 = new AluguelVeiculo(null, LocalDate.of(2020, 4, 10), cliente2, veiculo2, null,
//				BigDecimal.TEN);
//
//		aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2));

	}
}

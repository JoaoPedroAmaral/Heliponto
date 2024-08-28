package org.sample.Heliporto.Filtro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.sample.Heliporto.ETLHeliporto.ETLHeliporto;
import org.sample.Heliporto.ImprimirCSV.ImprimirHeliponto;

public class ObterFiltro {
	public static void obterFiltro(int opcao, String arquivo) {
		String input; 
		String caminhoArquivo = arquivo;
		ETLHeliporto etl = new ETLHeliporto();
		ImprimirHeliponto imprimir = new ImprimirHeliponto();
		List<Map<String, String>> dados = ETLHeliporto.extrairDados(caminhoArquivo);
		List<Map<String, String>> dadosFiltrados = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		//faz consulta com o CSV com base na opcao escolhida
		switch (opcao) {
		case 1:
			etl.carregarDados(dados);
			try {
				imprimir.gerarCSV(dados);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.println("Digite a UF por extenso, ex: São Paulo");
			input = scanner.nextLine().toString();
			/*dadosFiltrados = dados.stream()
						.filter(registro->input.equalsIgnoreCase(registro.get("UF")))
						.map(registro->(Map<String, String>)registro)
						.collect(Collectors.toList());Erro no Stream*/
			
			for (Map<String, String>registro : dados) {
				
				if(input.equalsIgnoreCase(registro.get("UF"))) {
					dadosFiltrados.add(registro);
				}
			}
			
			etl.carregarDados(dadosFiltrados);
			try {
				imprimir.gerarCSV(dadosFiltrados);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3: 
			System.out.println("Digite o formato da area, ex: Circular");
			input = scanner.nextLine().toString();
			
			for (Map<String, String>registro : dados) {
				
				if(input.equalsIgnoreCase(registro.get("Formato da Área"))) {
					dadosFiltrados.add(registro);
				}
			}
			
			etl.carregarDados(dadosFiltrados);
			try {
				imprimir.gerarCSV(dadosFiltrados);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4: 
			System.out.println("Digite o tipo da superficie, ex: Grama");
			input = scanner.nextLine().toString();
			
			for (Map<String, String>registro : dados) {
				
				if(input.equalsIgnoreCase(registro.get("Superfície"))) {
					dadosFiltrados.add(registro);
				}
			}
			
			etl.carregarDados(dadosFiltrados);
			try {
				imprimir.gerarCSV(dadosFiltrados);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			throw new IllegalArgumentException("Valor invalido: " + opcao);
		}
		
	}
}

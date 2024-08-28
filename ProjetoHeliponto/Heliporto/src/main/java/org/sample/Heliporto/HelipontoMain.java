package org.sample.Heliporto;

import java.nio.file.Paths;
import java.util.Scanner;

import org.sample.Heliporto.Filtro.ObterFiltro;


//Heliportos tirado do gov.br
public class HelipontoMain {

	public static void main(String[] args) {
        String arquivo = Paths.get("src/main/java/org/sample/Heliporto/CSV/helipontosDados.csv").toAbsolutePath().toString();
		Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;

        System.out.println("Bem vindo! Por favor selecione uma opção");
        System.out.println("1. Exibir toda a tabela");
        System.out.println("2. Filtrar tabela por UF");
        System.out.println("3. Filtrar tabela por Formato de área");
        System.out.println("4. Filtrar tabela por Superficie");
        System.out.println("0. Sair");

        opcao = Integer.parseInt(scanner.nextLine());

        while (opcao != 0) {
            try {
                ObterFiltro.obterFiltro(opcao, arquivo);

                // Reexibe o menu após cada operação
                System.out.println("\nPor favor selecione uma opção");
                System.out.println("1. Exibir toda a tabela");
                System.out.println("2. Filtrar tabela por UF");
                System.out.println("3. Filtrar tabela por Formato de área");
                System.out.println("4. Filtrar tabela por Superficie");
                System.out.println("0. Sair\n");
                
                opcao = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Eu pedi com carinho;");}

        }
        System.out.println("saindo");
    }
}

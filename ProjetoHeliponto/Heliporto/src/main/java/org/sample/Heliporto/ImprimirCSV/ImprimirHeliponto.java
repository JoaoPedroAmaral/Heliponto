package org.sample.Heliporto.ImprimirCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.sample.Heliporto.ETLHeliporto.ETLHeliporto;


public class ImprimirHeliponto {
	
    	public void gerarCSV(List<Map<String, String>> dados) throws IOException {
		
    		System.out.println("Deseja salvar pesquisa em CSV?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            int salvarCsv = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

            if (salvarCsv == 1) {
                // Define the output file path
        		String caminhoArquivoSaida = "src/main/java/org/sample/Heliporto/CSV/heliportos_saida.csv";

                // Create a FileWriter object for the output file
                FileWriter writer = new FileWriter(caminhoArquivoSaida);
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Nome", "UF", "Latitude", "Longitude", "Formato da Área de Pouso", "Superfície")
                        .withDelimiter(';')); // Adjust the delimiter if needed

               
                // Write each data record to the CSV file
                for (Map<String, String> registro : dados) {
                    List<String> dataRecord = new ArrayList<>();
                    dataRecord.add(registro.get("Nome"));
                    dataRecord.add(registro.get("UF"));
                    dataRecord.add(registro.get("Latitude"));
                    dataRecord.add(registro.get("Longitude"));
                    dataRecord.add(registro.get("Formato da Área"));
                    dataRecord.add(registro.get("Superfície"));
                    printer.printRecord(dataRecord);
                }

                // Flush and close the printer
                printer.flush();
                printer.close();

                System.out.println("Dados de heliportos gravados com sucesso no arquivo: " + caminhoArquivoSaida);
            }
 
    }
}


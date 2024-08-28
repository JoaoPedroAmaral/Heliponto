package org.sample.Heliporto.ETLHeliporto;


import java.io.IOException;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;


public class ETLHeliporto {
	
	public static List<Map<String, String>> extrairDados(String caminhoArquivo) {
        List<Map<String, String>> dados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); //pular linha
            br.readLine();
            CSVParser parser = new CSVParser(br, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim()
                    .withDelimiter(';')//delimitadores
            );
            
        	Map<String, String> columnMapping = new HashMap<>();
            columnMapping.put("Nome", "Nome");
            columnMapping.put("UF", "UF");
            columnMapping.put("Latitude", "Latitude");
            columnMapping.put("Longitude", "Longitude");
            columnMapping.put("Formato da Área", "Formato da Área de Pouso");
            columnMapping.put("Superfície", "Superfície");

            for (CSVRecord record : parser) {
                Map<String, String> registro = new HashMap<>();

                for (Map.Entry<String, String> entry : columnMapping.entrySet()) {
                    String desiredColumn = entry.getKey();
                    String actualColumn = entry.getValue();
                    try {
                        registro.put(desiredColumn, record.get(actualColumn));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Coluna '" + desiredColumn + "' não encontrada.");
                    }
                }

                dados.add(registro);
            }
        	
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dados;
    }

    public void carregarDados(List<Map<String, String>> dados) {
        for (Map<String, String> registro : dados) {
            System.out.println("Nome: " + registro.get("Nome"));
            System.out.println("Latitude: " + registro.get("Latitude"));
            System.out.println("Longitude: " + registro.get("Longitude"));
            System.out.println("UF: " + registro.get("UF"));
            System.out.println("Formato da Área: " + registro.get("Formato da Área"));
            System.out.println("Superfície: " + registro.get("Superfície"));
            System.out.println("---------------------------------------");
        }
    	
    }
}

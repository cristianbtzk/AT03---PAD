package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ServicoBusca {
	Semaphore s = new Semaphore(2);

	public void buscar(String nomeArquivo, String termoBusca) {
		try {
			s.acquire();
			System.out.println("##########################################");
			System.out.println("Iniciando busca no arquivo " + nomeArquivo);
			System.out.println("##########################################");
			BufferedReader br = new BufferedReader(new FileReader("src/main/" + nomeArquivo));

			String line = br.readLine();

			while (line != null) {
				if (line.regionMatches(true, 0, termoBusca, 0, termoBusca.length())) {
					System.out.println(line + " - Arquivo: " + nomeArquivo);
				}
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("##########################################");
			System.out.println("Finalizando busca no arquivo " + nomeArquivo);
			System.out.println("##########################################");
			s.release();
		}
	}
}

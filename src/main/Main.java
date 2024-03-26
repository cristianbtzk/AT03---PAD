package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] arquivos = {"nomescompletos-00.txt", "nomescompletos-01.txt",
				"nomescompletos-02.txt", "nomescompletos-03.txt",
				"nomescompletos-04.txt", "nomescompletos-05.txt",
				"nomescompletos-06.txt", "nomescompletos-07.txt",
				"nomescompletos-08.txt", "nomescompletos-09.txt",
		};
		
		ServicoBusca sb = new ServicoBusca();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Termo para busca: ");
		String termo = s.next();
		s.close();
		
		for(String nomeArquivo : arquivos) {
			Thread t = new Thread(new Busca(nomeArquivo, termo, sb));
			t.start();
		}
	}
}

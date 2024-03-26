package main;

public class Busca implements Runnable {
	String nomeArquivo;
	String termoBusca;
	ServicoBusca sb;

	public Busca(String nomeArquivo, String termoBusca, ServicoBusca sb) {
		this.nomeArquivo = nomeArquivo;
		this.termoBusca = termoBusca;
		this.sb = sb;
	}

	@Override
	public void run() {
		sb.buscar(nomeArquivo, termoBusca);
	}
}

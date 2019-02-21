package ufc.br.great.pc.banheiro.controle;

public class TarefaUsarBanheiroRapido implements Runnable {

	private Banheiro banheiro;
		
	public TarefaUsarBanheiroRapido(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero1();
	}

}

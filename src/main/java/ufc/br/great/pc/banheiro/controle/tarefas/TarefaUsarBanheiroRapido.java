package ufc.br.great.pc.banheiro.controle.tarefas;

import ufc.br.great.pc.banheiro.controle.recursos.Banheiro;

public class TarefaUsarBanheiroRapido implements Runnable {

	private Banheiro banheiro;
		
	public TarefaUsarBanheiroRapido(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero1(2000);
	}

}

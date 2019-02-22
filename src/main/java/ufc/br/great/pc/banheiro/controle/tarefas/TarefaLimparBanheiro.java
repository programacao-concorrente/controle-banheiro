package ufc.br.great.pc.banheiro.controle.tarefas;

import ufc.br.great.pc.banheiro.controle.recursos.Banheiro;

public class TarefaLimparBanheiro implements Runnable {

	private Banheiro banheiro;
	
	public TarefaLimparBanheiro(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		while (true) {
			this.banheiro.limpa();
		}
	}

}

package ufc.br.great.pc.banheiro.controle.tarefas;

import ufc.br.great.pc.banheiro.controle.recursos.Banheiro;

public class TarefaUsarBanheiroDemorado implements Runnable {

	private Banheiro banheiro;
		
	public TarefaUsarBanheiroDemorado(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero2(4000);
	}

}

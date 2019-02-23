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
			
			try {
                Thread.sleep(5000);//limpando cada 5s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}

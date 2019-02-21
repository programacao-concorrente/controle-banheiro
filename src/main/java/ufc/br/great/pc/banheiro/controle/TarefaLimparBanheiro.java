package ufc.br.great.pc.banheiro.controle;

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
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

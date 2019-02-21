package ufc.br.great.pc.banheiro.controle;

public class TarefaUsarBanheiroDemorado implements Runnable {

	private Banheiro banheiro;
		
	public TarefaUsarBanheiroDemorado(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero2();
	}

}

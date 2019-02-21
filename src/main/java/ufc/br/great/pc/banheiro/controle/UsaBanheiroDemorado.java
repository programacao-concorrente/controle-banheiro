package ufc.br.great.pc.banheiro.controle;

public class UsaBanheiroDemorado implements Runnable {

	private Banheiro banheiro;
		
	public UsaBanheiroDemorado(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero2();
	}

}

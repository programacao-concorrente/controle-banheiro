package ufc.br.great.pc.banheiro.controle;

public class UsaBanheiroRapido implements Runnable {

	private Banheiro banheiro;
		
	public UsaBanheiroRapido(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.fazNumero1();
	}

}

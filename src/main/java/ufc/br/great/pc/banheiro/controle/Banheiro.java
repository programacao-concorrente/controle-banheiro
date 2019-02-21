package ufc.br.great.pc.banheiro.controle;

public class Banheiro {
	
	private boolean ehSujo=true;
	
	/**
	 * Interrompe a thread até que o problema seja resolvido
	 * @param nome
	 */
	private void esperaLaFora(String nome) {

	    System.out.println(nome + ", eca, banheiro está sujo");
	    try {
	        this.wait();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Mostra uma barra de progresso enquanto a ação é executada
	 * @param total
	 */
	private void barraDeProgresso(float total){		
		
		ExtendedASCII eASCII = new ExtendedASCII();
		String barra = "";
		
		for(float i=1; i < total+1; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			char quadrado = eASCII.getAscii(218);
			barra = barra + quadrado; 
			float x = (i/total) * 100;
			String numero = String.format("%.2f", x); 
			if (x < 90) {
				System.out.print(barra + numero + "% \r");
			}else {
				System.out.print("\r"+ barra + numero + "%");
			}
		}
		System.out.println("\n");
		
	}

	
	/**
	 * Limpa o banheiro e notifica todas as threads, desse objeto, para acordarem
	 */
	public void limpa() {
		String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");

	        if (!this.ehSujo) {
	            System.out.println(nome + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(nome + " limpando o banheiro");
	        this.ehSujo = false;

	        this.barraDeProgresso(10);
	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
	    }
	}
		
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " Batendo na porta...");
		
		synchronized(this) {			
			while (this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
	        System.out.println(nome + " fazendo coisa rapida");
	        
	        try {
	        	//mostra barra de progresso
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        this.ehSujo = true;
	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");			
		}
	}
	
	public void fazNumero2() {		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " Batendo na porta...");
		
		synchronized(this) {			

			while (this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");
			
	        try {
	        	//mostra barra de progresso
				Thread.sleep(12000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        this.ehSujo = true;
	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");			
		}
	}

}
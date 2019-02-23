package ufc.br.great.pc.banheiro.controle.recursos;

import ufc.br.great.pc.banheiro.controle.util.BarraProgresso;

/**
 * Objeto que será compartilhado entre as tarefas do projeto
 * @author armandosoaressousa
 *
 */
public class Banheiro {
	private boolean ehSujo=true;
	
	/**
	 * Interrompe a thread até que o problema seja resolvido
	 * @param nome
	 */
	private void esperaLaFora(String nome) {
	    System.out.println(nome + ", eca, banheiro está sujo");
	    try {
	        this.wait(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Acao de limpar o banheiro: Limpa o banheiro e notifica todas as threads, desse objeto, para acordarem
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
	        this.notifyAll();	        
	        System.out.println(nome + " saindo do banheiro");
	        
	        this.ehSujo = false;
	    }
	}
		
	/**
	 * Usando o banheiro na acao numero 1
	 */
	public void fazNumero1(long tempo) {
		String nome = Thread.currentThread().getName();
		BarraProgresso barra = new BarraProgresso();
		int tempoI  = (int) tempo;
		
		System.out.println(nome + " Batendo na porta...");
		
		synchronized(this) {	
			
			while (this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
	        System.out.println(nome + " fazendo coisa rapida");	   	       	        
	        
	        barra.mostraBarraDeProgressoMultiploDe10(tempoI/1000);	        	        
	        
	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");	
	        
	        this.ehSujo = true;
		}
	}
	
	/**
	 * Usando o banheiro na acao numero 2
	 */
	public void fazNumero2(long tempo) {		
		String nome = Thread.currentThread().getName();
		BarraProgresso barra = new BarraProgresso();
		int tempoI = (int) tempo;
		
		System.out.println(nome + " Batendo na porta...");
		
		synchronized(this) {			

			while (this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");			
	        	        
	        barra.mostraBarraDeProgressoMultiploDe10(tempoI/1000);
	        	        
	        System.out.println(nome + " dando descarga");
	        System.out.println(nome + " lavando a mao");
	        System.out.println(nome + " saindo do banheiro");
	        
	        this.ehSujo = true;
		}
	}

}
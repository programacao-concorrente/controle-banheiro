package ufc.br.great.pc.banheiro.controle.tarefas;

import ufc.br.great.pc.banheiro.controle.util.BarraProgresso;

public class TarefaMostrarProgresso implements Runnable {
	private BarraProgresso barra;
	private float tempo; 
	
	public TarefaMostrarProgresso(BarraProgresso barra, float tempo) {
		this.barra = barra;
		this.tempo = tempo;
	}	
	
	@Override
	public void run() {
		barra.mostraBarraDeProgresso(tempo);		
	}

}

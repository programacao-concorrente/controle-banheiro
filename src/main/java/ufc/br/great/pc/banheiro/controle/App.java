package ufc.br.great.pc.banheiro.controle;

import ufc.br.great.pc.banheiro.controle.recursos.Banheiro;
import ufc.br.great.pc.banheiro.controle.tarefas.TarefaLimparBanheiro;
import ufc.br.great.pc.banheiro.controle.tarefas.TarefaUsarBanheiroDemorado;
import ufc.br.great.pc.banheiro.controle.tarefas.TarefaUsarBanheiroRapido;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Controle de entrada e limpeza do banheiro - convidados: Joao, Maria e Francisco" + "\n");
        
        //Recurso que sera compartilhado
		Banheiro banheiro = new Banheiro();
		
		//Threads que vao executar as tarefas sobre o recurso compartilhado
		Thread convidado1 = new Thread(new TarefaUsarBanheiroRapido(banheiro), "Joao");
		Thread convidado2 = new Thread(new TarefaUsarBanheiroDemorado(banheiro), "Maria");
		Thread convidado3 = new Thread(new TarefaUsarBanheiroDemorado(banheiro), "Francisco");
		Thread limpeza = new Thread(new TarefaLimparBanheiro(banheiro), "Limpeza");
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
		
		limpeza.setDaemon(true);
		limpeza.start();
    }
}

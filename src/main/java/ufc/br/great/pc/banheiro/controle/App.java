package ufc.br.great.pc.banheiro.controle;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Controle de entrada e limpeza do banheiro - convidados: Joao, Maria e Ana" );
        
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaUsarBanheiroRapido(banheiro), "Joao");
		Thread convidado2 = new Thread(new TarefaUsarBanheiroDemorado(banheiro), "Maria");
		Thread convidado3 = new Thread(new TarefaUsarBanheiroRapido(banheiro), "Ana");
		Thread limpeza = new Thread(new TarefaLimparBanheiro(banheiro), "Limpeza");
		
		limpeza.setDaemon(true);
		limpeza.start();
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
    }
}

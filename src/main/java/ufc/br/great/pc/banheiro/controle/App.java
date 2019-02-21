package ufc.br.great.pc.banheiro.controle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Controle de entrada e limpeza do banheiro:" );
        
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new UsaBanheiroRapido(banheiro), "Joao");
		Thread convidado2 = new Thread(new UsaBanheiroDemorado(banheiro), "Maria");
		Thread convidado3 = new Thread(new UsaBanheiroRapido(banheiro), "Ana");
		Thread limpeza = new Thread(new TarefaLimparBanheiro(banheiro), "Limpeza");
		
		limpeza.setDaemon(true);
		limpeza.start();
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
    }
}

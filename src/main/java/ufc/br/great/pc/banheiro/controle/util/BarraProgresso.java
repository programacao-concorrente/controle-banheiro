package ufc.br.great.pc.banheiro.controle.util;

public class BarraProgresso {

	/**
	 * Mostra uma barra de progresso enquanto a ação é executada
	 * @param total - tempo em segundos
	 */
	public synchronized void mostraBarraDeProgresso(float total){		
		
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
			
			if (x < 100) {
				System.out.print(barra + numero + "% \r");
			}else {
				System.out.print("\r"+ barra + numero + "%");
			}
		}
		System.out.println("\n");		
	}
	
}

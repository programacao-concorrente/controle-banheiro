package ufc.br.great.pc.banheiro.controle.util;

public class BarraProgresso {
	private ExtendedASCII eASCII = new ExtendedASCII();
	private char quadrado = eASCII.getAscii(218);
	
	/**
	 * Mostra uma barra de progresso enquanto a ação é executada
	 * @param total - tempo em segundos
	 */
	public synchronized void mostraBarraDeProgresso(float total){				
		String barra = "";
		
		for(float i=1; i < total+1; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}					
			
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

	public synchronized void mostraBarraDeProgressoSimplificada(float total){				
		
		for(float i=1; i < total+1; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}					
					
			float x = (i/total) * 100;			
			String numero = String.format("%.2f", x); 
			
			if (x < 100) {
				System.out.print(numero + "% \r");
			}else {
				System.out.print("\r"+numero + "%");
			}
		}
		System.out.println("\n");		
	}
	
	public synchronized void mostraBarraDeProgressoMultiploDe10(int tempo) {
		int qtdQuadrados = 10/tempo;
		String barra="";
		String barra1="";
		String novaBarra = "";
		float percentual;
		
		//define a quantidade de quadrados a preencher na barra
		for (int i=0; i < qtdQuadrados; i++) {
			barra = barra + quadrado;
		}
		barra1 = barra;
				
		//imprime as barras e percentual de progresso
		for (int i=0; i < 10; i = i + qtdQuadrados) {
			novaBarra = novaBarra + barra1;			

			if (i==0) {
				percentual = qtdQuadrados*10;
			}else {
				if (qtdQuadrados == 5) {
					percentual = 2*i*10;
				}else {
					if (qtdQuadrados == 2) {
						percentual = (i+2)*10;
					}else {
						percentual = (i+1)*10;
					}
				}
			}
			
			String numero = String.format("%.2f", percentual);
			
			if (percentual < 100) {
				System.out.print(novaBarra + numero + "% \r");
			}else {
				System.out.print("\r"+ novaBarra + numero + "%");
			}
		
			try {
				Thread.sleep(qtdQuadrados * 1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
						
			
		}
	}
	
	public synchronized void mostraBarraDeProgressoProporcionalAoTempo(float tempo) {
		float tempoIncremento;
		String barra="";
		int tempoI;
		
		tempoIncremento = tempo / 10;
		tempoI = (int) tempoIncremento;
		
		for (int i=0; i < tempo; i++) {
			try {
				Thread.sleep(tempoI * 100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			barra = barra + quadrado;
			float percentual = (i+1)*tempoIncremento * 10;
			String numero = String.format("%.2f", percentual);
			System.out.print(barra + numero + "% \r");
		}
	}
	
}
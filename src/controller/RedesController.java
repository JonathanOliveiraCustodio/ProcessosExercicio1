package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		super();
		
	}
	
	/**
		 * 1° Método que retorna o Nome do Sistema Operacional
		 * @
		 */
		public String osName() {
			String os = System.getProperty("os.name");
			return os;
		}
		
		public void ListaAdaptadorIPv4() {
			String comando="";
			if (System.getProperty("os.name").contains("Windows")) {			
				comando = "ipconfig";	
			} else {			
				comando = ("ifconfig");
			}		
			try {
				Process processo = Runtime.getRuntime().exec(comando.toString());
				InputStream fluxo = processo.getInputStream();
				InputStreamReader LerFluxo = new InputStreamReader(fluxo);
				BufferedReader bufferLeitura = new BufferedReader(LerFluxo);
				String linha = bufferLeitura.readLine();

				while (linha != null) {
					// Imprimi apenas Adaptadores IPv4
					if (linha.contains("IPv4")) {	
					System.out.println(linha);
					}
					
					linha = bufferLeitura.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
				try {  
				      Process p = Runtime.getRuntime().exec("ps ax"); //aqui fica o comando que vai pegar os processos  
				  
				      BufferedReader resultado = new BufferedReader(new InputStreamReader(p.getInputStream()));  
				  
				      //mostra os resultados obtidos pelo comando 'ps ax'  
				      String s;  
				      while ((s = resultado.readLine()) != null)  
				        System.out.println(s);  
				    } catch (Exception ex) {  
				      ex.printStackTrace();  
				    }  
			}
			}
			
			public void ListaPing() {
				String comando="";
				if (System.getProperty("os.name").contains("Windows")) {			
					comando = "PING -4 -n 10 www.google.com.br";	
				} else {			
					comando = ("PING -4 -c 10 www.google.com.br ");
				}		
				try {
					Process processo = Runtime.getRuntime().exec(comando.toString());
					InputStream fluxo = processo.getInputStream();
					InputStreamReader LerFluxo = new InputStreamReader(fluxo);
					BufferedReader bufferLeitura = new BufferedReader(LerFluxo);
					String linha = bufferLeitura.readLine();
					int cont=0;
					while (linha != null) {
						;
						
						String[] tempomedio= linha.split(" ",6);
						System.out.println(tempomedio[cont]);
						
						//System.out.println(linha);	
						
						linha = bufferLeitura.readLine();
						cont=cont+1;
					}

				} catch (IOException e) {
					e.printStackTrace();
					try {  
					      Process p = Runtime.getRuntime().exec("ps ax"); //aqui fica o comando que vai pegar os processos  
					  
					      BufferedReader resultado = new BufferedReader(new InputStreamReader(p.getInputStream()));  
					  
					      //mostra os resultados obtidos pelo comando 'ps ax'  
					      String s;  
					      while ((s = resultado.readLine()) != null)  
					        System.out.println(s);  
					    } catch (Exception ex) {  
					      ex.printStackTrace();  
					    }  

				}
		}

}

package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
	 int opc =0;
       RedesController Operacoes = new RedesController();
		
		// 1° Chamado Identifica o SO
		String os = Operacoes.osName();
		System.out.println(os);
		
		while (opc!=9){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null," 1 - Método Lista Adaptador IPv4.\n "
            		+ "2 - Método Lista PING.\n 9 - Finalizar.","Opções - SO " + os,JOptionPane.PLAIN_MESSAGE));
            switch (opc){
                case 1 : 
                   Operacoes.ListaAdaptadorIPv4();
                   System.out.println ("Método Lista Adapatador IPv4.\n");
                break;
                case 2 :
                	System.out.println ("Método Lista PING.\n");
                	Operacoes.ListaPing();
                break;
                case 3 : 
                   
                break;    
            }
        }
		
	}

}

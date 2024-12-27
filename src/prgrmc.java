/*
 * chiffre.class
 * 
 * Copyright 2024 user <user@DSNPRET-28>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prgrmc {
	
	public static void main (String[] args) {
		int a;
		int []T=new int [100];
		int i;
		int b;
		int e;
		int j;
	
		char op;
		int min = 101;
		int max = 999;
		

  // Créer une instance de JFrame
        JFrame frame = new JFrame("joueur 1");
        
        // Définir la taille de la fenêtre
        frame.setSize(1000, 800);
        //def ou se situe la fenetre 
        frame.setLocation(400, 300);
        
        // Spécifier l'opération de fermeture (fermer l'application quand on clique sur "X")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //afficher un premier message sur la fenêtre 
        JLabel titre = new JLabel("Bienvenue dans 'Des chiffres et des lettres' ");
        titre.setBounds(150, 10, 400, 30);
        frame.add(titre);
        

		
		//on génère aléatoirement le nombre à atteindre a = min + (int) 
		a = min + (int) (Math.random() * (max - min + 1)); 
		JLabel cible = new JLabel("le nombre à atteindre est "+a);
		cible.setBounds(50, 50, 400, 30);
		frame.add(cible);
		
		
		JLabel message = new JLabel(" ");
		message.setBounds(50, 450, 400, 30);
		frame.add(message);
            
		int min2=1;
		int max2=25;
		
		
		//on génère les six valeurs aléatoires utilisable par le joueur
		JLabel utilisable = new JLabel("Les nombres utilisables : ");
        utilisable.setBounds(50, 100, 400, 30);
        frame.add(utilisable);
		T[0] = 1 + (int)(Math.random() * 10);
		for (i=1; i<5; i++){
			b= min2 + (int) (Math.random() * (max2 - min2 + 1));
			//on vérifie que les valeurs soient toutes différentes 
			for (j=0; j<i; j++){
				if (b==T[j]){
					b= min2 + (int) (Math.random() * (max2 - min2 + 1));
					j = j-1;
				}
			}
			T[i]=b;
			max2 = max2 + 25;
			JLabel nombres = new JLabel(String.valueOf(b));
                nombres.setBounds(250 + i * 30, 100, 100, 30); // on affiche les nombres sur la même ligne 
                frame.add(nombres);
                frame.revalidate();
                frame.repaint();
                
		}
		   JTextField nombre1 = new JTextField();// zone de saisie du premier nombre 
        nombre1.setBounds(100, 175, 50, 30);
        frame.add(nombre1);
        JLabel affiche1 = new JLabel("entrez le premier nombre"); // texte associé 
		affiche1.setBounds(50, 150, 200, 30);
		frame.add(affiche1);
        
        JTextField nombre2 = new JTextField(); // zone de saisie du deuxième nombre 
        nombre2.setBounds(300, 175, 50, 30);
        frame.add(nombre2);
        JLabel affiche2 = new JLabel("entrez le deuxieme nombre"); // texte associé 
		affiche2.setBounds(250, 150, 200, 30);
		frame.add(affiche2);
		
		JTextField operation = new JTextField(); // zone de saisie de l'operation 
        operation.setBounds(175, 175, 50, 30);
        frame.add(operation);
		
		JButton egal = new JButton("calculer");
        egal.setBounds(400, 175, 100, 20);
        frame.add(egal);

		// Rendre la fenêtre visible
		frame.setVisible(true);
        
		/*int duree = 30; // Durée du timer en secondes
        long fin = System.currentTimeMillis() + (duree * 1000); // Temps de fin
		JLabel txt = new JLabel("le jeu commence. tu a " + duree + " secondes. pour te rapprocher le plus possible de "+a+" avec les nombres utilisabes");;
		txt.setBounds(50, 80, 800, 30);
		frame.add(txt);
        */
		
        //while (System.currentTimeMillis() < fin) {
			

		egal.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
                if (e.getSource() == egal){
						int m=0;
						int k=0;
						int nf=0;						
						int nb;
					
					 String texte1 = nombre1.getText();
					 int nb1 = Integer.parseInt(texte1);
					 while (nb1 != T[m] && m <6){
						m = m+1;
					
					if (m==6){
					message.setText("vous devez entrer une valeur du tableau pour nb1");
					}
					else{
					 String texte2 = nombre2.getText();
					 int nb2 = Integer.parseInt(texte2);
					 while (nb1 != T[m] && m <6){
					 k = k+1;
					}
					 if (k==6){
					 message.setText("vous devez entrer une valeur du tableau pour nb2");
					}
					else {
						String operation = egal.getText();
						char op = operation.charAt(0);
						if (op == '+'){
						nb = nb1 + nb2;
						T[k]=0;
						T[m]=nb;
					}
					else if (op == '-'){
						nb = nb1 - nb2;
						T[k]=0;
						T[m]=nb;
					}
					else if (op == '*'){
						nb = nb1 * nb2;
						T[k]=0;
						T[m]=nb;
					}
					else if (op == '/'){
						nb = nb1 / nb2;
						T[k]=0;
						T[m]=nb;
					}
					else{
						message.setText("vous devez entrer une operation valide");
						
					}
					int s = 0; // Initialisation de s
					 for (int idx = 0; idx < 5; idx++) { // idx remplace le conflit "e"
                        s += T[idx];
                        
                    }
					int y = 0;
					JLabel nvnombres = new JLabel(String.valueOf(s));
					nvnombres.setBounds(250 + y * 30, 300, 100, 30); // on affiche les nombres sur la même ligne 
					frame.add(nvnombres);
					frame.revalidate();
					frame.repaint();
			
		
					
					
				}	
					}
			
		}
		
		
		
	}
	
            
           
			};
		});

	
//}
}
}






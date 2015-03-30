import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Fereastra {
	static JTextArea textArea;
	static ColectieFilme f= new ColectieFilme();
 public static void main(String [] args){
	 	 	 
	 JFrame frame = new JFrame("Tema");
	 frame.setSize(1000, 500);
	 frame.setLayout(null);
	 


	 
	  textArea=new JTextArea();
	// textArea.setText(f.toString());
		 JButton btnFilme = new JButton("Filme");
		 btnFilme.setBounds(550, 11, 69, 24);
		 frame.add(btnFilme);
			btnFilme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//JOptionPane.showMessageDialog(null,f.toString());
					textArea.setText(f.toString());
				}
			});
			
	 JScrollPane scroll=new JScrollPane(textArea);
	 scroll.setBounds(5,5,800,300);
	  
	 frame.add(scroll);
	 frame.setVisible(true);
	 frame.setLocationRelativeTo(null);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}

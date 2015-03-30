import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Fereastra {
	static JTextArea textArea;
	static JFrame sterg = new JFrame("Date");
	static ColectieFilme f= new ColectieFilme();
 public static void main(String [] args){
	 	 	 
	 JFrame frame = new JFrame("Tema");
	 frame.setSize(1200, 500);
	 frame.setLayout(null);
	 


	 
	  textArea=new JTextArea();
	  textArea.setEditable(false);
	// textArea.setText(f.toString());
		 JButton btnFilme = new JButton("Filme");
		 btnFilme.setBounds(850, 11, 150, 24);
		 frame.add(btnFilme);
			btnFilme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//JOptionPane.showMessageDialog(null,f.toString());
					textArea.setText(f.toString());
				}
			});
	
	JButton sort=new JButton("Sorteaza");
	sort.setBounds(850,71,150,24);
	frame.add(sort);
	sort.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			f.sortareDupaNota();
			textArea.setText(f.toString());
			f=new ColectieFilme();
		}
	});
			
	JButton stergeFilm=new JButton("Sterge");
	stergeFilm.setBounds(850,101,150,24);
	frame.add(stergeFilm);
	stergeFilm.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			 
			 sterg.setSize(200, 100);
			 sterg.setLayout(new FlowLayout());
			
			 sterg.setLocationRelativeTo(null);
			 sterg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 JLabel label=new JLabel();
			 label.setText("Nume Film");
			 label.setLocation(10,10);
			 sterg.add(label);
			 
			 
			JTextArea textFilm=new JTextArea(1,10);
			 textFilm.setEditable(true);
			 
			 sterg.add(textFilm);
			 sterg.setVisible(true);
			 
			 JButton filmDeSters=new JButton("Sterge");
			 filmDeSters.setBounds(20,20,30,24);
			 filmDeSters.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String nume;
					try {
						nume=textFilm.getText();
						f.stergeFilm(nume);
						JOptionPane.showMessageDialog(null, "Film Sters cu succes");
						sterg.dispose();
					}
					catch (Exception e1){
						
					}
				}
			 });
			 sterg.add(filmDeSters);
			 
			 //sterg.dispose();
			//JOptionPane.showMessageDialog(null, "Film Sters cu succes");
		}
	});
	 JButton curata =new JButton("Clean");
	 curata.setBounds(850,41,150,24);
	 frame.add(curata);
	 curata.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e){
			 textArea.setText("");
			 
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

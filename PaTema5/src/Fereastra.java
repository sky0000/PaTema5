import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


public class Fereastra {
	static JTextArea textArea;
	 private static boolean useSystemLookAndFeel = false;
	    private JTree tree;
	    private JEditorPane Panel;
	    
	static ColectieFilme f= new ColectieFilme();
 public static void main(String [] args){
	 	 	 
	 JFrame frame = new JFrame("Tema");
	 frame.setSize(1200, 500);
	 frame.setLayout(null);
	 


	 
	  textArea=new JTextArea();
	  textArea.setEditable(false);
	  textArea.setFont(new Font("Consolas",Font.BOLD,10));
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
			JFrame sterg = new JFrame("Date");
			 sterg.setSize(200, 100);
			 sterg.setLayout(new FlowLayout());
			
			 sterg.setLocationRelativeTo(null);
			 sterg.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			 
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
					String nume;int ok;
					try { 
						
						nume=textFilm.getText();
						ok=f.existaFilm(nume);
						if (ok==1)
						{
						f.stergeFilm(nume);
						JOptionPane.showMessageDialog(null, "Film Sters cu succes");
						sterg.dispose();
					}
						else JOptionPane.showMessageDialog(null, "Film inexistent!Bye Bye");
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
	
	JButton adauga =new JButton("Adauga");
	adauga.setBounds(850, 131, 150, 24);
	frame.add(adauga);
	
	adauga.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JFrame adaug = new JFrame("Date");
			 adaug.setSize(100, 300);
			 adaug.setLayout(new FlowLayout());
			
			 adaug.setLocationRelativeTo(null);
			 adaug.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			 
			 JLabel label=new JLabel();
			 label.setText("Nume Film");
			 label.setLocation(10,10);
			 
			 
			 
			JTextArea textFilm=new JTextArea(1,10);
			 textFilm.setEditable(true);
			 
			 JLabel categorie=new JLabel();
			 categorie.setText("Categorie");
			 categorie.setLocation(10,10);
			 
			 
			 
			JTextArea categorieF=new JTextArea(1,10);
			 categorieF.setEditable(true);
			 
			 JLabel gen=new JLabel();
			 gen.setText("Gen");
			 gen.setLocation(10,10);
			 
			 
			 
			JTextArea genF=new JTextArea(1,10);
			 genF.setEditable(true);
			 
			 JLabel dataL=new JLabel();
			 dataL.setText("Data lansarii");
			 dataL.setLocation(10,10);
			
			 
			 
			JTextArea dataLansare=new JTextArea(1,10);
			 dataLansare.setEditable(true);
			 
			 JLabel nota=new JLabel();
			 nota.setText("Nota");
			 nota.setLocation(10,10);
			 
			 
			 
			JTextArea notaF=new JTextArea(1,10);
			 notaF.setEditable(true);
			 
			 
			 JLabel id=new JLabel();
			 id.setText("Id IMDB");
			 id.setLocation(10,10);
			 
			 
			 
			JTextArea idF=new JTextArea(1,10);
			 idF.setEditable(true);
			 
			
			 
			 
			 JButton add=new JButton("Adauga");
			 add.setBounds(20,20,30,24);
			 adaug.add(label);
			 adaug.add(textFilm);
			 adaug.add(gen);
			 adaug.add(genF);
			 adaug.add(dataL);
			 adaug.add(dataLansare);
			 adaug.add(nota);
			 adaug.add(notaF);			
			 adaug.add(id);
			 adaug.add(idF);
			 adaug.add(categorie);
			 adaug.add(categorieF);
			 adaug.add(add);
			  
			 add.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String nume,data,gen,id,categorie;
					double nota;
					nume=textFilm.getText();

					data=dataLansare.getText();
					gen=genF.getText();
					id=idF.getText();
					categorie=categorieF.getText();
					try{
					nota=Double.parseDouble(notaF.getText());
					f.adaugaFilm(nume, categorie, data, nota, id, gen);
					adaug.dispose();
					JOptionPane.showMessageDialog(null, "Film adaugat cu succes!");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Aia nu e o nota !");
					}
					
					}
			 });
			 adaug.setVisible(true);
		}
	});
	
	JButton xml=new JButton("XML File");
	xml.setBounds(850,161,150,24);
	frame.add(xml);
	xml.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			f.createXml();
			JOptionPane.showMessageDialog(null, "Fisier creat cu succes");
		}
	});
	 
	JButton tree=new JButton("Tree View");
	tree.setBounds(850,221,150,24);
	frame.add(tree);
	tree.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	TreeDemo t=new TreeDemo();
                    t.createAndShowGUI();
                }
            });	
		}
	});
	
	JButton openXml=new JButton("Open Xml");
	openXml.setBounds(850,191,150,24);
	frame.add(openXml);
	openXml.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				f.openXml();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null , "NU pot deschide Fisierul");
				e1.printStackTrace();
			}
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

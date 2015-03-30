
import java.util.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;

import javax.swing.*;
  
/*class Fereastra extends JFrame{
	JPanel p =new JPanel();
/*	public static void main(String [] args)
	{
		new Fereastra();
	}
	public Fereastra()
	{
		super("buhuh");
		setLayout(new FlowLayout());
		setSize(400,400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		Button b1=new Button("Filme");
		add(b1);
		Asculta listener = new Asculta(this);
		ColectieFilme f=new ColectieFilme();
		JLabel labe=new JLabel();
		JScrollPane scroll = new JScrollPane(labe);
		labe.setBounds(20, 20, 200, 100);
		labe.setText(f.toString());
		setVisible(true);
		add(labe);
		JTextField textField = new JTextField(f.toString());
		textField.setBounds(20, 20, 200, 100);
		textField.setText(f.toString());
		setVisible(true);
		p.add(textField);
	}
}
class Asculta implements ActionListener
{
	private Fereastra frame;
	public Asculta(Fereastra frame)
	{
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ColectieFilme f=new ColectieFilme();
		JLabel labe=new JLabel();
		labe.setText("ssas");
		
		//setVisible(true);
	}
}*/
class ExceptiiPosibile extends Exception{
	public ExceptiiPosibile(){
		
	}
   public void repeta()
   {
	  
   }
}
public class ColectieFilme  
{ 
	ArrayList<Film> Filme=new ArrayList<Film>();
	String linie;
	
public ColectieFilme()
{
	System.out.println("Reading File from Java code");
    String fileName="D:\\!Scoala\\java\\PaTema3Prob1\\src\\Filme.txt";
    try{
     
       FileReader inputFile = new FileReader(fileName);
     
       BufferedReader bufferReader = new BufferedReader(inputFile);
      
       String line;
   
       while ((line = bufferReader.readLine()) != null) 
       {
     	  linie=line;
     	String [] date=linie.split(" ");
     	String numeFilm=date[0];
     	String categorieFilm=date[1];
     	String dataLansare=date[2]; 
     	double notaFilm= Double.parseDouble(date[3]);
     	String idFilm=date[4];
     	Filme.add(new Film(numeFilm,categorieFilm,dataLansare,notaFilm,idFilm)); 

       }
       
       bufferReader.close();
    }catch(Exception e){
       System.out.println("Datele nu se pot citi" + e.getMessage()); 
       
    }
	
}
public void  afisareFilme()
{
	String spatiu="                                   ";
for(Film film : Filme)
		 {      
		 System.out.print( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getNumeFilm().length())+
		   		 film.getCategorieFilm()+spatiu.substring(0,spatiu.length()-film.getCategorieFilm().length())
		   		 +film.getDataLansareFilm()+spatiu.substring(0,spatiu.length()-film.getDataLansareFilm().length())
		   		 +film.getNotaFilm()+"     "
		   		 +film.getIdFilm());
		 System.out.println();
		 }
}	
@Override
public String toString()
{
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

	String spatiu="                                   ";
for(Film film : Filme)
		 {      
		 result.append( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getNumeFilm().length())+
		   		 film.getCategorieFilm()+spatiu.substring(0,spatiu.length()-film.getCategorieFilm().length())
		   		 +film.getDataLansareFilm()+spatiu.substring(0,spatiu.length()-film.getDataLansareFilm().length())
		   		 +film.getNotaFilm()+"     "
		   		 +film.getIdFilm());
		 result.append(NEW_LINE);
		 }
return result.toString();
}
public void scrieRaport() 
	 {
	 String numeFisier;
	 Scanner numeF=new Scanner(System.in);
	 System.out.println("Fisierul va fi salvat sub numele de ..");
	 numeFisier=numeF.nextLine();
	String spatiu="                              ";
	int spatii=spatiu.length();
	 try 
	        {
		 FileWriter writer = new FileWriter("D:\\!Scoala\\java\\PaTema3Prob1\\src\\"+numeFisier); 
		 for(Film film: Filme) {
		   writer.write( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getNumeFilm().length())+
				   		 film.getCategorieFilm()+spatiu.substring(0,spatiu.length()-film.getCategorieFilm().length())
				   		 +film.getDataLansareFilm()+spatiu.substring(0,spatiu.length()-film.getDataLansareFilm().length())
				   		 +film.getNotaFilm()+"     "
				   		 +film.getIdFilm());
		   writer.append("\r\n");
		 }
		 writer.close();
	 }
		 catch(IOException ex) {
	            System.out.println("Nu am putut scrie in"+ "D:\\!Scoala\\java\\PaTema3Prob1\\src\\"+numeFisier + "'");}
	 }
public void stergeFilm()
{  Scanner readFilm=new Scanner(System.in);
   System.out.println("Introduceti numele filmului pe care vreti sa il stergeti :");
   String numeFilm=readFilm.next();
   System.out.println(numeFilm);

   List<Film> copy = new ArrayList<Film>(Filme);

		for(Film film: Filme)
		{
			if(film.getNumeFilm().equals(numeFilm))
			{
				copy.remove(film);
				 System.out.println(numeFilm+" "+film.getNumeFilm());
		}
			 Filme = new ArrayList<Film>(copy);
		}


}
public void adaugaFilm()
{	 int x=1;
while(x==1)
{
	try
	{
	Scanner read=new Scanner(System.in);
	System.out.println("Nume film: ");
	String numeFilm=read.nextLine();

	Scanner read1=new Scanner(System.in);
	System.out.println("Categorie Film: ");
	String categorieFilm=read1.nextLine();
	
	Scanner read2=new Scanner(System.in);
	System.out.println("Data lansare : ");
	String dataLansare=read2.nextLine();
	
	Scanner read3=new Scanner(System.in);
	System.out.println("Nota film : ");
	double notaFilm=read3.nextDouble();
	

	Scanner read5=new Scanner(System.in);
	System.out.println("Id film : ");
	String idFilm=read5.nextLine();
	
	Filme.add(new Film (numeFilm,categorieFilm,dataLansare,notaFilm,idFilm));
	x=2;
	}
	catch (Exception e)
	{
		System.out.println("Asta nu e o nota ");
		
	}
}
}
public void meniu()
{ int ok=1;
	while(ok==1)
	{
		System.out.println("Introduseti optiunea: ");
		System.out.println("1-Afisare filme din colectie");
		System.out.println("2-Adauga film");
		System.out.println("3-Sterge film");
		System.out.println("4-Pune filmele intr-un fisier ");
		System.out.println("5-Sorteaza dupa nota ");
		System.out.println("0-Pentru iesire");
		Scanner optiune=new Scanner(System.in);
		int numar=optiune.nextInt();
		try {
		if(numar>5) throw new ExceptiiPosibile();
		}
		catch (ExceptiiPosibile e)
		{
			System.out.println("Optiune invalida");
			this.meniu();
		}
		switch(numar)
		{
		case 1: this.afisareFilme();break;
		case 2: this.adaugaFilm();break;
		case 3: this.stergeFilm();break;
		case 4: this.scrieRaport();break;
		case 5: this.sortareDupaNota();break;
		case 0: ok=0; break;
		}
	}
}
public void sortareDupaNota()
{
double []  vector= new double[100];
String [] denumire= new String[100];
int k=0; int l=0;
double aux;
String aux1;
for(Film film : Filme)
{
	vector[++k]=film.getNotaFilm();
	denumire[++l]=film.getNumeFilm();
}
for(int i=1;i<k;i++)
	for(int j=i+1;j<=k;j++)
	{
		if(vector[i] < vector[j])
		{ aux=vector[i]; vector[i]=vector[j]; vector[j]=aux; 
		  aux1=denumire[i]; denumire[i]=denumire[j]; denumire[j]=aux1;
		}
		
	}
	List<Film> copy = new ArrayList<Film>();
	for(int i=1;i<=k;i++)
	{
	  
		  for(Film film: Filme) 
			{ 
	  		  
			  if(vector[i]==film.getNotaFilm() && denumire[i]==film.getNumeFilm())
			  {
				  copy.add(new Film(film.getNumeFilm(),film.getCategorieFilm(),film.getDataLansareFilm(),film.getNotaFilm(),film.getIdFilm()));
			  }
			}	
  }
	 Filme = new ArrayList<Film>(copy);
}


//public static void main(String[] args) throws IOException 

	// {
	
//ColectieFilme filme=new ColectieFilme();

//filme.meniu();
//}
}

class Film implements Comparable
{
	String numeFilm;
	String categorieFilm;
	String dataLansare;
	public double notaFilm;
	String idFilm;
	public Film(){}
	 @Override
	    public int compareTo(Object film)
	    {
		 double comaparaNota=((Film)film).getNotaFilm();
		 return (int) ((int)this.notaFilm-comaparaNota);
	    }
    public Film(String nume,String categorie,String data,double nota,String id)
    {
    	numeFilm=nume;
    	categorieFilm=categorie;
    	dataLansare=data;
    	notaFilm=nota;
    	idFilm=id;
    }
	public void setNumeFilm(String nume)
	{
		this.numeFilm=nume;
	}
	public void setCategorieFilm(String categorie)
	{
		this.categorieFilm=categorie;
	}
	public void setDataLansare(String data)
	{
		this.dataLansare=data;
	}
	public void setNotaFilm(double nota )
	{
		this.notaFilm=nota;
	}
	public void setIdFilm(String id)
	{
		this.idFilm=id;
	}
	public String getNumeFilm()
	{
		return this.numeFilm;
	}
	public String getCategorieFilm()
	{
		return this.categorieFilm;
	}
	public String getDataLansareFilm()
	{
		return this.dataLansare;
	}
	public double getNotaFilm()
	{
		return this.notaFilm;
	}
	public String getIdFilm()
	{
		return this.idFilm;
	}

	  }
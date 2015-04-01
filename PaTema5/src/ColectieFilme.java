
import java.util.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;

import javax.swing.*;

import com.sun.xml.internal.txw2.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 



import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


  
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
	//System.out.println("Reading File from Java code");
	//InputStream in = this.getClass().getClassLoader()
      //      .getResourceAsStream("D:\\!Scoala\\java\\PaTema3Prob1\\src\\Filme.txt");

    String fileName="D:\\!Scoala\\gitRep\\Tema5\\PaTema5\\src\\Filme.txt";
    try{
    	
   	 InputStream is = getClass().getResourceAsStream("Filme.txt");
	  InputStreamReader isr = new InputStreamReader(is);
	  
      // FileReader inputFile = new FileReader(fileName);
     
       BufferedReader bufferReader = new BufferedReader(isr);
      
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
     	String genFilm=date[5];
     	Filme.add(new Film(numeFilm,categorieFilm,dataLansare,notaFilm,idFilm,genFilm)); 

       }
       
       bufferReader.close();
    }catch(Exception e){
       System.out.println("Datele nu se pot citi" + e.getMessage()); 
       
    }
	
}

//@Override
public String toStringGen(String gen )
{
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

	String spatiu="                                   ";
for(Film film : Filme)
		 {
			if(film.getGenFilm().equals(gen)){
		 result.append( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getNumeFilm().length())+
		   		 film.getCategorieFilm()+spatiu.substring(25,spatiu.length()-film.getCategorieFilm().length())+
		   		 film.getGenFilm()+spatiu.substring(20,spatiu.length()-film.getGenFilm().length())
		   		 +film.getDataLansareFilm()+spatiu.substring(15,spatiu.length()-film.getDataLansareFilm().length())
		   		 +film.getNotaFilm()+"  "
		   		 +film.getIdFilm());
		 result.append(NEW_LINE);}
		 }
return result.toString();
}

public String toString(String categorie)
{
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

	String spatiu="                                   ";
for(Film film : Filme)
		 {
			if(film.getCategorieFilm().equals(categorie)){
		 result.append( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getNumeFilm().length())+
		   		 film.getCategorieFilm()+spatiu.substring(25,spatiu.length()-film.getCategorieFilm().length())+
		   		 film.getGenFilm()+spatiu.substring(20,spatiu.length()-film.getGenFilm().length())
		   		 +film.getDataLansareFilm()+spatiu.substring(15,spatiu.length()-film.getDataLansareFilm().length())
		   		 +film.getNotaFilm()+"    "
		   		 +film.getIdFilm());
		 result.append(NEW_LINE);}
		 }
return result.toString();
}
public String toString()
{
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

	String spatiu="                                        ";
for(Film film : Filme)
		 {      
		 result.append( film.getNumeFilm()+spatiu.substring(8,spatiu.length()-film.getNumeFilm().length())+
		   		 film.getCategorieFilm()+spatiu.substring(30,spatiu.length()-film.getCategorieFilm().length())
		   		 +film.getGenFilm()+spatiu.substring(20,spatiu.length()-film.getGenFilm().length())
		   		 +film.getDataLansareFilm()+spatiu.substring(20,spatiu.length()-film.getDataLansareFilm().length())
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
		   writer.write( film.getNumeFilm()+spatiu.substring(0,spatiu.length()-film.getCategorieFilm().length())
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
public int existaFilm(String numeFilm)
{


		for(Film film: Filme)
		
			if(film.getNumeFilm().equals(numeFilm))
return 1;
return 0;


}

public void stergeFilm(String numeFilm)
{ 

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
public void adaugaFilm(String numeFilm,String categorieFilm,String dataLansare,double notaFilm,String idFilm,String genFilm)
{	

	Filme.add(new Film (numeFilm,categorieFilm,dataLansare,notaFilm,idFilm,genFilm));


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
				  copy.add(new Film(film.getNumeFilm(),film.getCategorieFilm(),film.getDataLansareFilm(),film.getNotaFilm(),film.getIdFilm(),film.getGenFilm()));
			  }
			}	
  }
	 Filme = new ArrayList<Film>(copy);
}

public void createXml(){
	 
	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		org.w3c.dom.Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("ColectieFilme");
		doc.appendChild(rootElement);
		for(Film film : Filme)
		 {      
	
		   		// +film.getIdFilm());
		// staff elements
		Element filmul = doc.createElement("Film");
		rootElement.appendChild(filmul);

		// seteaza id-ul filmului 
		Attr id = doc.createAttribute("id");
		id.setValue(film.getIdFilm());
		filmul.setAttributeNode(id);

		// shorten way
		// staff.setAttribute("id", "1");

		// seteaza numele filmului
		Element nume = doc.createElement("nume");
		nume.appendChild(doc.createTextNode(film.getNumeFilm()));
		filmul.appendChild(nume);

		// seteaza categoria filmului
		Element categorie = doc.createElement("categorie");
		categorie.appendChild(doc.createTextNode(film.getCategorieFilm()));
		filmul.appendChild(categorie);

		// seteaza data lansarii
		Element dataLansare = doc.createElement("Data-Lansare");
		dataLansare.appendChild(doc.createTextNode(film.getDataLansareFilm()));
		filmul.appendChild(dataLansare);

		// seteaza nota
		Element nota = doc.createElement("Nota");
		nota.appendChild(doc.createTextNode(String.valueOf(film.getNotaFilm())));
		filmul.appendChild(nota);
		
		//seteaza genul 
		Element gen = doc.createElement("Gen");
		gen.appendChild(doc.createTextNode(String.valueOf(film.getGenFilm())));
		filmul.appendChild(gen);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("D:\\file.xml"));
		 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		

	  }} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
public void openXml() throws IOException
{   
	try {		
	    String path ="D:\\file.xml";
	    Runtime runtime = Runtime.getRuntime();
	    runtime.exec("explorer.exe "+path);
	   // System.out.println("open");
	} catch (Exception E) 
	{
		System.out.println("Nu se poate reda"+E.getMessage());
	}
}
	public String ReadXMLFile () {
		 
	
	    StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");
		    try {
		    
		 
			File fXmlFile = new File("D:\\file.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("Film");
		 
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				org.w3c.dom.Node nNode = nList.item(temp);
		 
				result.append(NEW_LINE+"Parinte :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 
					result.append(" cu id Film : " + eElement.getAttribute("id")+NEW_LINE);
					result.append("Nume Film : " + eElement.getElementsByTagName("nume").item(0).getTextContent()+NEW_LINE);
					result.append("Categorie Film : " + eElement.getElementsByTagName("categorie").item(0).getTextContent()+NEW_LINE);
					result.append("Data Lansare : " + eElement.getElementsByTagName("Data-Lansare").item(0).getTextContent()+NEW_LINE);
					result.append("Nota : " + eElement.getElementsByTagName("Nota").item(0).getTextContent()+NEW_LINE);
					result.append("GEn : " + eElement.getElementsByTagName("Gen").item(0).getTextContent()+NEW_LINE);
		 
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    return result.toString();
		  }
		 
		


}

class Film implements Comparable
{
	String numeFilm;
	String categorieFilm;
	String dataLansare;
	public double notaFilm;
	String idFilm;
	String genFilm;
	public Film(){}
	 @Override
	    public int compareTo(Object film)
	    {
		 double comaparaNota=((Film)film).getNotaFilm();
		 return (int) ((int)this.notaFilm-comaparaNota);
	    }
    public Film(String nume,String categorie,String data,double nota,String id, String gen)
    {
    	numeFilm=nume;
    	categorieFilm=categorie;
    	dataLansare=data;
    	notaFilm=nota;
    	idFilm=id;
    	genFilm=gen;
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
	public void setGen(String gen)
	{
		this.genFilm=gen;
	}
	public String getGenFilm()
	{
		return this.genFilm;
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
package Facebook;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Server 
{

	private Persona [] utentiRegistrati = new Persona[50];
	private int ind=0;
	
	String [] nomi = {"Alfonso","Andrea","Alessio","Lorenzo","Alessandro","Christian","Manuel","Giovanni","Houssem",
					  "Andrea","Jed","Nicolò","Darion","Leonardo","Lina","Nicolo","Luke","Simone"};
	
	String [] cognomi = {"Mazzarella","Sabia","Aldera","Avallone","Battaglia","Biuso","Ottimofiore","Farina","Guerine",
						 "Perini","Robbles","Sallustio","Mance","Tedone","Zhou","Ziolini","Manalo","Bulloni"};
	
	//String [] nickname = {"GoodGuyJaden","Sabbi6322",""};
	
	public void fillServer()
	{
		String eta="";
		
		for (int i=0;i<nomi.length;i++)
		{
			eta=String.valueOf(ThreadLocalRandom.current().nextInt(16,20));
			registra(new Persona("default"+i,nomi[i],cognomi[i],eta));
		}
	}
		
	public boolean registra(Persona p)
	{
		for(int i=0;i<ind;i++)
		{
			if(p.getNick().equals(utentiRegistrati[i].getNick()))
			{
				System.out.println("Impossibile registrare l'utente. Nickname già in uso.");
				return false;
			}
		}
		
		utentiRegistrati[ind]=p;
		ind++;
		System.out.println("Utente registrato correttamente.");
		return true;
	}
	
	public Persona seleziona()
	{
		Scanner sc= new Scanner(System.in);
		String check="";
		int num=0;
		
		stampaServer();
		do
		{
			System.out.println("Inserisci il numero corrispondente all'utente da selezionare: ");
			check=sc.next().replaceAll("\\D+",""); //serve ad estrapolare solo i numeri
			sc.nextLine();
			num = Integer.parseInt(check);
		}while(num<0 || num>=ind);
		
		return utentiRegistrati[num];
	}
	
	public boolean rimuovi(Persona p)
	{
		for (int i=0;i<ind;i++)
		{
			if(p.equals(utentiRegistrati[i]))
			{
				utentiRegistrati[i]=null;
				setIndice();
				System.out.println("Utente rimosso.");
				return true;
			}
		}
		
		return false;
	}
	
	public void setIndice()
	{
		if(ind==1)
		{
			ind--;
		}
		else
		{
			for(int i=0;i<ind;i++)
			{
				if(utentiRegistrati[i]==null)
				{
					if(i==ind-1)
					{
						ind=i;
						break;
					}
					else
					{
						utentiRegistrati[i]=utentiRegistrati[i+1];
						utentiRegistrati[i+1]=null;
						i=-1;
					}
					
				}
			}
		}
		
	}
	
	public void stampaServer()
	{
		for(int i=0;i<ind;i++)
		{
			if(utentiRegistrati[i].isPub())
			{
				System.out.println("["+i+"]: "+utentiRegistrati[i]);				
			}
			else
			{
				System.out.println("["+i+"]: "+utentiRegistrati[i].getNick());
			}
			
		}
	}
	
	@Override
	public String toString() {
		return "Server [utentiRegistrati=" + Arrays.toString(utentiRegistrati) + "]";
	}
}

package Facebook;

import java.util.Scanner;

public class Utente 
{
	private Persona [] listaAmici = new Persona[500];
	private Foto [] galleria = new Foto[9];
	private int indA=0;
	private int indF=0;
	
	
	public boolean addAmici(Persona p)
	{
		for(int i=0;i<indA;i++)
		{
			if(p.getNick().equals(listaAmici[i].getNick()))
			{
				System.out.println("Hai già questo utente come amico.");
				return false;
			}			
		}
		
		listaAmici[indA]=p;
		System.out.println("Amico aggiunto.");
		indA++;
		return true;
	}
	
	public Persona selezionaA()
	{
		Scanner sc= new Scanner(System.in);
		String check="";
		int num=0;
		if(indA==0)
		{
			System.out.println("Lista amici vuota.");
			return null;
		}
		else
		{
			stampaLista();
			do
			{
				System.out.println("Inserisci il numero corrispondente all'utente da selezionare: ");
				check=sc.next().replaceAll("\\D+",""); //serve ad estrapolare solo i numeri
				sc.nextLine();
				num = Integer.parseInt(check);
			
			}while(num<0 || num>=indA);
			
			return listaAmici[num];
		}
				
	}
	
	public boolean remAmici(Persona p)
	{
		for(int i=0;i<indA;i++)
		{
			if(p.equals(listaAmici[i]))
			{
				listaAmici[i]=null;
				setIndiceA();
				System.out.println("Utente rimosso dalla lista amici.");
				return true;
			}	
		}
		
		return false;
	}
	
	private void setIndiceA()
	{
		if(indA==0)
		{
			
		}
		if(indA==1)
		{
			indA--;
		}
		else
		{
			for (int i=0;i<indA;i++)
			{
				if(listaAmici[i]==null)
				{
					if(i==indA-1)
					{
						indA=i;
						break;
					}
					else
					{
						listaAmici[i]=listaAmici[i+1];
						listaAmici[i+1]=null;
						i=-1;
					}
					
				}
				
			}
		
		}
	}
	
	public void stampaLista() 
	{
		if(indA==0)
		{
			System.out.println("Non hai amici.");
		}
		else
		{
			for(int i=0;i<indA;i++)
			{
				System.out.println("["+i+"]: "+listaAmici[i]);
			}
		}
		
	}

	
	public boolean contaTag(Persona p)
	{
		if(indF==0)
		{
			System.out.println("Non hai foto.");
			return false;
		}
		else
		{
			int conta=0;
			
			for (int i=0;i<indF;i++)
			{
				if(galleria[i].getTag().equals(p))
				{
					conta++;
				}
			}
			
			System.out.println(p + " è stato taggato " + conta + " volte.");
			return true;
		}
		
	}

	public boolean BFF()
	{
		if(indF==0)
		{
			System.out.println("Non hai foto.");
			return false;
		}
		else
		{
			int indice=0;
			int conta=0;
			int max=0;
			Persona p=null;
			
			for(int i=0;i<indF;i++)
			{
				if(galleria[indice].getTag().equals(galleria[i].getTag())) conta++;
				
				if(conta>max)
				{
					p=galleria[indice].getTag();
					max=conta;
					conta=0;
					indice++;
				}
				else
				{
					conta=0;
					indice++;
				}
			}
			
			System.out.println("L'amico taggato in più foto è: "+p);
			return true;
		}
		
	}
	
	
	public boolean addFoto(Foto f)
	{
		for (int i=0;i<indF;i++)
		{
			if(f.getTit().equals(galleria[i].getTit()))
			{
				System.out.println("Hai già una foto con questo titolo.");
				return false;
			}
		}
		
		galleria[indF]=f;
		System.out.println("Foto aggiunta.");
		indF++;
		return true;
	}
	
	public boolean tagA(Foto f)
	{
		if(f!= null) 
		{
			f.setTag(selezionaA());
			return true;
		}
		return false;
	}
	
	public Foto selezionaF()
	{
		Scanner sc= new Scanner(System.in);
		String check="";
		int num=0;
		
		if(indF==0)
		{
			System.out.println("Galleria vuota.");
			return null;
		}
		else
		{
			stampaGalleria();
			
			do
			{
				System.out.println("Inserisci il numero corrispondente alla foto da selezionare: ");
				check=sc.next().replaceAll("\\D+",""); //serve ad estrapolare solo i numeri
				sc.nextLine();
				num = Integer.parseInt(check);
			
			}while(num<0 || num>=indF);
			
			return galleria[num];
		}
		
	}
	
	public boolean remFoto(Foto f)
	{
		for(int i=0;i<indF;i++)
		{
			if(f.equals(galleria[i]))
			{
				galleria[i]=null;
				setIndiceF();
				System.out.println("Foto rimossa dalla galleria.");
				return true;
			}	
		}
		
		return false;
	}

	private void setIndiceF()
	{
		if(indF==0)
		{
			indF--;
		}
		else
		{
			for(int i=0;i<indF;i++)
			{
				if(galleria[i]==null)
				{
					if(i==indF-1)
					{
						indF=i;
						break;
					}
					else
					{
						galleria[i]=galleria[i+1];
						galleria[i+1]=null;
						i=-1;
					}
				}
			}
		}
	}
	
	public void stampaGalleria() 
	{
		if(indF==0)
		{
			System.out.println("Non hai foto.");
		}
		else
		{
			for(int i=0;i<indF;i++)
			{
				System.out.println("["+i+"]: "+galleria[i]);
			}
		}
		
	}
	
}

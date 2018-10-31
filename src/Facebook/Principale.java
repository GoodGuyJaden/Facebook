package Facebook;

import java.util.Scanner;

public class Principale 
{
	
	private static Scanner sc = new Scanner(System.in);
	private static Persona p;
	private static Utente u = new Utente();
	private static Server s = new Server();
	
	public static void main (String[]args)
	{
		menu();
	}
	
	
	static public void menu()
	{
		s.fillServer();
		String scelta ="";
		String nickname;
		String nome;
		String cognome;
		String titolo;
		String eta;
		
		while(!scelta.equals("x")) 
		{
			
			System.out.println("");
			System.out.println("Inserisci 0 per aggiungere una persona al server.");
			System.out.println("Inserisci 1 per aggiungere un amico.");
			System.out.println("Inserisci 2 per aggiungere una foto.");
			System.out.println("Inserisci 3 per aggiungere un tag ad una foto.");
			System.out.println("Inserisci 4 per contare quante foto sono taggate ad una persona.");
			System.out.println("Inserisci 5 per visualizzare la persona con più tag.");
			System.out.println("Inserisci 6 per visualizzare la tua lista amici.");
			System.out.println("Inserisci 7 per visualizzare la galleria.");
			System.out.println("Inserisci 8 per rimuovere un amico.");
			System.out.println("Inserisci 9 per rimuovere una foto.");
			System.out.println("Inserisci 10 per stampare il server.");
			System.out.println("Inserisci x per uscire.");
			scelta=sc.nextLine();
			
			switch(scelta)
			{
				case "0":
						System.out.println("Inserisci nickname, nome, cognome, eta separati da uno spazio o da un invio: ");
						nickname=sc.next();
						nome=sc.next();
						cognome=sc.next();
						eta=sc.next().replaceAll("\\D+","");
						sc.nextLine();
						while(eta.equals(""))
						{
							System.out.println("Reinserire età utilizzando unicamente NUMERI");
							eta=sc.next().replaceAll("\\D+","");
						}
						sc.nextLine();
						
						System.out.println("Vuoi impostare il profilo pubblico?  y/n");
						scelta=sc.nextLine();
						
						if(scelta.toLowerCase().equals("y"))	p = new Persona(nickname,nome,cognome,eta);
						
						else	p = new Persona(nickname,nome,cognome,eta,Facebook.Persona.profilo.privato); 
							
						s.registra(p);
						
						break;
					
				case "1":
						u.addAmici(s.seleziona());
						break;
						
				case "2":
						System.out.println("Inserisci il titolo della foto: ");
						titolo=sc.nextLine();
						
						System.out.println("Vuoi taggare qualcuno? y/n");
						scelta=sc.nextLine();
						
						if(scelta.toLowerCase().equals("y"))
						{
							p=u.selezionaA();
							u.addFoto(new Foto(titolo,p));
						}
												
						else u.addFoto(new Foto(titolo,null));
						
						break;
					
				case "3":
						u.tagA(u.selezionaF());
						break;
					
				case "4":
						u.contaTag(u.selezionaA());
						break;
				
				case "5":
						u.BFF();
						break;
						
				case "6":
						u.stampaLista();
						break;
						
				case "7":
						u.stampaGalleria();
						break;
						
				case "8":
						u.remAmici(u.selezionaA());
						break;
						
				case "9":
						u.remFoto(u.selezionaF());
						break;
						
				case "10":
						s.stampaServer();
						break;
						
				case "x":
						System.out.println("Grazie per aver usato la mia piattaforma :).");
						break;
						
				default:
						System.out.println("Selezionare un'opzione valida.");
						break;
			}
		}
	}
}

package Facebook;

public class Persona 
{
	enum profilo {pubblico,privato};
	
	private String nome;
	private String cognome;
	private String nickname;
	private String eta;
	private profilo statoProfilo;
	
	public Persona(String nickname, String nome, String cognome, String eta, profilo statoProfilo)
	{
		this.nickname=nickname;
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.statoProfilo=statoProfilo;
	}
	
	public Persona(String nickname, String nome, String cognome, String eta)
	{
		this.nickname=nickname;
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		statoProfilo=profilo.pubblico;
	}

	public String getNick()
	{
		return nickname;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getCogn()
	{
		return cognome;
	}
	
	public String getEta()
	{
		return eta;
	}
	
	public boolean isPub()
	{
		if(statoProfilo==profilo.pubblico) return true;
		else return false;
	}
	
	public profilo getProf()
	{
		return statoProfilo;
	}
	
	public void setProf(Persona p, profilo statoProfilo)
	{
		p.statoProfilo=statoProfilo;
	}
	
	
	@Override
	public String toString() 
	{	
		return  nickname + " " + nome + " " + cognome + " " + eta + " anni.";
	}

	public String toString1() {
		return "Lo stato del profilo di " + nome + " " + cognome + " è: " + statoProfilo;
	}
	
	
	
}

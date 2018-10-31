package Facebook;

public class Foto 
{
	private String titolo;
	private Persona tag;
	
	public Foto(String titolo, Persona tag)
	{
		this.titolo=titolo;
		this.tag=tag;
	}

	public String getTit()
	{
		return titolo;
	}
	
	public Persona getTag()
	{
		return tag;
	}
	
	public void setTag(Persona tag)
	{
		this.tag=tag;
	}
		
	@Override
	public String toString() {
		return "Titolo: " + titolo + "; " + tag + " è taggato in questa immagine.";
	}
	
	
}

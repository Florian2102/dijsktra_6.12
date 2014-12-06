package de;

public class Knoten implements Comparable<Knoten> {
	
public String name = null;
public Integer gewicht = null;
public Knoten vorgaenger = null;
	
	public Kante adjacencies[] = null;

	public Knoten(String name, Integer gewicht, Knoten vorgaenger) {
		super();
		this.name = name;
		this.gewicht = gewicht;
		this.vorgaenger = vorgaenger;
	}

	public Integer getGewicht()
	{
		return this.gewicht;
	}
	
	@Override
	public int compareTo(Knoten rand) {
		
		return this.gewicht.compareTo(rand.getGewicht());
	}
	
	

}

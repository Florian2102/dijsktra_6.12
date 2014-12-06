package de;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {

		Knoten a = new Knoten("A", 0, null);
		Knoten b = new Knoten("B", 0, null);
		Knoten c = new Knoten("C", 0, null);
		Knoten d = new Knoten("D", 0, null);
		Knoten e = new Knoten("E", 0, null);
		Knoten f = new Knoten("F", 0, null);

		a.adjacencies = new Kante[] {new Kante(b, 4),
				new Kante(c, 2),
				new Kante(d, 5)};
		b.adjacencies = new Kante[] {new Kante(a, 4),
				new Kante(e, 6),
				new Kante(f, 4)};
		c.adjacencies = new Kante[] {new Kante(a, 2),
				new Kante(d, 5)};
		d.adjacencies = new Kante[] {new Kante(a, 5),
				new Kante(e, 5),
				new Kante(f, 3)};
		e.adjacencies = new Kante[] {new Kante(b, 6),
				new Kante(d, 5),
				new Kante(f, 1)};
		f.adjacencies = new Kante[] {new Kante(b, 4),
				new Kante(d, 3),
				new Kante(e, 1)};

		ArrayList<Knoten> besucht = new ArrayList<Knoten>();
		ArrayList<Knoten> rand = new ArrayList<Knoten>();
		ArrayList<Knoten> unbekannt = new ArrayList<Knoten>();

		rand.add(a);

		if (rand.contains(a)) {
			
			unbekannt.add(b);
			unbekannt.add(c);
			unbekannt.add(d);
			unbekannt.add(e);
			unbekannt.add(f);
		}
		
		if (rand.contains(b)) {
			
			unbekannt.add(a);
			unbekannt.add(c);
			unbekannt.add(d);
			unbekannt.add(e);
			unbekannt.add(f);
		}

		if (rand.contains(c)) {
	
			unbekannt.add(a);
			unbekannt.add(b);
			unbekannt.add(d);
			unbekannt.add(e);
			unbekannt.add(f);
		}

		if (rand.contains(d)) {
	
			unbekannt.add(a);
			unbekannt.add(b);
			unbekannt.add(c);
			unbekannt.add(e);
			unbekannt.add(f);
		}

		if (rand.contains(e)) {
	
			unbekannt.add(a);
			unbekannt.add(b);
			unbekannt.add(c);
			unbekannt.add(d);
			unbekannt.add(f);
		}

		if (rand.contains(f)) {
	
			unbekannt.add(a);
			unbekannt.add(b);
			unbekannt.add(c);
			unbekannt.add(d);
			unbekannt.add(e);
		}
		

		Knoten aktiv = null;
		Knoten ziel = e;


		do {
			
			// aktiv entnehmen mit kleinstem Gewicht aus rand
			Collections.sort(rand);
			aktiv = rand.get(0);
			rand.remove(0);

			// wenn aktiv gleich ziel sind wir fertig
			if (aktiv == ziel) {

				System.out.println("Wir sind am Ziel.");
			}

			// ansonsten füge aktiv zu besucht hinzu
			else {

				besucht.add(aktiv);
			}

			// betrachte jeden von a aus direkt erreichbaren nachbarknoten n (aktiv.adjacencies[i])
			for (int i = 0; i < aktiv.adjacencies.length; i++) {

				// sein gesamtgewicht (gewicht) = gewicht aktiv + 
				int gewicht = aktiv.adjacencies[i].laenge + aktiv.gewicht;

				if (rand.contains(aktiv.adjacencies[i].knoten)) {

					if (gewicht < aktiv.adjacencies[i].knoten.gewicht || aktiv.adjacencies[i].knoten.gewicht == 0) {
						aktiv.adjacencies[i].knoten.gewicht = gewicht;
						aktiv.adjacencies[i].knoten.vorgaenger = aktiv;
					}

				}

				if (unbekannt.contains(aktiv.adjacencies[i].knoten)) {
					rand.add(aktiv.adjacencies[i].knoten);
					unbekannt.remove(aktiv.adjacencies[i].knoten);
					aktiv.adjacencies[i].knoten.gewicht = gewicht;
					aktiv.adjacencies[i].knoten.vorgaenger = aktiv;
				}

			}

		} while (aktiv != ziel);
		
		while ()
		Knoten ergebnis = null;
		Knoten ergebnis2 = null;
		System.out.println(ziel.name);
		System.out.println(ziel.vorgaenger.name);
		ergebnis = ziel.vorgaenger;
		System.out.println(ergebnis.vorgaenger.name);
		ergebnis2 = ergebnis.vorgaenger;
		System.out.println(ergebnis2.vorgaenger.name);
		System.out.println(ziel.gewicht);
	}

}

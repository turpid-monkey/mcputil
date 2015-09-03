package org.math.torture;

import java.text.Format;
import java.util.Random;

public class BirnenAufgabe extends DefaultTaskTemplate {

	double gebuehr;
	double preis;
	int birnen;

	void init(Random r) {
		gebuehr = r.nextInt(10) * 5.5d;
		preis = 0.5d + r.nextInt(10) * 0.05d;
		birnen = r.nextInt(20) + 7;
	}

	public String text() {
		return "Hannah verkauft "
				+ integer().format(birnen)
				+ " Birnen zu "
				+ currency().format(preis)
				+ " Euro auf dem Markt. Wieviel Geld nimmt sie ein, nachdem sie die Standgebuehr von "
				+ currency().format(gebuehr) + " gezahlt hat?";
	}

	public Format solutionFormat() {
		return currency();
	}

	public double solution() {
		return birnen * preis - gebuehr;
	}

	public double wrong1() {
		return (birnen / gebuehr) - preis;
	}

	public double wrong2() {
		return birnen - gebuehr * preis;
	}

	public double wrong3() {
		return (birnen - gebuehr) * preis;
	}

	public double wrong4() {
		return birnen * preis * preis;
	}
}

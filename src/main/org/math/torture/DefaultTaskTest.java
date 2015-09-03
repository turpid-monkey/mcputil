package org.math.torture;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultTaskTest {

	@Test
	public void testRandomOutput() {

		BirnenAufgabe aufgabe1 = new BirnenAufgabe();
		MultipleChoiceTask t = aufgabe1.create(1);
		System.out.println(t.getText());
		for (String o : t.getOptions()) {
			System.out.println(o);
		}
		System.out.println("Richtige Antwort = "
				+ t.getOptions()[t.getCorrectAnswer()] + " / Option "
				+ (t.getCorrectAnswer() + 1));
		
		System.out.println("--------");
	    t = aufgabe1.create(2);
		System.out.println(t.getText());
		for (String o : t.getOptions()) {
			System.out.println(o);
		}
		System.out.println("Richtige Antwort = "
				+ t.getOptions()[t.getCorrectAnswer()] + " / Option "
				+ (t.getCorrectAnswer() + 1));
	}
	
	@Test
	public void testSpecific()
	{
		BirnenAufgabe a = new BirnenAufgabe();
		a.birnen = 50;
		a.gebuehr = 10.00d;
		a.preis = 1d;
		assertEquals(40.0d, a.solution(), 0.00001d);
	}

}

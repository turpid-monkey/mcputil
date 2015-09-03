package org.math.torture;

import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public abstract class DefaultTaskTemplate implements TaskTemplate {

	@Override
	public MultipleChoiceTask create(long seed) {
		Random r = new Random(seed);
		init(r);
		List<Integer> indexes = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		String[] options = new String[5];
		Format f = solutionFormat();

		int idx;
		int solution = idx = indexes.remove(r.nextInt(5));
		options[idx] = f.format(solution());
		idx = indexes.remove(r.nextInt(4));
		options[idx] = f.format(wrong1());
		idx = indexes.remove(r.nextInt(3));
		options[idx] = f.format(wrong2());
		idx = indexes.remove(r.nextInt(2));
		options[idx] = f.format(wrong3());
		idx = indexes.remove(0);
		options[idx] = f.format(wrong4());
		return new MultipleChoiceTask(solution, text(), options);
	}

	abstract void init(Random r);
	abstract public String text();
	abstract double solution();
	abstract Format solutionFormat();
	abstract double wrong1();
	abstract double wrong2();
	abstract double wrong3();
	abstract double wrong4();

	public static Format currency() {
		return NumberFormat.getCurrencyInstance(Locale.GERMANY);
	}

	public static Format integer() {
		return NumberFormat.getIntegerInstance();
	}

	public static Format percent() {
		return NumberFormat.getPercentInstance();

	}
}
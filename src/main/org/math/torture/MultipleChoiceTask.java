package org.math.torture;

public class MultipleChoiceTask {

	int correctAnswer;
    String text;
	String[] answers;

	MultipleChoiceTask(int correctAnswer, String text,String... answers) {
		if (correctAnswer > answers.length)
			throw new IllegalArgumentException("Does not compute.");
		this.correctAnswer = correctAnswer;
		this.answers = answers;
		this.text = text;
	}
	
	public String[] getOptions() {
		return answers;
	}
	
	public String getText() {
		return text;
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}

}

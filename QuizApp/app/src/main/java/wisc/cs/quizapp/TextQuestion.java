package wisc.cs.quizapp;


import java.util.ArrayList;

public class TextQuestion extends Question {

	private int userAnswer; // int that maps to radio button user choose
	private int radioButtonAnswer; // the int value of radio button that is the correct answer
	private ArrayList<String> radioButtonPossibleAnswers; // strings for the radio button answers
	
	public TextQuestion(String q, String a, int radioButtonAnswer, String ra1, String ra2, String ra3) {
		super(q,a);
		this.userAnswer = -1;
		this.radioButtonAnswer = radioButtonAnswer;
		this.radioButtonPossibleAnswers = new ArrayList<String>();
		this.radioButtonPossibleAnswers.add(ra1);
		this.radioButtonPossibleAnswers.add(ra2);
		this.radioButtonPossibleAnswers.add(ra3);
	}

	public String[] getPossibleAnswers() {
		String[] answers = new String[this.radioButtonPossibleAnswers.size()];
		for(int i =0; i < answers.length; i++) {
			answers[i] = this.radioButtonPossibleAnswers.get(i);
		}
		return answers;
	}

	public int getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	public boolean gradeQuestion() {
		if(this.userAnswer == this.radioButtonAnswer) {
			return true;
		}
		return false;
	}

	public String toString() {
		String s1 = "";
		s1 = "Question: " + this.getQuestion() + "\n";
		s1 += "Answer: " + this.getAnswer() + "\n";
		s1 += "User Answer: " + this.getUserAnswer() + "\n";
		s1 += "Radio Button Answer: " + this.radioButtonAnswer;
		return s1;
	}
}

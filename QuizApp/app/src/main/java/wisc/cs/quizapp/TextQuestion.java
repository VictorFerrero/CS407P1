package wisc.cs.quizapp;


public class TextQuestion extends Question {

	private int userAnswer;
	private int radioButtonAnswer;
	
	public TextQuestion(String q, String a, int radioButtonAnswer) {
		super(q,a);
		this.userAnswer = -1;
		this.radioButtonAnswer = radioButtonAnswer;
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

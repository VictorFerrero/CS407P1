package wisc.cs.quizapp;

public class ImageQuestion extends Question{

	private String userAnswer;
	private int imageId;
	
	public ImageQuestion(String q, String answer, int id) {
		super(q, answer);
		this.userAnswer = ""; // no answer at first
		this.imageId = id;
	}

	
	public int getId() {
		return this.imageId;
	}


	public void setPathToImage(int id) {
		this.imageId = id;
	}


	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	public boolean gradeQuestion() {
		if(this.userAnswer.equals(this.answer)){
			return true;
		}
		return false;
	}

	public String toString() {
		String s1 = "";
		s1 = "Question: " + this.getQuestion() + "\n";
		s1 += "Answer: " + this.getAnswer() + "\n";
		s1 += "User Answer: " + this.getUserAnswer() + "\n";
		s1 += "image id: " + this.imageId + "\n";
		return s1;
	}
}
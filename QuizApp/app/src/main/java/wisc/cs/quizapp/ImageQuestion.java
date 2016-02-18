package wisc.cs.quizapp;

public class ImageQuestion extends Question{

	private String userAnswer;
	private String pathToImage;
	
	public ImageQuestion(String q, String answer, String pto) {
		super(q, answer);
		this.userAnswer = ""; // no answer at first
		this.pathToImage = pto;
	}

	
	public String getPathToImage() {
		return pathToImage;
	}


	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
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
		s1 += "Path to image: " + this.pathToImage + "\n";
		return s1;
	}
}

package wisc.cs.quizapp;

abstract class Question {

	private String question;
	protected String answer;
	
	protected Question(String q, String a) {
		this.question = q;
		this.answer = a;
	}

	protected String getQuestion() {
		return question;
	}

	protected void setQuestion(String question) {
		this.question = question;
	}

	protected String getAnswer() {
		return answer;
	}

	protected void setAnswer(String answer) {
		this.answer = answer;
	}
}

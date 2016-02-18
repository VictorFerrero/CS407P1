package wisc.cs.quizapp;

import android.media.Image;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Quiz {

	private ArrayList<Question> questions;
	private int index;
	
	public Quiz() {
		this.questions = new ArrayList<Question>();	
		this.index = -1;
	}
	
	public void initializeQuiz() {
		ImageQuestion img = new ImageQuestion("what is my favorite color?", "green", "/some/filepath");
		this.questions.add(img);

		this.questions.add(new TextQuestion("how many days are there in a week?", "7", 3));
	}
	
public Question getNextQuestion() {
	if(this.index + 1 < this.questions.size()) {
		this.index = this.index + 1;
		return this.questions.get(this.index);
	}
	return null;
}

public double gradeQuiz() {
	int totalQuestions = this.questions.size();
	int correct = 0;
	for(int i = 0; i < this.questions.size(); i++) {
		Question q = this.questions.get(i);
		if(q instanceof TextQuestion) {
			TextQuestion tq = (TextQuestion) q;
			if(tq.gradeQuestion()) {
				correct++;
			}
		}
		else if(q instanceof ImageQuestion) {
			ImageQuestion iq = (ImageQuestion) q;
			if (iq.gradeQuestion()) {
				correct++;
			}
		}
	}
	double x = (double) correct / totalQuestions;
	double percent = (double) (x * 100);
	return percent;
}
	
	
}

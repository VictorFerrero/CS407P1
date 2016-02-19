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
		ImageQuestion img = new ImageQuestion("what is the name of this school building?", "bascom hall", R.drawable.bascom_hall);
		this.questions.add(img);
		img = new ImageQuestion("what is the name of this abstract data type?", "binary search tree", R.drawable.binary_tree);
		this.questions.add(img);

		TextQuestion tq = new TextQuestion("how many days are there in a week?", "7", 3, "4", "2", "7");
		this.questions.add(tq);

		tq = new TextQuestion("what is the square root of 64?", "8", 1, "8", "16", "2");
		this.questions.add(tq);
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

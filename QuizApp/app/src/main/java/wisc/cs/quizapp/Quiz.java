package wisc.cs.quizapp;

import android.app.Activity;
import android.content.res.AssetManager;
import android.media.Image;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Quiz {

	private ArrayList<Question> questions;
	private int index;
	
	public Quiz() {
		this.questions = new ArrayList<Question>();	
		this.index = -1;
	}
	
	public void initializeQuiz(AssetManager assetManager, Activity activity) {
	/*
		ImageQuestion img = new ImageQuestion("what is the name of this school building?", "bascom hall", R.drawable.bascom_hall);
		this.questions.add(img);
		img = new ImageQuestion("what is the name of this abstract data type?", "binary search tree", R.drawable.binary_tree);
		this.questions.add(img);

		TextQuestion tq = new TextQuestion("how many days are there in a week?", "7", 3, "4", "2", "7");
		this.questions.add(tq);

		tq = new TextQuestion("what is the square root of 64?", "8", 1, "8", "16", "2");
		this.questions.add(tq);
*/

	//	AssetManager assetManager = getAssets();

		String[] imgQ = Data.imageQuestions;
		String[] textQ = Data.textQuestions;
		ArrayList<String> allQuestions = new ArrayList<String>();
		for(int i = 0; i < imgQ.length; i++) {
			allQuestions.add(imgQ[i]);
		}
		for(int i = 0; i < textQ.length; i++) {
			allQuestions.add(textQ[i]);
		}
		Collections.shuffle(allQuestions);
		String[] questions = new String[allQuestions.size()];
		questions = allQuestions.toArray(questions);

		for(int i = 0; i < questions.length; i++) {
			String question = questions[i];
			String[] tmp = question.split(",");
			if (tmp.length == 3) { // we have an image question
				String q = tmp[0].trim();
				String a = tmp[1].trim();
				String mDrawableName = tmp[2].trim();
				int resID = activity.getResources().getIdentifier(mDrawableName, "drawable", activity.getPackageName());
				ImageQuestion iq = new ImageQuestion(q, a, resID);
				this.questions.add(iq);
			} else if (tmp.length == 6) { // we have a text question
				String q = tmp[0].trim();
				String a = tmp[1].trim();
				int radioButtonAnswer = Integer.parseInt(tmp[2].trim());
				String radio1 = tmp[3].trim();
				String radio2 = tmp[4].trim();
				String radio3 = tmp[5].trim();
				TextQuestion tq = new TextQuestion(q, a, radioButtonAnswer, radio1, radio2, radio3);
				this.questions.add(tq);
			}
		}
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

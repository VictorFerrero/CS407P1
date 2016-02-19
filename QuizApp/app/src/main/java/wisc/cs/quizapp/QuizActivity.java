package wisc.cs.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Victor on 2/17/2016.
 */
public class QuizActivity
        extends AppCompatActivity
    implements ImageQuestionFragment.OnAnswerSubmittedListener, TextQuestionFragment.OnAnswerSubmittedListener

{

    private Quiz quiz;

    public void onAnswerSubmitted(ImageQuestion question, Fragment fragment) {
        // this is where control will be passed back
        // grab another question
       // String msg = question.toString();
       // Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        FragmentManager manager = ((Fragment) fragment).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) fragment);
        trans.commit();

        // now we would get the next question if it exists
        this.nextQuestion();
    }

    public void onAnswerSubmitted(TextQuestion question, Fragment fragment) {
        // this is where control will be passed back
        // grab another question
   //     String msg = question.toString();
   //     Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        FragmentManager manager = ((Fragment) fragment).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) fragment);
        trans.commit();

        // now we would get the next question if it exists
        this.nextQuestion();
    }

    private void nextQuestion() {
        Question question = this.quiz.getNextQuestion();
        if(question != null) {
            // Create a new Fragment to be placed in the activity layout
            ImageQuestion imageQ = null;
            TextQuestion textQ = null;
            if (question instanceof ImageQuestion) {
                imageQ = (ImageQuestion) question;
                ImageQuestionFragment imgFragment = new ImageQuestionFragment();
                imgFragment.setImageQuestion(imageQ);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, imgFragment).commit();
            } else if (question instanceof TextQuestion) {
                textQ = (TextQuestion) question;
                TextQuestionFragment textFragment = new TextQuestionFragment();
                textFragment.setTextQuestion(textQ);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, textFragment).commit();
            }
        }
        else {
            // the quiz is over
            double score =  this.quiz.gradeQuiz();
            Toast.makeText(getApplicationContext(), "QUIZ OVER", Toast.LENGTH_LONG).show();
        //    Toast.makeText(getApplicationContext(), "SCORE: " + score, Toast.LENGTH_LONG).show();
            Intent resultIntent = new Intent();
// TODO Add extras or a data URI to this intent as appropriate.
            resultIntent.putExtra("score", score);
            setResult(Activity.RESULT_OK, resultIntent);
            this.finish();
         //   Intent intent = new Intent(this, MainActivity.class);
          //  startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_quiz);
        super.onCreate(savedInstanceState);
        this.quiz = new Quiz();
        this.quiz.initializeQuiz(this.getAssets(), this);
        setContentView(R.layout.activity_quiz);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            this.nextQuestion();
        }
    }

    protected void onStart() {
        super.onStart();
     //   Toast.makeText(getApplicationContext(), "Your toast message", Toast.LENGTH_LONG).show();
    }

    protected void onRestart(){
        super.onRestart();
    }

    protected void onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
    }

    protected void onStop(){
        super.onStop();
    }

    protected void onDestroy(){
        super.onDestroy();
        this.quiz = null;
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this.getApplicationContext(), "You cannot go back to previous question.", Toast.LENGTH_LONG).show();
    }

}

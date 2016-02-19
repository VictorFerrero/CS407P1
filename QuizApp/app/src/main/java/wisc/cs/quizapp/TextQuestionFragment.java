package wisc.cs.quizapp;

/**
 * Created by Victor on 2/17/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TextQuestionFragment
        extends Fragment
        implements View.OnClickListener{

    private OnAnswerSubmittedListener mCallback;
    private TextQuestion question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView view = inflater.inflate(R.layout.fragment_rssitem_detail,
        View view = inflater.inflate(R.layout.text_question_fragment, container, false);
        // get the question string and put it into the TextView
        TextView tv = (TextView) view.findViewById(R.id.question);
        String question = this.question.getQuestion();
        char[] charSeq = question.toCharArray();
        tv.setText(charSeq, 0, charSeq.length);

        // now grab the possible answers for this question,
        // and put them in the radio buttons
        String[] possibleAnswers = this.question.getPossibleAnswers();
        // #1
        RadioButton rb = (RadioButton) view.findViewById(R.id.radio1);
        charSeq = possibleAnswers[0].toCharArray();
        rb.setText(charSeq, 0, charSeq.length);
        // #2
        rb = (RadioButton) view.findViewById(R.id.radio2);
        charSeq = possibleAnswers[1].toCharArray();
        rb.setText(charSeq, 0, charSeq.length);
        // #3
        rb = (RadioButton) view.findViewById(R.id.radio3);
        charSeq = possibleAnswers[2].toCharArray();
        rb.setText(charSeq, 0, charSeq.length);
        return view;
    }

    // Container Activity must implement this interface
    public interface OnAnswerSubmittedListener {
        public void onAnswerSubmitted(TextQuestion question, Fragment fragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        if(context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                this.mCallback = (OnAnswerSubmittedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        } else {
            throw new ClassCastException("context is not activity");
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // we need to bind the three radio buttons to their onClickListener
        RadioButton res1 = (RadioButton) getActivity().findViewById(R.id.radio1);
        res1.setOnClickListener(this);

        res1 = (RadioButton) getActivity().findViewById(R.id.radio2);
        res1.setOnClickListener(this);

        res1 = (RadioButton) getActivity().findViewById(R.id.radio3);
        res1.setOnClickListener(this);
    }

// onClick handler for the radio buttons
    public void onClick(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        int choice = -1;
        // Check which radio button was clicked
        if(checked) {
            switch (v.getId()) {
                case R.id.radio1:
                        choice = 1;
                        break;
                case R.id.radio2:
                        choice = 2;
                        break;
                case R.id.radio3:
                        choice = 3;
                        break;
            }
            this.question.setUserAnswer(choice);
            this.mCallback.onAnswerSubmitted(this.question, this); // pass the caller and the fragment back to QuizActivity
        }
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this.getContext(), "You cannot go back to previous question.", Toast.LENGTH_LONG).show();
    }

    public void setTextQuestion(TextQuestion q) {
        this.question = q;
    }

    public void onStart() {
        super.onStart();
    }

    // public void onRestart(){
//        super.onRestart();
    //  }

    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    public void onStop(){
        super.onStop();
    }

    public void onDestroy(){
        super.onDestroy();
        this.question = null;
        this.mCallback = null;
    }
}

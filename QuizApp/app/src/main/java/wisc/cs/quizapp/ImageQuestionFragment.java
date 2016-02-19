package wisc.cs.quizapp;

/**
 * Created by Victor on 2/17/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageQuestionFragment
        extends Fragment
implements View.OnClickListener{

    private OnAnswerSubmittedListener mCallback;
    private ImageQuestion question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView view = inflater.inflate(R.layout.fragment_rssitem_detail,
        View view = inflater.inflate(R.layout.image_question_fragment,
                container, false);

        // initialize the ImageView
        ImageView img= (ImageView) view.findViewById(R.id.imageView);
        int imageId = this.question.getId();
        img.setImageResource(imageId);
        // initialize the text view with the question
        TextView question = (TextView) view.findViewById(R.id.question);
        char[] stringSequence = this.question.getQuestion().toCharArray();
        question.setText(stringSequence, 0, stringSequence.length);

        // set onTouch listener for EditText.
        // we want to clear the text inside the edit text box when they click it
        EditText mEditInit = (EditText) view.findViewById(R.id.imageQuestionAnswer);
        mEditInit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch (View v, MotionEvent motionEvent) {
                EditText e = (EditText) v.findViewById(R.id.imageQuestionAnswer);
                e.setText(new char[' '], 0, 1);
                return false;
            }
        });
        return view;
    }

    // Container Activity must implement this interface
    public interface OnAnswerSubmittedListener {
        public void onAnswerSubmitted(ImageQuestion question, Fragment fragment);
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
        Button res1 = (Button) getActivity().findViewById(R.id.submit);
        res1.setOnClickListener(this);
    }

    public void onClick(View v) {
        EditText answer = (EditText) this.getActivity().findViewById(R.id.imageQuestionAnswer);
        String message = (answer.getText().toString()).toLowerCase();
        message = message.trim();
        this.question.setUserAnswer(message);
        this.mCallback.onAnswerSubmitted(this.question, this);
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this.getContext(), "You cannot go back to previous question.", Toast.LENGTH_LONG).show();
    }

    public void setImageQuestion(ImageQuestion q) {
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

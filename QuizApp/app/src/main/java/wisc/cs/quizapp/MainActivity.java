package wisc.cs.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    // this allows MainActivity to specify a call back function for the quiz
    // activity to send an intent back too
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Button submit = (Button) this.findViewById(R.id.startQuizButton);
        String s = "Try Again"; // change the button name
        char[] seq = s.toCharArray();
        submit.setText(seq, 0, seq.length);
        TextView tv = (TextView) this.findViewById(R.id.welcomeText);
        tv.setText(new char[' '], 0, 1); // get rid of welcome message
        if (resultCode == Activity.RESULT_OK) {
            // TODO Extract the data returned from the child Activity.
            double score = data.getDoubleExtra("score", -1.0);
            tv = (TextView) this.findViewById(R.id.score);
            String s1 = "You score was " + Double.toString(this.RoundTo2Decimals(score)) + "%";
            seq = s1.toCharArray();
            tv.setText(seq, 0, seq.length);
          //  Toast.makeText(getApplicationContext(), "SCORE: " + score, Toast.LENGTH_LONG).show();
        }
        else {
            // error state
        }
    }

    private double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }

    protected void onStart() {
        super.onStart();
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
    }

    public void onStartQuizButtonPress(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
      //  EditText editText = (EditText) findViewById(R.id.edit_message);
     //   String message = editText.getText().toString();
     //   intent.putExtra(EXTRA_MESSAGE, message);
       // startActivity(intent);
       // Toast.makeText(getApplicationContext(), "Your toast message", Toast.LENGTH_LONG).show();
        /*
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

         */
        int requestCode = 10; // just to satisfy the below function call
       this.startActivityForResult(intent, requestCode);
    }

    public void quit (View view) {
        this.finish();
    }
}
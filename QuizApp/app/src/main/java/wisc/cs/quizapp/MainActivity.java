package wisc.cs.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



/*
release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            // TODO Extract the data returned from the child Activity.
            double score = data.getDoubleExtra("score", -1.0);
            Toast.makeText(getApplicationContext(), "SCORE: " + score, Toast.LENGTH_LONG).show();
        }

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
        int requestCode = 10;
        startActivityForResult(intent, requestCode);
    }
}

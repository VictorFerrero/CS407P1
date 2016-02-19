package wisc.cs.quizapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Victor on 2/18/2016.
 */
public class Data {

    private static String[] imageQuestions = {
            // format: question, answer, string representation of the image id stored in R.drawable
            "What is the name of this school building?, bascom hall," +  Integer.toString(R.drawable.bascom_hall),
            "What is the name of this abstract data type?, binary search tree," + Integer.toString(R.drawable.binary_tree),
            "How many more Super Bowls does this quarterback have compared with Aaron Rodgers?, 3," + Integer.toString(R.drawable.tombrady)

    } ;

    private static String[] textQuestions = {
            // radioButtonAnswer range of possible values 1 <= x <= 3
            // possible answers can be any string
            // format: question, answer, radioButtonAnswer, radio1PossibleAnswer, radio2, radio3
            "How many days are there in a week?,7,3,4,2,7",
            "What is the square root of 64?,8,1,8,16,2",
            "Who was the first president of the United States?, George Washington, 2, Suman Banerjee, George Washington, Bill Clinton"
    };

    public static String[] getQuestions() {
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
        return questions;
    }

}

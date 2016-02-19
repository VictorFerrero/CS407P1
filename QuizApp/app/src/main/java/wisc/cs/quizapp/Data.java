package wisc.cs.quizapp;

/**
 * Created by Victor on 2/18/2016.
 */
public class Data {

    public static String[] imageQuestions = {
            // format: question, answer, string representation of the image id stored in R.drawable
            "what is the name of this school building?, bascom hall," +  Integer.toString(R.drawable.bascom_hall),
            "what is the name of this abstract data type?, binary search tree," + Integer.toString(R.drawable.binary_tree),

    } ;

    public static String[] textQuestions = {
            // radioButtonAnswer range of possible values 1 <= x <= 3
            // possible answers can be any string
            // format: question, answer, radioButtonAnswer, radio1PossibleAnswer, radio2, radio3
            "how many days are there in a week?,7,3,4,2,7",
            "what is the square root of 64?,8,1,8,16,2"
    };

}

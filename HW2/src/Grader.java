
import java.util.ArrayList;

/**
 * 
 */
public abstract class Grader {

    /**
     * Default constructor
     */
    public Grader() {
    }

    /**
     * 
     */
    private ArrayList<ResponseCorrectAnswer> correctAnswers;

    /**
     * 
     */
    private ArrayList<ResponseCorrectAnswer> userAnswers;

    /**
     * 
     */
    private float score;


    /**
     * @return
     */
    public float Grader() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public void show() {
        // TODO implement here
    }

    /**
     * @return
     */
    public ResponseCorrectAnswer getCorrectAnswers() {
        // TODO implement here
        return null;
    }

    /**
     * @param ResponseCorrectAnswer ans 
     * @return
     */
    public void setCorrectAnswers( ResponseCorrectAnswer ans) {
        // TODO implement here
    }

    /**
     * @param float newGrade 
     * @return
     */
    public void editGrade( float newGrade) {
        // TODO implement here
    }

}
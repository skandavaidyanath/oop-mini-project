import java.io.Serializable;


public class Question implements Serializable {
	
	int questionId;
	String instructions;
	String question;
	String answer;
	Question()
	{
		questionId = 0;
		instructions = "";
		question = "";
		answer = "";
	}
	int getQuestionId()
	{
		return questionId;
	}
	String getQuestion()
	{
		return question;
	}
	String getAnswer()
	{
		return answer;
	}
	public String toString()
	{
		return question;
	}
	
}

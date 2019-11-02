import java.io.Serializable;


public class FBQuestion extends Question implements Serializable {

	
	FBQuestion()
	{
		instructions = "This is a simple Fill in the Blanks question. Answer the question in one word only. Good Luck!";
	}
	String getInstructions()
	{
		return instructions;
	}
	public String toString()
	{
		return question;
	}

}

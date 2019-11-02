import java.io.Serializable;


public class TFQuestion extends Question implements Serializable {
	
	TFQuestion()
	{
		instructions = "This is a simple True or False question. Choose the appropriate option. Good Luck!";
	}
	String getInstructions()
	{
		return instructions;
	}
}

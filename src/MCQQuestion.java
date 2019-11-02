import java.io.Serializable;


public class MCQQuestion extends Question implements Serializable {
	
	String[] options;
	MCQQuestion()
	{
		options  = new String[4];
		instructions = "This is a simple Multiple Choice question. There is only one right answer. Choose the most appropriate answer from the options given. Good Luck!";
	}
	String getInstructions()
	{
		return instructions;
	}
	public String toString()
	{
		return question + " (a)" + options[0] + " (b)" + options[1] + " (c)" + options[2] + " (d)" + options[3];
	}

}

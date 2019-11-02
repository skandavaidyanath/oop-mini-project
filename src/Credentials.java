import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Credentials implements Serializable {

	String username;
	String password;
	void changeUsername()
	{
		/*Scanner sc  = new Scanner(System.in);
		System.out.println("Enter new username:");
		String newUser = sc.next();
		//write the new username into the file creds
		System.out.println("Username Successfully changed");
		sc.close();*/
	}
	void changePassword()
	{
		/*Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter new password");
		String newPass1 = sc1.next();
		System.out.println("Retype password for confirmation:");
		String newPass2 = sc2.next();
		try
		{
			if(newPass1 == newPass2) 
			{
				//write the password into the file creds
				System.out.println("Password Successfully changed");
			}
		catch(InvalidPasswordException e)
		{
			JOptionPane.showMessageDialog(null,"The two passwords don't match","Error message", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			//takes user back to the menu screen
		}*/
	}
	String getUsername()
	{
		return username; 
	}
	String getPassword()
	{
		return password;
	}
	
}

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RunApp {
	
	static QuestionBank physics = new QuestionBank();
	static QuestionBank chemistry = new QuestionBank();
	static QuestionBank math = new QuestionBank();
	static QuestionBank current;
	static String subject;
	static ArrayList<Credentials> creds = new ArrayList<Credentials>();
	static void setup()
	{
		try
		{
			FileInputStream fis = new FileInputStream("creds.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Credentials c;
			try
			{
				while(true)
				{
					c = (Credentials) ois.readObject();
					creds.add(c);
				}
			}
			catch(EOFException exc)
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("phyTF.txt");
			ois = new ObjectInputStream(fis);
			TFQuestion ptf = new TFQuestion();
			try
			{
				while(true)
				{
					ptf = (TFQuestion) ois.readObject();
					physics.tfquiz.add(ptf);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("phyFB.txt");
			ois = new ObjectInputStream(fis);
			FBQuestion pfb = new FBQuestion();
			try
			{
				while(true)
				{
					pfb = (FBQuestion) ois.readObject();
					physics.fbquiz.add(pfb);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("phyMCQ.txt");
			ois = new ObjectInputStream(fis);
			MCQQuestion pmc = new MCQQuestion();
			try
			{
				while(true)
				{
					pmc = (MCQQuestion) ois.readObject();
					physics.mcqquiz.add(pmc);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("chemTF.txt");
			ois = new ObjectInputStream(fis);
			TFQuestion ctf = new TFQuestion();
			try
			{
				while(true)
				{
					ctf = (TFQuestion) ois.readObject();
					chemistry.tfquiz.add(ctf);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("chemFB.txt");
			ois = new ObjectInputStream(fis);
			FBQuestion cfb = new FBQuestion();
			try
			{
				while(true)
				{
					cfb = (FBQuestion) ois.readObject();
					chemistry.fbquiz.add(cfb);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("chemMCQ.txt");
			ois = new ObjectInputStream(fis);
			MCQQuestion cmc = new MCQQuestion();
			try
			{
				while(true)
				{
					cmc = (MCQQuestion) ois.readObject();
					chemistry.mcqquiz.add(cmc);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("mathTF.txt");
			ois = new ObjectInputStream(fis);
			TFQuestion mtf = new TFQuestion();
			try
			{
				while(true)
				{
					mtf = (TFQuestion) ois.readObject();
					math.tfquiz.add(mtf);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("mathFB.txt");
			ois = new ObjectInputStream(fis);
			FBQuestion mfb = new FBQuestion();
			try
			{
				while(true)
				{
					mfb = (FBQuestion) ois.readObject();
					math.fbquiz.add(mfb);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			fis = new FileInputStream("mathMCQ.txt");
			ois = new ObjectInputStream(fis);
			MCQQuestion mmc = new MCQQuestion();
			try
			{
				while(true)
				{
					mmc = (MCQQuestion) ois.readObject();
					math.mcqquiz.add(mmc);
				}
			}
			catch(EOFException exc)
			{
			}
			finally
			{
				ois.close();
				fis.close();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	static void writeTF(String filename)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Question i : current.tfquiz)
			{
				oos.writeObject(i);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void writeFB(String filename)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Question i : current.fbquiz)
			{
				oos.writeObject(i);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void writeMCQ(String filename)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Question i : current.mcqquiz)
			{
				oos.writeObject(i);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void writeCredentials()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("creds.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Credentials i : creds)
			{
				oos.writeObject(i);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		setup();
		LoginForm login = new LoginForm();
		login.setVisible(true);
	}
		
	

}

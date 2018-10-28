
import java.io.FileReader;
import java.io.BufferedReader;
public class EasyReader {
	public static String EasyRead(String Loc)
	{
		try
		{
			String tempString = "";
			String tempStringSigma = "";
			BufferedReader B = new BufferedReader(new FileReader(Loc));			
			while((tempString = B.readLine()) != null)
			{
				tempStringSigma += tempString;
			}
			B.close();
			return tempStringSigma;			
		}
		catch(Exception E )
		{
				return E.toString();
		}	
	}
}

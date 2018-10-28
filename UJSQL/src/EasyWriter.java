

import java.io.FileWriter;
import java.io.BufferedWriter;

public class EasyWriter {
	public static boolean EasyWrite(String Loc, String Data)
	{
		try
		{
			BufferedWriter W = new BufferedWriter(new FileWriter(Loc));
			W.write(Data);
			W.close();
			return true;
		}
		catch (Exception E)
		{
			return false;
		}		
	}
}

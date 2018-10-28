

public class masterControler {
	public static void masterControlerDo()
	{
		/*
		 jdbc:sqlserver://localhost:55708;databaseName=LEXICON; 
		 SunocastUser 
		 Kana$12345 
		 SQLSTATMENT	  	 
		 */
			String conString = "jdbc:sqlserver://localhost:55708;databaseName=CROWDB;";
			String userName = "SunocastUser";
			String password = "Kana$12345";
			String SqlText = "SELECT * FROM [BIRDS]";
			
			databaseComlink tempCom = new databaseComlink();
			System.out.println(
					"Connection Set:" + 
					tempCom.setConnectionSettings(conString, userName, password)
			);
			

			
			System.out.println(
					"Connection Connected:" + 
					tempCom.makeConnection()
			);
			System.out.print(tempCom.getErrorLog());
			System.out.println(
				"Data Extracted:" + 										
				tempCom.SQLtoString(SqlText)			
			);
			
			System.out.println(
					"Connection Closed:" + 
					tempCom.closeConnection()
			);
			
		}
	}
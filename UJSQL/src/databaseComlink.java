
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class databaseComlink {

	private boolean isConnected = false;	
	private Connection internalConnection;
	private String errorLog = "[empty log]\n";
	private String connectionString;
	private String userName;
	private String password;
	
	
	public databaseComlink()
	{		
	}
				
	public databaseComlink(String connectionString, String userName, String password)
	{
		this.connectionString = connectionString;
		this.userName = userName;
		this.password = password;
		this.isConnected = false;
		
		/* 
		IMPLAMENT!
		  	This will set the values for 
		 	private String connectionString;
			private String userName;
			private String password;
			with the constructor arguments. 
		 */
	}
	
	public Boolean setConnectionSettings(String connectionString, String userName, String password)
	{
		if(!this.isConnected)
		{
			this.connectionString = connectionString;
			this.userName = userName;
			this.password = password;			
			return true;
		}
		else 
		{
			return false;
		}
		/* 
		IMPLAMENT!
		  	This will set the values for 
		 	private String connectionString;
			private String userName;
			private String password;
			and return true if the object isn't 
			connected otherwise it will not 
			change the objects state and return false.  
		 */

	}
	public String getErrorLog()
	{
		/* 
		IMPLAMENT!
			this is a getter for errorLog.
		 */
		return this.errorLog;
	}
	
	public Boolean getIsConnected()
	{
		/* 
		IMPLAMENT!
			this is a getter for isConnected
		 */		
		return this.isConnected;
	}
	
	public Boolean testConnection()
	{
		try
		{
			internalConnection = DriverManager.getConnection(
					this.connectionString, 
					this.userName, 
					this.password
					);	
			internalConnection.close();
			return true;
		}
		catch(Exception E)
		{
			this.errorLog += E.toString();
			return false;
		}
		/* 
		IMPLAMENT!
			This will attempt to make a connection then close said 
			connection. This will return true if the connection 
			was successful otherwise it will return false. 
			
			this.errorLog will be written with any relevant information 
			in the event of an error.
		 */		
	}	
	
	public Boolean makeConnection()
	{
		try
		{
			internalConnection = DriverManager.getConnection(
					this.connectionString, 
					this.userName, 
					this.password
					);	
			return true;
		}
		catch(Exception E)
		{
			this.errorLog += E.toString();
			return false;
		}				
		/* 
		IMPLAMENT!
			This will connect to a database based on what 
			connectionString, userName and password are set to. 
			If the connection fails this method shall return 
			false otherwise it should set this.isConnected to true 
			and return true.	
			
			this.errorLog will be written with any relevant information 
			in the event of an error.
		 */

	}

	public Boolean closeConnection()
	{
		try
		{
			this.internalConnection.close();
			this.isConnected = false;
			return true;
		}
		catch(Exception E)
		{
			this.errorLog += E.toString();
			return false;
		}	
		
		/* 
		IMPLAMENT!
			This will attempt to close any open connection. 
			If there is no connection or it fails to close 
			the open one this method will return false.
			Before returning isConnected will be set accordingly.
			
			this.errorLog will be written with any relevant information 
			in the event of an error.
		 */

	}
	
	public String SQLtoString(String sqlString)
	{
		try
		{
			String tempString = "";
			ResultSet tempResultSet = this.internalConnection.createStatement().executeQuery(sqlString);
			ResultSetMetaData tempResultSetMetaData = tempResultSet.getMetaData();
			int tempCollCount = tempResultSetMetaData.getColumnCount();
			for(int i = 1;i<= tempCollCount;i++)
			{
				tempString += tempResultSetMetaData.getColumnName(i);
				if(i<= tempCollCount -1)
				{
					tempString += ",";
				}					
			}
			tempString += "\n";
			while(tempResultSet.next())
			{
				for(int i=1;i<=tempCollCount;i++)
				{
					tempString += tempResultSet.getString(tempResultSetMetaData.getColumnName(i));
					if(i<= tempCollCount -1)
					{
						tempString += ",";
					}
				}
				tempString += "\n";
			}
			//tempResultSetMetaData.getcol
			
			return tempString;
		}
		catch(Exception E)
		{
			this.errorLog += E.toString();
			return null;
		}
		/* 
		IMPLAMENT!
			Execute the passed sqlString on any open connection then 
			return all results in the form of a string. If the operation 
			fails this function should return null 
		 */
		
	}
	
	@Override
	public String toString() {
		return "databaseComlink [isConnected=" + isConnected + ", internalConnection=" + internalConnection
				+ ", errorLog=" + errorLog + ", connectionString=" + connectionString + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
}

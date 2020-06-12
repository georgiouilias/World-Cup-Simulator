import java.io.*;

class UserInput
{
	static int getInteger()
	{
		String line;
		InputStreamReader eisodosString = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(eisodosString);
		try
		{
			line=br.readLine();
			int i=Integer.parseInt(line);
			return i;
		}
		catch(Exception e) {
		return -1;
		}
	}
	static float getFloat()
	{
		String line;
		InputStreamReader eisodosString = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(eisodosString);
		try
		{
			line = br.readLine();
			float i = Float.parseFloat(line);
			return i;
		}
		catch(Exception e) {
		return -1;
		}
	}
	static long getLong()
	{
		String line;
		InputStreamReader eisodosString = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(eisodosString);
		try
		{
			line = br.readLine();
			long i = Long.parseLong(line);
			return i;
		}
		catch(Exception e) {
		return -1;
		}
	}
	static short getShort()
		{
			String line;
			InputStreamReader eisodosString = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(eisodosString);
			try
			{
				line = br.readLine();
				short i = Short.parseShort(line);
				return i;
			}
			catch(Exception e)
			{
			return -1;
			}
		}
	static double getDouble()
		{
			String line;
			InputStreamReader eisodosString = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(eisodosString);
			try
			{
				line = br.readLine();
				double i = Double.parseDouble(line);
				return i;
			}
			catch(Exception e)
			{
			return -1;
			}
		}
	static char getChar()
		{
			String line;
			InputStreamReader eisodosString = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(eisodosString);
			try
			{
				line = br.readLine();
				char i = (char)br.read();
				return i;
			}
			catch(Exception e)
			{
			return '\0';
			}
		}
	static String getString()
		{
			String line;
			InputStreamReader eisodosString = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(eisodosString);
			try
			{
				line = br.readLine();
				String i = line;
				return i;
			}
			catch(Exception e)
			{
			return "-1";
			}
		}
}
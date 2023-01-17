public class FileUtils{
	public static java.util.Scanner openToRead(String name){
		try{
		return new java.util.Scanner(new java.io.File(name));
		}catch(Exception e){
			return null;
		}
	}
	public static java.io.PrintWriter openToWrite(String name){
		try{
			return new java.io.PrintWriter(name);
		}catch(Exception e){
			return null;
		}
	}
}

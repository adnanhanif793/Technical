package Pattern;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class Sikuli {

public static void main(String[] args) throws Exception {
		
Screen s = new Screen();
	
	Pattern gmail = new Pattern("C:\\Users\\adnan.hanif\\Desktop\\mini.PNG");
	s.wait(gmail, 3);
	s.click(gmail);
	s.type(gmail, "jhs");




}


}










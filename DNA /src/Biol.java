import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Biol {

	static Element[] sequenceArray;
	static int index = 0;
	
	public static void main(String[] args) throws IOException {
		Integer size = Integer.parseInt(args[0]);
		sequenceArray = new Element[size];
		String filePath = args[1];
		String contents = new String(Files.readAllBytes(Paths.get(filePath)));
		String[] command = contents.split("\\s+");
		
		execute(command);
		
	}
	
	public enum Type {DNA, RNA, UNUSED}
	
	public static void execute(String[] command) {
		
	if (command[0].equals("insert")) {
		Integer pos = Integer.parseInt(command[1]);
		assert (pos < sequenceArray.length) && (pos > 0): "Illegal position";
		Element.Type t;
		if(command[1].equals("DNA")) {
			t = Element.Type.DNA;
		}
		if (command[1].equals("RNA")) {
			t = Element.Type.RNA;
		}else {
			t = Element.Type.UNUSED;
		}
		
		lab4linked<String> l = new lab4linked<String>();
		l.insert(command[2]);
		
		Element e = new Element(t,l);
		sequenceArray[index] = e;
		index++;
	}
	if (command[0].equals("remove")) {
		Integer pos = Integer.parseInt(command[1]);
		assert (pos < sequenceArray.length) && (pos > 0): "Illegal position";
		Element.Type t;
		if(command[1].equals("DNA")) {
			t = Element.Type.DNA;
		}
		if(command[1].equals("RNA")) {
			t = Element.Type.RNA;
		} else {
			t = Element.Type.UNUSED;
		}
		
		sequenceArray[pos].setL(new lab4linked());	

	}
	
	
}
}
package rough;
import java.io.File;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

public class DirectAutoIT {
	public static void main(String[] args) throws InterruptedException {
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")){
			jacobDllVersionToUse = "jacob-1.18-x86.dll";
		}
		else {
			jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}

		File file = new File("mandatory_Jars", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		   String notepad = "Untitled - Notepad";
		   String testString = "this is a test.";
		AutoItX x = new AutoItX();
		  x.run("notepad.exe");
		    x.winActivate(notepad);
		    x.winWaitActive(notepad);
		    x.send(testString);
		    x.winClose(notepad, testString);
		    x.winWaitActive("Notepad");
		    x.send("{ALT}n");
	}
	
	public static String jvmBitVersion(){
		return System.getProperty("sun.arch.data.model");
	}
}

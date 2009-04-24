import java.io.File;
import java.net.MalformedURLException;
import java.applet.*;


public class UsingAudioClip {
	public static void main(String args[]){
		String fileName="F:/lanlianhua.wav";
		File file=new File(fileName);
		java.applet.AudioClip clip;
		try{
			clip=java.applet.Applet.newAudioClip(file.toURL());
			clip.play();
			System.out.println("Playin now!");
		}catch(MalformedURLException e){
//			e.printStackTrace();
		}
		
	}
}

import java.io.IOException;
import java.net.MalformedURLException;
import javax.media.*;


public class PlayRTP {
	Player player=null;
	
	public static void main(String args[]){
		PlayRTP play=new PlayRTP();
		play.playRTP();
	}
	
	public  void  playRTP(){
//		String url= "rtp://224.144.251.104:49150/audio/1";
		String url= "rtp://192.168.1.200:8000/audio/0";
	 
		MediaLocator mrl= new MediaLocator(url);
    
		if (mrl == null) {
			System.err.println("Can't build MRL for RTP");
//			return false;
		}
    
    // Create a player for this rtp session
    try {
        player = Manager.createPlayer(mrl);
    } catch (NoPlayerException e) {
        System.err.println("Error:" + e);
 //       return false;
    } catch (MalformedURLException e) {
        System.err.println("Error:" + e);
//        return false;
    } catch (IOException e) {
        System.err.println("Error:" + e);
 //       return false;
    }
    System.out.println("It's here！！Line n-1");
    System.out.println(player);
    if (player != null) {
        if (this.player == null) {


            this.player = player;
            player.addControllerListener((ControllerListener) this);
            player.realize();
            System.out.println("It's here！！Line n");
            player.start();
            System.out.println("It's here！！Line n+1");
        }
    }
    System.out.println("It's here！！Line n");

    

    
	}



}

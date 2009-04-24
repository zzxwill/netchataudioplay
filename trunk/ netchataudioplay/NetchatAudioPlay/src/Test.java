import javax.media.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
/*
 * 一个简单的音频播放器(JMF的HelloWorld应用)
 */
public class Test {
	/*
	 * The javax.media包是由JMF定义的多个包之一。
	 * javax.media是一个核心包，包括了定义Manager类和Player接口等
	 */
	
	private Player audioPlayer = null;

	
	/*
	 * Manager类在JMF中如同一个工厂制作许多的特殊接口类型，
	 * 包括Player接口。
	 * 因此，Manager类的责任就是创建Player实例
	 */
	
	
	/*
	 * 调用一个createRealizedPlayer()方法来阻塞调用线程，直到player达到Realized状态。
	 * 为了调用一个无阻塞的创建player的方法，我们在Manager类中使用了一个createPlayer()方法。
	 */
	public void SimpleAudioPlayer(URL url) throws IOException,NoPlayerException,CannotRealizeException
	{
		audioPlayer = Manager.createRealizedPlayer(url);
	}
	
	
	/*
	 * 将File 转化为URL
	 */
	public URL SimpleAudioPlayer(File file) throws IOException,NoPlayerException,CannotRealizeException
	{
		return file.toURL();
	}
	
	/*
	 * Player实例的启动
	 */
	
	public void play() {
		audioPlayer.start();
	}
	public void stop() {
		audioPlayer.stop();
		audioPlayer.close();
	}
	
	
	
	public static void main(String args[]){
		Test test=new Test();
		File file=new File("F:/lanlianhua.wav");
		
		try{
			test.SimpleAudioPlayer(test.SimpleAudioPlayer(file));
		}catch(Exception e){
			System.out.println("Wrong occurs!");
		}
		
		/*
		 * 对于读取和或者播放本地媒体文件来说，关闭Player实例释放所有资源是一个有用的方法。
		 * 因为这是一个简单的例子，关闭Player是终止一个会话可接受的方法。
		 * 但是在实际的应用中，你需要小心的确认在除掉Player之前必须要关闭掉。
		 * 一但你已经关闭掉player，在再次播放一个媒体之前你必须要创建一个新的Player实例

		 */
		test.play();
		
		
	}

}

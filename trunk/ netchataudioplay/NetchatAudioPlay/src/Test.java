import javax.media.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
/*
 * һ���򵥵���Ƶ������(JMF��HelloWorldӦ��)
 */
public class Test {
	/*
	 * The javax.media������JMF����Ķ����֮һ��
	 * javax.media��һ�����İ��������˶���Manager���Player�ӿڵ�
	 */
	
	private Player audioPlayer = null;

	
	/*
	 * Manager����JMF����ͬһ������������������ӿ����ͣ�
	 * ����Player�ӿڡ�
	 * ��ˣ�Manager������ξ��Ǵ���Playerʵ��
	 */
	
	
	/*
	 * ����һ��createRealizedPlayer()���������������̣߳�ֱ��player�ﵽRealized״̬��
	 * Ϊ�˵���һ���������Ĵ���player�ķ�����������Manager����ʹ����һ��createPlayer()������
	 */
	public void SimpleAudioPlayer(URL url) throws IOException,NoPlayerException,CannotRealizeException
	{
		audioPlayer = Manager.createRealizedPlayer(url);
	}
	
	
	/*
	 * ��File ת��ΪURL
	 */
	public URL SimpleAudioPlayer(File file) throws IOException,NoPlayerException,CannotRealizeException
	{
		return file.toURL();
	}
	
	/*
	 * Playerʵ��������
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
		 * ���ڶ�ȡ�ͻ��߲��ű���ý���ļ���˵���ر�Playerʵ���ͷ�������Դ��һ�����õķ�����
		 * ��Ϊ����һ���򵥵����ӣ��ر�Player����ֹһ���Ự�ɽ��ܵķ�����
		 * ������ʵ�ʵ�Ӧ���У�����ҪС�ĵ�ȷ���ڳ���Player֮ǰ����Ҫ�رյ���
		 * һ�����Ѿ��رյ�player�����ٴβ���һ��ý��֮ǰ�����Ҫ����һ���µ�Playerʵ��

		 */
		test.play();
		
		
	}

}

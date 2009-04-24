
import java.io.IOException;
import java.util.Vector;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.DataSink;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoDataSinkException;
import javax.media.NoProcessorException;
import javax.media.Processor;
import javax.media.control.StreamWriterControl;
import javax.media.format.AudioFormat;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;

import jmapps.util.StateHelper;

public class CaptureAudio {
      /**
       * Writing captured audio to a file with a DataSink. 
       */
      public static void main(String[] args) {
           CaptureDeviceInfo di = null;
          Processor p = null;
          StateHelper sh = null;
//��ѯCaptureDeviceManager������λ����Ҫʹ�õ�ý��ɼ��豸��
          Vector deviceList = CaptureDeviceManager.getDeviceList(new
                           AudioFormat(AudioFormat.LINEAR, 44100, 16, 2));
            if (deviceList.size() > 0){
//�õ����豸��CaptureDeviceInfoʵ����
                di = (CaptureDeviceInfo)deviceList.firstElement();
                }
            else
                // �Ҳ������㣨linear, 44100Hz, 16 bit,stereo audio.����Ƶ�豸���˳���
                System.exit(-1);
            try {
             //���MediaLocator�����ɴ˴���һ��Processor��
                  p = Manager.createProcessor(di.getLocator());
                sh = new StateHelper(p);
             } catch (IOException e) {
                  e.printStackTrace();
                System.exit(-1);
            } catch (NoProcessorException e) {
                  e.printStackTrace();
                System.exit(-1);
            }
            // Configure the processor
            if (!sh.configure(10000)){
                  System.out.println("configure wrong!");
                System.exit(-1);
                }
            //������洢��ý����������ͣ�content type����
            p.setContentDescriptor(new
                        FileTypeDescriptor(FileTypeDescriptor.WAVE));
         // realize the processor.
            if (!sh.realize(10000)){
                  System.out.println("realize wrong!");
                System.exit(-1);
                }
            // get the output of the processor
           DataSource source = p.getDataOutput();
         //����洢��ý����ļ���
           MediaLocator dest = new MediaLocator(new java.lang.String(
                 "file:///F:lanlianhua.wav"));
         //����һ�����ݳ�
            DataSink filewriter = null;
            try {
                filewriter = Manager.createDataSink(source, dest);
                filewriter.open();
            } catch (NoDataSinkException e) {
                  e.printStackTrace();
                System.exit(-1);
            } catch (IOException e) {
                  e.printStackTrace();
                System.exit(-1);
            } catch (SecurityException e) {
                  e.printStackTrace();
                System.exit(-1);
            }
            // if the Processor implements StreamWriterControl, we can
            // call setStreamSizeLimit
            // to set a limit on the size of the file that is written.
            StreamWriterControl swc = (StreamWriterControl)
                p.getControl("javax.media.control.StreamWriterControl");
            //set limit to 5MB
            if (swc != null)
                swc.setStreamSizeLimit(5000000);
            // now start the filewriter and processor
            try {
                filewriter.start();
            } catch (IOException e) {
                  e.printStackTrace();
                System.exit(-1);
            }
            // Capture for 5 seconds
            sh.playToEndOfMedia(5000);
            sh.close();
            // Wait for an EndOfStream from the DataSink and close it...
            filewriter.close();
      }
}

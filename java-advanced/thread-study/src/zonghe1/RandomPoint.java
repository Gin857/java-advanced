//package zonghe1;
//
//import javax.swing.*;
//import java.applet.Applet;
//import java.applet.AudioClip;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class RandomPoint implements Runnable {
//    private JFileChooser fileChooser;
//    @Override
//    public void run() {
//        fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File("D:\\yy"));
//        File[] file1 = fileChooser.getSelectedFiles();
//        URL url;
//        File file = new File("D:\\yy\\1.mp3");
//        try {
//            url = file.toURL();
//            AudioClip audioClip = Applet.newAudioClip(url);
//            audioClip.play();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//}

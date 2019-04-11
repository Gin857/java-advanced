package week1;

import javax.swing.*;

/**
 * @author xupeng
 * 2019.4.12
 */
public class NumberThread implements Runnable {
    private JLabel numLabel;
    public void setNumLabel (JLabel numLabel){
        this.numLabel=numLabel;
    }
    private final Object lock=new Object();
    private boolean pause =false;
    /*
    调用该方法的实现线程的暂停
     */
    void pauseThread(){
        pause=true;
    }
    /*
    调用该方法的实现线程的运行
     */
    void resumeThread(){
        pause=false;
        synchronized (lock){
            lock.notify();
        }
    }
    /*
    之歌方法只可以在run中实现，不然会阻止主线程，导致页面无响应
     */
    void onPause(){
        synchronized (lock){
            try{
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run () {
        int index=0;
        while (true){
            while (pause){
                onPause();
            }
            try{
                numLabel.setText(String.valueOf(index));
                Thread.sleep(500);
                ++index;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


package timer;

import java.util.Timer;
import java.util.TimerTask;

public class M {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),1000,2000);
    }
}
class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("这是一个timer");
    }
}

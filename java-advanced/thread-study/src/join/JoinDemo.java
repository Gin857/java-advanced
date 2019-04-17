package join;

/**
 * join的用法
 * @author xupeng
 * 2019.4.18
 */
public class JoinDemo extends Thread {
    @Override
    public void run() {
        for (int i = 10;i>0;i--){
            System.out.print(i+"   ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("开始倒数");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JoinDemo joinDemo  = new JoinDemo();
        Thread thread = new Thread(joinDemo);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("节目开始!");
    }

}
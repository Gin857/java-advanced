package timer;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ShadeBackFrame extends JFrame implements ActionListener {
    private int width;
    private int height;
    private ShadePanel shadePanel;
    private TimerTask aTask,bTask,cTask;
    private Timer timer;

    public ShadeBackFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("背景");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        setLayout(null);
        //主面板
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);
        shadePanel.setColor1(new Color(121,181,2));
        shadePanel.setColor2(new Color(211,222,2));

        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("erji1.jpg");
        imgPanel.setBounds(500, 150, 800, 600);
        //按钮区
        MyButton loginBtn = new MyButton();
        loginBtn.setPreferredSize(new Dimension(200, 80));
        loginBtn.setBgIcon("denglu.png");
        loginBtn.setFocusPainted(false);
        loginBtn.setContentAreaFilled(false);
//        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        loginBtn.setBounds(340, 400, 100, 50);

        imgPanel.add(loginBtn);
        shadePanel.add(imgPanel);
        add(shadePanel);


    }

    public static void main(String[] args) {
        new ShadeBackFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "播放音乐");
    }
}

class ShadePanel extends JPanel {
    private Color color1;
    private Color color2;

    public void setColor1(Color color1){
        this.color1= color1;
    }

    public void setColor2(Color color2){
        this.color2=color2;
    }
    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //创建填充模式对象
        GradientPaint paint0 = new GradientPaint(0, 0, color1, 0, height, color2);
        g.setPaint(paint0);
        g.fillRect(0, 0, width, height);

    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

/**
 * 自定义按钮，绘制背景图
 */
class MyButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
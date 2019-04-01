package week1;
/**
 * 卡片布局
 * @author xupeng
 * 2019.4.2
 */

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardLayoutTest extends JFrame implements ActionListener {
    private JPanel cardPanel;
    private JButton preButton, nextButton;
    private JPanel ButtonPanel;
    private CardLayout cardLayout;

    public CardLayoutTest() {
        init();
        setTitle("CardLayout");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void init() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        for (int i = 0; i < 3; i++) {
            cardPanel.add(String.valueOf(i + 1), getPanel());
        }
        add(cardPanel);
        ButtonPanel = new JPanel();
        ButtonPanel.setBackground(new Color(113, 197, 211));
        preButton = new JButton("上一张");
        nextButton = new JButton("下一张");
        ButtonPanel.add(preButton);
        ButtonPanel.add(nextButton);
        add(ButtonPanel, BorderLayout.SOUTH);
        preButton.addActionListener(this);
        nextButton.addActionListener(this);
    }

    private JPanel getPanel() {
        JPanel newPanel = new JPanel();
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        newPanel.setBackground(new Color(r, g, b));
        return newPanel;
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new CardLayoutTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == preButton) {
            cardLayout.previous(cardPanel);
        } else {
            cardLayout.next(cardPanel);
        }
    }
}

package test;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WithBackgroundImageJPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    Image currentBackgroundImage;

    List<Image> allImages;
    int currentImageIndex;

    Timer timeTicker;

    class ChangeImageTask extends TimerTask {

        @Override
        public void run() {
            int amount = WithBackgroundImageJPanel.this.allImages.size();

// DEBUG_INFO:
            System.out.println("all pictures:" + amount);

            if (amount > 0) {
                int index = WithBackgroundImageJPanel.this.currentImageIndex;
                index++;
                index = index % amount;

// DEBUG_INFO:
                System.out.println("current pic:" + index);

                WithBackgroundImageJPanel.this.currentBackgroundImage = WithBackgroundImageJPanel.this.allImages
                        .get(index);
                WithBackgroundImageJPanel.this.currentImageIndex = index;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        WithBackgroundImageJPanel.this.repaint();
                    }
                });

// DEBUG_INFO:
                System.out.println("change background image...");
            }

// DEBUG_INFO:
            System.out.println("***");
        }

    }

    public WithBackgroundImageJPanel() {
// get image files from default directory and set 5 second to change
        this(".", 5 * 1000);

    }

    private void loadAllImages(String imagePath) {
        File file = new File(imagePath);
        if (file.exists()) {
            if (file.isDirectory()) {
// if is directory, add all jpg files
                String[] files = file.list(new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith("jpg") || name.endsWith("JPG");
                    }
                });

                if (files.length > 0) {
                    for (int i = 0; i < files.length; i++) {
                        this.allImages.add(Toolkit.getDefaultToolkit()
                                .createImage(files[i]));
                    }
                }
            } else {
// if is file add the only jpg file
                if (imagePath.endsWith("jpg") || imagePath.endsWith("JPG")) {
                    this.allImages.add(Toolkit.getDefaultToolkit().createImage(
                            imagePath));
                }
            }
        }
    }

    public WithBackgroundImageJPanel(String imagePath, long period) {
        allImages = new ArrayList<Image>();
        timeTicker = new Timer(true);

        loadAllImages(imagePath);
        if (allImages.size() == 0) {
// default color if can't show background image
            this.setBackground(new Color(204, 170, 136));
        } else {
            currentBackgroundImage = allImages.get(0);
        }

        timeTicker.schedule(new ChangeImageTask(), 1L, period);

        this.setPreferredSize(new Dimension(500, 400));
    }

    public Image getBackgroundImage() {
        return currentBackgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.currentBackgroundImage != null) {

// first way : static picture
// g.drawImage(backgroundImage, 0, 0, this);

// second way : transform size according view
            int imageWidth = this.currentBackgroundImage.getWidth(null);
            int imageHeight = this.currentBackgroundImage.getHeight(null);

// DEBUG_INFO:
            System.out.println("image width:height :: " + imageWidth + " "
                    + imageHeight);

            float panelWidth = this.getWidth();
            float panelHeight = this.getHeight();

// DEBUG_INFO:
            System.out
                    .println("panel field: " + panelWidth + " " + panelHeight);

            AffineTransform transform = AffineTransform.getScaleInstance(
                    panelWidth / imageWidth, panelHeight / imageHeight);
            ((Graphics2D) g).drawImage(currentBackgroundImage, transform, this);

        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame mainWindow = new JFrame("Image");
                WithBackgroundImageJPanel panel = new WithBackgroundImageJPanel();

                panel.setLayout(new BorderLayout());

                panel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

                JLabel info = new JLabel("Input something here :");
                info.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
                panel.add(info, BorderLayout.BEFORE_FIRST_LINE);

                JTextArea inputContentTextArea = new JTextArea() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        AlphaComposite ac = AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER, .5f);
                        g2.setComposite(ac);

                        super.paintComponent(g2);

                    }
                };
                inputContentTextArea
                        .setText("you must copy jpg files to eclipse project directory,\n cause the default directory is project directory, \nnot src or bin directory! \n\n Good Luck!!");
                panel.add(inputContentTextArea);

                panel.add(new JLabel("This is a test on background image",
                        JLabel.CENTER), BorderLayout.AFTER_LAST_LINE);

                mainWindow.getContentPane().add(panel);
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.pack();
                Dimension screenSize = Toolkit.getDefaultToolkit()
                        .getScreenSize();
                mainWindow.setLocation(
                        (screenSize.width - mainWindow.getWidth()) / 2,
                        (screenSize.height - mainWindow.getHeight()) / 2);
                mainWindow.setVisible(true);
            }
        });
    }
}

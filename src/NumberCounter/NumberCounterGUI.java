package NumberCounter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NumberCounterGUI extends JFrame {

    private int n = 0;
    public JLabel countLabel;
    private JPanel controlButtons;
    private NumberCounter numberCounter;

    public NumberCounterGUI() {
        super("Number Counter");

        setSize(540, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(207, 138, 165));
        ImageIcon icon = new ImageIcon(loadImage("/resources/NumberCounter/NumberCounter-icon.png").getImage());
        Image image = icon.getImage();
        setIconImage(image);

        addGUIComponents();
        numberCounter = new NumberCounter(this);

        setVisible(true);
    }

    private void addGUIComponents() {

        // number
        countLabel = new JLabel("0");
        countLabel.setName("countLabel");
        countLabel.setBounds(60, 205, getWidth() - 132, 105);
        countLabel.setFont(loadCustomFont("/resources/NumberCounter/m6x11.ttf", 105f));
        countLabel.setForeground(new Color(77, 47, 47));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(countLabel);

        // buttons
        addButtons();

        // container
        JLabel contentPanel = new JLabel(loadImage("/resources/NumberCounter/frame.png"));
        contentPanel.setBounds(0, 80, getWidth() - 20, 384);
        add(contentPanel);

    }

    private void addButtons() {
        controlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        controlButtons.setBounds(0, 335, getWidth() - 20, 128);
        controlButtons.setOpaque(false);

        // decrease
        ImageIcon icon2 = loadImage("/resources/NumberCounter/decrease.png");
        JButton decreaseButton = new JButton(icon2);
        decreaseButton.setName("decreaseButton");
        decreaseButton.setBorderPainted(false);
        decreaseButton.setContentAreaFilled(false);
        decreaseButton.setFocusPainted(false);
        decreaseButton.setOpaque(false);
        decreaseButton.setBackground(null);
        decreaseButton.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
        decreaseButton.setSize(icon2.getIconWidth(), icon2.getIconHeight());
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberCounter.decreaseNum();
            }
        });
        controlButtons.add(decreaseButton);

        // increase
        ImageIcon icon1 = loadImage("/resources/NumberCounter/increase.png");
        JButton increaseButton = new JButton(icon1);
        increaseButton.setName("increaseButton");
        increaseButton.setBorderPainted(false);
        increaseButton.setContentAreaFilled(false);
        increaseButton.setFocusPainted(false);
        increaseButton.setOpaque(false);
        increaseButton.setBackground(null);
        increaseButton.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
        increaseButton.setSize(icon1.getIconWidth(), icon1.getIconHeight());
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberCounter.increaseNum();
            }
        });
        controlButtons.add(increaseButton);

        add(controlButtons);
    }

    public void updateNum(int n) {
        countLabel.setText(String.valueOf(n));
    }

    private ImageIcon loadImage(String ImagePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ImageIcon(image);
    }

    private Font loadCustomFont(String path, float size) {
        try {
            Font font = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream(path)
            ).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font;
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, (int) size);
        }
    }
}
package Calculator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CalculatorGUI extends JFrame {

    private final Border customBorder = BorderFactory.createLineBorder(new Color(0x63,0x29,0x32),1);
    private Calculator calculator;
    private JLabel lblResult;
    public JComboBox<String> cbOperations;
    public JTextField tfNumber1, tfNumber2;

    public CalculatorGUI() {
        super("Simple Calculator");
        calculator = new Calculator(this);
        setSize(630, 440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(255,232,238));
        ImageIcon icon = new ImageIcon(loadImage("/resource/Calculator/Calculator-icon.png").getImage());
        Image image = icon.getImage();
        setIconImage(image);

        addGUIComponents();

        setVisible(true);
    }

    private void addGUIComponents() {

        // button
        addBtn();

        // text field
        addTxtField();

        // operator
        addOperator();

        // result
        addResult();

        // container
        JLabel contentPanel = new JLabel(loadImage("/resource/Calculator/container-1.png"));
        contentPanel.setBounds(0, 0, getWidth()-20, getHeight()-40);
        add(contentPanel);
    }

    private void addOperator() {
        String[] operators = {"+", "-", "*", "/"};
        cbOperations = new JComboBox<>(operators);
        cbOperations.setBounds(223, 178,53,25);
        cbOperations.setFont(loadCustomFont(14));
        cbOperations.setBackground(Color.white);
        cbOperations.setForeground(new Color(0x63,0x29,0x32));
        cbOperations.setOpaque(true);
        cbOperations.setFocusable(false);
        cbOperations.setBorder(customBorder);
        ((JLabel) cbOperations.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        cbOperations.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton(new ImageIcon("src/resource/Calculator/arrow.png")); // your image
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setBackground(null);
                return button;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                // remove highlight/shadow
            }
        });

        cbOperations.setLightWeightPopupEnabled(true);
        ((JLabel)cbOperations.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        add(cbOperations);
    }

    private void addResult() {
        lblResult = new JLabel("0");
        lblResult.setBounds(418, 178, 65,38);
        lblResult.setFont(loadCustomFont(14));
        lblResult.setForeground(new Color(0x63,0x29,0x32));
        lblResult.setOpaque(true);
        lblResult.setBackground(Color.WHITE);
        lblResult.setBorder(customBorder);
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setVerticalAlignment(SwingConstants.CENTER);

        add(lblResult);
    }

    private void addTxtField() {
        JPanel txtFields = new JPanel();
        txtFields.setBounds(128,178,242,38);
        txtFields.setOpaque(false);
        txtFields.setLayout(null);

        tfNumber1 = new JTextField();
        tfNumber1.setBounds(0, 0, 65, 38);
        tfNumber1.setFont(loadCustomFont(14));
        tfNumber1.setBackground(Color.WHITE);
        tfNumber1.setForeground(new Color(0x63,0x29,0x32));

        tfNumber1.setBorder(BorderFactory.createEmptyBorder());
        tfNumber1.setBorder(customBorder);
        tfNumber1.setHorizontalAlignment(JTextField.CENTER);

        ((AbstractDocument) tfNumber1.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.insert(offset, string);
                if (isValidInteger(sb.toString())) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.replace(offset, offset + length, text);
                if (isValidInteger(sb.toString())) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidInteger(String text) {
                return text.matches("-?\\d*");
            }
        });

        txtFields.add(tfNumber1);

        tfNumber2 = new JTextField();
        tfNumber2.setBounds(177, 0, 65, 38);
        tfNumber2.setFont(loadCustomFont(14));
        tfNumber2.setBackground(Color.WHITE);
        tfNumber2.setForeground(new Color(0x63,0x29,0x32));

        tfNumber2.setBorder(BorderFactory.createEmptyBorder());
        tfNumber2.setBorder(customBorder);
        tfNumber2.setHorizontalAlignment(JTextField.CENTER);

        ((AbstractDocument) tfNumber2.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.insert(offset, string);
                if (isValidInteger(sb.toString())) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.replace(offset, offset + length, text);
                if (isValidInteger(sb.toString())) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidInteger(String text) {
                return text.matches("-?\\d*");
            }
        });

        txtFields.add(tfNumber2);

        add(txtFields);
    }

    private void addBtn() {
        JPanel btns = new JPanel();
        btns.setBounds(247,280,117,29);
        btns.setOpaque(false);
        btns.setLayout(null);

        ImageIcon icon1 = loadImage("/resource/Calculator/compute-btn.png");
        JButton btnCompute = new JButton(icon1);
        btnCompute.setName("btnCompute");
        btnCompute.setBorderPainted(false);
        btnCompute.setContentAreaFilled(false);
        btnCompute.setFocusPainted(false);
        btnCompute.setOpaque(false);
        btnCompute.setBackground(null);
        btnCompute.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
        btnCompute.setSize(icon1.getIconWidth(), icon1.getIconHeight());
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculator.computeResult();
            }
        });

        btns.add(btnCompute);

        add(btns);
    }

    public void updateText(int n) {
        if(n == -1) {
            lblResult.setText("Invalid");
        } else
            lblResult.setText(String.valueOf(n));
    }

    private ImageIcon loadImage(String ImagePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(ImagePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ImageIcon(image);
    }

    private Font loadCustomFont(float size) {
        try {
            Font font = Font.createFont(
                    Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getResourceAsStream("/resource/Calculator/SmallMemory.ttf"))
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

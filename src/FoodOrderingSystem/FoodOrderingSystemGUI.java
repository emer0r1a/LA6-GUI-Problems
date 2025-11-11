package FoodOrderingSystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class FoodOrderingSystemGUI extends JFrame {

    private FoodOrderingSystem foodOrderingSystem;
    ImageIcon PizzaUn = loadImage("/resources/FoodOrderingSystem/Pizza.png");
    ImageIcon PizzaCh = loadImage("/resources/FoodOrderingSystem/Pizza-select.png");
    ImageIcon SDUn = loadImage("/resources/FoodOrderingSystem/Soft Drink.png");
    ImageIcon SDCh = loadImage("/resources/FoodOrderingSystem/Soft Drink-select.png");
    ImageIcon FriesUn = loadImage("/resources/FoodOrderingSystem/Fries.png");
    ImageIcon FriesCh = loadImage("/resources/FoodOrderingSystem/Fries-select.png");
    ImageIcon BurgerUn = loadImage("/resources/FoodOrderingSystem/Burger.png");
    ImageIcon BurgerCh = loadImage("/resources/FoodOrderingSystem/Burger-select.png");
    ImageIcon SundaeUn = loadImage("/resources/FoodOrderingSystem/Sundae.png");
    ImageIcon SundaeCh = loadImage("/resources/FoodOrderingSystem/Sundae-select.png");
    ImageIcon TeaUn = loadImage("/resources/FoodOrderingSystem/Tea.png");
    ImageIcon TeaCh = loadImage("/resources/FoodOrderingSystem/Tea-select.png");
    JLabel pizza, burger, fries, sd, tea, sundae;
    ButtonGroup discountGroup;
    JCheckBox cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae;
    JRadioButton rbNone;

    public FoodOrderingSystemGUI() {
        super("Food Ordering System");
        foodOrderingSystem = new FoodOrderingSystem(this);

        setSize(987,687);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addGUIComponents();

        ImageIcon icon = new ImageIcon(loadImage("/resources/FoodOrderingSystem/food-icon.png").getImage());
        Image image = icon.getImage();
        setIconImage(image);

        setVisible(true);
    }

    private void addGUIComponents() {

        // checkbox
        addCheckbox();

        // radio button
        addRadioButton();

        // button
        addBtn();

        // add boxes
        addBoxes();

        // container
        JLabel contentPanel = new JLabel(loadImage("/resources/FoodOrderingSystem/cont-bg.png"));
        contentPanel.setBounds(0, 0, getWidth()-17, getHeight()-40);
        add(contentPanel);
    }

    void addBoxes() {
        JPanel grid = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 0));
        grid.setBounds(61, 205, 850, 143);
        grid.setOpaque(false);

        // pizza
        pizza = new JLabel(PizzaUn);
        pizza.setSize(115, 143);
        grid.add(pizza);

        // burger
        burger = new JLabel(BurgerUn);
        burger.setSize(115, 143);
        grid.add(burger);

        // fries
        fries = new JLabel(FriesUn);
        fries.setSize(115, 143);
        grid.add(fries);

        // soft drink
        sd = new JLabel(SDUn);
        sd.setSize(115, 143);
        grid.add(sd);

        // tea
        tea = new JLabel(TeaUn);
        tea.setSize(115, 143);
        grid.add(tea);

        // sundae
        sundae = new JLabel(SundaeUn);
        sundae.setSize( 115, 143);
        grid.add(sundae);

        add(grid);
    }

    void addRadioButton() {
        JPanel rbPanel = new JPanel();
        rbPanel.setLayout(null);
        rbPanel.setBounds(176, 442, 620, 23);
        rbPanel.setOpaque(false);

        ImageIcon selected = loadImage("/resources/FoodOrderingSystem/selected.png");
        ImageIcon unselected = loadImage("/resources/FoodOrderingSystem/unselected.png");

        // none
        rbNone = new JRadioButton("None");
        rbNone.setName("rbNone");
        rbNone.setBounds(0, 0, 98,23);
        rbNone.setFont(loadCustomFont(20));
        rbNone.setForeground(Color.WHITE);
        rbNone.setLayout(null);
        rbNone.setOpaque(false);
        rbNone.setFocusPainted(false);
        rbNone.setBorderPainted(false);
        rbNone.setContentAreaFilled(false);
        rbNone.setIcon(unselected);
        rbNone.setSelectedIcon(selected);
        rbNone.setIconTextGap(8);

        rbNone.setSelected(true);
        rbPanel.add(rbNone);

        // 5%
        JRadioButton rb5 = new JRadioButton("5% off");
        rb5.setName("rb5");
        rb5.setBounds(172, 0, 108,23);
        rb5.setFont(loadCustomFont(20));
        rb5.setForeground(Color.WHITE);
        rb5.setLayout(null);
        rb5.setOpaque(false);
        rb5.setFocusPainted(false);
        rb5.setBorderPainted(false);
        rb5.setContentAreaFilled(false);
        rb5.setIcon(unselected);
        rb5.setSelectedIcon(selected);
        rb5.setIconTextGap(8);

        rbPanel.add(rb5);

        // 10%
        JRadioButton rb10 = new JRadioButton("10% off");
        rb10.setName("rb10");
        rb10.setBounds(344, 0, 118,23);
        rb10.setFont(loadCustomFont(20));
        rb10.setForeground(Color.WHITE);
        rb10.setLayout(null);
        rb10.setOpaque(false);
        rb10.setFocusPainted(false);
        rb10.setBorderPainted(false);
        rb10.setContentAreaFilled(false);
        rb10.setIcon(unselected);
        rb10.setSelectedIcon(selected);
        rb10.setIconTextGap(8);

        rbPanel.add(rb10);

        // 15%
        JRadioButton rb15 = new JRadioButton("15% off");
        rb15.setName("rb15");
        rb15.setBounds(516, 0, 122,23);
        rb15.setFont(loadCustomFont(20));
        rb15.setForeground(Color.WHITE);
        rb15.setLayout(null);
        rb15.setOpaque(false);
        rb15.setFocusPainted(false);
        rb15.setBorderPainted(false);
        rb15.setContentAreaFilled(false);
        rb15.setIcon(unselected);
        rb15.setSelectedIcon(selected);
        rb15.setIconTextGap(8);

        rbPanel.add(rb15);

        discountGroup = new ButtonGroup();
        discountGroup.add(rbNone);
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);

        rbNone.setActionCommand("0");
        rb5.setActionCommand("0.05");
        rb10.setActionCommand("0.10");
        rb15.setActionCommand("0.15");

        add(rbPanel);
    }

    void addCheckbox() {
        JPanel cbPanel = new JPanel();
        cbPanel.setLayout(null);
        cbPanel.setBounds(90, 208, 792,43);
        cbPanel.setOpaque(false);

        ImageIcon checked = loadImage("/resources/FoodOrderingSystem/star-checked.png");
        ImageIcon unchecked = loadImage("/resources/FoodOrderingSystem/star-unchecked.png");

        // pizza
        cPizza = new JCheckBox("Pizza");
        cPizza.setName("cPizza");
        cPizza.setBounds(0,0,90,43);
        cPizza.setLayout(null);
        cPizza.setOpaque(false);
        cPizza.setFocusPainted(false);
        cPizza.setBorderPainted(false);
        cPizza.setContentAreaFilled(false);
        cPizza.setForeground(new Color(140,57,27));
        cPizza.setFont(loadCustomFont(20));
        cPizza.setIcon(unchecked);
        cPizza.setSelectedIcon(checked);

        cPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cPizza.isSelected()) {
                    pizza.setIcon(PizzaCh);
                } else pizza.setIcon(PizzaUn);
            }
        });

        cbPanel.add(cPizza);

        // burger
        cBurger = new JCheckBox("Burger");
        cBurger.setName("cBurger");
        cBurger.setBounds(140,0,100,43);
        cBurger.setLayout(null);
        cBurger.setOpaque(false);
        cBurger.setFocusPainted(false);
        cBurger.setBorderPainted(false);
        cBurger.setContentAreaFilled(false);
        cBurger.setForeground(new Color(140,57,27));
        cBurger.setFont(loadCustomFont(20));
        cBurger.setIcon(unchecked);
        cBurger.setSelectedIcon(checked);

        cBurger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cBurger.isSelected()) {
                    burger.setIcon(BurgerCh);
                } else burger.setIcon(BurgerUn);
            }
        });

        cbPanel.add(cBurger);

        // fries
        cFries = new JCheckBox("Fries");
        cFries.setName("cFries");
        cFries.setBounds(278,0,90,43);
        cFries.setLayout(null);
        cFries.setOpaque(false);
        cFries.setFocusPainted(false);
        cFries.setBorderPainted(false);
        cFries.setContentAreaFilled(false);
        cFries.setForeground(new Color(140,57,27));
        cFries.setFont(loadCustomFont(20));
        cFries.setIcon(unchecked);
        cFries.setSelectedIcon(checked);

        cFries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cFries.isSelected()) {
                    fries.setIcon(FriesCh);
                } else fries.setIcon(FriesUn);
            }
        });

        cbPanel.add(cFries);

        // soft drink
        cSoftDrinks = new JCheckBox("Soft Drinks");
        cSoftDrinks.setName("cSoftDrinks");
        cSoftDrinks.setBounds(415,0,100,43);
        cSoftDrinks.setLayout(null);
        cSoftDrinks.setOpaque(false);
        cSoftDrinks.setFocusPainted(false);
        cSoftDrinks.setBorderPainted(false);
        cSoftDrinks.setContentAreaFilled(false);
        cSoftDrinks.setForeground(new Color(140,57,27));
        cSoftDrinks.setFont(loadCustomFont(14));
        cSoftDrinks.setIcon(unchecked);
        cSoftDrinks.setSelectedIcon(checked);

        cSoftDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cSoftDrinks.isSelected()) {
                    sd.setIcon(SDCh);
                } else sd.setIcon(SDUn);
            }
        });

        cbPanel.add(cSoftDrinks);

        // tea
        cTea = new JCheckBox("Tea");
        cTea.setName("cTea");
        cTea.setBounds(555,0,90,43);
        cTea.setLayout(null);
        cTea.setOpaque(false);
        cTea.setFocusPainted(false);
        cTea.setBorderPainted(false);
        cTea.setContentAreaFilled(false);
        cTea.setForeground(new Color(140,57,27));
        cTea.setFont(loadCustomFont(20));
        cTea.setIcon(unchecked);
        cTea.setSelectedIcon(checked);

        cTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cTea.isSelected()) {
                    tea.setIcon(TeaCh);
                } else tea.setIcon(TeaUn);
            }
        });

        cbPanel.add(cTea);

        // sundae
        cSundae = new JCheckBox("Sundae");
        cSundae.setName("cSundae");
        cSundae.setBounds(695,0,100,43);
        cSundae.setLayout(null);
        cSundae.setOpaque(false);
        cSundae.setFocusPainted(false);
        cSundae.setBorderPainted(false);
        cSundae.setContentAreaFilled(false);
        cSundae.setForeground(new Color(140,57,27));
        cSundae.setFont(loadCustomFont(20));
        cSundae.setIcon(unchecked);
        cSundae.setSelectedIcon(checked);

        cSundae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cSundae.isSelected()) {
                    sundae.setIcon(SundaeCh);
                } else sundae.setIcon(SundaeUn);
            }
        });

        cbPanel.add(cSundae);

        cPizza.putClientProperty("price", 100.0);
        cBurger.putClientProperty("price", 80.0);
        cFries.putClientProperty("price", 65.0);
        cSoftDrinks.putClientProperty("price", 55.0);
        cTea.putClientProperty("price", 50.0);
        cSundae.putClientProperty("price", 40.0);

        add(cbPanel);
    }

    void addBtn() {
        JPanel btns = new JPanel();
        btns.setBounds(406-9,516,162,59);
        btns.setOpaque(false);
        btns.setLayout(null);

        ImageIcon icon1 = loadImage("/resources/FoodOrderingSystem/button.png");
        JButton btnOrder = new JButton(icon1);
        btnOrder.setName("btnOrder");
        btnOrder.setBorderPainted(false);
        btnOrder.setContentAreaFilled(false);
        btnOrder.setFocusPainted(false);
        btnOrder.setOpaque(false);
        btnOrder.setBackground(null);
        btnOrder.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
        btnOrder.setSize(icon1.getIconWidth(), icon1.getIconHeight());
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodOrderingSystem.order();
            }
        });

        btns.add(btnOrder);

        add(btns);
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
                    Objects.requireNonNull(getClass().getResourceAsStream("/resources/FoodOrderingSystem/Papernotes Bold.ttf"))
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

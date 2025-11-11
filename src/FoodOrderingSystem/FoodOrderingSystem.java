package FoodOrderingSystem;

import javax.swing.*;
import java.util.Arrays;

public class FoodOrderingSystem {
    private FoodOrderingSystemGUI foodOrderingSystemGUI;

    public FoodOrderingSystem(FoodOrderingSystemGUI foodOrderingSystemGUI) {
        this.foodOrderingSystemGUI = foodOrderingSystemGUI;
    }

    public void order() {
        double total = 0;
        double discount = 0;
        double finalPrice = 0;

        discount = Double.parseDouble(foodOrderingSystemGUI.discountGroup.getSelection().getActionCommand());

        for (JCheckBox cb : Arrays.asList(
                foodOrderingSystemGUI.cPizza,
                foodOrderingSystemGUI.cBurger,
                foodOrderingSystemGUI.cFries,
                foodOrderingSystemGUI.cSoftDrinks,
                foodOrderingSystemGUI.cTea,
                foodOrderingSystemGUI.cSundae)) {
            if (cb.isSelected()) {
                Object priceObj = cb.getClientProperty("price");
                if (priceObj != null) {
                    total += (double) priceObj;
                }
            }
        }

        finalPrice = total - (total * discount);

        if(total != 0) {
            JOptionPane.showMessageDialog(
                    null,
                    String.format("The total price is Php %.2f", finalPrice)
            );

            reset();
        }
    }

    public void reset() {
        for (JCheckBox cb : Arrays.asList(
                foodOrderingSystemGUI.cPizza,
                foodOrderingSystemGUI.cBurger,
                foodOrderingSystemGUI.cFries,
                foodOrderingSystemGUI.cSoftDrinks,
                foodOrderingSystemGUI.cTea,
                foodOrderingSystemGUI.cSundae)) {
            cb.setSelected(false);
        }

        foodOrderingSystemGUI.discountGroup.clearSelection();
        foodOrderingSystemGUI.rbNone.setSelected(true);

        foodOrderingSystemGUI.pizza.setIcon(foodOrderingSystemGUI.PizzaUn);
        foodOrderingSystemGUI.burger.setIcon(foodOrderingSystemGUI.BurgerUn);
        foodOrderingSystemGUI.fries.setIcon(foodOrderingSystemGUI.FriesUn);
        foodOrderingSystemGUI.sd.setIcon(foodOrderingSystemGUI.SDUn);
        foodOrderingSystemGUI.tea.setIcon(foodOrderingSystemGUI.TeaUn);
        foodOrderingSystemGUI.sundae.setIcon(foodOrderingSystemGUI.SundaeUn);
    }
}

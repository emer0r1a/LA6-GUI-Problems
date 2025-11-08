package NumberCounter;

public class NumberCounter {
    int currentNum = 0;
    NumberCounterGUI numberCounterGUI;

    public NumberCounter(NumberCounterGUI numberCounterGUI) {
        this.numberCounterGUI = numberCounterGUI;
    }

    public void increaseNum() {
        // only until 999 due to limited space inside container :'
        if(currentNum < 9999) {
            currentNum++;
        }
        numberCounterGUI.updateNum(currentNum);
    }

    public void decreaseNum() {
        if(currentNum > 0){
            currentNum--;
        }
        numberCounterGUI.updateNum(currentNum);
    }

}

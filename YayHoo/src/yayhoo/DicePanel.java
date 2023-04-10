package yayhoo;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

/**
 *
 * @author madeline lewis
 */
public class DicePanel extends JPanel implements ActionListener, MouseListener, Runnable {

    Thread rollTheDice;
    long startTime;

    private JButton rollDi = new JButton("Roll the Dice!");
    private JPanel dices = new JPanel();

    private ImageIcon onePNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/one.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon twoPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/two.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon threePNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/three.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon fourPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/four.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon fivePNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/five.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon sixPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/six.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    
    private ImageIcon oneSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/oneSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon twoSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/twoSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon threeSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/threeSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon fourSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/fourSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon fiveSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/fiveSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon sixSelectedPNG = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("faces/sixSelected.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));

    private JLabel one = new JLabel(twoPNG);
    private JLabel two = new JLabel(twoPNG);
    private JLabel three = new JLabel(twoPNG);
    private JLabel four = new JLabel(twoPNG);
    private JLabel five = new JLabel(twoPNG);

    private boolean oneS, twoS, threeS, fourS, fiveS;

    private int counter = 0;
    private JLabel rollCounter = new JLabel("Rolled " + counter + " times.");
    private JLabel console = new JLabel("Roll the dice to start!");

    private ImageIcon[] diceFaces = {onePNG, twoPNG, threePNG, fourPNG, fivePNG, sixPNG};
    private ImageIcon[] selectedDiceFaces = {null, oneSelectedPNG, twoSelectedPNG, threeSelectedPNG, fourSelectedPNG, fiveSelectedPNG, sixSelectedPNG};
    private JLabel[] diceLabels = {one, two, three, four, five};

    private JPanel helper1 = new JPanel();
    private JPanel helper2 = new JPanel();
    private JPanel helper3 = new JPanel();

    public DicePanel() {

        setPreferredSize(new Dimension(200, 500));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        dices.setLayout(new GridLayout(6, 1));
        dices.setBackground(Color.LIGHT_GRAY);

        Font font1 = new Font("Serif", Font.ITALIC | Font.BOLD, 10);
        Font font = font1.deriveFont(18F);

        console.setFont(font);

        rollDi.addActionListener(this);
        helper1.setPreferredSize(new Dimension(40, 40));
        rollDi.setBackground(Color.white);
        helper3.add(console);
        add(helper3, BorderLayout.NORTH);
        helper1.add(rollDi);
        helper2.add(rollCounter);
        add(helper1, BorderLayout.AFTER_LAST_LINE);
        add(helper2, BorderLayout.AFTER_LAST_LINE);

        rollDi.setAlignmentX(Component.CENTER_ALIGNMENT);

        one.addMouseListener(this);
        two.addMouseListener(this);
        three.addMouseListener(this);
        four.addMouseListener(this);
        five.addMouseListener(this);

        dices.add(one);
        dices.add(two);
        dices.add(three);
        dices.add(four);
        dices.add(five);

        add(dices, BorderLayout.PAGE_END);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Play again?")) {
            resetDiceSelected();
            MainPanel.setRolledFalse();
        } else {
                if (MainPanel.getRolledStatus() == true && counter == 3) {
                    console.setText("Pick a score catagory");
                } else {
                    counter++;
                    rollCounter.setText("Rolled " + counter + " times.");
                    if (counter < 3) {
                        rollTheDice = new Thread(this);
                        rollTheDice.start();
                        startTime = System.currentTimeMillis() / 1000;
                        MainPanel.setRolledTrue();
                        console.setText("Pick dice to keep");
                    } else if (counter <= 3) {
                        rollTheDice = new Thread(this);
                        rollTheDice.start();
                        startTime = System.currentTimeMillis() / 1000;
                        console.setText("You're all out of rolls!");
                    }
                }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (counter > 0) {
            rollDi.setText("Roll again!");
        }
        JLabel labelClicked = (JLabel) e.getSource();

        if (labelClicked.equals(one)) {
            if (oneS) {
                oneS = false;
                one.setIcon(diceFaces[getDiceVal(0) - 1]);
            } else {
                oneS = true;
                one.setIcon(selectedDiceFaces[getDiceVal(0)]);
            }
        } else if (labelClicked.equals(two)) {
            if (twoS) {
                twoS = false;
                two.setIcon(diceFaces[getDiceVal(1) - 1]);
            } else {
                twoS = true;
                two.setIcon(selectedDiceFaces[getDiceVal(1)]);
            }
        } else if (labelClicked.equals(three)) {
            if (threeS) {
                threeS = false;
                three.setIcon(diceFaces[getDiceVal(2) - 1]);
            } else {
                threeS = true;
                three.setIcon(selectedDiceFaces[getDiceVal(2)]);
            }
        } else if (labelClicked.equals(four)) {
            if (fourS) {
                fourS = false;
                four.setIcon(diceFaces[getDiceVal(3) - 1]);
            } else {
                fourS = true;
                four.setIcon(selectedDiceFaces[getDiceVal(3)]);
            }
        } else if (labelClicked.equals(five)) {
            if (fiveS) {
                fiveS = false;
                five.setIcon(diceFaces[getDiceVal(4) - 1]);
            } else {
                fiveS = true;
                five.setIcon(selectedDiceFaces[getDiceVal(4)]);
            }
        }

    }


    public void run() {
        int runTime = (int) (Math.random() * 3 + 1);
        long currentTime = System.currentTimeMillis() / 1000;

        while (currentTime < startTime + runTime) {
            currentTime = System.currentTimeMillis() / 1000;
            int rng1 = (int) (Math.random() * diceFaces.length);
            int rng2 = (int) (Math.random() * diceFaces.length);
            int rng3 = (int) (Math.random() * diceFaces.length);
            int rng4 = (int) (Math.random() * diceFaces.length);
            int rng5 = (int) (Math.random() * diceFaces.length);
            int rng6 = (int) (Math.random() * diceFaces.length);

            if (!oneS) {
                one.setIcon(diceFaces[rng1]);
            }

            if (!twoS) {
                two.setIcon(diceFaces[rng2]);
            }

            if (!threeS) {
                three.setIcon(diceFaces[rng3]);
            }

            if (!fourS) {
                four.setIcon(diceFaces[rng4]);
            }

            if (!fiveS) {
                five.setIcon(diceFaces[rng5]);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public int getDiceVal(int i) {
        if (diceLabels[i].getIcon().equals(onePNG) || diceLabels[i].getIcon().equals(oneSelectedPNG)) {
            return 1;
        } else if (diceLabels[i].getIcon().equals(twoPNG) || diceLabels[i].getIcon().equals(twoSelectedPNG)) {
            return 2;
        } else if (diceLabels[i].getIcon().equals(threePNG) || diceLabels[i].getIcon().equals(threeSelectedPNG)) {
            return 3;
        } else if (diceLabels[i].getIcon().equals(fourPNG) || diceLabels[i].getIcon().equals(fourSelectedPNG)) {
            return 4;
        } else if (diceLabels[i].getIcon().equals(fivePNG) || diceLabels[i].getIcon().equals(fiveSelectedPNG)) {
            return 5;
        } else if (diceLabels[i].getIcon().equals(sixPNG) || diceLabels[i].getIcon().equals(sixSelectedPNG)) {
            return 6;
        } else {
            System.out.println("problems...");
            return -1;
        }
    }

    public int getAceScore() {
        int acesRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 1) {
                acesRolled++;
            }
        }
        return acesRolled;
    }

    public int getTwoScore() {
        int twosRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 2) {
                twosRolled++;
            }
        }
        return twosRolled * 2;
    }

    public int getThreeScore() {
        int threesRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 3) {
                threesRolled++;
            }
        }
        return threesRolled * 3;
    }

    public int getFourScore() {
        int foursRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 4) {
                foursRolled++;
            }
        }
        return foursRolled * 4;
    }

    public int getFiveScore() {
        int fivesRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 5) {
                fivesRolled++;
            }
        }
        return fivesRolled * 5;
    }

    public int getSixScore() {
        int sixesRolled = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 6) {
                sixesRolled++;
            }
        }
        return sixesRolled * 6;
    }

    public int getChanceScore() {
        int total = 0;
        for (int i = 0; i < diceLabels.length; i++) {
            total += getDiceVal(i);
        }
        return total;
    }

    public int getThreeKindScore() {
        if (threeKind()) {
            return getChanceScore();
        } else {
            return 0;
        }
    }

    public int getFourKindScore() {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 1) {
                ones++;
            } else if (getDiceVal(i) == 2) {
                twos++;
            } else if (getDiceVal(i) == 3) {
                threes++;
            } else if (getDiceVal(i) == 4) {
                fours++;
            } else if (getDiceVal(i) == 5) {
                fives++;
            } else if (getDiceVal(i) == 6) {
                sixes++;
            }
        }

        if (ones >= 4 || twos >= 4 || threes >= 4 || fours >= 4 || fives >= 4 || sixes >= 4) {
            return getChanceScore();
        } else {
            return 0;
        }

    }

    public int getFullHouseScore() {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        boolean twoKind = false;

        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 1) {
                ones++;
            } else if (getDiceVal(i) == 2) {
                twos++;
            } else if (getDiceVal(i) == 3) {
                threes++;
            } else if (getDiceVal(i) == 4) {
                fours++;
            } else if (getDiceVal(i) == 5) {
                fives++;
            } else if (getDiceVal(i) == 6) {
                sixes++;
            }
        }

        if (ones == 2 || twos == 2 || threes == 2 || fours == 2 || fives == 2 || sixes == 2) {
            twoKind = true;
        }

        if (twoKind && threeKind()) {
            return 25;
        } else {
            return 0;
        }
    }

    public int getSmStraightScore() {
        List<Integer> vals = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();
        for (int i = 0; i < diceLabels.length; i++) {
            vals.add(getDiceVal(i));
        }
        Collections.sort(vals);
// remove duplicates
        for (int i = 0; i < vals.size() - 1; i++) {
            if (vals.get(i) == vals.get(i + 1)) {
                vals.remove(i);
                i--;
            }
        }

        for (int i = 0; i < vals.size() - 1; i++) {
            flags.add(vals.get(i).valueOf(i));
        }

        if (flags.size() == 2) {
            if (flags.get(0) && flags.get(1)) {
                return 30;
            } else {
                return 0;
            }
        } else if (flags.size() == 3) {
            if (flags.get(0) && flags.get(1) && flags.get(2)) {
                return 30;
            } else {
                return 0;
            }
        } else if (flags.size() > 3) {
            if (flags.get(0) && flags.get(1) && flags.get(2) || flags.get(1) && flags.get(2) && flags.get(3)) {
                return 30;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int getLgStraightScore() {
        List<Integer> vals = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();
        for (int i = 0; i < diceLabels.length; i++) {
            vals.add(getDiceVal(i));
        }
        Collections.sort(vals);
// remove duplicates
        for (int i = 0; i < vals.size() - 1; i++) {
            if (vals.get(i) == vals.get(i + 1)) {
                vals.remove(i);
                i--;
            }
        }

        for (int i = 0; i < vals.size() - 1; i++) {
            flags.add(vals.get(i) + 1 == vals.get(i + 1));
        }

        if (flags.size() == 4) {
            if (flags.get(0) && flags.get(1) && flags.get(2) && flags.get(3)) {
                return 40;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int getYayhooScore() {
        int theOne = getDiceVal(0);

        for (int i = 0; i < diceLabels.length; i++) {
            if (!(getDiceVal(i) == theOne)) {
                return 0;
            }
        }

        return 50;
    }

    private boolean threeKind() {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        for (int i = 0; i < diceLabels.length; i++) {
            if (getDiceVal(i) == 1) {
                ones++;
            } else if (getDiceVal(i) == 2) {
                twos++;
            } else if (getDiceVal(i) == 3) {
                threes++;
            } else if (getDiceVal(i) == 4) {
                fours++;
            } else if (getDiceVal(i) == 5) {
                fives++;
            } else if (getDiceVal(i) == 6) {
                sixes++;
            }
        }

        if (ones >= 3 || twos >= 3 || threes >= 3 || fours >= 3 || fives >= 3 || sixes >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public void resetDiceSelected() {
        oneS = false;
        twoS = false;
        threeS = false;
        fourS = false;
        fiveS = false;
    }
    
    public void resetRolls() {
        counter = 0;
    }

    public void setButtonString(String text) {
        rollDi.setText(text);
    }
    
    public void setConsoleString(String text) {
        console.setText(text);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

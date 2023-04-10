package yayhoo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author madeline lewis
 */
public class MainPanel extends JPanel implements MouseListener {

    private static DicePanel dicePanel = new DicePanel();

    private JPanel USP = new JPanel();
    private JPanel LSP = new JPanel();

    private JPanel UScolumsP = new JPanel();
    private JPanel LScolumsP = new JPanel();

    private JLabel upperSection = new JLabel("Upper Section");
    private JLabel lowerSection = new JLabel("Lower Section");
    private JLabel upperTotals = new JLabel("Total of Upper Section");
    private JLabel lowerTotals = new JLabel("Total of Lower Section");
    private JLabel totalTotals = new JLabel("Grand Total");

    private JLabel aces = new JLabel("Aces");
    private JLabel twos = new JLabel("Twos");
    private JLabel threes = new JLabel("Threes");
    private JLabel fours = new JLabel("Fours");
    private JLabel fives = new JLabel("Fives");
    private JLabel sixes = new JLabel("Sixes");
    private JLabel bonus = new JLabel("Bonus");
    private JLabel threeKind = new JLabel("3 of a Kind");
    private JLabel fourKind = new JLabel("4 of a Kind");
    private JLabel fullHouse = new JLabel("Full House");
    private JLabel smStraight = new JLabel("Small Straight");
    private JLabel lgStraight = new JLabel("Large Straight");
    private JLabel yayhoo = new JLabel("YayHoo!");
    private JLabel chance = new JLabel("Chance");

    private JLabel acesTF = new JLabel();
    private JLabel twosTF = new JLabel();
    private JLabel threesTF = new JLabel();
    private JLabel foursTF = new JLabel();
    private JLabel fivesTF = new JLabel();
    private JLabel sixesTF = new JLabel();
    private JLabel bonusTF = new JLabel();
    private JLabel threeKindTF = new JLabel();
    private JLabel fourKindTF = new JLabel();
    private JLabel fullHouseTF = new JLabel();
    private JLabel smStraightTF = new JLabel();
    private JLabel lgStraightTF = new JLabel();
    private JLabel yayhooTF = new JLabel();
    private JLabel chanceTF = new JLabel();
    private JLabel upperTotalsTF = new JLabel();
    private JLabel lowerTotalsTF = new JLabel();

    private boolean acesB = false;
    private boolean twosB = false;
    private boolean threesB = false;
    private boolean foursB = false;
    private boolean fivesB = false;
    private boolean sixesB = false;
    private boolean threeKindB = false;
    private boolean fourKindB = false;
    private boolean fullHouseB = false;
    private boolean smStraightB = false;
    private boolean lgStraightB = false;
    private boolean yayhooB = false;
    private boolean chanceB = false;
    
    private int acesVal, twosVal, threesVal, foursVal, fivesVal, sixesVal, threeKindVal, fourKindVal, fullHouseVal, smStraightVal, lgStraightVal, yayhooVal, chanceVal;
    

    private static boolean rolled = true;

    public MainPanel() {
        Dimension dem = new Dimension(40, 40);

        GridLayout grid1 = new GridLayout(8, 7, 6, 10);
        GridLayout grid2 = new GridLayout(8, 0, 6, 10);
        setBackground(Color.WHITE);
//        setLayout(grid);

        USP.setLayout(new BoxLayout(USP, BoxLayout.PAGE_AXIS));
        LSP.setLayout(new BoxLayout(LSP, BoxLayout.PAGE_AXIS));
        USP.setBackground(Color.white);
        LSP.setBackground(Color.white);

        UScolumsP.setLayout(grid1);
        LScolumsP.setLayout(grid2);
        UScolumsP.setPreferredSize(new Dimension(300, 300));
        LScolumsP.setPreferredSize(new Dimension(300, 300));
        UScolumsP.setBackground(Color.white);
        LScolumsP.setBackground(Color.white);

        upperSection.setHorizontalAlignment(JLabel.CENTER);
        USP.add(upperSection, BorderLayout.NORTH);
        UScolumsP.add(aces);
        UScolumsP.add(acesTF);
        UScolumsP.add(twos);
        UScolumsP.add(twosTF);
        UScolumsP.add(threes);
        UScolumsP.add(threesTF);
        UScolumsP.add(fours);
        UScolumsP.add(foursTF);
        UScolumsP.add(fives);
        UScolumsP.add(fivesTF);
        UScolumsP.add(sixes);
        UScolumsP.add(sixesTF);
        UScolumsP.add(bonus);
        UScolumsP.add(bonusTF);
        bonusTF.setVisible(false);
        UScolumsP.add(upperTotals);
        UScolumsP.add(upperTotalsTF);

        USP.add(UScolumsP, BorderLayout.AFTER_LINE_ENDS);

        lowerSection.setHorizontalAlignment(JLabel.CENTER);
        LSP.add(lowerSection, BorderLayout.NORTH);
        LScolumsP.add(threeKind);
        LScolumsP.add(threeKindTF);
        LScolumsP.add(fourKind);
        LScolumsP.add(fourKindTF);
        LScolumsP.add(fullHouse);
        LScolumsP.add(fullHouseTF);
        LScolumsP.add(smStraight);
        LScolumsP.add(smStraightTF);
        LScolumsP.add(lgStraight);
        LScolumsP.add(lgStraightTF);
        LScolumsP.add(yayhoo);
        LScolumsP.add(yayhooTF);
        LScolumsP.add(chance);
        LScolumsP.add(chanceTF);
        LScolumsP.add(lowerTotals);
        LScolumsP.add(lowerTotalsTF);

        LSP.add(LScolumsP, BorderLayout.AFTER_LINE_ENDS);

        add(USP);
        add(LSP);
        add(totalTotals);

        acesTF.setPreferredSize(dem);
        acesTF.setBackground(Color.white);
        acesTF.setBorder(new LineBorder(Color.black));
        acesTF.addMouseListener(this);

        twosTF.setPreferredSize(dem);
        twosTF.setBackground(Color.white);
        twosTF.setBorder(new LineBorder(Color.black));
        twosTF.addMouseListener(this);

        threesTF.setPreferredSize(dem);
        threesTF.setBackground(Color.WHITE);
        threesTF.setBorder(new LineBorder(Color.black));
        threesTF.addMouseListener(this);

        foursTF.setPreferredSize(dem);
        foursTF.setBackground(Color.white);
        foursTF.setBorder(new LineBorder(Color.black));
        foursTF.addMouseListener(this);

        fivesTF.setPreferredSize(dem);
        fivesTF.setBackground(Color.white);
        fivesTF.setBorder(new LineBorder(Color.black));
        fivesTF.addMouseListener(this);

        sixesTF.setPreferredSize(dem);
        sixesTF.setBackground(Color.white);
        sixesTF.setBorder(new LineBorder(Color.black));
        sixesTF.addMouseListener(this);

        bonusTF.setPreferredSize(dem);
        bonusTF.setBackground(Color.white);
        bonusTF.setBorder(new LineBorder(Color.black));

        threeKindTF.setPreferredSize(dem);
        threeKindTF.setBackground(Color.white);
        threeKindTF.setBorder(new LineBorder(Color.black));
        threeKindTF.addMouseListener(this);

        fourKindTF.setPreferredSize(dem);
        fourKindTF.setBackground(Color.white);
        fourKindTF.setBorder(new LineBorder(Color.black));
        fourKindTF.addMouseListener(this);

        fullHouseTF.setPreferredSize(dem);
        fullHouseTF.setBackground(Color.white);
        fullHouseTF.setBorder(new LineBorder(Color.black));
        fullHouseTF.addMouseListener(this);

        smStraightTF.setPreferredSize(dem);
        smStraightTF.setBackground(Color.white);
        smStraightTF.setBorder(new LineBorder(Color.black));
        smStraightTF.addMouseListener(this);

        lgStraightTF.setPreferredSize(dem);
        lgStraightTF.setBackground(Color.white);
        lgStraightTF.setBorder(new LineBorder(Color.black));
        lgStraightTF.addMouseListener(this);

        yayhooTF.setPreferredSize(dem);
        yayhooTF.setBackground(Color.white);
        yayhooTF.setBorder(new LineBorder(Color.black));
        yayhooTF.addMouseListener(this);

        chanceTF.setPreferredSize(dem);
        chanceTF.setBackground(Color.white);
        chanceTF.setBorder(new LineBorder(Color.black));
        chanceTF.addMouseListener(this);
        
        upperTotalsTF.setPreferredSize(dem);
        upperTotalsTF.setBackground(new Color(222, 227, 247));
        upperTotalsTF.setBorder(new LineBorder(Color.black));
        upperTotalsTF.setVisible(false);
        
        lowerTotalsTF.setPreferredSize(dem);
        lowerTotalsTF.setBackground(new Color(222, 227, 247));
        lowerTotalsTF.setBorder(new LineBorder(Color.black));
        lowerTotalsTF.setVisible(false);
    }

    public static void initalizeFrame() {
        JFrame frame = new JFrame("YayHoo!");
        MainPanel panel = new MainPanel();
        GridLayout grid = new GridLayout(0, 2);
        frame.setLayout(grid);
        frame.setSize(700, 730);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.add(dicePanel);

        frame.setVisible(true);
    }

    public static void setRolledTrue() {
        rolled = true;
    }
    
    public static void setRolledFalse() {
        rolled = false;
    }
    
    public static boolean getRolledStatus() {
        return rolled;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel labelClicked = (JLabel) e.getSource();
        if (rolled) {
            if (labelClicked.equals(acesTF) && !acesB) {
                acesVal = dicePanel.getAceScore();
                acesTF.setText("" + acesVal);
                acesB = true;
            } else if (labelClicked.equals(twosTF) && !twosB) {
                twosVal = dicePanel.getTwoScore();
                twosTF.setText("" + twosVal);
                twosB = true;
            } else if (labelClicked.equals(threesTF) && !threesB) {
                threesVal = dicePanel.getThreeScore();
                threesTF.setText("" + threesVal);
                threesB = true;
            } else if (labelClicked.equals(foursTF) && !foursB) {
                foursVal = dicePanel.getFourScore();
                foursTF.setText("" + foursVal);
                foursB = true;
            } else if (labelClicked.equals(fivesTF) && !fivesB) {
                fivesVal = dicePanel.getFiveScore();
                fivesTF.setText("" + dicePanel.getFiveScore());
                fivesB = true;
            } else if (labelClicked.equals(sixesTF) && !sixesB) {
                sixesVal = dicePanel.getSixScore();
                sixesTF.setText("" + dicePanel.getSixScore());
                sixesB = true;
            } else if (labelClicked.equals(chanceTF) && !chanceB) {
                chanceVal = dicePanel.getChanceScore();
                chanceTF.setText("" + dicePanel.getChanceScore());
                chanceB = true;
            } else if (labelClicked.equals(threeKindTF) && !threeKindB) {
                threeKindVal = dicePanel.getThreeKindScore();
                threeKindTF.setText("" + dicePanel.getThreeKindScore());
                threeKindB = true;
            } else if (labelClicked.equals(fourKindTF) && !fourKindB) {
                fourKindVal = dicePanel.getFourKindScore();
                fourKindTF.setText("" + dicePanel.getFourKindScore());
                fourKindB = true;
            } else if (labelClicked.equals(fullHouseTF) && !fullHouseB) {
                fullHouseVal = dicePanel.getFullHouseScore();
                fullHouseTF.setText("" + dicePanel.getFullHouseScore());
                fullHouseB = true;
            } else if (labelClicked.equals(smStraightTF) && !smStraightB) {
                smStraightVal = dicePanel.getSmStraightScore();
                smStraightTF.setText("" + dicePanel.getSmStraightScore());
                smStraightB = true;
            } else if (labelClicked.equals(lgStraightTF) && !lgStraightB) {
                lgStraightVal = dicePanel.getLgStraightScore();
                lgStraightTF.setText("" + dicePanel.getLgStraightScore());
                lgStraightB = true;
            } else if (labelClicked.equals(yayhooTF) && !yayhooB) {
                yayhooVal = dicePanel.getYayhooScore();
                yayhooTF.setText("" + dicePanel.getYayhooScore());
                yayhooB = true;
            }
            rolled = false;
            dicePanel.resetRolls();
            dicePanel.resetDiceSelected();
            if (isGameOver()) {
                setTotals();
            }
        }
    }
    
    public boolean isGameOver() {
        return (acesB && twosB && threesB && foursB && fivesB && sixesB && threeKindB && fourKindB && fullHouseB && smStraightB && lgStraightB && chanceB && yayhooB);
    }
    
    public void setTotals() {
        int upperTotal = 0;
        int lowerTotal = 0;
        int grandTotal = 0;
        
        bonusTF.setVisible(true);
        upperTotalsTF.setVisible(true);
        lowerTotalsTF.setVisible(true);
        
        if ((acesVal + twosVal + threesVal + foursVal + fivesVal + sixesVal) >= 63) {
            upperTotal = acesVal + twosVal + threesVal + foursVal + fivesVal + sixesVal + 35;
            bonusTF.setText("" + 35);
        } else {
            upperTotal = acesVal + twosVal + threesVal + foursVal + fivesVal + sixesVal;
            bonusTF.setText("" + 0);
        }
        
        lowerTotal = threeKindVal + fourKindVal + fullHouseVal + smStraightVal + lgStraightVal + yayhooVal;
        grandTotal = lowerTotal + upperTotal;
                
        upperTotalsTF.setText("" + upperTotal);
        lowerTotalsTF.setText("" + lowerTotal);
        totalTotals.setText("Grand Total:  " + grandTotal);
        dicePanel.setButtonString("Play again?");
        dicePanel.setConsoleString("Game over!");
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

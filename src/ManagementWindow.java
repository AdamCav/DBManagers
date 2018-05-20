import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ManagementWindow extends JFrame {

    JPanel panel=new JPanel();
    JLabel characterName;
    JLabel powerlevelLabel=new JLabel("PL:");
    JLabel date;
    JLabel spacer= new JLabel("                                                                                                ");
    JLabel location;
    Player player;
    BoxLayout boxLayout;
    JTextField powerlevel;
    JTextField fatigue;
    GameState gameState;
    JButton train;
    JButton adventure;
    JButton rest;
    LogWindow log;
    DecisionWindow decisions;

    public ManagementWindow(Player player,GameState gameState, LogWindow log,DecisionWindow decisions){
        super();

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {
                refreshFrame();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                refreshFrame();
            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        this.decisions=decisions;
        this.gameState=gameState;
        this.log=log;
        boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        this.player=player;
        setSize(250,200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(boxLayout);
        characterName = new JLabel(player.name);
        powerlevel=new JTextField();
        fatigue=new JTextField();
        location=new JLabel();
        date=new JLabel(gameState.determineDate());
        powerlevel.setEditable(false);
        powerlevel.setBorder(null);
        fatigue.setEditable(false);
        fatigue.setBorder(null);
        panel.add(characterName);
        panel.add(date);
        //panel.add(powerlevelLabel);
        panel.add(powerlevel);
        panel.add(fatigue);
        train = new JButton("Train");
        adventure = new JButton("Adventure");
        rest = new JButton("Rest");
        panel.add (train);
        train.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                training();
            }
        });
        panel.add(adventure);
        adventure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adventuring();
            }
        });

        panel.add(rest);
        rest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resting();
            }
        });

        refreshFrame();
        add(panel);
        setVisible(true);
    }

    public void resting(){
        gameState.action++;
        player.modifyFatigue(-5);
        refreshFrame();
    }

    public void adventuring(){
        gameState.action++;
        refreshFrame();
    }

    public void training(){
        player.hasTrained=true;
        gameState.action++;
        player.powerlevel+=player.trainingGains()*(1-(player.fatigue/100));
        log.updateLog("You gain "+(int)((player.trainingGains()*(1-(player.fatigue/100)))));
player.modifyFitness(1);
        player.modifyFatigue(5);
        System.out.println("BasePL:"+player.powerlevel+" Fitness:"+player.fitness+" TrainingMod:"+player.trainingMod+ " Gains: "+ player.trainingGains());
        refreshFrame();
    }

    public void refreshFrame(){
        if (gameState.action==gameState.maxAction) {
            advanceDay();
        }

        powerlevel.setText("PL: "+player.determinePowerLevel());
        fatigue.setText("Fatigue: "+(int)player.fatigue+"%");
        date.setText(gameState.determineDate());
        location.setText(player.getLocation());
        log.setLocation(this.getX()+this.getWidth(),this.getY());
        log.requestFocus();
        decisions.setLocation(this.getX(),this.getY()+this.getHeight());
        decisions.requestFocus();
    }

    public void advanceDay(){
        gameState.action=0;
        gameState.day++;
        if (!player.hasTrained) {
            player.fitness--;
        }
        player.modifyFatigue(-5);
        player.hasTrained=false;
    }

}

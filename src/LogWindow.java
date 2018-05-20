import javax.swing.*;
import java.awt.*;

/**
 * Created by Killbot Prime on 5/9/2017.
 */
public class LogWindow extends JFrame {
    JPanel panel=new JPanel();
    JLabel logLabel = new JLabel("Log:");
    JTextArea log = new JTextArea();
    String logText="Test\n";


    public LogWindow(){
        super();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
        log.setColumns(20);
        log.setRows(20);
        log.setText(logText);
        log.setEditable(false);
        log.setLineWrap(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(BorderLayout.EAST,log);
        this.pack();
        //this.add(logLabel);
        this.add(log);
        setVisible(true);

    }

    public void updateLog(String text){
        logText+=text+"\n";
        log.setText(logText);
    }

    public void clearLog(){
        logText="";
        log.setText(logText);
    }


}

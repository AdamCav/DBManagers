import javax.swing.*;
import java.awt.*;

public class DecisionWindow extends JFrame {
    JPanel panel;
    GridLayout layout;
    JButton Decision1;
    JButton Decision2;
    JButton Decision3;
    JButton Decision4;

    public DecisionWindow(){
        super();
        setSize(250,100);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        panel = new JPanel();
        layout = new GridLayout(0,2);
        panel.setLayout(layout);
        Decision1 = new JButton("Decision 1");
        Decision2 = new JButton("Decision 2");
        Decision3 = new JButton("Decision 3");
        Decision4 = new JButton("Decision 4");
        panel.add(Decision1);
        panel.add(Decision2);
        panel.add(Decision3);
        panel.add(Decision4);
        add(panel);
        setVisible(true);

    }
}

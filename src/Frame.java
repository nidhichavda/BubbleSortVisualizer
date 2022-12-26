import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;


public class Frame extends JFrame{

    public static final long serialVersionUID = 1L;

    private SortingPanel panel = new SortingPanel();


    public Frame(){
        this.setTitle("Sorting Visualizer");
        this.getContentPane().setPreferredSize(new Dimension(1200,600));
        this.getContentPane().add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public SortingPanel getPanel(){
        return this.panel;
    }

}
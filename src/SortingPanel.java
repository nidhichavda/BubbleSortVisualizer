import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SortingPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Random random;
    private int[] array;

    private BubbleSort bubbleSort;

    private JButton start;
    private JButton bubble;
    private JButton reset;

    private boolean isBubble=false;
    private boolean isRunning;

    int i=0;

    public SortingPanel(){

        random =new Random();
        array = new int[80];
        this.setArray();


        bubbleSort = new BubbleSort(array);

        start = new JButton("Start");
        bubble = new JButton("Bubble");
        reset = new JButton("reset");

        this.add(start);
        this.add(bubble);
        this.add(reset);

      
        start.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                start.setBackground(Color.lightGray);
                    if(isRunning == false)
                    {
                        isRunning = true;
                    }
                    animate();
              }
              catch(Exception exception){
                exception.printStackTrace();
              }
            }
        });

        bubble.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                bubble.setBackground(Color.lightGray);

                    if(isRunning == false)
                    {
                        isBubble=true;
                    }
                     
              }
              catch(Exception exception){
                exception.printStackTrace();
              }
            }
        });

        reset.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) {

                setArray();
                // bubbleSort.setArray(array);
                // bubbleSort.setArrayIndex(0);
                // bubbleSort.setCompareIndex(0);
                bubbleSort.Init(array);

                isRunning = false;

                Timer timer = new Timer(100, new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                      
                        reset.setBackground(Color.WHITE);
                        ((Timer)e.getSource()).stop();
                    }

                });
                timer.start();
                repaint();

            }
        });
    }
    // public int[] getArray(){
    //     return this.array;
    // }

    public void setArray() {
        for(int i=0; i<this.array.length; i++)
        {
            this.array[i] = random.nextInt(500) + 50;
        }
        }

    public boolean isSorted(){

        for(int i=0; i<array.length-1; i++)
        {
            if(array[i] > array[i+1])
            {
                return false;
            }
            
        }
        return true;
    }
    
    public void animate() throws Exception{

        if(isBubble)
        {
            bubbleSort.setCompareIndex(0);

                Timer bubblTimer = new Timer(1, new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                        if(isSorted() || isRunning == false)
                        { 
                            bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                            isRunning = false;
                           ((Timer)e.getSource()).stop();

                        }
                        else{
                            if(isRunning == true)
                            {
                                array = bubbleSort.sortOnlyOneItem();
                            }                            
                        }  
                        repaint();
                    }

                });
                bubblTimer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        for(int i=0; i<array.length; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect(i*20, 600-array[i], 14, array[i]);


            if(isBubble)
            {
                if(i == bubbleSort.getCompareIndex() || i== (bubbleSort.getCompareIndex() + 1)){
                    g.setColor(Color.MAGENTA);
                }
            }

            if(g.getColor() != Color.MAGENTA)
            {
                g.setColor(Color.CYAN);
            }

            g.fillRect(i*20, 600 - array[i],14, array[i]);

        }

    }

}
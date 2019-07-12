package Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Window.Windows_par.*;

import Graph.*;




public class Quation_for_delete extends JFrame {
    private JButton B1 = new JButton("OK");
    private JButton B2 = new JButton("OK");
    private JTextField number = new JTextField("0",5);
    private JTextField number2 = new JTextField("0",5);
    JTextField in[][];
    private int a,b,flag,flag2;
    GraphPlane graph;
    JFrame Parent;
    public Quation_for_delete(GraphPlane graph,int flag,int flag2){
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Кого?");      //Имя окна
        setSize( WINDOW_SIZE );
        this.graph=graph;
        this.flag=flag;
        this.flag2=flag2;
        setLayout(null);
        setVisible(true);
        this.setBounds(200, 110, 600, 500);
        B1.setBounds(0, 100, 100, 40);
        B1.addActionListener(new Check_number1());
        add(B1);
        number.setBounds(0,0,100,100);
        add(number);
        if(flag==2)
        {
            B2.setBounds(100, 100, 100, 40);
            B2.addActionListener(new Check_number2());
            add(B2);
            number2.setBounds(100,0,100,100);
            add(number2);
        }
    }
    class Check_number1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setLayout(null);
            //System.out.println("sdada");
            a= Integer.parseInt(number.getText());
            flag--;
            remove(number);
            remove(B1);
            if(flag==0)
               Doner();
           /* System.out.println("\n\n");
            System.out.println(n);
            System.out.println("\n\n");*/
        }
    }
    class Check_number2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i,j;
            setLayout(null);
            //System.out.println("sdada");
            b= Integer.parseInt(number2.getText());
            flag--;
            remove(number2);
            remove(B2);
            if(flag==0)
                Doner();

           /* System.out.println("\n\n");
            System.out.println(n);
            System.out.println("\n\n");*/
        }
    }
    void Doner(){
        if (flag2==1)
            graph.addE(new Graph.Edge(a,b,1));
        if (flag2==2)
            graph.remE(new Graph.Edge(a,b,1));
        if (flag2==3)
            graph.addV();
        if (flag2==4)
            graph.remV(a);
        setVisible(false);
    }
}

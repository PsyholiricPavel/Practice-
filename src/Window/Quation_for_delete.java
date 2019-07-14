package Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Window.Windows_par.*;

import Graph.*;




public class Quation_for_delete extends JFrame {
    private JButton B1 = new JButton("OK");
    private JButton B2 = new JButton("OK");
    JComboBox numb = new JComboBox();
    private JTextField wei= new JTextField("0",5);
    private JComboBox number = new JComboBox();
    int in[][] = {
            {0, 0, 1, 0, 0},
            {2, 0, 0, 0, 0},
            {1, 2, 0, 0, 0},
            {0, 0, 3, 0, 0},
            {1, 0, 5, 6, 0},
    };
    private int a, b, i, j, counter, flag, flag2,c;
    GraphPlane graph;

    public Quation_for_delete(GraphPlane graph, int flag, int flag2) {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Кого?");      //Имя окна
        setSize(WINDOW_SIZE);
        this.graph = graph;
        this.flag = flag;
        this.flag2 = flag2;
        setLayout(null);
        setVisible(true);
        char[] a = {'0', '1', '2', '3'};
        // JComboBox number = new JComboBox();
        //number.setEditable(true);
        //System.out.println("lol" + graph.points.keySet());
                            //тип тут копирую.
        in=graph.get_matr();
        ArrayList<Integer> vert =graph.graph.getVertexes();
        if(flag2==3)
            Doner();
        if(flag2==4)
            for (i=0;i< vert.size();i++) {
                number.addItem(vert.get(i));
                System.out.println(vert.get(i));
            }
        else
        for (i = 0; i < in.length; i++) {
            counter = 0;
            for (j = 0; j < in[i].length; j++)
                if (in[i][j] > 0||flag2==1)
                    counter++;
            if (counter > 0)
                number.addItem(i);
        }
        if (flag2==1)
            add(wei);
        wei.setBounds(200, 0, 100, 100);
        this.setBounds(100, 110, 600, 500);
        B1.setBounds(0, 100, 100, 40);
        B1.addActionListener(new Check_number());
        add(B1);
        if (flag==2){
            add (numb);
            numb.setBounds(100, 0, 100, 100);
        }
        add(number);
        number.setBounds(0, 0, 100, 100);
        number.addActionListener(actionListener);
        //add(number);
        //if(flag==2)

        // number.actionPerformed(new Check_number1());



    }
    class Check_number implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            a = Integer.parseInt(number.getSelectedItem().toString());
            if(flag==2)
                b= Integer.parseInt(numb.getSelectedItem().toString());
            if(flag2==1)
                c=Integer.parseInt(wei.getText());
            Doner();
        }
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = number.getSelectedIndex();
            System.out.println(selectedIndex);
            numb.removeAllItems();
            //JComboBox number2=new JComboBox();
            //numb.setEditable(true);
            numb.setVisible(true);
            getContentPane().add(numb);
            numb.setLayout(null);
            // numb.addItem(1);
            a = Integer.parseInt(number.getSelectedItem().toString());
            for (i = 0; i < in[a].length; i++)
                if(selectedIndex!=i)
                    if ((in[selectedIndex][i] > 0)!=(flag2!=2)) {
                        numb.addItem(i);
                        System.out.println(i);
                }
            numb.setBounds(100, 0, 100, 100);
            numb.setVisible(true);
        }
    };
    void Doner(){
        if (flag2==1)
            graph.addE(new Graph.Edge(a,b,1));
        if (flag2==2)
            graph.remE(new Graph.Edge(a,b,1));
        if (flag2==3)
            graph.addV();
        if (flag2==4)
            graph.remV(a);
        dispose();
    }
}

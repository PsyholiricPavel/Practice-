package Window;

import Graph.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Window.*;
import Graph.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import Window.KeyIn;
import static Window.Windows_par.*;
import static Window.Windows_par.BACKGROUND;
import static Window.Windows_par.SIZE_OF_GRAPH_FIELD;

import static Window.Windows_par.*;

public class KeyInAlgo extends JPanel {
    private JButton B1 = new JButton("OK");
    private JButton B2 = new JButton("OK");
    private JTextField number = new JTextField("",5);
    private JLabel Dia[];
    JTextField in[][];
    static int[][] arr;
    private int n=2;
    JFrame Parent;


    public KeyInAlgo(JFrame Parent) {
        setLayout(null);
        this.setBounds(200, 110, 600, 500);
        B1.setBounds(100, 10, 200, 100);
        B1.addActionListener(new Check_number());
        add(B1);
        number.setBounds(300,10,100,100);
        add(number);
        this.Parent=Parent;
        //arr=ar;
    }
    class Check_number implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i,j;
            setLayout(null);
            //System.out.println("sdada");
            n= Integer.parseInt(number.getText());
           /* System.out.println("\n\n");
            System.out.println(n);
            System.out.println("\n\n");*/
            removeAll();
            in=new JTextField[n][];
            arr= new int[n][];
            Dia=new JLabel[n];
            for(i=0;i<n;i++) {
                arr[i] = new int[n];
                in[i] = new JTextField[n];
                Dia[i]=new JLabel("0");
            }
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                {
                    arr[i][j]=100*i+j;
                   // System.out.println(arr[i][j]+"Lol"+i+" "+j);
                    in[i][j] = new JTextField("0",5);
                    if(i!=j) {
                        in[i][j].setBounds(i * 40, j * 40, 40, 40);
                        in[i][j].setVisible(true);
                        add(in[i][j]);
                    }
                    else
                    {
                        Dia[i].setBounds(i * 40, j * 40, 40, 40);
                        Dia[i].setVisible(true);
                        add(Dia[i]);
                    }
                }
            repaint();
            B2.setBounds(n*40, 0, 100, 500);
            B2.addActionListener(new Out_matr());
            add(B2);

        }
    }
    class Out_matr implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i,j;
            /*for(i=0;i<n;i++) {
                for (j = 0; j < n; j++)
                    System.out.print(arr[i][j]);
                System.out.println();
            }*/
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                {
                    arr[i][j]=Integer.parseInt(in[i][j].getText());
                }
            /*for(i=0;i<n;i++) {
                for (j = 0; j < n; j++)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }*/
            Parent.setVisible(false);
            //Parent.dispose();
        }
        }

    public static int[][] getArr() {
        return arr;
    }
}
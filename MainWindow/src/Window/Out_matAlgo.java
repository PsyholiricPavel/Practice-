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

public class Out_matAlgo extends JPanel {
    private JButton B1 = new JButton("OK");
    private JTextField number = new JTextField("", 5);
    private JLabel Dia[];
    JLabel out[][];
    static int[][] arr;
    JFrame Parent;


    public Out_matAlgo(JFrame Parent,int[][] ar) {
        setLayout(null);
        this.setBounds(200, 110, 600, 500);
        this.Parent = Parent;
        int i,j;
        out=new JLabel[ar.length][];
        for(i=0;i< ar.length;i++)
            out[i] = new JLabel[ar[i].length];
        for(i=0;i<ar.length;i++)
            for(j=0;j< ar[i].length;j++)
            {
                if(ar[i][j]>=10_000_000)
                    out[i][j] = new JLabel("INF");
                else
                out[i][j] = new JLabel(String.valueOf(ar[i][j]));
                    out[i][j].setBounds(i * 40, j * 40, 40, 40);
                    out[i][j].setVisible(true);
                    add(out[i][j]);

            }
        B1.setBounds(ar.length*40, 0, 100, 500);
        B1.addActionListener(new Out_mat_ev());
        add(B1);
    }

    class Out_mat_ev implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Parent.dispose();
        }
    }

}
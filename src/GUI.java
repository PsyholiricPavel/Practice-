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


public class GUI extends JFrame {
    private JButton in_from_file = new JButton("Ввод с файла");
    private JButton Matr_out = new JButton("Вон матрицу");
    private JButton to_start = new JButton("В начало");
    private JButton prev_step = new JButton("Прошлый шаг");
    private JButton next_step = new JButton("Следующий шаг");
    private JButton to_finish = new JButton("В конец");
    private JButton in_from_key = new JButton("Ввод с клавиатуры");
    private JButton in_from_graphic = new JButton("Ввод графически");
    private JButton start_algorithm = new JButton("Запустить алгоритм");
    private JButton NewE= new JButton("NewE");
    private JButton DelE = new JButton("DelE");
    private JButton NewV = new JButton("NewV");
    private JButton DelV = new JButton("DelV");
    private JButton BB = new JButton("Назад");
    private JButton B1 = new JButton("Назад");
    private GraphPlane graph = new GraphPlane();
    JPanel down_panel = new JPanel();
    JPanel up_panel = new JPanel();
    JPanel create_panel = new JPanel();
    private JLabel important_to_add=new JLabel("Developed By KKB");
    private int ar[][];

    public GUI() {
        super("MainWindow");
        this.setBounds(250, 150, 1000, 800); //само окно
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //закрытие окна

        setPreferredSize(SIZE_OF_GRAPH_FIELD);    //Размер рамки
        setBackground(BACKGROUND);
        up_panel.setLayout(null);
        down_panel.setLayout(null);
        create_panel.setLayout(null);
        important_to_add.setBounds(300,610,200,15);
        add(important_to_add);

        in_from_file.addActionListener(new InFromFileEvent());//вызов чего то при нажатии
        up_panel.add(in_from_file);
        in_from_file.setBounds(100, 10, 200, 100);

        Matr_out.addActionListener(new Matr_out_event());//вызов чего то при нажатии
        add(Matr_out);
        Matr_out.setBounds(100, 610, 200, 100);

        in_from_key.addActionListener(new InFromKeyEvent());
        in_from_key.setBounds(300, 10, 200, 100);
        up_panel.add(in_from_key);

        in_from_graphic.addActionListener(new InFromGraphicEvent());
        in_from_graphic.setBounds(500, 10, 200, 100);
        up_panel.add(in_from_graphic);

        start_algorithm.addActionListener(new Algorithm());
        start_algorithm.setBounds(700, 10, 200, 100);
        up_panel.add(start_algorithm);

        graph.setBackground(GRAPH_FIELD_BACKGROUND);
        graph.setBounds(200,110,600,500);
        getContentPane().add(graph);
        repaint();

        to_start.addActionListener(new Step_to_start());
        to_start.setBounds(100, 10, 200, 100);
        down_panel.add(to_start);

        prev_step.addActionListener(new Step_back());
        prev_step.setBounds(300, 10, 200, 100);
        down_panel.add(prev_step);

        next_step.addActionListener(new Step_forward());
        next_step.setBounds(500, 10, 200, 100);
        down_panel.add(next_step);

        to_finish.addActionListener(new Step_to_finish());
        to_finish.setBounds(700, 10, 200, 100);
        down_panel.add(to_finish);

        NewE.addActionListener(new NewE_ev());
        NewE.setBounds(100, 10, 200, 100);
        create_panel.add(NewE);

        DelE.addActionListener(new DelE_ev());
        DelE.setBounds(300, 10, 200, 100);
        create_panel.add(DelE);

        NewV.addActionListener(new NewV_ev());
        NewV.setBounds(500, 10, 200, 100);
        create_panel.add(NewV);

        DelV.addActionListener(new DelV_ev());
        DelV.setBounds(700, 10, 200, 100);
        create_panel.add(DelV);

        BB.addActionListener(new Back_to_main());
        BB.setBounds(700, 610, 200, 100);
        create_panel.add(BB);
        B1.addActionListener(new Back_to_main());
        B1.setBounds(700, 610, 200, 100);
        down_panel.add(B1);

        getContentPane().add(down_panel);
        getContentPane().add(create_panel);
        down_panel.setVisible(false);
        create_panel.setVisible(false);
        getContentPane().add(up_panel); //форма
        //pack();

    }

    class InFromFileEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Filer in =new Filer(graph);
        }
    }

    class Matr_out_event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i,j;
            System.out.println('K');
            for(i=0;i<ar.length;i++) {
                for (j = 0; j < ar[i].length; j++)
                    System.out.print(ar[i][j]);
                System.out.println();
            }
            Out_mat ee=new Out_mat(ar);
            add(ee);
        }
    }

    class InFromKeyEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KeyIn hm=new KeyIn();
            int i,j;
            graph.addFromKlav(hm.getArr());
            int ar_c[][] = hm.getArr();
            System.out.println("SUKA");
            for(i=0;i<ar_c.length;i++) {
                for (j = 0; j < ar_c[i].length; j++)
                    System.out.print(ar_c[i][j]);
                System.out.println();
            }
            ar= new int[ar_c.length][];
            for(i=0;i<ar_c.length;i++)
                ar[i] = new int[ar_c[i].length];
            for(i=0;i<ar_c.length;i++)
                for (j = 0; j < ar_c[i].length; j++)
                    ar[i][j]=ar_c[i][j];
            System.out.println('L');
            for(i=0;i<ar.length;i++) {
                for (j = 0; j < ar[i].length; j++)
                    System.out.print(ar[i][j]);
                System.out.println();
            }
            add(hm);
            repaint();

        }
    }

    class InFromGraphicEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            up_panel.setVisible(false);
            create_panel.setVisible(true);
            getContentPane().add(create_panel);
            repaint();
        }
    }

    class Algorithm implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           graph.start_alg();
            up_panel.setVisible(false);
            down_panel.setVisible(true);
            getContentPane().add(down_panel);
            repaint();
        }
    }

    class Step_to_start implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            graph.go_to_start();
        }
    }

    class Step_back implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           graph.step_back();
        }
    }

    class Step_forward implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            graph.step();
        }
    }

    class Step_to_finish implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ar=graph.result();
           add(new Out_mat(ar));
        }
    }
    class Back_to_main implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            create_panel.setVisible(false);
            down_panel.setVisible(false);
            up_panel.setVisible(true);
            getContentPane().add(up_panel);
            repaint();
        }
    }
    class NewE_ev implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Integer first=0,second=1;
            Quation_for_delete a =new Quation_for_delete( graph,2,1);
            //add(a);
            System.out.print(first);
            graph.addE(new Graph.Edge(first,second,1));
        }
    }
    class DelE_ev implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Integer first=0,second=0;
            Quation_for_delete a =new Quation_for_delete( graph,2,2);
            System.out.print(first);
            //graph.remE(new Graph.Edge(first,second));
            add(a);
        }
    }
    class NewV_ev implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            graph.addV();
        }
    }
    class DelV_ev implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Quation_for_delete a =new Quation_for_delete( graph,1,4);
        //repaint();
        }
    }
}
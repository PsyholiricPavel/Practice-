package Window;

import javax.swing.*;

import static Window.Windows_par.*;



public class Out_mat extends JFrame {
    private static Out_matAlgo in;
    public Out_mat(int[][]ar){
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Результат");      //Имя окна
        setSize( WINDOW_SIZE );
        in= new Out_matAlgo( this,ar);//Размер окна
        setResizable(true);
        add(in);
        setVisible(true);

    }

}

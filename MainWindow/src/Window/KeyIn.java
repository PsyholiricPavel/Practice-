package Window;

import javax.swing.*;

import static Window.Windows_par.*;



public class KeyIn extends JFrame {
    private static KeyInAlgo in;
    private static int[][] ar;
   // public void KeyIn(int ar[][]) {new KeyIn(); }
    public KeyIn(){
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Алгоритм");      //Имя окна
        setSize( WINDOW_SIZE );                            //Размер окна
        in=new KeyInAlgo( this);
        setResizable(true);
        add(in);
        setVisible(true);
       int[][] ar_c = in.getArr();
        int i,j;
        ar= new int[ar_c.length][];
        for(i=0;i<ar_c.length;i++)
            ar[i] = new int[ar_c[i].length];
        for(i=0;i<ar_c.length;i++)
            for (j = 0; j < ar_c[i].length; j++)
                ar[i][j]=ar_c[i][j];
        System.out.println('o');
        for(i=0;i<ar.length;i++) {
            for (j = 0; j < ar[i].length; j++)
                System.out.print(ar[i][j]);
            System.out.println();
        }

    }
    public static int[][] getArr() {
        return ar;
    }

}

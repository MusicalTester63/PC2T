import javax.swing.*;
import java.awt.*;



public class Calculator extends JFrame{

    private final JLabel label;
    private boolean delete =true;
    private boolean read =true;
    private boolean operation =true;
    private int a=0;
    private int b=0;
    private String text;




    Calculator(){
        setSize(300,200) ;
        setTitle("Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button;

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,3));

        for (int i=0;i<10;i++){
            button=new JButton(Integer.toString(i));
            final int numButton=i;

            button.addActionListener(e -> inputNumber(numButton));

            p1.add(button);
        }

        button=new JButton("+");
        button.addActionListener(e -> operation(true));
        p1.add(button);


        button=new JButton("-");
        button.addActionListener(e -> operation(false));
        p1.add(button);

        button=new JButton("=");
        button.addActionListener(e -> carryOperation());
        p1.add(button);

        label=new JLabel("0");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        setLayout(new BorderLayout());
        getContentPane().add(label,BorderLayout.NORTH);
        getContentPane().add(p1,BorderLayout.CENTER);
        getContentPane().add(button,BorderLayout.SOUTH);
        text="";
        setVisible(true);
    }

    public void operation(boolean typ){
        if (!operation){
            operation =true;
            read =typ;
            if (read)
                text+="+";
            else
                text+="-";
            label.setText(text);
        }
    }

    public void carryOperation(){
        int result;
        if (read)
            result=a+b;
        else
            result=a-b;
        text= Integer.toString(result);
        label.setText(text);
        delete =true;
        operation =true;
    }

    public void inputNumber(int num){
        if (delete){
            a=0;
            b=0;
            text="";
            delete =false;
            operation =false;
        }
        if (operation){
            b*=10;
            b+=num;
        }
        else{
            a*=10;
            a+=num;
        }
        text+=num;
        label.setText(text);
    }

    public static void main(String[] args) {
        JFrame calc = new Calculator();
    }



}

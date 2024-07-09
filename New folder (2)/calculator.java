import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

class calculator extends JFrame implements ActionListener {

    // create a frame

    static JFrame f;
 

    // create a textfield

    static JTextField l;
 

    // store operator and operands

    String s0, s1, s2;
 

    // default constructor

    calculator()

    {

        s0 = s1 = s2 = "";

    }
 

    // main function

    public static void main(String args[])

    {

        // create a frame

        f = new JFrame("calculator");
 

        try {

            // set look and feel

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        }

        catch (Exception e) {

            System.err.println(e.getMessage());

        }
 

        // create a object of class

        calculator c = new calculator();
 

        // create a textfield

        l = new JTextField(13);
 

        // set the textfield to non editable
		l.setFont(new Font("",Font.BOLD,28));
        l.setEditable(false);
 

        // create number buttons and some operators

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
 

        // create number buttons

        b0 = new JButton("0");
		b0.setFont(new Font("Constantia",Font.BOLD,25));

        b1 = new JButton("1");
		b1.setFont(new Font("Constantia",Font.BOLD,20));

        b2 = new JButton("2");
		b2.setFont(new Font("Constantia",Font.BOLD,20));

        b3 = new JButton("3");
		b3.setFont(new Font("Constantia",Font.BOLD,20));

        b4 = new JButton("4");
		b4.setFont(new Font("Constantia",Font.BOLD,20));

        b5 = new JButton("5");
		b5.setFont(new Font("Constantia",Font.BOLD,20));

        b6 = new JButton("6");
		b6.setFont(new Font("Constantia",Font.BOLD,20));

        b7 = new JButton("7");
		b7.setFont(new Font("Constantia",Font.BOLD,20));

        b8 = new JButton("8");
		b8.setFont(new Font("Constantia",Font.BOLD,20));

        b9 = new JButton("9");
		b9.setFont(new Font("Constantia",Font.BOLD,20));
 

        // equals button

        beq1 = new JButton("=");
		beq1.setFont(new Font("Constantia",Font.BOLD,28));
 

        // create operator buttons

        ba = new JButton("+");
		ba.setFont(new Font("Constantia",Font.BOLD,28));

        bs = new JButton("-");
		bs.setFont(new Font("Constantia",Font.BOLD,28));

        bd = new JButton("/");
		bd.setFont(new Font("Constantia",Font.BOLD,20));

        bm = new JButton("*");
		bm.setFont(new Font("Constantia",Font.BOLD,28));

        beq = new JButton("C");
		beq.setFont(new Font("Constantia",Font.BOLD,20));
          
        // create . button

        be = new JButton(".");
		be.setFont(new Font("Constantia",Font.BOLD,28));
 

        // create a panel

        JPanel p = new JPanel();
 

        // add action listeners
		bm.setPreferredSize(new Dimension(100,30));
		bm.addActionListener(c);
		bd.setPreferredSize(new Dimension(100,30));
		bd.addActionListener(c);
		bs.setPreferredSize(new Dimension(100,30));
		bs.addActionListener(c);		
		ba.setPreferredSize(new Dimension(100,30));
        ba.addActionListener(c);
		b9.setPreferredSize(new Dimension(100,30));
        b9.addActionListener(c);
		b8.setPreferredSize(new Dimension(100,30));
        b8.addActionListener(c);
		b7.setPreferredSize(new Dimension(100,30));
        b7.addActionListener(c);
		b6.setPreferredSize(new Dimension(100,30));
        b6.addActionListener(c);
		b5.setPreferredSize(new Dimension(100,30));
        b5.addActionListener(c);
		b4.setPreferredSize(new Dimension(100,30));
        b4.addActionListener(c);
		b3.setPreferredSize(new Dimension(100,30));
        b3.addActionListener(c);
		b2.setPreferredSize(new Dimension(100,30));
        b2.addActionListener(c);
		b1.setPreferredSize(new Dimension(100,30));
        b1.addActionListener(c);
		b0.setPreferredSize(new Dimension(100,30));
        b0.addActionListener(c);
		be.setPreferredSize(new Dimension(100,30));
        be.addActionListener(c);
		beq.setPreferredSize(new Dimension(100,30));
        beq.addActionListener(c);
		beq1.setPreferredSize(new Dimension(205,30));
        beq1.addActionListener(c);
        
        // add elements to panel

        p.add(l);
        p.add(b1);
        p.add(b2);
        p.add(b3); 
		p.add(b4);
        p.add(b5);
        p.add(b6);
		
        
		
		p.add(b7);
        p.add(b8);
        p.add(b9);
		p.add(be);
		p.add(b0);
        
		p.add(bm);
        p.add(bd);
		p.add(ba);
		p.add(bs);
        p.add(beq1);
		p.add(beq);
 
        
        // set Background of panel

        p.setBackground(Color.gray);
 

        // add panel to frame

        f.add(p);
		//f.add(beq);
		//f.setBounds(14,14,250,250);
 

        f.setSize(400, 400);

        f.show();

    }

    public void actionPerformed(ActionEvent e)

    {

        String s = e.getActionCommand();
 

        // if the value is a number

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            // if operand is present then add to second no

            if (!s1.equals(""))

                s2 = s2 + s;

            else

                s0 = s0 + s;
 

            // set the value of text

            l.setText(s0 + s1 + s2);

        }

        else if (s.charAt(0) == 'C') {

            // clear the one letter

            s0 = s1 = s2 = "";
 

            // set the value of text

            l.setText(s0 + s1 + s2);

        }

        else if (s.charAt(0) == '=') {
 

            double te;
 

            // store the value in 1st

            if (s1.equals("+"))

                te = (Double.parseDouble(s0) + Double.parseDouble(s2));

            else if (s1.equals("-"))

                te = (Double.parseDouble(s0) - Double.parseDouble(s2));

            else if (s1.equals("/"))

                te = (Double.parseDouble(s0) / Double.parseDouble(s2));

            else

                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 

            // set the value of text

            l.setText(s0 + s1 + s2 + "=" + te);
 

            // convert it to string

            s0 = Double.toString(te);
 

            s1 = s2 = "";

        }

        else {

            // if there was no operand

            if (s1.equals("") || s2.equals(""))

                s1 = s;

            // else evaluate

            else {

                double te;
 

                // store the value in 1st

                if (s1.equals("+"))

                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));

                else if (s1.equals("-"))

                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));

                else if (s1.equals("/"))

                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));

                else

                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 

                // convert it to string

                s0 = Double.toString(te);
 

                // place the operator

                s1 = s;
 

                // make the operand blank

                s2 = "";

            }
 

            // set the value of text

            l.setText(s0 + s1 + s2);

        }

    }
}
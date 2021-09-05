import java.awt.*;   
import java.awt.event.*; 
class CardLayoutExample extends Frame implements ActionListener 
{ 
     CardLayout card = new CardLayout(20,20); 
     CardLayoutExample2() 
     { 
         setLayout(card); 
         Button Btnfirst = new Button("first "); 
         Button BtnSecond = new Button ("Second"); 
         Button BtnThird = new Button("Third"); 
         add(Btnfirst,"Card1"); 
         add(BtnSecond,"Card2"); 
         add(BtnThird,"Card3"); 
         Btnfirst.addActionListener(this); 
         BtnSecond.addActionListener (this); 
         BtnThird.addActionListener(this); 
     } 
     public void actionPerformed(ActionEvent e) 
     { 
       card.next(this); 
     } 
} 
   class CardLayoutExample2 
   { 
        public static void main(String args[]) 
       { 
            CardLayoutExample2 frame = new CardLayoutExample2(); 
            frame.setTitle("CardLayout in Java Example"); 
            frame.setSize(220,150); 
            frame.setResizable(false); 
            frame.setVisible(true); 
       } 
   } 

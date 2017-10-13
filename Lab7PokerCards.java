/*
 * NAME: HAROLD DANE C. BAGUINON
 * DATE: 7/29/2014
 * PURPOSE: This program is the seventh assignment.
 *          It will utilize a GUI.
 *          
 */

// Commentos.

/* Instructions: Choose ONE of the following (after you read through Chapters 12, 13,  & 14):

   1) Write a program which displays a frame that contains three labels. Each label displays a card.
   The card image files should be called 1.png, 2.png, ..., 52.png (there are 2 joker cards too if you
   want to use them). Randomly select 3 cards to show at a time. (hint: get a random number between 1 
   and 52 and then make a string with the .png concatenated onto it)

       (Make sure to copy the card image files from this folder to your local drive before you begin and
       rename the cards as 1.png,...).
       This exercise is great for learning about how to use the Random class or Math.random() which you
       can use for your final Bingo game project.

*******************************************************

   I modified the instructions so that it displays 5 cards rather than 3, which can be used
   for a poker hand. I was getting tired of getting duplicate draws (an annoying bug! A deck of cards
   shouldn't have duplicate values!), so I wrote a crazy-looking Do-While loop, which continuously checks
   for duplicate values in the array. I'm VERY proud of the solution I came up with, and I was initially
   skeptical whether or not it would even work!
*/

import javax.swing.*;            // For Swing classes
import java.awt.*;               // For BorderLayout class and color class
import java.awt.event.*;         // For event listener interface
import java.util.Random;         // For the Random class

public class Lab7PokerCards extends JFrame
{
   private JLabel label1;           // To show image of card 1.
   private JLabel label2;           // To show image of card 2.
   private JLabel label3;           // To show image of card 3.
   private JLabel label4;           // To show image of card 4.
   private JLabel label5;           // To show image of card 5.
   
   /**
      Constructionator ;)
   */
   
   public Lab7PokerCards()
   {
      // Title.
      setTitle("Poker Hand");
      
      // Close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Add BorderLayout manager to content pane.
      setLayout(new BorderLayout());
      
      // Build 2 panels and add it to frame. Make them GREEN.
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel1.setBackground(Color.GREEN);
      panel2.setBackground(Color.GREEN);
      
      // Create five labels.
      label1 = new JLabel();
      label2 = new JLabel("Are you ready to play Poker? ");
      label3 = new JLabel();
      label4 = new JLabel("Click the button below to draw a hand! ");
      label5 = new JLabel();
      
      // Add labels to panels.
      panel1.add(label1);
      panel1.add(label2);
      panel1.add(label3);
      panel1.add(label4);
      panel1.add(label5);
      
      // Add 2 panels to the content pane.
      add(panel1, BorderLayout.CENTER);
      add(panel2, BorderLayout.SOUTH);
      
      // Create "Draw Hand" button.
      JButton drawHand = new JButton("Draw Hand");
      
      // Add an action listener to the button.
      drawHand.addActionListener(new DrawHandButtonListener());
      
      // Add button to panel 2
      panel2.add(drawHand);
      
      // Pack and display the window.
      pack();
      setVisible(true);
   }
   
   /**
      The DrawHandButtonListener is an action listener class for Draw Hand button.
   */
   
   private class DrawHandButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executes when the user clicks on the
         Draw Hand button.
         @param action The event object.
      */
      
      public void actionPerformed(ActionEvent action)
      {
         // Declare an int which will be used to number the cards.
         int[] cardNumber = new int[5];      // Array of 5 cards.
         
         // Create a Random object.
         Random randomCard = new Random();
         
         // Assign random numbers to number array and try to remove duplicates via do-while loop.
         do
         {
         // This For loop will enter a random number into each array element while the above loop continuously checks
         // against duplicate values. The loops run until there are no duplicate values, and the values may be assigned
         // to the card images below, as an ImageIcon object.
            for (int index = 0; index < 5; index++)
            {
               cardNumber[index] = randomCard.nextInt(54) + 1;
            }
         }
         while (cardNumber[0] == cardNumber[1] || cardNumber[0] == cardNumber[2] || cardNumber[0] == cardNumber[3] ||
               cardNumber[0] == cardNumber[4] || cardNumber[1] == cardNumber[2] || cardNumber[1] == cardNumber[3] ||
               cardNumber[1] == cardNumber[4] || cardNumber[2] == cardNumber[3] || cardNumber[2] == cardNumber[4] ||
               cardNumber[3] == cardNumber[4]);
                        
         // Read the image file into an ImageIcon object. Note that the files are located in the Cards folder.
         ImageIcon card1 = new ImageIcon("Cards\\" + cardNumber[0] + ".jpg");
         ImageIcon card2 = new ImageIcon("Cards\\" + cardNumber[1] + ".jpg");
         ImageIcon card3 = new ImageIcon("Cards\\" + cardNumber[2] + ".jpg");
         ImageIcon card4 = new ImageIcon("Cards\\" + cardNumber[3] + ".jpg");
         ImageIcon card5 = new ImageIcon("Cards\\" + cardNumber[4] + ".jpg");
         
         // Remove text from the labels. Only labels 2 and 4 had text.
         label2.setText(null);
         label4.setText(null);
         
         // Display the image in the label.
         label1.setIcon(card1);
         label2.setIcon(card2);
         label3.setIcon(card3);
         label4.setIcon(card4);
         label5.setIcon(card5);
         
         //Pack the frame to accommodate the size.
         pack();
      }
      
   }
   
   /**
      The main method creates an instance of the Lab7PokerCards class, which causes
      five cards to appear in its window.
   */
   
   public static void main(String[] args)
   {
      new Lab7PokerCards();
   }
      
}
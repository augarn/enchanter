/*    */ package dev.august.enchanter.display;
/*    */ 
/*    */ import java.awt.Canvas;
/*    */ import java.awt.Dimension;
/*    */ import java.net.URL;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Display
/*    */ {
/*    */   private JFrame frame;
/*    */   private Canvas canvas;
/*    */   private String title;
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   public Display(String title, int width, int height) {
/* 20 */     this.title = title;
/* 21 */     this.width = width;
/* 22 */     this.height = height;
/*    */     
/* 24 */     createDisplay();
/*    */   }
/*    */   
/*    */   private void createDisplay() {
/* 28 */     this.frame = new JFrame(this.title);
/* 29 */     this.frame.setSize(this.width, this.height);
/* 30 */     this.frame.setUndecorated(false);
/* 31 */     this.frame.setDefaultCloseOperation(3);
/* 32 */     this.frame.setResizable(false);
/* 33 */     this.frame.setLocationRelativeTo(null);
/* 34 */     this.frame.setVisible(true);
/*    */     
/* 36 */     URL iconURL = getClass().getResource("icon.png");
/* 37 */     ImageIcon icon = new ImageIcon(iconURL);
/* 38 */     this.frame.setIconImage(icon.getImage());
/*    */     
/* 40 */     this.canvas = new Canvas();
/* 41 */     this.canvas.setPreferredSize(new Dimension(this.width, this.height));
/* 42 */     this.canvas.setMaximumSize(new Dimension(this.width, this.height));
/* 43 */     this.canvas.setMinimumSize(new Dimension(this.width, this.height));
/* 44 */     this.canvas.setFocusable(false);
/*    */     
/* 46 */     this.frame.add(this.canvas);
/* 47 */     this.frame.pack();
/*    */   }
/*    */ 
/*    */   
/* 51 */   public Canvas getCanvas() { return this.canvas; }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public JFrame getFrame() { return this.frame; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\display\Display.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
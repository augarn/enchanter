/*    */ package dev.august.enchanter.gfx;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.entities.creatures.Creature;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.image.ImageObserver;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserUI
/*    */   extends Creature
/*    */   implements ImageObserver
/*    */ {
/* 23 */   public UserUI(Handler handler, float x, float y, int width, int height) throws IOException { super(handler, x, y, width, height); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) { return false; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void die() {
/* 47 */     JOptionPane.showMessageDialog(null, "Exiting.");
/* 48 */     System.exit(1);
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\UserUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
/*    */ package dev.august.enchanter.input;
/*    */ 
/*    */ import dev.august.enchanter.UI.UIManager;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MouseManager
/*    */   implements MouseListener, MouseMotionListener
/*    */ {
/*    */   private boolean leftPressed;
/*    */   private boolean rightPressed;
/*    */   private int mouseX;
/*    */   private int mouseY;
/*    */   private UIManager uiManager;
/*    */   
/* 20 */   public void setUIManager(UIManager uiManager) { this.uiManager = uiManager; }
/*    */ 
/*    */ 
/*    */   
/* 24 */   public boolean isLeftPressed() { return this.leftPressed; }
/*    */ 
/*    */ 
/*    */   
/* 28 */   public int getMouseX() { return this.mouseX; }
/*    */ 
/*    */ 
/*    */   
/* 32 */   public int getMouseY() { return this.mouseY; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public boolean isRightPressed() { return this.rightPressed; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseDragged(MouseEvent arg0) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseMoved(MouseEvent e) {
/* 46 */     this.mouseX = e.getX();
/* 47 */     this.mouseY = e.getY();
/*    */     
/* 49 */     if (this.uiManager != null) {
/* 50 */       this.uiManager.onMouseMove(e);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent arg0) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseEntered(MouseEvent arg0) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseExited(MouseEvent arg0) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 70 */     if (e.getButton() == 1) {
/* 71 */       this.leftPressed = true;
/* 72 */     } else if (e.getButton() == 3) {
/* 73 */       this.rightPressed = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 78 */     if (e.getButton() == 1) {
/* 79 */       this.leftPressed = false;
/* 80 */     } else if (e.getButton() == 3) {
/* 81 */       this.rightPressed = false;
/* 82 */     }  if (this.uiManager != null)
/* 83 */       this.uiManager.onMouseRelease(e); 
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\input\MouseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
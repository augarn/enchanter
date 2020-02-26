/*    */ package dev.august.enchanter.input;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyManager
/*    */   implements KeyListener
/*    */ {
/* 14 */   private boolean[] keys = new boolean[256];
/* 15 */   private boolean[] justPressed = new boolean[this.keys.length];
/* 16 */   private boolean[] cantPress = new boolean[this.keys.length]; public boolean up;
/*    */   public boolean down;
/*    */   public boolean left;
/*    */   
/*    */   public void tick() {
/* 21 */     for (int i = 0; i < this.keys.length; i++) {
/* 22 */       if (this.cantPress[i] && !this.keys[i]) {
/* 23 */         this.cantPress[i] = false;
/* 24 */       } else if (this.justPressed[i]) {
/* 25 */         this.cantPress[i] = true;
/* 26 */         this.justPressed[i] = false;
/*    */       } 
/* 28 */       if (!this.cantPress[i] && this.keys[i]) {
/* 29 */         this.justPressed[i] = true;
/*    */       }
/*    */     } 
/*    */     
/* 33 */     this.up = this.keys[87];
/* 34 */     this.down = this.keys[83];
/* 35 */     this.left = this.keys[65];
/* 36 */     this.right = this.keys[68];
/* 37 */     this.testHealth = this.keys[84];
/* 38 */     this.attackMove = this.keys[1];
/*    */   }
/*    */   public boolean right; public boolean testHealth; public boolean attackMove; public static boolean esc;
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 43 */     if (e.getKeyCode() < 0 || e.getKeyCode() >= this.keys.length)
/*    */       return; 
/* 45 */     this.keys[e.getKeyCode()] = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 51 */     if (e.getKeyCode() < 0 || e.getKeyCode() >= this.keys.length)
/*    */       return; 
/* 53 */     this.keys[e.getKeyCode()] = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ 
/*    */   
/*    */   public boolean keyJustPressed(int keyCode) {
/* 62 */     if (keyCode < 0 || keyCode >= this.keys.length)
/* 63 */       return false; 
/* 64 */     return this.justPressed[keyCode];
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\input\KeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
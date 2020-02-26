/*    */ package dev.august.enchanter.UI;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class UIImageButton
/*    */   extends UIObject {
/*    */   private BufferedImage[] images;
/*    */   private ClickListener clicker;
/*    */   
/*    */   public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
/* 12 */     super(x, y, width, height);
/* 13 */     this.images = images;
/* 14 */     this.clicker = clicker;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 24 */     if (this.hovering) {
/* 25 */       g.drawImage(this.images[1], (int)this.x, (int)this.y, null);
/*    */     } else {
/* 27 */       g.drawImage(this.images[0], (int)this.x, (int)this.y, null);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 32 */   public void onClick() { this.clicker.onClick(); }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\UI\UIImageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
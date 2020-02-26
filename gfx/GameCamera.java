/*    */ package dev.august.enchanter.gfx;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.entities.Entity;
/*    */ 
/*    */ public class GameCamera
/*    */ {
/*    */   private Handler handler;
/*    */   private float xOffset;
/*    */   private float yOffset;
/*    */   
/*    */   public GameCamera(Handler handler, float xOffset, float yOffset) {
/* 13 */     this.handler = handler;
/* 14 */     this.xOffset = xOffset;
/* 15 */     this.yOffset = yOffset;
/*    */   }
/*    */   
/*    */   public void checkBlankSpace() {
/* 19 */     if (this.xOffset < 0.0F) {
/* 20 */       this.xOffset = 0.0F;
/* 21 */     } else if (this.xOffset > (this.handler.getWorld().getWidth() * 32 - this.handler.getWidth())) {
/* 22 */       this.xOffset = (this.handler.getWorld().getWidth() * 32 - this.handler.getWidth());
/*    */     } 
/*    */     
/* 25 */     if (this.yOffset < 0.0F) {
/* 26 */       this.yOffset = 0.0F;
/* 27 */     } else if (this.yOffset > (this.handler.getWorld().getHeight() * 32 - this.handler.getHeight())) {
/* 28 */       this.yOffset = (this.handler.getWorld().getHeight() * 32 - this.handler.getHeight());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void centerOnEntity(Entity e) {
/* 33 */     this.xOffset = e.getX() - (this.handler.getWidth() / 2) + (e.getWidth() / 2);
/* 34 */     this.yOffset = e.getY() - (this.handler.getHeight() / 2) + (e.getHeight() / 2);
/* 35 */     checkBlankSpace();
/*    */   }
/*    */   
/*    */   public void move(float xAmt, float yAmt) {
/* 39 */     this.xOffset += xAmt;
/* 40 */     this.yOffset += yAmt;
/* 41 */     checkBlankSpace();
/*    */   }
/*    */ 
/*    */   
/* 45 */   public float getxOffset() { return this.xOffset; }
/*    */ 
/*    */ 
/*    */   
/* 49 */   public void setxOffset(float xOffset) { this.xOffset = xOffset; }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public float getyOffset() { return this.yOffset; }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public void setyOffset(float yOffset) { this.yOffset = yOffset; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\GameCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
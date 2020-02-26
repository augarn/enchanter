/*    */ package dev.august.enchanter.UI;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.geom.RoundRectangle2D;
/*    */ 
/*    */ public abstract class UIObject
/*    */ {
/*    */   protected float x;
/*    */   protected float y;
/*    */   protected float width;
/*    */   
/*    */   public UIObject(float x, float y, float width, float height) {
/* 14 */     this.x = x;
/* 15 */     this.y = y;
/* 16 */     this.width = width;
/* 17 */     this.height = height;
/* 18 */     this.bounds = new RoundRectangle2D.Float(x, y, width, height, 10.0F, 10.0F);
/*    */   }
/*    */   protected float height; protected RoundRectangle2D bounds; protected boolean hovering = false;
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */   
/*    */   public abstract void onClick();
/*    */   
/*    */   public void onMouseMove(MouseEvent e) {
/* 28 */     if (this.bounds.contains(e.getX(), e.getY())) {
/* 29 */       this.hovering = true;
/*    */     } else {
/* 31 */       this.hovering = false;
/*    */     } 
/*    */   }
/*    */   public void onMouseRelease(MouseEvent e) {
/* 35 */     if (this.hovering) {
/* 36 */       onClick();
/*    */     }
/*    */   }
/*    */   
/* 40 */   public float getX() { return this.x; }
/*    */ 
/*    */   
/* 43 */   public void setX(float x) { this.x = x; }
/*    */ 
/*    */   
/* 46 */   public float getY() { return this.y; }
/*    */ 
/*    */   
/* 49 */   public void setY(float y) { this.y = y; }
/*    */ 
/*    */   
/* 52 */   public float getWidth() { return this.width; }
/*    */ 
/*    */   
/* 55 */   public void setWidth(int width) { this.width = width; }
/*    */ 
/*    */   
/* 58 */   public float getHeight() { return this.height; }
/*    */ 
/*    */   
/* 61 */   public void setHeight(int height) { this.height = height; }
/*    */ 
/*    */   
/* 64 */   public boolean isHovering() { return this.hovering; }
/*    */ 
/*    */   
/* 67 */   public void setHovering(boolean hovering) { this.hovering = hovering; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\UI\UIObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
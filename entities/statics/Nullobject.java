/*    */ package dev.august.enchanter.entities.statics;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class Nullobject
/*    */   extends StaticEntity
/*    */ {
/* 10 */   public Nullobject(Handler handler, float x, float y, int width, int height) { super(handler, x, y, width, height); }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {}
/*    */   
/*    */   public void die() {}
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\statics\Nullobject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
/*    */ package dev.august.enchanter.entities.statics;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tree
/*    */   extends StaticEntity
/*    */ {
/* 14 */   public Tree(Handler handler, float x, float y, int width, int height) { super(handler, x, y, 96, 128); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 24 */     g.drawImage(Assets.tree, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 25 */         (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*    */   }
/*    */   
/*    */   public void die() {}
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\statics\Tree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
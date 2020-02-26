/*    */ package dev.august.enchanter.entities.statics;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rock
/*    */   extends StaticEntity
/*    */ {
/* 12 */   public Rock(Handler handler, float x, float y, int width, int height) { super(handler, x, y, width, height); }
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
/* 23 */   public void render(Graphics g) { g.drawImage(Assets.rock, (int)(this.x - this.handler.getGameCamera().getxOffset()), (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null); }
/*    */   
/*    */   public void die() {}
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\statics\Rock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
/*    */ package dev.august.enchanter.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class SpriteSheet
/*    */ {
/*    */   private BufferedImage sheet;
/*    */   
/* 10 */   public SpriteSheet(BufferedImage sheet) { this.sheet = sheet; }
/*    */ 
/*    */ 
/*    */   
/* 14 */   public BufferedImage crop(int x, int y, int width, int height) { return this.sheet.getSubimage(x, y, width, height); }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\SpriteSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
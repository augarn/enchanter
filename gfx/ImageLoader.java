/*    */ package dev.august.enchanter.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ public class ImageLoader
/*    */ {
/*    */   public static BufferedImage loadImage(String path) {
/*    */     try {
/* 12 */       return ImageIO.read(ImageLoader.class.getResource(path));
/* 13 */     } catch (IOException e) {
/* 14 */       e.printStackTrace();
/* 15 */       System.exit(1);
/*    */       
/* 17 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\ImageLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
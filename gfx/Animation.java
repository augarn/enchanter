/*    */ package dev.august.enchanter.gfx;
/*    */ 
/*    */ import dev.august.enchanter.items.Item;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Animation {
/*    */   private int speed;
/*    */   private int index;
/*    */   private long lastTime;
/*    */   private long timer;
/*    */   private BufferedImage[] frames;
/*    */   private Animation anim;
/*    */   private String name;
/*    */   private int id;
/*    */   
/*    */   public Animation(int speed, BufferedImage[] frames) {
/* 17 */     this.speed = speed;
/* 18 */     this.frames = frames;
/* 19 */     this.index = 0;
/* 20 */     this.timer = 0L;
/* 21 */     this.lastTime = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void tick() {
/* 25 */     this.timer += System.currentTimeMillis() - this.lastTime;
/* 26 */     this.lastTime = System.currentTimeMillis();
/*    */     
/* 28 */     if (this.timer > this.speed) {
/* 29 */       this.index++;
/* 30 */       this.timer = 0L;
/* 31 */       if (this.index >= this.frames.length) {
/* 32 */         this.index = 0;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/* 37 */   public BufferedImage getCurrentFrame() { return this.frames[this.index]; }
/*    */ 
/*    */   
/*    */   public Item createNew(int x, int y) {
/* 41 */     Item i = new Item(this.anim, this.name, this.id);
/* 42 */     i.setPosition(x, y);
/* 43 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
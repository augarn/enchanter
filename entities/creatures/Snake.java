/*    */ package dev.august.enchanter.entities.creatures;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.gfx.Animation;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import dev.august.enchanter.items.Item;
/*    */ import java.awt.Graphics;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Snake
/*    */   extends Creature
/*    */ {
/*    */   private Animation animDown;
/*    */   private Animation animUp;
/*    */   private Animation animLeft;
/*    */   private Animation animRight;
/*    */   private long timer;
/*    */   private long lastTime;
/* 19 */   private Random rand = new Random();
/*    */   private int mode;
/* 21 */   private int duration = this.rand.nextInt(4000) + 1000;
/*    */   
/*    */   public Snake(Handler handler, float x, float y, int width, int height) {
/* 24 */     super(handler, x, y, width, height);
/*    */     
/* 26 */     this.bounds.x = 16;
/* 27 */     this.bounds.y = 16;
/* 28 */     this.bounds.width = 16;
/* 29 */     this.bounds.height = 16;
/* 31 */     this.animDown = new Animation(180, Assets.snake_down);
/* 32 */     this.animUp = new Animation(180, Assets.snake_up);
/* 33 */     this.animLeft = new Animation(180, Assets.snake_left);
/* 34 */     this.animRight = new Animation(180, Assets.snake_right);
/*    */     this.playerHealth = 1;
/* 36 */     this.lastTime = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 41 */     this.animDown.tick();
/* 42 */     this.animUp.tick();
/* 43 */     this.animLeft.tick();
/* 44 */     this.animRight.tick();
/* 45 */     movement();
/* 46 */     move();
/*    */   }
/*    */   
/*    */   public void movement() {
/* 50 */     this.timer += System.currentTimeMillis() - this.lastTime;
/* 51 */     this.lastTime = System.currentTimeMillis();
/* 52 */     if (this.timer < 1L || this.timer == 3000L) {
/* 53 */       this.mode = this.rand.nextInt(4);
/*    */     }
/* 55 */     if (this.timer < 1000L) {
/* 56 */       if (this.mode == 0) {
/* 57 */         this.xMove = (float)(this.speed * 0.25D);
/* 58 */       } else if (this.mode == 1) {
/* 59 */         this.xMove = (float)(-this.speed * 0.25D);
/* 60 */       } else if (this.mode == 2) {
/* 61 */         this.yMove = (float)(this.speed * 0.25D);
/* 62 */       } else if (this.mode == 3) {
/* 63 */         this.yMove = (float)(-this.speed * 0.25D);
/*    */       } 
/*    */     } else {
/* 66 */       this.xMove = 0.0F;
/* 67 */       this.yMove = 0.0F;
/*    */     } 
/* 69 */     if (this.timer >= this.duration) {
/* 70 */       this.timer = 0L;
/*    */     }
/*    */   }
/*    */ 
/*    
/*    */   public void render(Graphics g) {
/* 76 */     if (this.mode == 0) {
/* 77 */       g.drawImage(this.animRight.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 78 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*    */     }
/* 80 */     if (this.mode == 1) {
/* 81 */       g.drawImage(this.animLeft.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 82 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*    */     }
/* 84 */     if (this.mode == 2) {
/* 85 */       g.drawImage(this.animDown.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 86 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*    */     }
/* 88 */     if (this.mode == 3) {
/* 89 */       g.drawImage(this.animUp.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 90 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void die() {
/* 96 */     this.handler.getWorld().getItemManager().addItem(Item.coinItem.createNew((int)this.x, (int)this.y));
/* 97 */     this.handler.getWorld().getEntityManager().getPlayer().setPlayerXP(100);
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\creatures\Snake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
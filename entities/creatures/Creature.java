/*     */ package dev.august.enchanter.entities.creatures;
/*     */ 
/*     */ import dev.august.enchanter.Handler;
/*     */ import dev.august.enchanter.entities.Entity;
/*     */ 
/*     */ public abstract class Creature
/*     */   extends Entity {
/*     */   public static final float DEFAULT_SPEED = 3.0F;
/*     */   public static final int DEFAULT_CREATURE_WIDTH = 64;
/*     */   public static final int DEFAULT_CREATURE_HEIGHT = 64;
/*     */   protected float speed;
/*     */   protected float xMove;
/*     */   protected float yMove;
/*     */   protected boolean inCombat = false;
/*     */   
/*  16 */   public int getHealth() { return this.playerHealth; }
/*     */ 
/*     */ 
/*     */   
/*  20 */   public void setHealth(int health) { this.playerHealth = health; }
/*     */ 
/*     */ 
/*     */   
/*  24 */   public float getSpeed() { return this.speed; }
/*     */ 
/*     */ 
/*     */   
/*  28 */   public float getPlayerHealth() { return this.playerHealth; }
/*     */ 
/*     */   
/*  31 */   public void setSpeed(float speed) { this.speed = speed; }
/*     */ 
/*     */   
/*     */   public Creature(Handler handler, float x, float y, int width, int height) {
/*  35 */     super(handler, x, y, width, height);
/*  36 */     this.speed = 3.0F;
/*  37 */     this.xMove = 0.0F;
/*  38 */     this.yMove = 0.0F;
/*     */   }
/*     */   
/*     */   public void move() {
/*  42 */     if (!checkEntityCollisions(this.xMove, 0.0F))
/*  43 */       moveX(); 
/*  44 */     if (!checkEntityCollisions(0.0F, this.yMove))
/*  45 */       moveY(); 
/*     */   }
/*     */   
/*     */   public void moveX() {
/*  49 */     if (this.xMove > 0.0F) {
/*     */       
/*  51 */       int tx = (int)(this.x + this.xMove + this.bounds.x + this.bounds.width) / 32;
/*  52 */       if (!collisionWithTile(tx, (int)(this.y + this.bounds.y) / 32) && 
/*  53 */         !collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32)) {
/*  54 */         this.x += this.xMove;
/*     */       }
/*     */     }
/*  57 */     else if (this.xMove < 0.0F) {
/*  58 */       int tx = (int)(this.x + this.xMove + this.bounds.x) / 32;
/*  59 */       if (!collisionWithTile(tx, (int)(this.y + this.bounds.y) / 32) && 
/*  60 */         !collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32)) {
/*  61 */         this.x += this.xMove;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveY() {
/*  67 */     if (this.yMove < 0.0F) {
/*  68 */       int ty = (int)(this.y + this.yMove + this.bounds.y) / 32;
/*     */       
/*  70 */       if (!collisionWithTile((int)(this.x + this.bounds.x) / 32, ty) && 
/*  71 */         !collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty)) {
/*  72 */         this.y += this.yMove;
/*     */       }
/*  74 */     } else if (this.yMove > 0.0F) {
/*  75 */       int ty = (int)(this.y + this.yMove + this.bounds.y + this.bounds.height) / 32;
/*     */       
/*  77 */       if (!collisionWithTile((int)(this.x + this.bounds.x) / 32, ty) && 
/*  78 */         !collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty)) {
/*  79 */         this.y += this.yMove;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  85 */   protected boolean collisionWithTile(int x, int y) { return this.handler.getWorld().getTile(x, y).isSolid(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public float getxMove() { return this.xMove; }
/*     */ 
/*     */ 
/*     */   
/*  94 */   public void setxMove(float xMove) { this.xMove = xMove; }
/*     */ 
/*     */ 
/*     */   
/*  98 */   public float getyMove() { return this.yMove; }
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void setyMove(float yMove) { this.yMove = yMove; }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\creatures\Creature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
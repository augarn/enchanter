/*     */ package dev.august.enchanter.entities;
/*     */ 
/*     */ import dev.august.enchanter.Handler;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ public abstract class Entity
/*     */ {
/*     */   public static final int DEFAULT_HEALTH = 1;
/*     */   protected Handler handler;
/*     */   protected float x;
/*     */   protected float y;
/*     */   protected int width;
/*     */   protected int height;
/*     */   protected int playerHealth;
/*     */   protected Rectangle bounds;
/*     */   protected boolean active = true;
/*     */   private int health;
/*     */   
/*  20 */   public int getHealth() { return this.playerHealth; }
/*     */ 
/*     */ 
/*     */   
/*  24 */   public void setHealth(int health) { this.playerHealth = health; }
/*     */ 
/*     */ 
/*     */   
/*  28 */   public boolean isActive() { return this.active; }
/*     */ 
/*     */ 
/*     */   
/*  32 */   public void setActive(boolean active) { this.active = active; }
/*     */ 
/*     */   
/*     */   public Entity(Handler handler, float x, float y, int width, int height) {
/*  36 */     this.handler = handler;
/*  37 */     this.x = x;
/*  38 */     this.y = y;
/*  39 */     this.width = width;
/*  40 */     this.height = height;
/*  41 */     this.health = 1;
/*  42 */     this.bounds = new Rectangle(0, 0, width, height);
/*     */   }
/*     */ 
/*     */   
/*  46 */   public float getX() { return this.x; }
/*     */ 
/*     */ 
/*     */   
/*  50 */   public void setX(float x) { this.x = x; }
/*     */ 
/*     */ 
/*     */   
/*  54 */   public float getY() { return this.y; }
/*     */ 
/*     */ 
/*     */   
/*  58 */   public void setY(float y) { this.y = y; }
/*     */ 
/*     */ 
/*     */   
/*  62 */   public int getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */   
/*  66 */   public void setWidth(int width) { this.width = width; }
/*     */ 
/*     */ 
/*     */   
/*  70 */   public int getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */   
/*  74 */   public void setHeight(int height) { this.height = height; }
/*     */ 
/*     */   
/*     */   public abstract void tick();
/*     */   
/*     */   public abstract void render(Graphics paramGraphics);
/*     */   
/*     */   public abstract void die();
/*     */   
/*     */   public void hurt(int amt, Graphics g) {
/*  84 */     this.health -= amt;
/*  85 */     if (this.health < 0) {
/*  86 */       this.active = false;
/*  87 */       die();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  92 */   public Rectangle getCollisionBounds(float xOffset, float yOffset) { return new Rectangle((int)(this.x + this.bounds.x + xOffset), (int)(this.y + this.bounds.y + yOffset), this.bounds.width - 5, this.bounds.height - 5); }
/*     */ 
/*     */   
/*     */   public boolean checkEntityCollisions(float xOffset, float yOffset) {
/*  96 */     for (Entity e : this.handler.getWorld().getEntityManager().getEntities()) {
/*  97 */       if (e.equals(this))
/*     */         continue; 
/*  99 */       if (e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
/* 100 */         return true; 
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
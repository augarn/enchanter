/*     */ package dev.august.enchanter.entities.creatures;
/*     */ 
		  import dev.august.enchanter.entities.statics.*;
/*     */ import dev.august.enchanter.Handler;
/*     */ import dev.august.enchanter.entities.Entity;
/*     */ import dev.august.enchanter.gfx.Animation;
/*     */ import dev.august.enchanter.gfx.Assets;
/*     */ import dev.august.enchanter.inventory.Inventory;
/*     */ import dev.august.enchanter.vfx.Sound;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ public class Player
/*     */   extends Creature {
/*     */   private Animation animDown;
/*     */   private Animation animUp;
/*     */   private Animation animRight;
/*     */   private Animation animLeft;
/*  19 */   private int lastMovement = 0; private Animation animAttackUp; private Animation animAttackDown; private Animation animAttackLeft; private Animation animAttackRight;
/*  20 */   private int xp = 0;
/*  21 */   private int level = 0;
/*     */   
/*     */   private Inventory inventory;
/*     */   
/*  25 */   public int getHealth() { return this.playerHealth; }
/*     */ 
/*     */ 
/*     */   
/*  29 */   public void setHealth(int health) { this.playerHealth = health; }
/*     */ 
/*     */   
/*     */   public void setPlayerXP(int xp) {
/*  33 */     if (this.xp < 127)
/*  34 */       this.xp += xp; 
/*  35 */     if (this.xp >= 127) {
/*  36 */       Sound.levelUp.play_normal_volume();
/*  37 */       this.level++;
/*  38 */       this.xp = 0;
/*     */     } 
/*     */   }
/*  41 */   public static Sound walking_grass = new Sound("walking_grass.wav");
/*     */   
/*     */   public Player(Handler handler, float x, float y) {
/*  44 */     super(handler, x, y, 40, 40);
/*     */     
/*  46 */     this.bounds.x = 16;
/*  47 */     this.bounds.y = 16;
/*  48 */     this.bounds.width = 13;
/*  49 */     this.bounds.height = 13;
/*     */ 
/*     */     
/*  52 */     this.animDown = new Animation(90, Assets.player_down);
/*  53 */     this.animUp = new Animation(90, Assets.player_up);
/*  54 */     this.animRight = new Animation(90, Assets.player_right);
/*  55 */     this.animLeft = new Animation(90, Assets.player_left);
/*  56 */     this.animAttackUp = new Animation(90, Assets.player_attack_up);
/*  57 */     this.animAttackDown = new Animation(60, Assets.player_attack_down);
/*  58 */     this.animAttackLeft = new Animation(90, Assets.player_attack_left);
/*  59 */     this.animAttackRight = new Animation(90, Assets.player_attack_right);
/*     */     
/*  61 */     this.inventory = new Inventory(handler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tick() {
/*  67 */     this.animUp.tick();
/*  68 */     this.animDown.tick();
/*  69 */     this.animRight.tick();
/*  70 */     this.animLeft.tick();
/*  71 */     this.animAttackUp.tick();
/*  72 */     this.animAttackDown.tick();
/*  73 */     this.animAttackLeft.tick();
/*  74 */     this.animAttackRight.tick();
/*     */     
/*  76 */     getInput();
/*  77 */     move();
/*  78 */     checkAttacks();
/*  79 */     this.handler.getGameCamera().centerOnEntity(this);
/*  80 */     this.inventory.tick();
/*     */   }
/*     */   
/*     */   private void checkAttacks() {
/*  84 */     Rectangle cb = getCollisionBounds(0.0F, 0.0F);
/*  85 */     Rectangle ar = new Rectangle();
/*  86 */     int arSize = 3;
/*  87 */     ar.width = arSize;
/*  88 */     ar.height = arSize;
/*     */     
/*  90 */     if (this.handler.getMouseManager().isLeftPressed() && this.lastMovement == 1) {
/*  91 */       ar.x = cb.x + cb.width / 2 - arSize / 2;
/*  92 */       cb.y -= arSize;
/*  93 */     } else if (this.handler.getMouseManager().isLeftPressed() && this.lastMovement == 2) {
/*  94 */       ar.x = cb.x + cb.width / 2 - arSize / 2;
/*  95 */       cb.y += cb.height;
/*  96 */     } else if (this.handler.getMouseManager().isLeftPressed() && this.lastMovement == 3) {
/*  97 */       cb.x += cb.width;
/*  98 */       cb.y -= arSize;
/*  99 */     } else if (this.handler.getMouseManager().isLeftPressed() && this.lastMovement == 4) {
/* 100 */       cb.x -= arSize;
/* 101 */       ar.y = cb.y + cb.height / 2 - arSize / 2;
/*     */     } else {
/*     */       return;
/*     */     } 
/* 105 */     for (Entity e : this.handler.getWorld().getEntityManager().getEntities()) {
/* 106 */       if (e.equals(this) || e.getClass() == Tree.class) {
					continue;
				}else if (e.getClass() == Snake.class) {
/* 109 */         e.hurt(4, null);
				  System.out.println(e);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getInput() {
/* 116 */     this.xMove = 0.0F;
/* 117 */     this.yMove = 0.0F;
/*     */     
/* 119 */     if ((this.handler.getKeyManager()).up && !(this.handler.getKeyManager()).down)
/* 120 */       this.yMove = -this.speed; 
/* 121 */     if ((this.handler.getKeyManager()).down && !(this.handler.getKeyManager()).up)
/* 122 */       this.yMove = this.speed; 
/* 123 */     if ((this.handler.getKeyManager()).right && !(this.handler.getKeyManager()).left)
/* 124 */       this.xMove = this.speed; 
/* 125 */     if ((this.handler.getKeyManager()).left && !(this.handler.getKeyManager()).right) {
/* 126 */       this.xMove = -this.speed;
/*     */     }
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 131 */     if (this.handler.getMouseManager().isLeftPressed() && this.lastMovement == 2) {
/* 132 */       g.drawImage(this.animAttackDown.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 133 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     }
/* 135 */     if (this.lastMovement == 0) {
/* 136 */       g.drawImage(Assets.player_down_still, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 137 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     }
/*     */     
/* 140 */     if (((this.handler.getKeyManager()).up && !(this.handler.getKeyManager()).down) || (
/* 141 */       (this.handler.getKeyManager()).up && (this.handler.getKeyManager()).right && !(this.handler.getKeyManager()).down) || (
/* 142 */       (this.handler.getKeyManager()).up && !(this.handler.getKeyManager()).right) || (
/* 143 */       (this.handler.getKeyManager()).up && (this.handler.getKeyManager()).left)) {
/* 144 */       g.drawImage(this.animUp.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 145 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/* 146 */       this.lastMovement = 1;
/* 147 */       if (!Sound.walking_grass.isActive())
/*     */       {
/*     */         
/* 150 */         Sound.walking_grass.play_normal_volume();
/*     */       }
/* 152 */     } else if (this.lastMovement == 1) {
/* 153 */       g.drawImage(Assets.player_up_still, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 154 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     } 
/*     */     
/* 157 */     if (((this.handler.getKeyManager()).down && !(this.handler.getKeyManager()).up) || (
/* 158 */       (this.handler.getKeyManager()).down && (this.handler.getKeyManager()).right) || (
/* 159 */       (this.handler.getKeyManager()).down && (this.handler.getKeyManager()).left)) {
/* 160 */       g.drawImage(this.animDown.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 161 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/* 162 */       this.lastMovement = 2;
/* 163 */       if (!Sound.walking_grass.isActive())
/*     */       {
/*     */         
/* 166 */         Sound.walking_grass.play_normal_volume();
/*     */       }
/* 168 */     } else if (this.lastMovement == 2 && !this.handler.getMouseManager().isLeftPressed()) {
/* 169 */       g.drawImage(Assets.player_down_still, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 170 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     } 
/*     */ 
/*     */     
/* 174 */     if ((this.handler.getKeyManager()).right && !(this.handler.getKeyManager()).up && !(this.handler.getKeyManager()).down && 
/* 175 */       !(this.handler.getKeyManager()).left) {
/* 176 */       g.drawImage(this.animRight.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 177 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/* 178 */       this.lastMovement = 3;
/* 179 */       if (!Sound.walking_grass.isActive())
/*     */       {
/*     */         
/* 182 */         Sound.walking_grass.play_normal_volume();
/*     */       }
/* 184 */     } else if (this.lastMovement == 3) {
/* 185 */       g.drawImage(Assets.player_right_still, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 186 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     } 
/*     */     
/* 189 */     if ((this.handler.getKeyManager()).left && !(this.handler.getKeyManager()).right && !(this.handler.getKeyManager()).down && 
/* 190 */       !(this.handler.getKeyManager()).up) {
/* 191 */       g.drawImage(this.animLeft.getCurrentFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 192 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/* 193 */       this.lastMovement = 4;
/* 194 */       if (!Sound.walking_grass.isActive())
/*     */       {
/*     */         
/* 197 */         Sound.walking_grass.play_normal_volume();
/*     */       }
/* 199 */     } else if (this.lastMovement == 4) {
/* 200 */       g.drawImage(Assets.player_left_still, (int)(this.x - this.handler.getGameCamera().getxOffset()), 
/* 201 */           (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
/*     */     } 
/*     */     
/* 204 */     this.inventory.render(g);
/* 205 */     g.setColor(Color.RED);
/* 206 */     g.fillRect(75, 23, 130, 18);
/* 207 */     g.setColor(Color.GRAY);
/* 208 */     g.fillRect(75, 40, 130, 18);
/* 209 */     g.setColor(Color.YELLOW);
/* 210 */     g.fillRect(75, 63, this.xp, 9);
/* 211 */     g.setColor(Color.WHITE);
/* 212 */     g.drawImage(Assets.playergui, 0, 0, null);
/* 213 */     g.drawString(Integer.toString(this.level), 56, 70);
/*     */   }
/*     */ 
/*     */   
/* 217 */   public Inventory getInventory() { return this.inventory; }
/*     */ 
/*     */ 
/*     */   
/* 221 */   public void setInventory(Inventory inventory) { this.inventory = inventory; }
/*     */   
/*     */   public void die() {}
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\creatures\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
/*     */ package dev.august.enchanter.items;
/*     */ 
/*     */ import dev.august.enchanter.Handler;
/*     */ import dev.august.enchanter.gfx.Animation;
/*     */ import dev.august.enchanter.gfx.Assets;
/*     */ import dev.august.enchanter.vfx.Sound;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ 
/*     */ public class Item
/*     */ {
/*  13 */   public static Item[] items = new Item[256];
/*     */   
/*  15 */   public static Animation stoneAnimation = new Animation(120, Assets.stoneAnimation);
/*  16 */   public static Item rockItem = new Item(stoneAnimation, "Rock", 0);
/*  17 */   public static Item coinItem = new Item(Assets.coinsanim, "Copper", 1);
/*     */   
/*     */   public static final int ITEMWIDTH = 16;
/*     */   public static final int ITEMHEIGHT = 16;
/*     */   protected Handler handler;
/*     */   protected Animation texture;
/*     */   protected String name;
/*     */   protected final int id;
/*     */   protected Rectangle bounds;
/*     */   protected int x;
/*     */   protected int y;
/*     */   protected int count;
/*     */   protected boolean pickedUp = false;
/*     */   
/*     */   public Item(Animation texture, String name, int id) {
/*  32 */     this.texture = texture;
/*  33 */     this.name = name;
/*  34 */     this.id = id;
/*  35 */     this.count = 1;
/*     */     
/*  37 */     this.bounds = new Rectangle(this.x, this.y, 16, 16);
/*     */     
/*  39 */     items[id] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  44 */     this.texture.tick();
/*  45 */     if (this.handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0.0F, 0.0F).intersects(this.bounds)) {
/*  46 */       this.pickedUp = true;
/*  47 */       this.handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
/*  48 */       if (this.handler.getWorld().getEntityManager().getEntities().get(1) != null) {
/*  49 */         Sound.coin.play_normal_volume();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  56 */   public boolean isPickedUp() { return this.pickedUp; }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  60 */     if (this.handler == null)
/*     */       return; 
/*  62 */     render(g, (int)(this.x - this.handler.getGameCamera().getxOffset()), (int)(this.y - this.handler.getGameCamera().getyOffset()));
/*     */   }
/*     */   
/*     */   public Item createNew(int x, int y) {
/*  66 */     Item i = new Item(this.texture, this.name, this.id);
/*  67 */     i.setPosition(x, y);
/*  68 */     return i;
/*     */   }
/*     */   
/*     */   public void setPosition(int x, int y) {
/*  72 */     this.x = x;
/*  73 */     this.y = y;
/*  74 */     this.bounds.x = x;
/*  75 */     this.bounds.y = y;
/*     */   }
/*     */   
/*  78 */   public Handler getHandler() { return this.handler; }
/*     */ 
/*     */ 
/*     */   
/*  82 */   public void setHandler(Handler handler) { this.handler = handler; }
/*     */ 
/*     */ 
/*     */   
/*  86 */   public Animation getTexture() { return this.texture; }
/*     */ 
/*     */ 
/*     */   
/*  90 */   public void setTexture(Animation texture) { this.texture = texture; }
/*     */ 
/*     */ 
/*     */   
/*  94 */   public String getName() { return this.name; }
/*     */ 
/*     */ 
/*     */   
/*  98 */   public void setName(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */   
/* 102 */   public int getX() { return this.x; }
/*     */ 
/*     */ 
/*     */   
/* 106 */   public void setX(int x) { this.x = x; }
/*     */ 
/*     */ 
/*     */   
/* 110 */   public int getY() { return this.y; }
/*     */ 
/*     */ 
/*     */   
/* 114 */   public void setY(int y) { this.y = y; }
/*     */ 
/*     */ 
/*     */   
/* 118 */   public int getCount() { return this.count; }
/*     */ 
/*     */ 
/*     */   
/* 122 */   public void setCount(int count) { this.count = count; }
/*     */ 
/*     */ 
/*     */   
/* 126 */   public int getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/* 130 */   public void render(Graphics g, int x, int y) { g.drawImage(getTexture().getCurrentFrame(), x, y, 16, 16, null); }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\items\Item.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
/*     */ package dev.august.enchanter.worlds;
/*     */ 
/*     */ import dev.august.enchanter.Handler;
/*     */ import dev.august.enchanter.entities.Entity;
/*     */ import dev.august.enchanter.entities.EntityManager;
/*     */ import dev.august.enchanter.entities.creatures.Player;
/*     */ import dev.august.enchanter.entities.creatures.Snake;
/*     */ import dev.august.enchanter.entities.statics.Tree;
/*     */ import dev.august.enchanter.gfx.UserUI;
/*     */ import dev.august.enchanter.items.ItemManager;
/*     */ import dev.august.enchanter.tiles.Tile;
/*     */ import dev.august.enchanter.utils.Utils;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class World
/*     */ {
/*     */   private Handler handler;
/*     */   private int width;
/*     */   private int height;
/*     */   private int spawnX;
/*     */   private int spawnY;
/*     */   private int[][] tiles;
/*     */   private EntityManager entityManager;
/*     */   private ItemManager itemManager;
/*     */   private UserUI guiObj;
/*     */   
/*     */   public World(Handler handler, String path) throws IOException {
/*  32 */     this.handler = handler;
/*  33 */     this.entityManager = new EntityManager(handler, new Player(handler, 0.0F, 0.0F));
/*  34 */     this.itemManager = new ItemManager(handler);
/*  35 */     this.guiObj = new UserUI(handler, 0.0F, 0.0F, 0, 0);
/*  36 */     loadWorld(path);
/*  37 */     this.entityManager.getPlayer().setX(this.spawnX);
/*  38 */     this.entityManager.getPlayer().setY(this.spawnY);
/*     */     
/*  40 */     this.entityManager.addEntity((Entity)new Snake(handler, 550.0F, 550.0F, 64, 64));
/*  41 */     this.entityManager.addEntity((Entity)new Snake(handler, 400.0F, 400.0F, 64, 64));
/*  42 */     this.entityManager.addEntity((Entity)new Snake(handler, 600.0F, 600.0F, 64, 64));
/*  43 */     this.entityManager.addEntity((Entity)new Snake(handler, 300.0F, 300.0F, 64, 64));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     for (int i = 0; i < 10000; i += 80) {
/*  62 */       this.entityManager.addEntity((Entity)new Tree(handler, i, 0.0F, 32, 32));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  67 */     for (int i = 0; i < 10000; i += 80) {
/*  68 */       this.entityManager.addEntity((Entity)new Tree(handler, i, -60.0F, 32, 32));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     for (int i = 0; i < 10000; i += 80) {
/*  79 */       this.entityManager.addEntity((Entity)new Tree(handler, 0.0F, i, 32, 32));
/*     */     }
/*  81 */     for (int i = 40; i < 10000; i += 80) {
/*  82 */       this.entityManager.addEntity((Entity)new Tree(handler, -60.0F, i, 32, 32));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public EntityManager getEntityManager() { return this.entityManager; }
/*     */ 
/*     */   
/*     */   public void tick() {
/* 103 */     this.itemManager.tick();
/* 104 */     this.entityManager.tick();
/* 105 */     this.guiObj.tick();
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 109 */     int xStart = (int)Math.max(0.0F, this.handler.getGameCamera().getxOffset() / 32.0F);
/* 110 */     int xEnd = (int)Math.min(this.width, (
/* 111 */         this.handler.getGameCamera().getxOffset() + this.handler.getWidth()) / 32.0F + 1.0F);
/* 112 */     int yStart = (int)Math.max(0.0F, this.handler.getGameCamera().getyOffset() / 32.0F);
/* 113 */     int yEnd = (int)Math.min(this.height, (
/* 114 */         this.handler.getGameCamera().getyOffset() + this.handler.getHeight()) / 32.0F + 1.0F);
/*     */     
/* 116 */     for (int y = yStart; y < yEnd; y++) {
/* 117 */       for (int x = xStart; x < xEnd; x++) {
/* 118 */         getTile(x, y).render(g, (int)((x * 32) - this.handler.getGameCamera().getxOffset()), 
/* 119 */             (int)((y * 32) - this.handler.getGameCamera().getyOffset()));
/*     */       }
/*     */     } 
/* 122 */     this.itemManager.render(g);
/* 123 */     this.entityManager.render(g);
/* 124 */     this.guiObj.render(g);
/*     */   }
/*     */ 
/*     */   
/* 128 */   public Handler getHandler() { return this.handler; }
/*     */ 
/*     */ 
/*     */   
/* 132 */   public void setHandler(Handler handler) { this.handler = handler; }
/*     */ 
/*     */ 
/*     */   
/* 136 */   public ItemManager getItemManager() { return this.itemManager; }
/*     */ 
/*     */ 
/*     */   
/* 140 */   public void setItemManager(ItemManager itemManager) { this.itemManager = itemManager; }
/*     */ 
/*     */   
/*     */   public Tile getTile(int x, int y) {
/* 144 */     if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
/* 145 */       return Tile.Grasswithgrass;
/*     */     }
/* 147 */     Tile t = Tile.tiles[this.tiles[x][y]];
/* 148 */     if (t == null)
/* 149 */       return Tile.treeTile; 
/* 150 */     return t;
/*     */   }
/*     */   
/*     */   private void loadWorld(String path) {
/* 154 */     String file = Utils.loadFileAsString(path);
/* 155 */     String[] tokens = file.split("\\s+");
/* 156 */     this.width = Utils.parseInt(tokens[0]);
/* 157 */     this.height = Utils.parseInt(tokens[1]);
/* 158 */     this.spawnX = Utils.parseInt(tokens[2]);
/* 159 */     this.spawnY = Utils.parseInt(tokens[3]);
/*     */     
/* 161 */     this.tiles = new int[this.width][this.height];
/* 162 */     for (int y = 0; y < this.height; y++) {
/* 163 */       for (int x = 0; x < this.width; x++) {
/* 164 */         this.tiles[x][y] = Utils.parseInt(tokens[x + y * this.width + 4]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 170 */   public int getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */   
/* 174 */   public int getHeight() { return this.height; }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\worlds\World.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
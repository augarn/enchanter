/*    */ package dev.august.enchanter.tiles;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tile
/*    */ {
/* 10 */   public static Tile[] tiles = new Tile[256];
/* 11 */   public static Tile grassTile_2 = new Grasstile_2(0);
/* 12 */   public static Tile Grasswithgrass = new Grasswithgrass(1);
/* 13 */   public static Tile treeTile = new TreeTile(2);
/* 14 */   public static Tile rockTile = new RockTile(3);
/* 15 */   public static Tile flowerbedTile = new FlowerbedTile(4);
/* 16 */   public static Tile grassTopleft = new Grasstopleft(5);
/* 17 */   public static Tile grassTopmid = new Grasstopmid(6);
/* 18 */   public static Tile grassTopright = new Grasstopright(7);
/* 19 */   public static Tile grassMidRight = new Grassmidright(8);
/* 20 */   public static Tile grassMidMid = new Grassmidmid(9);
/* 21 */   public static Tile GrassMidLeft = new Grassmidleft(10);
/* 22 */   public static Tile GrassMidMidLeft = new Grassmidmidleft(13);
/* 23 */   public static Tile GrassMidMidMid = new Grassmidmidmid(12);
/* 24 */   public static Tile GrassMidMidRight = new Grassmidmidright(11);
/* 25 */   public static Tile GrassBotLeft = new Grassbotleft(14);
/* 26 */   public static Tile Grasscomptopleft = new Grasscomptopleft(15);
/* 27 */   public static Tile Grasscomptopright = new Grasscomptopright(16);
/* 28 */   public static Tile Grasscompbotleft = new Grasscompbotleft(17);
/* 29 */   public static Tile Grasscompbotright = new Grasscompbotright(18);
/*    */   
/*    */   public static final int TILEWIDTH = 32;
/*    */   
/*    */   public static final int TILEHEIGHT = 32;
/*    */   protected BufferedImage texture;
/*    */   protected final int id;
/*    */   
/*    */   public Tile(BufferedImage texture, int id) {
/* 38 */     this.texture = texture;
/* 39 */     this.id = id;
/*    */     
/* 41 */     tiles[id] = this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {}
/*    */ 
/*    */   
/* 49 */   public void render(Graphics g, int x, int y) { g.drawImage(this.texture, x, y, 32, 32, null); }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public boolean isSolid() { return false; }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public int getId() { return this.id; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\tiles\Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
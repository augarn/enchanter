/*    */ package dev.august.enchanter;
/*    */ 
/*    */ import dev.august.enchanter.gfx.GameCamera;
/*    */ import dev.august.enchanter.input.KeyManager;
/*    */ import dev.august.enchanter.input.MouseManager;
/*    */ import dev.august.enchanter.worlds.World;
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */ {
/*    */   private Game game;
/*    */   private World world;
/*    */   
/* 14 */   public Handler(Game game) { this.game = game; }
/*    */ 
/*    */ 
/*    */   
/* 18 */   public GameCamera getGameCamera() { return this.game.getGameCamera(); }
/*    */ 
/*    */ 
/*    */   
/* 22 */   public KeyManager getKeyManager() { return this.game.getKeyManager(); }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public MouseManager getMouseManager() { return this.game.getMouseManager(); }
/*    */ 
/*    */ 
/*    */   
/* 30 */   public int getWidth() { return Game.getWidth(); }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public int getHeight() { return Game.getHeight(); }
/*    */ 
/*    */   
/* 37 */   public Game getGame() { return this.game; }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public void setGame(Game game) { this.game = game; }
/*    */ 
/*    */ 
/*    */   
/* 45 */   public World getWorld() { return this.world; }
/*    */ 
/*    */ 
/*    */   
/* 49 */   public void setWorld(World world) { this.world = world; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
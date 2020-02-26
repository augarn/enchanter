/*    */ package dev.august.enchanter.entities;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.entities.creatures.Player;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Comparator;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityManager
/*    */ {
/*    */   private Handler handler;
/*    */   private Player player;
/*    */   private ArrayList<Entity> entities;
/*    */   
/* 20 */   private Comparator<Entity> renderSorter = new Comparator<Entity>()
/*    */     {
/*    */       public int compare(Entity a, Entity b)
/*    */       {
/* 24 */         if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
/* 25 */           return -1; 
/* 26 */         return 1;
/*    */       }
/*    */     };
/*    */   
/*    */   public EntityManager(Handler handler, Player player) {
/* 31 */     this.handler = handler;
/* 32 */     this.player = player;
/* 33 */     this.entities = new ArrayList<>();
/* 34 */     addEntity((Entity)player);
/*    */   }
/*    */   
/*    */   public void tick() {
/* 38 */     Iterator<Entity> it = this.entities.iterator();
/* 39 */     while (it.hasNext()) {
/* 40 */       Entity e = it.next();
/* 41 */       e.tick();
/* 42 */       if (!e.isActive() && e instanceof dev.august.enchanter.entities.creatures.Snake)
/* 43 */         it.remove(); 
/*    */     } 
/* 45 */     this.entities.sort(this.renderSorter);
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 49 */     for (Entity e : this.entities) {
/* 50 */       e.render(g);
/*    */     }
/* 52 */     this.player.render(g);
/*    */   }
/*    */ 
/*    */   
/* 56 */   public Handler getHandler() { return this.handler; }
/*    */ 
/*    */ 
/*    */   
/* 60 */   public void setHandler(Handler handler) { this.handler = handler; }
/*    */ 
/*    */ 
/*    */   
/* 64 */   public Player getPlayer() { return this.player; }
/*    */ 
/*    */ 
/*    */   
/* 68 */   public void setPlayer(Player player) { this.player = player; }
/*    */ 
/*    */ 
/*    */   
/* 72 */   public ArrayList<Entity> getEntities() { return this.entities; }
/*    */ 
/*    */ 
/*    */   
/* 76 */   public void setEntities(ArrayList<Entity> entities) { this.entities = entities; }
/*    */ 
/*    */ 
/*    */   
/* 80 */   public void addEntity(Entity e) { this.entities.add(e); }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\entities\EntityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
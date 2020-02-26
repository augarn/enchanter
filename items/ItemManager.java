/*    */ package dev.august.enchanter.items;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ public class ItemManager
/*    */ {
/*    */   private Handler handler;
/*    */   private ArrayList<Item> items;
/*    */   
/*    */   public ItemManager(Handler handler) {
/* 15 */     this.handler = handler;
/* 16 */     this.items = new ArrayList<>();
/*    */   }
/*    */ 
/*    */   
/* 20 */   public Handler getHandler() { return this.handler; }
/*    */ 
/*    */ 
/*    */   
/* 24 */   public void setHandler(Handler handler) { this.handler = handler; }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 28 */     Iterator<Item> it = this.items.iterator();
/* 29 */     while (it.hasNext()) {
/* 30 */       Item i = it.next();
/* 31 */       i.tick();
/* 32 */       if (i.isPickedUp()) {
/* 33 */         it.remove();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 39 */     for (Item i : this.items) {
/* 40 */       i.render(g);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addItem(Item i) {
/* 45 */     i.setHandler(this.handler);
/* 46 */     this.items.add(i);
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\items\ItemManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
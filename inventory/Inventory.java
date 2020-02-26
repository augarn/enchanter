/*    */ package dev.august.enchanter.inventory;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import dev.august.enchanter.items.Item;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Inventory
/*    */ {
/*    */   private Handler handler;
/*    */   private boolean active = false;
/*    */   private ArrayList<Item> inventoryItems;
/*    */   
/*    */   public Inventory(Handler handler) {
/* 19 */     this.handler = handler;
/* 20 */     this.inventoryItems = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public void tick() {
/* 24 */     if (this.handler.getKeyManager().keyJustPressed(69))
/* 25 */       this.active = !this.active; 
/* 26 */     if (!this.active) {
/*    */       return;
/*    */     }
/* 29 */     for (Item item : this.inventoryItems);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 34 */     if (!this.active)
/*    */       return; 
/* 36 */     g.drawImage(Assets.inventoryscreen, 760, 400, null);
/*    */   }
/*    */   
/*    */   public void addItem(Item item) {
/* 40 */     for (Item i : this.inventoryItems) {
/* 41 */       if (i.getId() == item.getId()) {
/* 42 */         i.setCount(i.getCount() + item.getCount());
/*    */         return;
/*    */       } 
/*    */     } 
/* 46 */     this.inventoryItems.add(item);
/*    */   }
/*    */ 
/*    */   
/* 50 */   public Handler getHandler() { return this.handler; }
/*    */ 
/*    */ 
/*    */   
/* 54 */   public void setHandler(Handler handler) { this.handler = handler; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\inventory\Inventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
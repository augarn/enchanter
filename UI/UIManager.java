/*    */ package dev.august.enchanter.UI;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class UIManager
/*    */ {
/*    */   private Handler handler;
/*    */   private ArrayList<UIObject> objects;
/*    */   
/*    */   public UIManager(Handler handler) {
/* 14 */     this.handler = handler;
/* 15 */     this.objects = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public void tick() {
/* 19 */     for (UIObject o : this.objects)
/* 20 */       o.tick(); 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 24 */     for (UIObject o : this.objects)
/* 25 */       o.render(g); 
/*    */   }
/*    */   
/*    */   public void onMouseMove(MouseEvent e) {
/* 29 */     for (UIObject o : this.objects)
/* 30 */       o.onMouseMove(e); 
/*    */   }
/*    */   
/*    */   public void onMouseRelease(MouseEvent e) {
/* 34 */     for (UIObject o : this.objects) {
/* 35 */       o.onMouseRelease(e);
/*    */     }
/*    */   }
/*    */   
/* 39 */   public Handler getHandler() { return this.handler; }
/*    */ 
/*    */ 
/*    */   
/* 43 */   public void setHandler(Handler handler) { this.handler = handler; }
/*    */ 
/*    */ 
/*    */   
/* 47 */   public ArrayList<UIObject> getObjects() { return this.objects; }
/*    */ 
/*    */ 
/*    */   
/* 51 */   public void setObjects(ArrayList<UIObject> objects) { this.objects = objects; }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public void addObject(UIObject o) { this.objects.add(o); }
/*    */ 
/*    */ 
/*    */   
/* 59 */   public void removeObject(UIObject o) { this.objects.removeAll(this.objects); }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\UI\UIManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
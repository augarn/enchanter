/*    */ package dev.august.enchanter.states;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class State
/*    */ {
/* 10 */   private static State currentState = null;
/*    */   protected Handler handler;
/*    */   
/* 13 */   public static void setState(State state) { currentState = state; }
/*    */ 
/*    */ 
/*    */   
/* 17 */   public static State getState() { return currentState; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public State(Handler handler) { this.handler = handler; }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\states\State.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
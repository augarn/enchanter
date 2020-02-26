/*    */ package dev.august.enchanter.states;
/*    */ 
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.UI.ClickListener;
/*    */ import dev.august.enchanter.UI.UIImageButton;
/*    */ import dev.august.enchanter.UI.UIManager;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import dev.august.enchanter.worlds.World;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameState
/*    */   extends State
/*    */ {
/*    */   private World world;
/*    */   static int SCREEN_WIDTH;
/*    */   static int SCREEN_HEIGHT;
/*    */   private UIImageButton exitButton;
/*    */   protected static UIManager menuManager;
/*    */   protected static UIManager nonStateManager;
/*    */   
/*    */   public GameState(Handler handler) throws IOException {
/* 33 */     super(handler);
/* 34 */     Toolkit tk = Toolkit.getDefaultToolkit();
/* 35 */     SCREEN_WIDTH = (int)tk.getScreenSize().getWidth() / 2;
/* 36 */     SCREEN_HEIGHT = (int)tk.getScreenSize().getHeight() / 2;
/* 37 */     this.world = new World(handler, "res/worlds/world1.txt");
/* 38 */     handler.setWorld(this.world);
/* 39 */     menuManager = new UIManager(handler);
/* 40 */     handler.getMouseManager().setUIManager(menuManager);
/* 41 */     this.exitButton = new UIImageButton((float)(SCREEN_WIDTH - SCREEN_WIDTH / 12.5D), (SCREEN_HEIGHT - SCREEN_HEIGHT / 2), 160, 65, Assets.btnStart, new ClickListener()
/*    */         {
/*    */           public void onClick()
/*    */           {
/* 45 */             System.exit(1);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 55 */   public static int getSCREEN_WIDTH() { return SCREEN_WIDTH; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 61 */   public static int getSCREEN_HEIGHT() { return SCREEN_HEIGHT; }
/*    */ 
/*    */ 
/*    */   
/* 65 */   public void openMenu() { this.handler.getKeyManager(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {
/* 75 */     menuManager.tick();
/* 76 */     openMenu();
/* 77 */     this.world.tick();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 82 */     this.world.render(g);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 87 */     menuManager.render(g);
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\states\GameState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
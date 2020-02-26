/*    */ package dev.august.enchanter.states;
/*    */ 
/*    */ import dev.august.enchanter.Game;
/*    */ import dev.august.enchanter.Handler;
/*    */ import dev.august.enchanter.UI.ClickListener;
/*    */ import dev.august.enchanter.UI.UIImageButton;
/*    */ import dev.august.enchanter.UI.UIManager;
/*    */ import dev.august.enchanter.UI.UIObject;
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ import dev.august.enchanter.vfx.Sound;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.ImageObserver;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class MenuState
/*    */   extends State
/*    */   implements ImageObserver
/*    */ {
/*    */   protected static UIManager uiManager;
/*    */   public BufferedImage image;
/*    */   private static int width;
/*    */   private static int height;
/*    */   
/* 29 */   public static int getWidth() { return width; }
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void setWidth(int width) { MenuState.width = width; }
/*    */ 
/*    */ 
/*    */   
/* 37 */   public static int getHeight() { return height; }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public void setHeight(int height) { MenuState.height = height; }
/*    */ 
/*    */   
/*    */   public MenuState(final Handler handler) {
/* 45 */     super(handler);
/* 46 */     Toolkit tk = Toolkit.getDefaultToolkit();
/* 47 */     width = (int)tk.getScreenSize().getWidth() / 2 - 80;
/* 48 */     height = (int)tk.getScreenSize().getHeight() / 2 - 30;
/* 49 */     Sound.theme.loop();
/* 50 */     uiManager = new UIManager(handler);
/* 51 */     handler.getMouseManager().setUIManager(uiManager);
/* 52 */     uiManager.addObject((UIObject)new UIImageButton(422.0F, 500.0F, 160, 65, Assets.btnStart, new ClickListener()
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 56 */               Sound.theme.stop();
/* 57 */               handler.getMouseManager().setUIManager(GameState.menuManager);
/* 58 */               Sound.background.loop();
/* 59 */               State.setState((handler.getGame()).gameState);
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/*    */     try {
/* 65 */       this.image = ImageIO.read(new File("res/textures/Menu.png"));
/* 66 */     } catch (IOException e) {
/* 67 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 74 */   public void tick() { uiManager.tick(); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 79 */     g.drawImage(this.image, 0, 0, Game.getWidth(), Game.getHeight(), this);
/* 80 */     uiManager.render(g);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 86 */   public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) { return false; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\states\MenuState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
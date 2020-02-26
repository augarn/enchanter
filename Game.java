/*     */ package dev.august.enchanter;
/*     */ 
/*     */ import dev.august.enchanter.display.Display;
/*     */ import dev.august.enchanter.gfx.Assets;
/*     */ import dev.august.enchanter.gfx.GameCamera;
/*     */ import dev.august.enchanter.input.KeyManager;
/*     */ import dev.august.enchanter.input.MouseManager;
/*     */ import dev.august.enchanter.states.GameState;
/*     */ import dev.august.enchanter.states.MenuState;
/*     */ import dev.august.enchanter.states.State;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Game
/*     */   implements Runnable
/*     */ {
/*     */   private Display display;
/*     */   private static int width;
/*     */   private static int height;
/*     */   public String title;
/*     */   private boolean running = false;
/*     */   private Thread thread;
/*     */   private BufferStrategy bs;
/*     */   private Graphics g;
/*     */   public State gameState;
/*     */   public State menuState;
/*     */   private KeyManager keyManager;
/*     */   private MouseManager mouseManager;
/*     */   private GameCamera gameCamera;
/*     */   private Handler handler;
/*     */   
/*     */   public Game(String title, int width, int height) {
/*  43 */     Game.width = width;
/*  44 */     Game.height = height;
/*  45 */     this.title = title;
/*  46 */     this.keyManager = new KeyManager();
/*  47 */     this.mouseManager = new MouseManager();
/*     */   }
/*     */   
/*     */   private void init() throws IOException {
/*  51 */     this.display = new Display(this.title, width, height);
/*  52 */     this.display.getFrame().addKeyListener((KeyListener)this.keyManager);
/*  53 */     this.display.getFrame().addMouseListener((MouseListener)this.mouseManager);
/*  54 */     this.display.getFrame().addMouseMotionListener((MouseMotionListener)this.mouseManager);
/*  55 */     this.display.getCanvas().addMouseListener((MouseListener)this.mouseManager);
/*  56 */     this.display.getCanvas().addMouseMotionListener((MouseMotionListener)this.mouseManager);
/*  57 */     Assets.init();
/*     */     
/*  59 */     this.handler = new Handler(this);
/*  60 */     this.gameCamera = new GameCamera(this.handler, 0.0F, 0.0F);
/*     */     
/*  62 */     this.gameState = (State)new GameState(this.handler);
/*  63 */     this.menuState = (State)new MenuState(this.handler);
/*  64 */     State.setState(this.menuState);
/*     */   }
/*     */   
/*     */   private void tick() {
/*  68 */     this.keyManager.tick();
/*     */     
/*  70 */     if (State.getState() != null)
/*  71 */       State.getState().tick(); 
/*     */   }
/*     */   
/*     */   private void render() {
/*  75 */     this.bs = this.display.getCanvas().getBufferStrategy();
/*  76 */     if (this.bs == null) {
/*  77 */       this.display.getCanvas().createBufferStrategy(3);
/*     */       return;
/*     */     } 
/*  80 */     this.g = this.bs.getDrawGraphics();
/*     */     
/*  82 */     this.g.clearRect(0, 0, width, height);
/*     */ 
/*     */     
/*  85 */     if (State.getState() != null) {
/*  86 */       State.getState().render(this.g);
/*     */     }
/*     */     
/*  89 */     this.bs.show();
/*  90 */     this.g.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  96 */       init();
/*  97 */     } catch (IOException e) {
/*  98 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 101 */     int fps = 60;
/* 102 */     double timePerTick = (1000000000 / fps);
/* 103 */     double delta = 0.0D;
/*     */     
/* 105 */     long lastTime = System.nanoTime();
/* 106 */     long timer = 0L;
/* 107 */     int ticks = 0;
/*     */     
/* 109 */     while (this.running) {
/* 110 */       long now = System.nanoTime();
/* 111 */       delta += (now - lastTime) / timePerTick;
/* 112 */       timer += now - lastTime;
/* 113 */       lastTime = now;
/* 114 */       if (delta >= 1.0D) {
/* 115 */         tick();
/* 116 */         render();
/* 117 */         ticks++;
/* 118 */         delta--;
/*     */       } 
/*     */       
/* 121 */       if (timer >= 1000000000L) {
/*     */         
/* 123 */         ticks = 0;
/* 124 */         timer = 0L;
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     stop();
/*     */   }
/*     */ 
/*     */   
/* 132 */   public KeyManager getKeyManager() { return this.keyManager; }
/*     */ 
/*     */ 
/*     */   
/* 136 */   public MouseManager getMouseManager() { return this.mouseManager; }
/*     */ 
/*     */   
/* 139 */   public GameCamera getGameCamera() { return this.gameCamera; }
/*     */ 
/*     */ 
/*     */   
/* 143 */   public static int getWidth() { return width; }
/*     */ 
/*     */ 
/*     */   
/* 147 */   public static int getHeight() { return height; }
/*     */ 
/*     */   
/*     */   public synchronized void start() {
/* 151 */     if (this.running) {
/*     */       return;
/*     */     }
/*     */     
/* 155 */     this.running = true;
/* 156 */     this.thread = new Thread(this);
/* 157 */     this.thread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 161 */     if (!this.running)
/*     */       return; 
/* 163 */     this.running = false;
/*     */     try {
/* 165 */       this.thread.join();
/* 166 */     } catch (InterruptedException e) {
/* 167 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
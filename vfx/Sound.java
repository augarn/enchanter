/*     */ package dev.august.enchanter.vfx;
/*     */ 
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.Clip;
/*     */ import javax.sound.sampled.FloatControl;
/*     */ 
/*     */ public class Sound {
/*   9 */   public static Sound background = new Sound("ambience.wav"); private Clip clip;
/*  10 */   public static Sound walking_grass = new Sound("walking_grass.wav");
/*  11 */   public static Sound theme = new Sound("theme.wav");
/*  12 */   public static Sound coin = new Sound("coin.wav");
/*  13 */   public static Sound levelUp = new Sound("levelup.wav");
/*     */   public Sound(String fileName) {
/*     */     try {
/*  16 */       AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
/*  17 */       this.clip = AudioSystem.getClip();
/*  18 */       this.clip.open(ais);
/*  19 */     } catch (Exception e) {
/*  20 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void play_ambience() {
/*  25 */     FloatControl gainControl = (FloatControl)this.clip.getControl(FloatControl.Type.MASTER_GAIN);
/*  26 */     gainControl.setValue(-10.0F);
/*     */     try {
/*  28 */       if (this.clip != null) {
/*  29 */         (new Thread() {
/*     */             public void run() {
/*  31 */               synchronized (Sound.this.clip) {
/*  32 */                 Sound.this.clip.stop();
/*  33 */                 Sound.this.clip.setFramePosition(0);
/*  34 */                 Sound.this.clip.start();
/*     */               } 
/*     */             }
/*  37 */           }).start();
/*     */       }
/*  39 */     } catch (Exception e) {
/*  40 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void play_normal_volume() {
/*     */     try {
/*  46 */       if (this.clip != null) {
/*  47 */         (new Thread() {
/*     */             public void run() {
/*  49 */               synchronized (Sound.this.clip) {
/*  50 */                 Sound.this.clip.stop();
/*  51 */                 Sound.this.clip.setFramePosition(0);
/*  52 */                 Sound.this.clip.start();
/*     */               } 
/*     */             }
/*  55 */           }).start();
/*     */       }
/*  57 */     } catch (Exception e) {
/*  58 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stop() {
/*  63 */     if (this.clip == null)
/*     */       return; 
/*  65 */     this.clip.stop();
/*     */   }
/*     */   
/*     */   public void loop_decreased_volume() {
/*  69 */     FloatControl gainControl = (FloatControl)this.clip.getControl(FloatControl.Type.MASTER_GAIN);
/*  70 */     gainControl.setValue(-10.0F);
/*     */     try {
/*  72 */       if (this.clip != null) {
/*  73 */         (new Thread() {
/*     */             public void run() {
/*  75 */               synchronized (Sound.this.clip) {
/*  76 */                 Sound.this.clip.stop();
/*  77 */                 Sound.this.clip.setFramePosition(0);
/*  78 */                 Sound.this.clip.start();
/*     */               } 
/*     */             }
/*  81 */           }).start();
/*     */       }
/*  83 */     } catch (Exception e) {
/*  84 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  87 */       if (this.clip != null) {
/*  88 */         (new Thread() {
/*     */             public void run() {
/*  90 */               synchronized (Sound.this.clip) {
/*  91 */                 Sound.this.clip.stop();
/*  92 */                 Sound.this.clip.setFramePosition(0);
/*  93 */                 Sound.this.clip.loop(-1);
/*     */               } 
/*     */             }
/*  96 */           }).start();
/*     */       }
/*  98 */     } catch (Exception e) {
/*  99 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 104 */   public boolean isActive() { return this.clip.isActive(); }
/*     */ 
/*     */   
/*     */   public void loop() {
/*     */     try {
/* 109 */       if (this.clip != null) {
/* 110 */         (new Thread() {
/*     */             public void run() {
/* 112 */               synchronized (Sound.this.clip) {
/* 113 */                 Sound.this.clip.stop();
/* 114 */                 Sound.this.clip.setFramePosition(0);
/* 115 */                 Sound.this.clip.start();
/*     */               } 
/*     */             }
/* 118 */           }).start();
/*     */       }
/* 120 */     } catch (Exception e) {
/* 121 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 124 */       if (this.clip != null) {
/* 125 */         (new Thread() {
/*     */             public void run() {
/* 127 */               synchronized (Sound.this.clip) {
/* 128 */                 Sound.this.clip.stop();
/* 129 */                 Sound.this.clip.setFramePosition(0);
/* 130 */                 Sound.this.clip.loop(-1);
/*     */               } 
/*     */             }
/* 133 */           }).start();
/*     */       }
/* 135 */     } catch (Exception e) {
/* 136 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\vfx\Sound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
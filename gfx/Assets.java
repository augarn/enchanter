/*     */ package dev.august.enchanter.gfx;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Assets
/*     */ {
/*     */   private static final int width = 32;
/*     */   private static final int height = 32;
/*     */   private static final int widthP = 64;
/*     */   private static final int heightP = 64;
/*     */   public static BufferedImage player_down_still;
/*     */   public static BufferedImage player_up_still;
/*     */   public static BufferedImage player_right_still;
/*     */   public static BufferedImage player_left_still;
/*     */   public static BufferedImage grass;
/*     */   public static BufferedImage grass_2;
/*     */   public static BufferedImage rock;
/*     */   public static BufferedImage tree;
/*     */   public static BufferedImage treetrunk;
/*     */   public static BufferedImage flowerbed;
/*     */   public static BufferedImage grass_top_left;
/*     */   public static BufferedImage grass_top_mid;
/*     */   public static BufferedImage grass_top_right;
/*     */   public static BufferedImage grass_mid_left;
/*     */   public static BufferedImage grass_mid_mid;
/*     */   public static BufferedImage grass_mid_right;
/*     */   public static BufferedImage grass_midmid_left;
/*     */   public static BufferedImage grass_midmid_mid;
/*     */   public static BufferedImage grass_midmid_right;
/*     */   public static BufferedImage grass_bot_left;
/*     */   
/*     */   public static void init() {
/*  40 */     SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain_atlas.png"));
/*  41 */     SpriteSheet sheet_player = new SpriteSheet(ImageLoader.loadImage("/textures/malewalkcycletest.png"));
/*  42 */     SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/MenuButtons.png"));
/*  43 */     SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/ForegroundTextures_2.png"));
/*  44 */     SpriteSheet stoneAnimationSheet = new SpriteSheet(ImageLoader.loadImage("/textures/stoneAnimation.png"));
/*  45 */     SpriteSheet terrain = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
/*  46 */     SpriteSheet snake = new SpriteSheet(ImageLoader.loadImage("/textures/snake.png"));
/*  47 */     SpriteSheet playerdaggerattack = new SpriteSheet(ImageLoader.loadImage("/textures/maleslash.png"));
/*  48 */     SpriteSheet coin = new SpriteSheet(ImageLoader.loadImage("/textures/coin.png"));
/*  49 */     SpriteSheet inventory = new SpriteSheet(ImageLoader.loadImage("/textures/gui.png"));
/*     */     
/*  51 */     coins = new BufferedImage[8];
/*  52 */     coins[0] = coin.crop(64, 390, 82, 80);
/*  53 */     coins[1] = coin.crop(170, 390, 82, 80);
/*  54 */     coins[2] = coin.crop(280, 390, 82, 80);
/*  55 */     coins[3] = coin.crop(370, 390, 70, 80);
/*  56 */     coins[4] = coin.crop(410, 390, 70, 80);
/*  57 */     coins[5] = coin.crop(480, 390, 70, 80);
/*  58 */     coins[6] = coin.crop(550, 390, 70, 80);
/*  59 */     coins[7] = coin.crop(630, 390, 70, 80);
/*     */ 
/*     */     
/*  62 */     btnStart = new BufferedImage[2];
/*  63 */     btnStart[0] = menu.crop(0, 0, 160, 65);
/*  64 */     btnStart[1] = menu.crop(160, 0, 160, 65);
/*     */ 
/*     */ 
/*     */     
/*  68 */     player_down = new BufferedImage[8];
/*  69 */     player_up = new BufferedImage[8];
/*  70 */     player_left = new BufferedImage[8];
/*  71 */     player_right = new BufferedImage[8];
/*  72 */     stoneAnimation = new BufferedImage[12];
/*     */ 
/*     */     
/*  75 */     snake_down = new BufferedImage[3];
/*  76 */     snake_up = new BufferedImage[3];
/*  77 */     snake_right = new BufferedImage[3];
/*  78 */     snake_left = new BufferedImage[3];
/*     */ 
/*     */     
/*  81 */     player_attack_up = new BufferedImage[5];
/*  82 */     player_attack_down = new BufferedImage[5];
/*  83 */     player_attack_left = new BufferedImage[5];
/*  84 */     player_attack_right = new BufferedImage[5];
/*     */ 
/*     */     
/*  87 */     player_down[0] = sheet_player.crop(64, 128, 64, 64);
/*  88 */     player_down[1] = sheet_player.crop(128, 128, 64, 64);
/*  89 */     player_down[2] = sheet_player.crop(192, 128, 64, 64);
/*  90 */     player_down[3] = sheet_player.crop(256, 128, 64, 64);
/*  91 */     player_down[4] = sheet_player.crop(320, 128, 64, 64);
/*  92 */     player_down[5] = sheet_player.crop(384, 128, 64, 64);
/*  93 */     player_down[6] = sheet_player.crop(448, 128, 64, 64);
/*  94 */     player_down[7] = sheet_player.crop(512, 128, 64, 64);
/*  95 */     player_up[0] = sheet_player.crop(64, 0, 64, 64);
/*  96 */     player_up[1] = sheet_player.crop(128, 0, 64, 64);
/*  97 */     player_up[2] = sheet_player.crop(192, 0, 64, 64);
/*  98 */     player_up[3] = sheet_player.crop(256, 0, 64, 64);
/*  99 */     player_up[4] = sheet_player.crop(320, 0, 64, 64);
/* 100 */     player_up[5] = sheet_player.crop(384, 0, 64, 64);
/* 101 */     player_up[6] = sheet_player.crop(448, 0, 64, 64);
/* 102 */     player_up[7] = sheet_player.crop(512, 0, 64, 64);
/* 103 */     player_right[0] = sheet_player.crop(64, 192, 64, 64);
/* 104 */     player_right[1] = sheet_player.crop(128, 192, 64, 64);
/* 105 */     player_right[2] = sheet_player.crop(192, 192, 64, 64);
/* 106 */     player_right[3] = sheet_player.crop(256, 192, 64, 64);
/* 107 */     player_right[4] = sheet_player.crop(320, 192, 64, 64);
/* 108 */     player_right[5] = sheet_player.crop(384, 192, 64, 64);
/* 109 */     player_right[6] = sheet_player.crop(448, 192, 64, 64);
/* 110 */     player_right[7] = sheet_player.crop(512, 192, 64, 64);
/* 111 */     player_left[0] = sheet_player.crop(64, 64, 64, 64);
/* 112 */     player_left[1] = sheet_player.crop(128, 64, 64, 64);
/* 113 */     player_left[2] = sheet_player.crop(192, 64, 64, 64);
/* 114 */     player_left[3] = sheet_player.crop(256, 64, 64, 64);
/* 115 */     player_left[4] = sheet_player.crop(320, 64, 64, 64);
/* 116 */     player_left[5] = sheet_player.crop(384, 64, 64, 64);
/* 117 */     player_left[6] = sheet_player.crop(448, 64, 64, 64);
/* 118 */     player_left[7] = sheet_player.crop(512, 64, 64, 64);
/*     */     
/* 120 */     stoneAnimation[0] = stoneAnimationSheet.crop(0, 0, 32, 32);
/* 121 */     stoneAnimation[1] = stoneAnimationSheet.crop(32, 0, 32, 32);
/* 122 */     stoneAnimation[2] = stoneAnimationSheet.crop(64, 0, 32, 32);
/* 123 */     stoneAnimation[3] = stoneAnimationSheet.crop(96, 0, 32, 32);
/* 124 */     stoneAnimation[4] = stoneAnimationSheet.crop(128, 0, 32, 32);
/* 125 */     stoneAnimation[5] = stoneAnimationSheet.crop(160, 0, 32, 32);
/* 126 */     stoneAnimation[6] = stoneAnimationSheet.crop(192, 0, 32, 32);
/* 127 */     stoneAnimation[7] = stoneAnimationSheet.crop(224, 0, 32, 32);
/* 128 */     stoneAnimation[8] = stoneAnimationSheet.crop(256, 0, 32, 32);
/* 129 */     stoneAnimation[9] = stoneAnimationSheet.crop(288, 0, 32, 32);
/* 130 */     stoneAnimation[10] = stoneAnimationSheet.crop(320, 0, 32, 32);
/* 131 */     stoneAnimation[11] = stoneAnimationSheet.crop(352, 0, 32, 32);
/*     */     
/* 133 */     player_attack_up[0] = playerdaggerattack.crop(64, 0, 64, 64);
/* 134 */     player_attack_up[1] = playerdaggerattack.crop(128, 0, 64, 64);
/* 135 */     player_attack_up[2] = playerdaggerattack.crop(192, 0, 64, 64);
/* 136 */     player_attack_up[3] = playerdaggerattack.crop(256, 0, 64, 64);
/* 137 */     player_attack_up[4] = playerdaggerattack.crop(320, 0, 64, 64);
/*     */     
/* 139 */     player_attack_left[0] = playerdaggerattack.crop(64, 64, 64, 64);
/* 140 */     player_attack_left[1] = playerdaggerattack.crop(128, 64, 64, 64);
/* 141 */     player_attack_left[2] = playerdaggerattack.crop(192, 64, 64, 64);
/* 142 */     player_attack_left[3] = playerdaggerattack.crop(256, 64, 64, 64);
/* 143 */     player_attack_left[4] = playerdaggerattack.crop(320, 64, 64, 64);
/*     */     
/* 145 */     player_attack_down[0] = playerdaggerattack.crop(64, 128, 64, 64);
/* 146 */     player_attack_down[1] = playerdaggerattack.crop(128, 128, 64, 64);
/* 147 */     player_attack_down[2] = playerdaggerattack.crop(192, 128, 64, 64);
/* 148 */     player_attack_down[3] = playerdaggerattack.crop(256, 128, 64, 64);
/* 149 */     player_attack_down[4] = playerdaggerattack.crop(320, 128, 64, 64);
/*     */     
/* 151 */     player_attack_right[0] = playerdaggerattack.crop(64, 192, 64, 64);
/* 152 */     player_attack_right[1] = playerdaggerattack.crop(128, 192, 64, 64);
/* 153 */     player_attack_right[2] = playerdaggerattack.crop(192, 192, 64, 64);
/* 154 */     player_attack_right[3] = playerdaggerattack.crop(256, 192, 64, 64);
/* 155 */     player_attack_right[4] = playerdaggerattack.crop(320, 192, 64, 64);
/*     */     
/* 157 */     player_down_still = sheet_player.crop(0, 128, 64, 64);
/* 158 */     player_up_still = sheet_player.crop(0, 0, 64, 64);
/* 159 */     player_right_still = sheet_player.crop(0, 192, 64, 64);
/* 160 */     player_left_still = sheet_player.crop(0, 64, 64, 64);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     grasswithgrass = terrain.crop(0, 352, 32, 32);
/*     */     
/* 167 */     grass_2 = terrain.crop(384, 352, 32, 32);
/*     */     
/* 169 */     grass_top_left = sheet.crop(160, 544, 32, 32);
/* 170 */     grass_top_mid = sheet.crop(192, 544, 32, 32);
/* 171 */     grass_top_right = sheet.crop(224, 544, 32, 32);
/* 172 */     grass_mid_left = sheet.crop(160, 576, 32, 32);
/* 173 */     grass_mid_mid = sheet.crop(192, 576, 32, 32);
/* 174 */     grass_mid_right = sheet.crop(224, 576, 32, 32);
/* 175 */     grass_midmid_left = sheet.crop(160, 608, 32, 32);
/* 176 */     grass_midmid_mid = sheet.crop(192, 608, 32, 32);
/* 177 */     grass_midmid_right = sheet.crop(224, 608, 32, 32);
/* 178 */     grass_bot_left = sheet.crop(160, 640, 32, 32);
/* 179 */     grass_bot_mid = sheet.crop(192, 640, 32, 32);
/* 180 */     grass_bot_right = sheet.crop(224, 640, 32, 32);
/*     */ 
/*     */     
/* 183 */     grass_comp_topleft = sheet.crop(192, 480, 32, 32);
/* 184 */     grass_comp_topright = sheet.crop(224, 480, 32, 32);
/* 185 */     grass_comp_botleft = sheet.crop(192, 512, 32, 32);
/* 186 */     grass_comp_botright = sheet.crop(224, 512, 32, 32);
/*     */ 
/*     */     
/* 189 */     rock = sheet.crop(864, 736, 64, 64);
/* 190 */     tree = sheet.crop(928, 896, 96, 128);
/* 191 */     treetrunk = items.crop(32, 64, 32, 32);
/* 192 */     flowerbed = sheet.crop(64, 0, 32, 32);
/*     */ 
/*     */ 
/*     */     
/* 196 */     snake_down[0] = snake.crop(0, 64, 32, 32);
/* 197 */     snake_down[1] = snake.crop(32, 64, 32, 32);
/* 198 */     snake_down[2] = snake.crop(64, 64, 32, 32);
/*     */     
/* 200 */     snake_up[0] = snake.crop(0, 0, 32, 32);
/* 201 */     snake_up[1] = snake.crop(32, 0, 32, 32);
/* 202 */     snake_up[2] = snake.crop(64, 0, 32, 32);
/*     */     
/* 204 */     snake_right[0] = snake.crop(0, 96, 32, 32);
/* 205 */     snake_right[1] = snake.crop(32, 96, 32, 32);
/* 206 */     snake_right[2] = snake.crop(64, 96, 32, 32);
/*     */     
/* 208 */     snake_left[0] = snake.crop(0, 32, 32, 32);
/* 209 */     snake_left[1] = snake.crop(32, 32, 32, 32);
/* 210 */     snake_left[2] = snake.crop(64, 32, 32, 32);
/*     */     
/* 212 */     coinsanim = new Animation(90, coins);
/*     */     
/* 214 */     inventoryscreen = inventory.crop(44, 177, 236, 184);
/* 215 */     playergui = inventory.crop(60, 33, 205, 81);
/*     */   }
/*     */   
/*     */   public static BufferedImage grass_bot_mid;
/*     */   public static BufferedImage grass_bot_right;
/*     */   public static BufferedImage grass_comp_topleft;
/*     */   public static BufferedImage grass_comp_topright;
/*     */   public static BufferedImage grass_comp_botleft;
/*     */   public static BufferedImage grass_comp_botright;
/*     */   public static BufferedImage grasswithgrass;
/*     */   public static BufferedImage inventoryscreen;
/*     */   public static BufferedImage playergui;
/*     */   public static BufferedImage[] player_down;
/*     */   public static BufferedImage[] player_up;
/*     */   public static BufferedImage[] player_right;
/*     */   public static BufferedImage[] player_left;
/*     */   public static BufferedImage[] btnStart;
/*     */   public static BufferedImage[] stoneAnimation;
/*     */   public static BufferedImage[] snake_down;
/*     */   public static BufferedImage[] snake_up;
/*     */   public static BufferedImage[] snake_right;
/*     */   public static BufferedImage[] snake_left;
/*     */   public static BufferedImage[] player_attack_up;
/*     */   public static BufferedImage[] player_attack_down;
/*     */   public static BufferedImage[] player_attack_left;
/*     */   public static BufferedImage[] player_attack_right;
/*     */   public static BufferedImage[] coins;
/*     */   public static Animation coinsanim;
/*     */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\gfx\Assets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
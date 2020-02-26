/*    */ package dev.august.enchanter.tiles;
/*    */ 
/*    */ import dev.august.enchanter.gfx.Assets;
/*    */ 
/*    */ public class TreeTile
/*    */   extends Tile
/*    */ {
/*  8 */   public TreeTile(int id) { super(Assets.tree, id); }
/*    */ 
/*    */ 
/*    */   
/* 12 */   public boolean isSolid() { return true; }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchanter\tiles\TreeTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
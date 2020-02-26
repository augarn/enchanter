/*    */ package dev.august.enchanter.utils;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Utils
/*    */ {
/*    */   public static String loadFileAsString(String path) {
/* 10 */     StringBuilder builder = new StringBuilder();
/*    */     
/*    */     try {
/* 13 */       BufferedReader br = new BufferedReader(new FileReader(path));
/*    */       String line;
/* 15 */       while ((line = br.readLine()) != null) {
/* 16 */         builder.append(String.valueOf(line) + "\n");
/*    */       }
/* 18 */       br.close();
/* 19 */     } catch (IOException e) {
/* 20 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 23 */     return builder.toString();
/*    */   }
/*    */   
/*    */   public static int parseInt(String number) {
/*    */     try {
/* 28 */       return Integer.parseInt(number);
/* 29 */     } catch (NumberFormatException e) {
/* 30 */       e.printStackTrace();
/* 31 */       return 0;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\August\Desktop\Enchanter alpha V0.9.1\Enchanter.jar!\dev\august\enchante\\utils\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */
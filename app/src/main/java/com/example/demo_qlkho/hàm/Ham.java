//package com.example.demo_qlkho.hàm;
//
//import android.util.Log;
//
//public class Ham {
//
////    public static Ham getInstance() {
////        return null;
////    }
//
//    private char[] charA = { 'à', 'á', 'ạ', 'ả', 'ã',// 0-&gt;16
//            'â', 'ầ', 'ấ', 'ậ', 'ẩ', 'ẫ', 'ă', 'ằ', 'ắ', 'ặ', 'ẳ', 'ẵ' };// a,// ă,// â
//    private char[] charE = { 'ê', 'ề', 'ế', 'ệ', 'ể', 'ễ',// 17-&gt;27
//            'è', 'é', 'ẹ', 'ẻ', 'ẽ' };// e
//    private char[] charI = { 'ì', 'í', 'ị', 'ỉ', 'ĩ' };// i 28-&gt;32
//    private char[] charO = { 'ò', 'ó', 'ọ', 'ỏ', 'õ',// o 33-&gt;49
//            'ô', 'ồ', 'ố', 'ộ', 'ổ', 'ỗ',// ô
//            'ơ', 'ờ', 'ớ', 'ợ', 'ở', 'ỡ' };// ơ
//    private char[] charU = { 'ù', 'ú', 'ụ', 'ủ', 'ũ',// u 50-&gt;60
//            'ư', 'ừ', 'ứ', 'ự', 'ử', 'ữ' };// ư
//    private char[] charY = { 'ỳ', 'ý', 'ỵ', 'ỷ', 'ỹ' };// y 61-&gt;65
//    private char[] charD = { 'đ', ' ' }; // 66-67
//private String charact = String.valueOf(charA, 0, charA.length)
//        + String.valueOf(charE, 0, charE.length)
//        + String.valueOf(charI, 0, charI.length)
//        + String.valueOf(charO, 0, charO.length)
//        + String.valueOf(charU, 0, charU.length)
//        + String.valueOf(charY, 0, charY.length)
//        + String.valueOf(charD, 0, charD.length);
////    private char GetAlterChar(char pC) {
////        if ((int) pC == 32) {
////            return ' ';
////        }
////
////        char tam = pC;// Character.toLowerCase(pC);
////
////        int i = 0;
////        while (i &lt; charact.length() &amp;&amp; charact.charAt(i) != tam) {
////            i++;
////        }
////        if (i &lt; 0 || i &gt; 67)
////        return pC;
////
////        if (i == 66) {
////            return 'd';
////        }
////        if (i &gt;= 0 &amp;&amp; i &lt;= 16) {
////            return 'a';
////        }
////        if (i &gt;= 17 &amp;&amp; i &lt;= 27) {
////            return 'e';
////        }
////        if (i &gt;= 28 &amp;&amp; i &lt;= 32) {
////            return 'i';
////        }
////        if (i &gt;= 33 &amp;&amp; i &lt;= 49) {
////            return 'o';
////        }
////        if (i &gt;= 50 &amp;&amp; i &lt;= 60) {
////            return 'u';
////        }
////        if (i &gt;= 61 &amp;&amp; i &lt;= 65) {
////            return 'y';
////        }
////        return pC;
////    }
//    public String ConvertString(String pStr) {
//        String convertString = pStr.toLowerCase();
//        Character[] returnString = new Character[convertString.length()];
//        for (int i = 0; i &lt; convertString.length(); i++) {
//            char temp = convertString.charAt(i);
//            if ((int) temp &lt; 97 || temp &gt; 122) {
//                char tam1 = this.GetAlterChar(temp);
//                if ((int) temp != 32)
//                    convertString = convertString.replace(temp, tam1);
//            }
//        }
//        return convertString;
//    }
//    public String GetString(String str){
//        char[] cha = str.toCharArray();
//        String chuoi = "";
//        for(int i = 0;i<str.length();i++){
//            char o = cha[i];
//            boolean ii = false;
//            for(int j = 0;j<charA.length;j++){
//                if(o == charA[j]){
//                    chuoi += "a";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charE.length;j++){
//                if(o == charE[j]){
//                    chuoi += "e";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charI.length;j++){
//                if(o == charI[j]){
//                    chuoi += "i";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charO.length;j++){
//                if(o == charO[j]){
//                    chuoi += "e";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charU.length;j++){
//                if(o == charU[j]){
//                    chuoi += "u";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charY.length;j++){
//                if(o == charY[j]){
//                    chuoi += "y";
//                    ii =true;
//                }
//            }
//            for(int j = 0;j<charD.length;j++){
//                if(o == charD[j]){
//                    chuoi += "d";
//                    ii =true;
//                }
//            }
//            if(!ii)chuoi+=String.valueOf(o);
//            Log.d("s",String.valueOf(o));
//        }
//
//        return chuoi;
//    }
//}

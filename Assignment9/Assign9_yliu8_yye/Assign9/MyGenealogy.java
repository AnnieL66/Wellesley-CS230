
/**
 * MyGenealogy.java
 * uses GenealogyTree.java with an ancestral tree which contains 
 * my biological heritage.
 * My name appears at the root (the Center of The Universe), 
 * and its two "children" contain my parents' names.
 * My father's on the left and my mother's on the right. 
 * Include grandparents.
 * 
 * @author Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

public class MyGenealogy
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        GenealogyTree<String> myGenealogy = new GenealogyTree<String>("Yaxin L");
        myGenealogy.setPater("Yaxin L", "Harper L");
        myGenealogy.setMater("Yaxin L", "Yanxia W");
        myGenealogy.setPater("Harper L", "Fuquan L");
        myGenealogy.setMater("Harper L", "Xianglan Z");
        myGenealogy.setPater("Yanxia W", "Qinghai W");
        myGenealogy.setMater("Yanxia W", "Aifeng C");
        System.out.println(myGenealogy.toString());
    }
}

package test;

import structureData.TreeK_ary;

public class TestTreeK_ary {

	public static void main(String[] args) {
		 TreeK_ary<String> nTree = new TreeK_ary();
       System.out.println("Caso 1: " + (nTree.add("hola", null) ? "ok" : "error"));
       System.out.println("Caso 2: " + (nTree.add("ana", "hola") ? "ok" : "error"));
       System.out.println("Caso 3: " + (nTree.add("lulu", "hola") ? "ok" : "error"));
       System.out.println("Caso 4: " + (nTree.add("viviana", "lulu") ? "ok" : "error"));
       System.out.println("Caso 5: " + (nTree.add("yuliana", "lulu") ? "ok" : "error"));
       System.out.println(nTree.findParent("viviana"));
       nTree.printTree(nTree.getRoot());

	}
}

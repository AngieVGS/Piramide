package test;

import java.util.Comparator;

import structureData.NTree;

public class TestTreeK_ary {

	public static void main(String[] args) {
		NTree<String> nTree = new NTree(new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.equals(o2)) {
					return 0;	
				}
					return 1;
			};
		});
		System.out.println("Caso 1: " + (nTree.add("Hola") ? "ok" : "Error")); //es la raiz
	        System.out.println("Caso 2: " + (nTree.add("Ana", "Hola") ? "ok" : "Error"));//se agrega un hijo al padre (Hola)
	        System.out.println("Caso 3: " + (nTree.add("lulu", "Hola") ? "ok" : "Error"));
	        System.out.println("Caso 4: " + (nTree.add("pepe", "Hola") ? "ok" : "Error"));
	        System.out.println("Caso 5: " + (nTree.add("lucas", "pepe") ? "ok" : "Error"));
	        System.out.println("Caso 5: " + (nTree.add("sebas", "pepe") ? "ok" : "Error"));
	        System.out.println("Caso 6: " + (nTree.add("loli", "sebas") ? "ok" : "Error"));
	        System.out.println("Caso 7: " + (nTree.add("mimo", "sebas") ? "ok" : "Error"));
	        System.out.println("Caso 8: " + (nTree.add("luis", "Ana") ? "ok" : "Error"));
	        System.out.println("Caso 8: " + (nTree.add("camilo", "Ana") ? "ok" : "Error"));

	   //     nTree.imprimir();

	        System.out.println("Busqueda correcta-->" + nTree.findParent("camilo"));
	}
}

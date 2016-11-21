package BalancedSearchTrees;

import PositionalList.Position;
import PriorityQueue.Entry;
import Tree.LinkedBinaryTree;

/**
 * @author Priyank Agrawal
 * 
 * Date: 11/20/2016
 */
public class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>>{
	
	//this class extends the Node class from the LinkedBinaryTree class
	protected static class BSTNode<E> extends Node<E>{
		int aux = 0;
		public BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild){
			super(e, parent, leftChild, rightChild);
		}
		public int getAux() {
			return aux;
		}
		public void setAux(int aux) {
			this.aux = aux;
		}		
	}
	
	//methods to set and get the auxiliary value in BSTNodes
	public int getAux(Position<Entry<K,V>> p){
		return ((BSTNode<Entry<K,V>>)p).getAux();
	}
	
	public void setAux(Position<Entry<K,V>> p, int value){
		((BSTNode<Entry<K,V>>)p).setAux(value);
	}
	
	//override the createNode method which created node into a createNode method which creates BSTNode
	protected Node<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent, Node<Entry<K,V>> leftChild, 
			Node<Entry<K,V>> rightChild){
		return new BSTNode<>(e, parent, leftChild, rightChild);
	}
	
}
package org.mk.List.LinkedList;

import java.util.*;

public class linkedListMK<E> implements List<E> {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
    }


    public Node first;
    public Node last;
    public int size;//链表的元素大小

    public linkedListMK() {

    }

    private class Node<E> {

        private E item;

        private Node pre;

        private Node next;


        public Node(Node pre, E element, Node next) {
            this.item = element;
            this.pre = pre;
            this.next = next;
        }
    }


    /***
     * 往链表末尾加节点
     * @param element
     */
    public void insertLast(E element) {
        final Node l = last;

        final Node<E> newNode = new Node<E>(l, element, null);

        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    /**
     * 添加新的element元素在node元素前
     *
     * @param element
     * @param node    不为null
     */
    private void insertBefore(E element, Node<E> node) {
        // assert node != null;
        final Node preNode = node.pre;
        final Node<E> newNode = new Node<>(preNode, element, node);
        node.pre = newNode;
        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        size++;
    }

    /**
     * 获取制定位置的元素节点
     *
     * @param index
     * @return
     */
    private Node getNode(int index) {
        checkElementIndex(index);
        if ((size >> 1) > index) {//index小于链表一半大小，从链表表头遍历
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {//index小于链表一半大小，从链表尾部开始遍历
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }


    /**
     * 检查是不是允许在指定索引处添加元素
     *
     * @param index
     */
    private void checkPositionIndex(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

    }

    /**
     * 检查指定索引是否越界
     *
     * @param index
     */
    private void checkElementIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**以下是必须实现的接口**/


    /**
     * 添加元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        insertLast(element);
        return true;
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean contains(Object o) {


        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);//检查是不是允许在指定索引处添加元素

        final Node<E> newNode = new Node<>(null, element, null);

        if (index == size) {
            insertLast(element);
        } else {
            insertBefore(element, getNode(index));
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

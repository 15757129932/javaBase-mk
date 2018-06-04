package org.mk.List.LinkedList;

import java.util.*;

public class linkedListMK<E> implements List<E> {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
    }


    private Node first;
    private Node last;
    private transient int size;//链表的元素大小

    protected transient int modCount = 0;//Fast-Failed 实现的方式之一


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
        modCount++;
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
        modCount++;
    }

    /**
     * 获取制定位置的元素节点
     *
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        if ((size >> 1) > index) {//index小于链表一半大小，从链表表头遍历
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {//index小于链表一半大小，从链表尾部开始遍历
            Node<E> node = last;
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

    /**
     * 删除指定的节点
     *
     * @param node
     */
    private E unlink(Node<E> node) {

        final E item = node.item;
        final Node<E> pre = node.pre;
        final Node<E> next = node.next;

        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            node.pre = null;
        }

        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            node.next = null;
        }

        node.item = null;
        node = null;
        size--;
        modCount++;
        return item;
    }


    /**
     * 实现内部迭代器
     */
    public class LinkedListMKIterator<E> implements Iterator<E> {


        int expectedCount;

        private Node<E> x;

        LinkedListMKIterator() {
            expectedCount = modCount;
            x = first;
        }


        @Override
        public boolean hasNext() {

            checkFastFailed();

            return x == null ? false : true;

        }


        @Override
        public E next() {

            checkFastFailed();
            if (!hasNext()) throw new ConcurrentModificationException();

            Node<E> node = x;
            x = x.next;

            return node.item;
        }

        @Override
        public void remove() {

        }


        /**
         * fast-failed realized
         */
        public void checkFastFailed() {
            if (modCount != expectedCount)
                throw new ConcurrentModificationException();
        }


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
        if (o == null) {
            Node<E> nextNode = first;
            for (int i = 0; i < size; i++) {
                if (nextNode.item == o) {
                    return true;
                }
                nextNode = nextNode.next;
            }
            return false;
        } else {

            Node<E> nextNode = first;
            for (int i = 0; i < size; i++) {
                if (o.equals(nextNode.item)) {
                    return true;
                }
                nextNode = nextNode.next;
            }
            return false;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListMKIterator<E>();
    }

    @Override
    public Object[] toArray() {

        Object[] arr = new Object[size];
        int i = 0;

        for (Node<E> x = first; x != null; x = x.next) {
            arr[i++] = x.item;
        }
        return arr;

    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x.next != null; x = x.next) {
                if (x.item == o) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x.next != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }

        }


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

        checkElementIndex(index);
        Node<E> x = getNode(index);

        return unlink(x);

    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            int i = 0;
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == o) {
                    return i;
                }
                i++;
            }
        } else {
            int i = 0;
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return i;
                }
                i++;
            }
        }

        return -1;
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

package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    transient int size = 0;
    transient Node first;
    transient Node last;


    public Solution() {
    }

    private static class Node {
        String item;
        Node next;
        Node prev;
        Node child1;
        Node child2;
        Node parent;

        Node(Node parent, String element, Node prev) {
            this.item = element;
            this.parent = parent;
            this.prev = prev;
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new SolutionIterator();
    }


    private class SolutionIterator implements Iterator<String> {
        private Node current;

        public SolutionIterator() {
            Node beforeFirst = new Node(null, null, null);
            beforeFirst.next = first;
            current = beforeFirst;
        }

        @Override
        public boolean hasNext() {
            return (current.next != null);
        }

        @Override
        public String next() {
            current = current.next;
            return current.item;
        }

        @Override
        public void remove() {
            removeBranch(current);
        }

        public void removeBranch(Node current) {
            if (current != null) {
                removeBranch(current.child1);
                removeBranch(current.child2);
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == last) {
                    if (last.parent != null) {
                        if (last == last.parent.child1) last.parent.child1 = null;
                        else if (last == last.parent.child2) last.parent.child2 = null;
                    }
                    last = last.prev;
                }
                if (current == first) {
                    first = first.next;
                }
                Node tempNodeNext = current.next;
                clearNode(current);
                current.next = tempNodeNext;
                size--;
            }
        }
    }




    public String getParent(String value) {
        Node current = first;
        Iterator<String> iter = this.iterator();
        while (iter.hasNext()) {
            if (value == null) {
                iter.next();
                if (current.item == null) {
                    return (current.parent != null) ? current.parent.item : null;
                }
            } else if (value.equals(iter.next())) {
                return (current.parent != null) ? current.parent.item : null;
            }
            current = current.next;
        }
        return null;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
//    моя версия
//    public void clear() {
//        for (Node x = first; x != null; ) {
//            Node next = x.next;
//            clearNode(x);
//            x = next;
//        }
//        first = last = null;
//        size = 0;
//    }


    public void clearNode(Node x) {
        x.item = null;
        x.next = null;
        x.prev = null;
        x.parent = null;
        x.child1 = null;
        x.child2 = null;
    }



    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution clone = new Solution();
        for (Solution.Node x = first; x != null; x = x.next) {
            clone.add(x.item);
        }
        return clone;
    }
//    моя версия
//    protected Solution clone() throws CloneNotSupportedException {
//        return (Solution) super.clone();
//    }




    @Override
    public boolean add(String s) {
        if (first == null) {
            first = new Node(null, s, null);
            last = first;
        }
        else if (last.equals(first)) {
            last = new Node(null, s, first);
            first.next = last;
        }
        else if (last.parent == null) {
            first.child1 = new Node(first, s, last);
            last.next = first.child1;
            last = first.child1;
        }
        else if (last.parent.child2 == null) {
            last.parent.child2 = new Node(last.parent, s, last);
            last = last.parent.child2;
            last.parent.child1.next = last;
        }
        else {
            for (Solution.Node x = last.parent.next; x != null; x = x.next) {
                if (x.child1 == null) {
                    x.child1 = new Node(x, s, last);
                    last.next = x.child1;
                    last = x.child1;
                    break;
                }
            }
        }
        size++;
        return true;
    }
//    моя версия
//    @Override
//    public boolean add(String s) {
//        if (first == null) {
//            first = new Node(null, s, null);
//            last = first;
//        } else if (last == first) {
//            last = new Node(null, s, first);
//            first.next = last;
//        } else if (first.child1 == null) {
//            first.child1 = new Node(first, s, last);
//            last.next = first.child1;
//            last = first.child1;
//        } else if (last.parent.child2 == null) {
//            last.parent.child2 = new Node(last.parent, s, last);
//            last.next = last.parent.child2;
//            last = last.parent.child2;
//        } else {
//            Node otherParent = last.parent.next;
//            otherParent.child1 = new Node(otherParent, s, last);
//            last.next = otherParent.child1;
//            last = otherParent.child1;
//        }
//        size++;
//        return true;
//    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Solution.Node x = first; x != null; x = x.next) {
                if(x.item == null) {
                    final Solution.Node next = x.next;
                    final Solution.Node prev = x.prev;
                    final Solution.Node parent = x.parent;
                    final Solution.Node firstCh = x.child1;
                    final Solution.Node secondCh = x.child2;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }


                    if (parent != null) {
                        if (parent.child1.item == null) {
                            parent.child1 = parent.child2;
                        }
                        parent.child2 = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        }
        else {
            for (Solution.Node x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    final Solution.Node next = x.next;
                    final Solution.Node prev = x.prev;
                    final Solution.Node parent = x.parent;
                    final Solution.Node firstCh = x.child1;
                    final Solution.Node secondCh = x.child2;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    if (parent != null) {
                        if (parent.child1.item.equals(o)) {
                            parent.child1 = parent.child2;
                        }
                        parent.child2 = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        }
    }
//    моя версия
//    @Override
//    public boolean remove(Object o) {
//        String s;
//        if (o instanceof String) {
//            s = (String) o;
//        } else s = null;
//
//        Iterator<String> iter = this.iterator();
//
//        while (iter.hasNext()) {
//            String item = iter.next();
//            if (s == null) {
//                if (item == null) iter.remove();
//            } else if (s.equals(item)) {
//                iter.remove();
//            }
//
//        }
//        return true;
//    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Solution mySugar = new Solution();
        mySugar.add("1");
        mySugar.add("2");
        mySugar.add(null);
        mySugar.add("4");
        mySugar.add("5");
        mySugar.add(null);
        System.out.println(mySugar);
        System.out.println("sol.getParent(1) = "+mySugar.getParent("1"));
        System.out.println("sol.getParent(2) = "+mySugar.getParent("2"));
        System.out.println("sol.getParent(3) = "+mySugar.getParent("3"));
        System.out.println("sol.getParent(null) = "+mySugar.getParent(null));
        System.out.println("sol.getParent(4) = "+mySugar.getParent("4"));
        System.out.println("sol.getParent(5) = "+mySugar.getParent("5"));
        System.out.println("sol.getParent(6) = "+mySugar.getParent("6"));
        System.out.println("sol.getParent(null) = "+mySugar.getParent(null));
        System.out.println("------------------------------------------sol.remove(null);");
        mySugar.remove(null);
        System.out.println(mySugar);
        System.out.println("sol.getParent(1) = "+mySugar.getParent("1"));
        System.out.println("sol.getParent(2) = "+mySugar.getParent("2"));
        System.out.println("sol.getParent(3) = "+mySugar.getParent("3"));
        System.out.println("sol.getParent(null) = "+mySugar.getParent(null));
        System.out.println("sol.getParent(4) = "+mySugar.getParent("4"));
        System.out.println("sol.getParent(5) = "+mySugar.getParent("5"));
        System.out.println("sol.getParent(6) = "+mySugar.getParent("6"));
        System.out.println("sol.getParent(null) = "+mySugar.getParent(null));
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");


        List listTree = new Solution();
        System.out.println("Check isEmpty0: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("Check isEmpty1: " + listTree.isEmpty() + " Size: " + listTree.size());

        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty2: " + list2222.isEmpty() + " Size: " + list2222.size());

        list2222.add("test");
        System.out.println("Check isEmpty3: " + list2222.isEmpty() + " Size: " + list2222.size());

        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty4: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }


        Solution list = ((Solution)listTree).clone();
        System.out.println("=====================================================================================");
        System.out.println("listTree  = "+list);
        System.out.println("listClone = "+list);
        System.out.println("=====================================================================================");

        System.out.println("Start value with using clone: " + list);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 - 32 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");

        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        List<String> sol = (Solution)list.clone();

        System.out.println("Clone : " + sol + " --> Size = " + sol.size());

        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));


        System.out.println("*******************************************************************");
        System.out.println("*******************************************************************");
        System.out.println("*******************************************************************");

        list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println(list);
        ((Solution) list).remove("2");
        ((Solution) list).remove("9");
        System.out.println("Удалили 2 и 9:");
        System.out.println(list);

        for (int i = 16; i < 21; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Добавили 16,17,18,19,20");
        System.out.println(list);

        ((Solution) list).remove("18");
        ((Solution) list).remove("20");
        System.out.println("Удалили 18 и 20:");
        System.out.println(list);

        list.add("21");
        list.add("22");
        System.out.println("Добавили 21 и 22:");
        System.out.println(list);


        System.out.println("Expected null, actual is " + ((Solution) list).getParent("1"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("2"));
        System.out.println("Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("5"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("6"));
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("7"));
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("9"));
        System.out.println("Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("12"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("13"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("14"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("18"));
        System.out.println("Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("20"));
        System.out.println("Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("Expected 15, actual is " + ((Solution) list).getParent("22"));

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected __, actual is " + ((Solution) list).getParent("0"));
        System.out.println("Expected __, actual is " + ((Solution) list).getParent("1"));
        System.out.println("Expected 6, actual is " + ((Solution) list).getParent("14"));
        System.out.println("Expected __, actual is " + ((Solution) list).getParent("2"));
        System.out.println("Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));

        System.out.println("--------------------list.remove(2)-------------------");
        ((Solution) list).remove("2");


        System.out.println("getParent 1== " + ((Solution) list).getParent("1"));
        System.out.println("getParent 2== " + ((Solution) list).getParent("2"));
        System.out.println("getParent 3== " + ((Solution) list).getParent("3"));
        System.out.println("getParent 4== " + ((Solution) list).getParent("4"));
        System.out.println("getParent 5== " + ((Solution) list).getParent("5"));
        System.out.println("getParent 6== " + ((Solution) list).getParent("6"));
        System.out.println("getParent 7== " + ((Solution) list).getParent("7"));
        System.out.println("getParent 8== " + ((Solution) list).getParent("8"));
        System.out.println("getParent 9== " + ((Solution) list).getParent("9"));
        System.out.println("getParent 10== " + ((Solution) list).getParent("10"));
        System.out.println("getParent 11== " + ((Solution) list).getParent("11"));
        System.out.println("getParent 12== " + ((Solution) list).getParent("12"));
        System.out.println("getParent 13== " + ((Solution) list).getParent("13"));
        System.out.println("getParent 14== " + ((Solution) list).getParent("14"));
        System.out.println("getParent 15== " + ((Solution) list).getParent("15"));

        System.out.println("size= "+list.size());

        System.out.println("--------------------list.clear-------------------");
        list.clear();

        System.out.println(list.size());

        System.out.println("**************************************************************************");

        System.out.println("===========Adding all 1=============");
        list = new Solution();
        for (int i = 1; i < 7; i++) {
            list.add("1");
        }

        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 6");
        list.remove("1");
        System.out.println("==========After removing 1===========");
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());


        System.out.println("List size is " + list.size() + ", expected 0");

        System.out.println("=========Adding 1,2 & all 1===========");
        list.add("1");
        list.add("2");


        for (int i = 1; i < 13; i++) {
            list.add("1");
        }
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 14");
        list.remove("1");
        System.out.println("==========After removing 1===========");
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 1");


        System.out.println("______________________________________________________________________");
        System.out.println("______________________________________________________________________");
        System.out.println("______________________________________________________________________");

        List<String> listStr = new Solution();
        for (int i = 1; i < 16; i++)
        {
            listStr.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((Solution) listStr).getParent("8"));
        listStr.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listStr).getParent("11"));

        for (char i = 'a'; i < 'f'; i++)
        {
            listStr.add(String.valueOf((i)));
        }

        System.out.println("a Expected 7, actual is " + ((Solution) listStr).getParent("a"));
        System.out.println("b Expected 8, actual is " + ((Solution) listStr).getParent("b"));
        System.out.println("c Expected 8, actual is " + ((Solution) listStr).getParent("c"));
        System.out.println("d Expected 9, actual is " + ((Solution) listStr).getParent("d"));
        System.out.println("e Expected 9, actual is " + ((Solution) listStr).getParent("e"));
        System.out.println(listStr.size());
    }

}

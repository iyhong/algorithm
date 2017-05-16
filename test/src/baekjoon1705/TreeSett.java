package baekjoon1705;
import java.util.Iterator;
import java.util.TreeSet;
 
public class TreeSett {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
 
        if(treeSet.isEmpty())
            System.out.println("트리셋이 비어있음");
 
        final int SIZE_ADD = 7;
        for(int i = 0; i < SIZE_ADD; i++)
            treeSet.add(i + 2);
        printAllElements("ADD 후 트리셋", treeSet);
 
        final int CONTAINS_ELEMENT = 4;
        if(treeSet.contains(CONTAINS_ELEMENT))
            System.out.println(CONTAINS_ELEMENT + "은(는) 트리셋에 포함되어 있음");
        else
            System.out.println(CONTAINS_ELEMENT + "은(는) 트리셋에 없음");
 
        final int REMOVE_ELEMENT = 5;
        if(treeSet.remove(REMOVE_ELEMENT))
            printAllElements(REMOVE_ELEMENT + "제거 후 트리셋", treeSet);
        else
            System.out.println(REMOVE_ELEMENT + "은(는) 없어서 제거 못함");
 
        final int HEADSET_ELEMENT = 4;
        System.out.println(HEADSET_ELEMENT + "보다 작은 요소 : " +
                treeSet.headSet(HEADSET_ELEMENT));
 
        final int SUBSET_ELEMENT_FROM = 2;
        final int SUBSET_ELEMENT_TO = 6;
        System.out.println(SUBSET_ELEMENT_FROM + "부터 " + SUBSET_ELEMENT_TO + "사이의 요소 : " +
                treeSet.subSet(SUBSET_ELEMENT_FROM, SUBSET_ELEMENT_TO));
 
        final int TAIL_ELEMENT = 8;
        System.out.println(TAIL_ELEMENT + "보다 큰 요소 : " +
                treeSet.tailSet(TAIL_ELEMENT));
 
        treeSet.clear();
        System.out.println("트리셋 클리어!");
        if(treeSet.isEmpty())
            System.out.println("트리셋이 비어있음");
    }
    public static <T extends Integer> void printAllElements(final String str, final TreeSet<T> treeSet)
    {
        Iterator<T> iterator = treeSet.iterator();
        System.out.print(str + " : ");
        while(true)
        {
            System.out.print(iterator.next());
            if(iterator.hasNext())
                System.out.print(", ");
            else
                break;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(6);
        list.add(1, 5);

        System.out.println(list);

        System.out.println("Размер: " + list.size());
        System.out.println("Первый: " + list.getFirst());

        System.out.println("Замена: " + list.set(1, 6));
        System.out.println("После замены: " + list);

        System.out.println("Значение по индексу '0': " + list.get(0));

        System.out.println("Удалён по индексу '2': " + list.remove(2));
        System.out.println("После удаления: " + list);

        System.out.println("Удалён первый элемент: " + list.removeFirst());
        System.out.println("После удаления: " + list);

        list.addFirst(9);
        System.out.println("После добавления: " + list);

        list.reverse();
        System.out.println("После разворота: " + list);

        SinglyLinkedList<Integer> copy = list.copy();
        System.out.println("Копия: " + copy);

        System.out.println("Удаление по значению '5': " + copy.removeByValue(5));
        System.out.println("Копия после удаления: " + copy);
    }
}
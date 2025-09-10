import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        this.head = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public T getFirst() {
        return head == null ? null : head.getData();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует.");
        }
    }

    private ListItem<T> getListItem(int index) {
        checkIndex(index);
        ListItem<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public T get(int index) {
        return getListItem(index).getData();
    }

    public T set(int index, T newValue) {
        checkIndex(index);
        ListItem<T> item = getListItem(index);
        T oldValue = item.getData();
        item.setData(newValue);
        return oldValue;
    }

    public T remove(int index) {
        checkIndex(index);

        T removedData;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();

        } else {
            ListItem<T> prevItem = getListItem(index - 1);
            ListItem<T> removedItem = prevItem.getNext();
            removedData = removedItem.getData();
            prevItem.setNext(removedItem.getNext());
        }

        count--;
        return removedData;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует.");
        }

        if (index == 0) {
            addFirst(data);
        }

        ListItem<T> prevItem = getListItem(index - 1);
        ListItem<T> newItem = new ListItem<>(data, prevItem.getNext());
        prevItem.setNext(newItem);
        count++;
    }

    public boolean removeByValue(T data) {
        if (head == null) {
            return false;
        }

        if ((data == null && head.getData() == null) ||
                (data != null && data.equals(head.getData()))) {
            head = head.getNext();
            count--;
            return true;
        }

        ListItem<T> prevItem = head;
        ListItem<T> currentItem = head.getNext();

        while (currentItem != null) {
            if (currentItem.getData().equals(data)) {
                prevItem.setNext(currentItem.getNext());
                count--;
                return true;
            }

            prevItem = currentItem;
            currentItem = currentItem.getNext();
        }

        return false;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }

        T removedHeadValue = head.getData();
        head = head.getNext();
        count--;
        return removedHeadValue;
    }

    public void reverse() {
        if (head == null || head.getNext() == null) return;

        ListItem<T> prevItem = null;
        ListItem<T> currentItem = head;
        ListItem<T> nextItem;

        while (currentItem != null) {
            nextItem = currentItem.getNext();
            currentItem.setNext(prevItem);
            prevItem = currentItem;
            currentItem = nextItem;
        }

        head = prevItem;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        ListItem<T> currentItem = head;

        while (currentItem != null) {
            newList.addFirst(currentItem.getData());
            currentItem = currentItem.getNext();
        }

        newList.reverse();

        return newList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            builder.append(currentItem.getData());
            if (currentItem.getNext() != null) builder.append("; ");
        }
        return builder.append("]").toString();
    }
}
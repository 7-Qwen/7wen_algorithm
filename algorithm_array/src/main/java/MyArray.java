import jdk.jfr.DataAmount;

import java.util.Arrays;

/**
 * @author: 7wen
 * @Date: 2023-07-26 15:02
 * @description:
 */
public class MyArray {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.addLast(1);
        myArray.addLast(2);
        myArray.addLast(3);
        myArray.addLast(4);
        myArray.addLast(5);
        myArray.addLast(6);
        myArray.addLast(7);
        myArray.addLast(8);
        myArray.addLast(9);
        myArray.addLast(10);
        while (myArray.size > 0) {
            System.out.println(myArray);
            myArray.remove(0);
        }
//        myArray.removeFirst();
//        myArray.update(myArray.size - 1, 2444);
//        System.out.println(myArray);
    }

    /**
     * 默认数组容量
     */
    private int capacity = 10;

    /**
     * 数组中的元素个数额
     */
    private Integer size = 0;

    /**
     * 声明整形数组
     */
    private int[] array;


    /**
     * 初始化容量
     */
    public MyArray() {
        this.array = new int[capacity];
    }

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }


    /**
     * 获取数组当前容量
     */
    public int length() {
        return this.capacity;
    }


    /**
     * 获取数组当前元素个数
     */
    public int size() {
        return size;
    }

    //增删改查

    /**
     * 往数组中插入元素
     */
    public int add(int index, int e) {
        if (size >= capacity) {
            throw new RuntimeException("超过数组容量无法插入");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("超过数组边界,无法添加");
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
        return e;
    }


    /**
     * 往数组头插入元素
     */
    public int addFirst(int e) {
        return add(0, e);
    }


    /**
     * 往数组末插入元素
     */
    public int addLast(int e) {
        return add(size, e);
    }


    /**
     * 往数组中删除元素
     */
    public int remove(int index) {
        if (size <= 0) {
            throw new RuntimeException("数组无有效元素,无法删除");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("超过数组边界");
        }
        int num = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return num;
    }


    /**
     * 删除数组收个值
     */
    public int removeFirst() {
        return remove(0);
    }


    /**
     * 删除数组末尾值
     */
    public int removeLast() {
        return remove(size - 1);
    }


    /**
     * 改变数据
     */
    public int update(int index, int e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("超过数据边界值");
        }
        int num = array[index];
        array[index] = e;
        return num;
    }


    /**
     * 获取数据
     */
    public int getValueByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("超过数据边界值");
        }
        return array[index];
    }


    /**
     * 根据内容获取下标
     */
    public Integer getIndexByValue(int e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}

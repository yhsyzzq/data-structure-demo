package com.zzq.demo.charpter2.array;

/**
 * Created by yhsyzzq on 2017-11-16.
 */
public class LineList {

    private final int maxSize =8;

    private DataType[] elementData;

    public LineList() {
        initList();
    }

    /**
     * 初始化线性集合
     */
    private void initList() {
        elementData = new DataType[maxSize];
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if(ListLength() == 0){
            return true;
        }
        return false;
    }

    /**
     * 清空集合
     */
    public void clearList() {
        elementData = new DataType[maxSize];
    }

    /**
     * 获取指定位置元素
     *
     * @param i
     * @return
     */
    public DataType getElem(int i) {
        return elementData[i];
    }

    /**
     * 查找是否存在与给定e值相等的元素
     * 如果存在返回第一个相等元素的位置，否则返回-1
     *
     * @param e
     * @return
     */
    public int locateElem(DataType e) {
        int index = 0;
        for(int i=0;i<elementData.length;i++){
            DataType element = elementData[i];
            if(e != null && e.equals(element)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 指定位置插入元素
     *
     * @param i
     * @param e
     */
    public DataType ListInsert(int i,DataType e) throws ListOutOfBoundaryException, ListHasFullException {
        if(ListLength() == maxSize){
            throw new ListHasFullException("集合已满了");
        }else if(i>=maxSize || i<0){
            throw new ListOutOfBoundaryException("集合越界了");
        }else{
            for (int k = ListLength(); k >= i; k--) {
                elementData[k+1] = elementData[k];
            }
            elementData[i-1] = e;
        }
        return e;
    }

    /**
     * 删除某个位置上的给定元素
     *
     * @param i
     */
    public DataType ListDelete(int i) {
        return null;
    }

    /**
     * 依次增加
     * @param e
     * @return
     */
    public DataType add(DataType e){
        return null;
    }

    /**
     * 返回集合的大小
     *
     * @return
     */
    public int ListLength() {
        int n = 0;
        for (DataType e : elementData) {
            if (e != null) n++;
        }
        return n;
    }

}

package com.jiaoshen.study.structure;

import java.util.*;

/**
 * 加强堆 加上反向索引
 * 左节点 2i+1
 * 右节点 2i+2
 * 父节点 (i-1)/2
 *
 * @author jiaoshen
 * @date 2022/6/5-9:56
 */
public class HeapGreater<T> {

    private List<T> data;
    private int heapSize;
    private HashMap<T, Integer> indexMap;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> comp) {
        this.data = new ArrayList<>();
        this.heapSize = 0;
        this.indexMap = new HashMap<>();
        this.comp = comp;
    }

    public boolean  empty(){
        return heapSize == 0;
    }

    public T pop(){
        T result =data.get(0);
        swap(0,heapSize-1);
        data.remove(--heapSize);
        heapIfy(0);
        return result;


    }

    public T top(){
        return data.get(0);

    }

    public void add(T x){
        data.add(x);
        heapInsert(x, heapSize++);

    }

    public int size(){
        return heapSize;
    }

    public void heapIfy(int index){
        while (heapSize>2*index+1 ){
            int maxChildIndex = getMin(2*index+1,2*index+2);
            if(comp.compare(data.get(index),data.get(maxChildIndex))>0){
                swap(index,maxChildIndex);
                index =maxChildIndex;
            }else{
                break;
            }
        }
    }

    public void heapInsert(T x,int index){
        while (comp.compare(data.get((index-1)/2),data.get(index))>0){
            swap((index-1)/2,index);
        }
    }
    public void  swap(int i, int j){
        if(i == j){
            return;
        }
        T temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }

    public int getMin(int i, int j){
        if(j>=heapSize){
            return i;
        }
       return  comp.compare(data.get(i),data.get(j))<0?i:j;

    }

    public static void main(String[] args) {
        HeapGreater<Integer> heapGreater = new HeapGreater<>(Integer::compareTo);
        heapGreater.add(15);
        heapGreater.add(13);
        heapGreater.add(14);
        heapGreater.add(25);

        while (!heapGreater.empty()){
            System.out.println(heapGreater.pop());
        }



    }


}

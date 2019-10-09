package cn.zdh.diffutil;

import android.support.v7.util.DiffUtil;

import java.util.List;

public abstract class BaseDiffUtilCallback<T> extends DiffUtil.Callback {

    protected List<T> oldList;
    protected List<T> newList;

    public BaseDiffUtilCallback(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        if (oldList != null) {
            return oldList.size();
        }

        return 0;
    }

    @Override
    public int getNewListSize() {
        if (newList != null) {
            return newList.size();
        }
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        return setAreItemsTheSame(oldItemPosition,newItemPosition);
    }

    /**
     * 判断item布局是否相同
     * 子类实现
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    public abstract boolean setAreItemsTheSame(int oldItemPosition, int newItemPosition);




    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return setAreContentsTheSame(oldItemPosition, newItemPosition);
    }

    /**
     * 判断item内容是否相同
     * 子类实现
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    public abstract boolean setAreContentsTheSame(int oldItemPosition, int newItemPosition);
}

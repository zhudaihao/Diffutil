package cn.zdh.diffutil;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

public class MyCallback extends BaseDiffUtilCallback<Bean> {

    public MyCallback(List<Bean> oldList, List<Bean> newList) {
        super(oldList, newList);
    }

    @Override
    public boolean setAreItemsTheSame(int oldItemPosition, int newItemPosition) {
        return (newList.get(newItemPosition).getId() + "").equals(oldList.get(oldItemPosition).getId() + "");
    }




    @Override
    public boolean setAreContentsTheSame(int oldItemPosition, int newItemPosition) {
        Log.e("zdh", "-----------new " + newList.get(newItemPosition).getImage() + "--------old " + oldList.get(oldItemPosition).getImage());
        return newList.get(newItemPosition).getImage().equals(oldList.get(oldItemPosition).getImage());
    }


    /**
     * 数据改变回调
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);

    }
}

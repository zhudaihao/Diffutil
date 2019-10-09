package cn.zdh.diffutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<Bean> newList = new ArrayList<>();
    private List<Bean> oldList = new ArrayList<>();
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);

        newList.add(new Bean(1, "http://img3.imgtn.bdimg.com/it/u=1535148441,4230194458&fm=26&gp=0.jpg"));
        newList.add(new Bean(2, "http://img4.imgtn.bdimg.com/it/u=2866533716,2951245878&fm=26&gp=0.jpg"));
        newList.add(new Bean(3, "http://img5.imgtn.bdimg.com/it/u=2271585224,2521053925&fm=26&gp=0.jpg"));
        myAdapter = new MyAdapter(newList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myAdapter);

        for (Bean bean : newList) {
            oldList.add(bean);
        }


    }



    //测试
    public void text(View view) {
        //add
        newList.add(new Bean(4, "http://img1.imgtn.bdimg.com/it/u=3247749323,1379996244&fm=26&gp=0.jpg"));
        newList.add(new Bean(5, "http://img0.imgtn.bdimg.com/it/u=4243074413,3824683139&fm=26&gp=0.jpg"));
        newList.add(new Bean(6, "http://img1.imgtn.bdimg.com/it/u=2048116090,3629196295&fm=26&gp=0.jpg"));


        //change
        //newList.remove(0);
        /**
         * 修改同一个内存地址，两个集合数据都变了
         */
        //  newList.get(0).setImage("http://img5.imgtn.bdimg.com/it/u=2062687559,2599915666&fm=26&gp=0.jpg");
        //正常姿势
        newList.set(1, new Bean(1, "http://img5.imgtn.bdimg.com/it/u=2062687559,2599915666&fm=26&gp=0.jpg"));


        DiffUtil.Callback myCallback = new MyCallback(oldList, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(myCallback, true);
        diffResult.dispatchUpdatesTo(myAdapter);
    }


}


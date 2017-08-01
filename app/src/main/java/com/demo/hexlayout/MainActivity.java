package com.demo.hexlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vander.hexlayout.PolygonItemView;
import com.vander.hexlayout.PolygonLayoutManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int[] COLORS = {0xff00FFFF, 0xffDEB887, 0xff5F9EA0,
            0xff7FFF00, 0xff6495ED, 0xffDC143C,
            0xff008B8B, 0xff006400, 0xff2F4F4F,
            0xffFF69B4, 0xffFF00FF, 0xffCD5C5C,
            0xff90EE90, 0xff87CEFA, 0xff800000};

    private int mCount = 15;

    private RecyclerView mMainRv;
    private Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    /**
     * 初始化View
     */
    private void initView() {
        mMainRv = (RecyclerView) findViewById(R.id.main_rv);

    }

    private void initData() {
        mAdapter = new Adapter();
        PolygonLayoutManager manager = new PolygonLayoutManager(true);
        manager.setLandscapeInterval(0);
        mMainRv.setLayoutManager(manager);
        mMainRv.setAdapter(mAdapter);
    }


    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new Holder(item);
        }

        @Override
        public void onBindViewHolder(final Holder holder, final int position) {

            if (position != 0) {
                holder.text.setText(position + "");
                //随机设置Item颜色
                holder.item.setInnerColor(randomColor());
                //设置阴影
                //holder.item.setShadowLayer(10,3,3, Color.BLACK,true);
            } else {
                holder.item.setRadius(200);
            }
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, holder.text.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return mCount;
        }

        private int randomColor() {
            return COLORS[new Random().nextInt(COLORS.length)];
        }

        class Holder extends RecyclerView.ViewHolder {
            PolygonItemView item;
            TextView text;

            public Holder(View itemView) {
                super(itemView);
                item = (PolygonItemView) itemView.findViewById(R.id.itemview);
                text = (TextView) itemView.findViewById(R.id.text);
            }
        }
    }
}

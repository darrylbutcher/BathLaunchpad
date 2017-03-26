package com.example.darryl.bathlaunchpad;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class FindJobs extends AppCompatActivity {

    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<Data> array;
    private SwipeFlingAdapterView flingContainer;
    private JobsDbHelper JDBH;
    private int UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_jobs);
        Intent intent=getIntent();
        this.UserID=intent.getIntExtra("UserID", 0);
        JDBH=new JobsDbHelper(this);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        array = new ArrayList<>();
        Cursor res=JDBH.getAllData();
        String temp="";
        String img="http://combiboilersleeds.com/images/money/money-2.jpg";
        while(res.moveToNext()){
            int id=Integer.valueOf(res.getString(0));
            temp+=("Job Title: "+res.getString(1)+"\n");
            temp+=("Job Role: "+res.getString(2)+"\n");
            temp+=("Location: "+res.getString(3)+"\n");
            temp+=("Description: "+res.getString(4)+"\n");
            temp+=("Date: "+res.getString(5)+"\n");
            temp+=("Hours: "+res.getString(6)+"\n");
            temp+=("Pay: "+res.getString(7)+"\n");
            temp+=("Skills: "+res.getString(8));
            array.add(new Data(img, id,temp));
            temp="";
        }
        String finalimg="https://images.washingtonpost.com/?url=http://img.washingtonpost.com/news/morning-mix/wp-content/uploads/sites/21/2015/06/sleepy-face.png&w=1484&op=resize&opt=1&filter=antialias";
        array.add(new Data(finalimg,-1,"NO MORE JOBS LEFT :("));
        myAppAdapter = new MyAppAdapter(array, FindJobs.this);
        flingContainer.setAdapter(myAppAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                array.remove(0);
                myAppAdapter.notifyDataSetChanged();

            }

            @Override
            public void onRightCardExit(Object dataObject) {
                int JobID=array.get(0).getID();
                array.remove(0);
                myAppAdapter.notifyDataSetChanged();
                MatchesDbHelper MDBH= new MatchesDbHelper(FindJobs.this);
                Boolean check=MDBH.insertData(UserID,JobID);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                myAppAdapter.notifyDataSetChanged();
            }
        });
    }

    public static class ViewHolder {
        public static FrameLayout background;
        public TextView DataText;
        public ImageView cardImage;


    }

    public class MyAppAdapter extends BaseAdapter {


        public List<Data> parkingList;
        public Context context;

        private MyAppAdapter(List<Data> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder

                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                viewHolder.DataText.setTextSize(30);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(parkingList.get(position).getDescription() + "");

            Glide.with(FindJobs.this).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);

            return rowView;
        }
    }
}

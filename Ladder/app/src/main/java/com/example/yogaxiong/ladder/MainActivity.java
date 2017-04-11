package com.example.yogaxiong.ladder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView ladderListView;
    private LadderAdapter ladderAdapter;
    private List<Ladder> ladderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config();
        configView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void config() {
        ladderList = new ArrayList<Ladder>();
        ladderAdapter = new LadderAdapter(MainActivity.this, ladderList);
    }

    private void configView() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });

        ladderListView = (ListView) findViewById(R.id.ladder_list_view);
        ladderListView.setAdapter(ladderAdapter);
    }

    private void loadData() {
        NetWorkUtil.getInstance().getResponse(MainActivity.this, Config.url, callBack);
    }

    private NetWorkUtil.CallBack callBack = new NetWorkUtil.CallBack() {
        @Override
        public void successCallBack(String result) {
            ladderList = Creater.getInstance().create(result);
            ladderAdapter.setLadders(ladderList);
            ladderAdapter.notifyDataSetChanged();
        }

        @Override
        public void failureCallBack(String result) {

        }
    };
}

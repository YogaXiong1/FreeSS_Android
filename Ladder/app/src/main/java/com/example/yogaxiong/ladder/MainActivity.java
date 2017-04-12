package com.example.yogaxiong.ladder;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView ladderListView;
    private LadderAdapter ladderAdapter;
    private List<Ladder> ladderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config();
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

        ladderList = new ArrayList<Ladder>();
        ladderAdapter = new LadderAdapter(MainActivity.this, ladderList);

        ladderListView = (RecyclerView) findViewById(R.id.ladder_list_view);
        ladderListView.setAdapter(ladderAdapter);
        ladderListView.setLayoutManager(new LinearLayoutManager(this));

//        ladderListView.setOnItemClickListener(itemClickListener);
    }

    private void loadData() {
        NetWorkUtil.getInstance().getResponse(MainActivity.this, Config.url, callBack);
    }

    private NetWorkUtil.CallBack callBack = new NetWorkUtil.CallBack() {
        @Override
        public void successCallBack(String result) {
            ladderList = Creater.getInstance().createLadders(result);
            ladderAdapter.setLadders(ladderList);
            ladderAdapter.notifyDataSetChanged();
        }

        @Override
        public void failureCallBack(String result) {
        }
    };

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Ladder ladder = ladderList.get(position);
            LogUtil.e("LINK", ladder.toSSLink());
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setPrimaryClip(ClipData.newPlainText(null, ladder.toSSLink()));
        }
    };
}
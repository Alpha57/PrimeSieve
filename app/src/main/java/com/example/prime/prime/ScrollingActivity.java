package com.example.prime.prime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.prime.PrimeListAdapter;

// This is a simple app to compute prime numbers using the Sieve of Eratosthenes
// and display them in a scrollable grid.
// Use the StaggeredGridLayoutManager.
// And let's add a FAB to re-start the calculations.

public class ScrollingActivity extends AppCompatActivity {

    // Recycler list stuff (view, adapter, layout manager)
    private RecyclerView                mRecyclerView;
    private RecyclerView.Adapter        mAdapter;
    private StaggeredGridLayoutManager  mStaggeredLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        // Setup the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup the recycler list for the prime numbers.
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        // Fix the layout size to improve performance.
        mRecyclerView.setHasFixedSize(true);

        // Use the staggered grid manager oriented vertically.
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        // Setup the adapter.
        mAdapter = new PrimeListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        // Setup the FAB.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Primes recalculated.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

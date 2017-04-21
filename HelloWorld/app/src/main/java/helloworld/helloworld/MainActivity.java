package helloworld.helloworld;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("HelloWorld","onCreate");

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("valorText","true");

        startActivity(i);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("HelloWorld","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HelloWorld","onRestar");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HelloWorld","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HelloWorld","onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void access(){

        getContentResolver cr = getContentResolver();
        Cursor cur = cr.query {Contacts.People.CONTENT_URI, null, null, null, null};
        if(cur.getCount()>0){
            while (cur.moveToNext()){

                String id =cur.getString(cur.getColumnIndex(Contacts.People._ID));
                String name = cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));
                log.d("ContentProvider",name);

            }

        }
    }
}

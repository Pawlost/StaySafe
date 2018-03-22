package com.example.pc.staysafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.staysafe.ListAdapter.ArticlesListAdapter;
import com.example.pc.staysafe.Model.Objects.Article;
import com.example.pc.staysafe.Model.TestModel;
import java.util.ArrayList;

/**
 * Shows all articles on given danger type
 */
public class DangerActivity extends AppCompatActivity {

    private TestModel testModel = new TestModel();
    private TextView pageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danger);

        ArrayList<Article> arts = testModel.getArticles(TestModel.DangerType.REAL);
        pageTitle = findViewById(R.id.pageTitle);

        for (Article article : arts) {

            Log.w("AAA Title", article.getTitle());
            Log.w("AAA Time", Integer.toString(article.getTimeToRead()));

            for (String subarticle : article.getSubarticles()) {
                Log.w("AAA SubArticles", subarticle);
            }
        }

        final ListView testArticles = findViewById(R.id.TestArticlesContainer);

        ArticlesListAdapter testArticlesAdapter = new ArticlesListAdapter(this, arts);
        testArticles.setAdapter(testArticlesAdapter);

        //Make Item in listview clickable and change title of page when cliked
        testArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article text = (Article) parent.getItemAtPosition(position);
                pageTitle.setText(text.getTitle());
            }
        });
    }
}
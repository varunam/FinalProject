package app.testproject.com.jokeslib_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    
    public static String JOKE_KEY = "joke-key";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        
        TextView textView = findViewById(R.id.joke_text_id);
        Intent intent = getIntent();
        if (intent.hasExtra(JOKE_KEY)) {
            String joke = intent.getStringExtra(JOKE_KEY);
            textView.setText(joke);
        }
    }
}

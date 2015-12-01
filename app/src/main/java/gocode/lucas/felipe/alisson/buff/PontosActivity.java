package gocode.lucas.felipe.alisson.buff;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class PontosActivity extends Activity {

    private TextView pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos);
        Bundle bundle = getIntent().getExtras();
        pontos = (TextView) findViewById(R.id.TextViewPontosPontos);
        pontos.setText(bundle.getInt("pontos"));

    }

}

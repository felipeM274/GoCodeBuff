package gocode.lucas.felipe.alisson.buff;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MathActivity extends Activity {

    private TextView x, y, op;
    private Button a, b, c;
    private Random random;
    private int xi, opi, yi, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        random = new Random();
        x = (TextView) findViewById(R.id.TextViewMathX);
        y = (TextView) findViewById(R.id.TextViewMathY);
        op = (TextView) findViewById(R.id.TextViewMathOp);
        a = (Button) findViewById(R.id.buttonMathA);
        b = (Button) findViewById(R.id.buttonMathB);
        c = (Button) findViewById(R.id.buttonMathC);
        setValores(x, op, y, a, b, c);
    }

    private void setValores(TextView x, TextView op, TextView y, Button a, Button b, Button c) {
        while (xi == 0 && yi == 0) {
            xi = random.nextInt(11);
            yi = random.nextInt(11);
        }
        x.setText(xi);
        y.setText(yi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math, menu);
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

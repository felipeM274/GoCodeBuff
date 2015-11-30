package gocode.lucas.felipe.alisson.buff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

public class MathActivity extends Activity {

    private TextView x, y, op, pts;
    private Button[] resultado;
    private Button a, b, c;
    private Random random;
    private int xi, opi, yi, r, pontos;
    private Double rd;
    private DecimalFormat d = new DecimalFormat("#,##0.00");
    private boolean div, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        random = new Random();
        resultado = new Button[03];
        x = (TextView) findViewById(R.id.TextViewMathX);
        y = (TextView) findViewById(R.id.TextViewMathY);
        op = (TextView) findViewById(R.id.TextViewMathOp);
        pts = (TextView) findViewById(R.id.TextViewMathPts);
        a = (Button) findViewById(R.id.buttonMathA);
        b = (Button) findViewById(R.id.buttonMathB);
        c = (Button) findViewById(R.id.buttonMathC);
        resultado[0] = a;
        resultado[1] = b;
        resultado[2] = c;
        Bundle bundle = getIntent().getExtras();
        t = bundle.getBoolean("aberto");
        if (t){

            if (bundle.getInt("pontos") < 0){
                finish();
            } else {
                pontos = bundle.getInt("pontos");
            }
        }
        setValores(x, op, y);
        pts.setText("Pontos: " + pontos);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acertou(a);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acertou(b);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acertou(c);
            }
        });
    }

    private void acertou(Button resposta) {
        if (div) {
            if (resposta.getText().equals(d.format(rd))) {
                pontos += 1;
            } else {
                pontos -= 1;
            }
        } else {
            if (resposta.getText().equals(String.valueOf(r))) {
                pontos += 1;
            } else {
                pontos -= 1;
            }
        }
        if (pontos < 0){
            Intent intent = getIntent();
            intent.putExtra("pontos",pontos);
            intent.putExtra("aberto",t = true);
            finish();
            startActivity(intent);
        } else {
            pts.setText("Pontos: " + pontos);
            Intent intent = getIntent();
            intent.putExtra("pontos",pontos);
            intent.putExtra("aberto",t = true);
            finish();
            startActivity(intent);
        }
    }
    private void setValores(TextView x, TextView op, TextView y) {
        opi = random.nextInt(4);
        if (opi == 1){
            div = true;
            while (xi < 2 || yi > xi || yi == 0) {
                xi = random.nextInt(11);
                yi = random.nextInt(11);
            }
        } else {
            div = false;
            while (xi == 0 || yi == 0) {
                xi = random.nextInt(11);
                yi = random.nextInt(11);
            }

        }
        x.setText(String.valueOf(xi));
        y.setText(String.valueOf(yi));
        op.setText(" " + op(opi) + " ");
        if (opi == 1){
            resultado[random.nextInt(3)].setText(d.format(rd));
            for (int i = 0; i < resultado.length; i++){
                if (resultado[i].getText().equals("0")){
                    double g = random.nextDouble()*20;
                    if (g == rd){
                        g += 1.7;
                    }
                    resultado[i].setText(d.format(g));
                }
            }
        } else {
            resultado[random.nextInt(3)].setText(String.valueOf(r));
            for (int i = 0; i < resultado.length; i++){
                if (resultado[i].getText().equals("0")){
                    int g = random.nextInt(21);
                    if (g == r){
                        g += 2;
                    }
                    resultado[i].setText(String.valueOf(g));
                }
            }
        }
    }

    private String op(int op) {
        if (op == 1) {
            rd =(double)xi / yi;
            return "/";
        }
        if (op == 2) {
            r = xi - yi;
            return "-";
        }
        if (op == 3) {
            r = xi * yi;
            return "*";
        }
        r = xi + yi;
        return "+";
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

package de.example.malte.ohkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int para, pot, yA;
    public boolean quadF = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        para = 1;
        pot = 2;
        yA = 0;

        Switch qswitch = (Switch) findViewById(R.id.quadSwitch);
        qswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                EditText etPot = (EditText) findViewById(R.id.etPot);
                if (isChecked) {
                    quadF = true;
                    pot = 2;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion aktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
                    etPot.setVisibility(View.VISIBLE);
                } else {
                    quadF = false;
                    pot = 1;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion deaktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + " + " + yA);
                    etPot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void bt1Click(View v) {
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        EditText etPara = (EditText) findViewById(R.id.etPara);
        EditText etPot = (EditText) findViewById(R.id.etPot);
        EditText etyA = (EditText) findViewById(R.id.etyA);

        if (etPara.length() == 0) {
            para = 1;
        } else {
            para = Integer.parseInt(etPara.getText().toString());
            if (quadF == true) {
                tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
            } else {
                tv1.setText("f(x)=" + para + "x" + " + " + yA);
            }
        }

        if (etPot.length() == 0) {
            pot = 2;
        } else {
            pot = Integer.parseInt(etPot.getText().toString());
            tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
        }

        if (etyA.length() == 0) {
            yA = 0;
        } else {
            yA = Integer.parseInt(etyA.getText().toString());
            if (quadF == true) {
                tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
            } else {
                tv1.setText("f(x)=" + para + "x" + " + " + yA);
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), "Werte übernommen!", Toast.LENGTH_SHORT);

    }

    public void bt1weiterClick(View v) {
        EditText et_max = (EditText)findViewById(R.id.et_max);

        int x;
        int i;
        if (et_max.length() == 0) {
            x = 100;
        }   else    {
            x = Integer.parseInt(et_max.getText().toString());
            x++;
        }
        Integer xWerte[] = new Integer[x];

        for(i = 0; i < x; i++) {
            xWerte[i] = i;
        }

        setContentView(R.layout.werte);

        ListAdapter myAda = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, xWerte);
        ListView mylv = (ListView)findViewById(R.id.listView1);
        mylv.setAdapter(myAda);

        TextView tvFct = (TextView) findViewById(R.id.tvFct);

        //int xwert = 1;
        //double y = (para * Math.pow(y, pot)) + yA;

        //String yAs = Double.toString(yA);

        tvFct.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
    }

    public void back_Click(View v) {
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.tv1);

        tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);

        Switch qswitch = (Switch) findViewById(R.id.quadSwitch);
        qswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                EditText etPot = (EditText) findViewById(R.id.etPot);
                if (isChecked) {
                    quadF = true;
                    pot = 2;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion aktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
                    etPot.setClickable(true);
                } else {
                    quadF = false;
                    pot = 1;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion deaktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + " + " + yA);
                    etPot.setClickable(false);
                }
            }
        });
    }
}
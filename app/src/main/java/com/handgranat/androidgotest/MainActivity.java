package com.handgranat.androidgotest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import go.androidtest.Androidtest;

//Importerar mitt "clibrary"
import com.handgranat.clibrary.MainNative;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public int numRekurs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Klicka på Calc-knappen
    public void onClickCalcBtn(View view) {
        EditText nInput = (EditText) findViewById(R.id.n1);
        EditText numrunsInput = (EditText) findViewById(R.id.numRuns1);

        int nint = Integer.parseInt(nInput.getText().toString());
        int numruns = Integer.parseInt(numrunsInput.getText().toString());

        executeAlgorithms(numruns, nint);
    }


    // Klicka på Calc-knappen
    public void executeAlgorithms(int numruns, int n) {
        int nint = n;
        long nlong = n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        for (int i = 0; i < numruns ; i++) {
            numRekurs = 0;
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            long goCalcResult = Androidtest.Calc(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            int cCalcResult = mainnative.callNativeMethod(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            int javaCalcResult = javaRekurs(nint);
            javaSum += System.nanoTime() - javaStartTime;
        }

//        int nint = n;
//        long nlong = n;

//        int TIME_VAR = 1000000;
        int TIME_VAR = 1;

        // -- GO --
        TextView goResult = (TextView) findViewById(R.id.goResult1);
        TextView goTimeResult = (TextView) findViewById(R.id.goTimeResult1);
        TextView cResult = (TextView) findViewById(R.id.cResult1);
        TextView cTimeResult = (TextView) findViewById(R.id.cTimeResult1);
        TextView javaResult = (TextView) findViewById(R.id.javaResult1);
        TextView javaTimeResult = (TextView) findViewById(R.id.javaTimeResult1);

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Printa resultatet
//        goResult.setText(String.valueOf(goCalcResult));
        goTimeResult.setText(String.valueOf(formatter.format(goSum/numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum/numruns)));
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum/numruns)));

        javaResult.setText(String.valueOf(formatter.format(numRekurs)));

//        cResult.setText(String.valueOf(cCalcResult));







        // Printa resultatet
//        javaResult.setText(String.valueOf(javaCalcResult));


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

    private int javaHeltal(int n) {
        int result = 0;
        int i;
        int j;

        for (i = 0; i < n; i = i + 1) {
            for (j = 0; j < n; j = j + 1) {
//                result = j*1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20;
                result = (j*1*2*3*4*5*6)+i;
            }
        }

        return result;
    }

    private int javaRekurs(int n) {
        if(n < 2) {
            return 1;
        } else {
            numRekurs++;
            return (javaRekurs(n-1) * javaRekurs(n-2));
        }
    }
}

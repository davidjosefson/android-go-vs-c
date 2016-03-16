package com.handgranat.androidgotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.handgranat.clibrary.MainNative;
import java.text.DecimalFormat;
import go.golib.Golib;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    // Klicka på Calc-knappen
    public void onClickCalcBtn(View view) {
        EditText nInput = (EditText) findViewById(R.id.n1);
//        EditText numrunsInput = (EditText) findViewById(R.id.numRuns1);

        int nint = Integer.parseInt(nInput.getText().toString());
//        int numruns = Integer.parseInt(numrunsInput.getText().toString());
        int numruns = 100;
        executeAlgorithm1(numruns, nint);
    }


    // Klicka på Calc-knappen
    public void executeAlgorithm1(int numruns, int n) {
        int nint = n;
        long nlong = n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        int cCalcResult = 0;
        long goCalcResult = 0;
        int javaCalcResult = 0;

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        for (int i = 0; i < numruns ; i++) {
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            goCalcResult = Golib.IntegerMultiplication(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callIntegerMultiplication(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            javaCalcResult = IntegerMultiplication(nint);
            javaSum += System.nanoTime() - javaStartTime;
        }

        // -- GO --
        TextView goResult = (TextView) findViewById(R.id.goResult1);
        TextView goTimeResult = (TextView) findViewById(R.id.goTimeResult1);
        TextView cResult = (TextView) findViewById(R.id.cResult1);
        TextView cTimeResult = (TextView) findViewById(R.id.cTimeResult1);
        TextView javaResult = (TextView) findViewById(R.id.javaResult1);
        TextView javaTimeResult = (TextView) findViewById(R.id.javaTimeResult1);

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Printa resultatet
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum / numruns)));
        goTimeResult.setText(String.valueOf(formatter.format(goSum / numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum / numruns)));

        String javaRes = String.valueOf(javaSum / numruns);
        String goRes = String.valueOf(goSum / numruns);
        String cRes = String.valueOf(cSum / numruns);
        logResult(javaRes, goRes, cRes, nint);

        javaResult.setText(String.valueOf(javaCalcResult));
        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));


    }

    // Klicka på Calc4-knappen
    public void onClickCalcBtn4(View view) {
        EditText nInput = (EditText) findViewById(R.id.n4);
//        EditText numrunsInput = (EditText) findViewById(R.id.numRuns4);

        int nint = Integer.parseInt(nInput.getText().toString());
//        int numruns = Integer.parseInt(numrunsInput.getText().toString());
        int numruns = 100;

        executeAlgorithm4(numruns, nint);
    }


    public void executeAlgorithm4(int numruns, int n) {
        int nint = n;
        double ndouble = (double) n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        double goCalcResult = 0;
        double cCalcResult = 0;
        double javaCalcResult = 0;

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        for (int i = 0; i < numruns ; i++) {

            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            goCalcResult = Golib.FloatMultiplication(ndouble);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callFloatMultiplication(ndouble);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            javaCalcResult = FloatMultiplication(ndouble);
            javaSum += System.nanoTime() - javaStartTime;
        }


        // -- GO --
        TextView goResult = (TextView) findViewById(R.id.goResult4);
        TextView goTimeResult = (TextView) findViewById(R.id.goTimeResult4);
        TextView cResult = (TextView) findViewById(R.id.cResult4);
        TextView cTimeResult = (TextView) findViewById(R.id.cTimeResult4);
        TextView javaResult = (TextView) findViewById(R.id.javaResult4);
        TextView javaTimeResult = (TextView) findViewById(R.id.javaTimeResult4);

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Printa resultatet
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum / numruns)));
        goTimeResult.setText(String.valueOf(formatter.format(goSum / numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum / numruns)));

        String javaRes = String.valueOf(javaSum / numruns);
        String goRes = String.valueOf(goSum / numruns);
        String cRes = String.valueOf(cSum / numruns);
        logResult(javaRes, goRes, cRes, nint);

        javaResult.setText(String.valueOf(javaCalcResult));
        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));


    }


    // Klicka på Calc2-knappen
    public void onClickCalcBtn2(View view) {
        EditText nInput = (EditText) findViewById(R.id.n2);
//        EditText numrunsInput = (EditText) findViewById(R.id.numRuns2);

        int nint = Integer.parseInt(nInput.getText().toString());
//        int numruns = Integer.parseInt(numrunsInput.getText().toString());

        int numruns = 100;
        executeAlgorithm2(numruns, nint);
    }

    public void executeAlgorithm2(int numruns, int n) {
        int nint = n;
        long nlong = n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        long goCalcResult = 0;
        int cCalcResult = 0;
        int javaCalcResult = 0;
        for (int i = 0; i < numruns ; i++) {
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            goCalcResult = Golib.CreateArray(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callCreateArray(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            javaCalcResult = CreateArray(nint);
            javaSum += System.nanoTime() - javaStartTime;
        }


        // -- GO --
        TextView goResult = (TextView) findViewById(R.id.goResult2);
        TextView goTimeResult = (TextView) findViewById(R.id.goTimeResult2);
        TextView cResult = (TextView) findViewById(R.id.cResult2);
        TextView cTimeResult = (TextView) findViewById(R.id.cTimeResult2);
        TextView javaResult = (TextView) findViewById(R.id.javaResult2);
        TextView javaTimeResult = (TextView) findViewById(R.id.javaTimeResult2);

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Printa resultatet
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum / numruns)));
        goTimeResult.setText(String.valueOf(formatter.format(goSum / numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum / numruns)));

        String javaRes = String.valueOf(javaSum / numruns);
        String goRes = String.valueOf(goSum / numruns);
        String cRes = String.valueOf(cSum / numruns);
        logResult(javaRes, goRes, cRes, nint);


        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));
        javaResult.setText(String.valueOf(javaCalcResult));


    }

    // Klicka på Calc3-knappen
    public void onClickCalcBtn3(View view) {
        EditText nInput = (EditText) findViewById(R.id.n3);
//        EditText numrunsInput = (EditText) findViewById(R.id.numRuns3);

        int nint = Integer.parseInt(nInput.getText().toString());
//        int numruns = Integer.parseInt(numrunsInput.getText().toString());
        int numruns = 100;

        executeAlgorithm3(numruns, nint);
    }

    public void executeAlgorithm3(int numruns, int n) {
        int nint = n;
        long nlong = n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        long goCalcResult = 0;
        int cCalcResult = 0;
        int javaCalcResult = 0;
        for (int i = 0; i < numruns ; i++) {
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            goCalcResult = Golib.BubbleSort(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callBubbleSort(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
             javaCalcResult = BubbleSort(nint);
            javaSum += System.nanoTime() - javaStartTime;
        }


        // -- GO --
        TextView goResult = (TextView) findViewById(R.id.goResult3);
        TextView goTimeResult = (TextView) findViewById(R.id.goTimeResult3);
        TextView cResult = (TextView) findViewById(R.id.cResult3);
        TextView cTimeResult = (TextView) findViewById(R.id.cTimeResult3);
        TextView javaResult = (TextView) findViewById(R.id.javaResult3);
        TextView javaTimeResult = (TextView) findViewById(R.id.javaTimeResult3);

        DecimalFormat formatter = new DecimalFormat("#,###");

        // Printa resultatet
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum / numruns)));
        goTimeResult.setText(String.valueOf(formatter.format(goSum / numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum / numruns)));

        String javaRes = String.valueOf(javaSum / numruns);
        String goRes = String.valueOf(goSum / numruns);
        String cRes = String.valueOf(cSum / numruns);
        logResult(javaRes, goRes, cRes, nint);


        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));
        javaResult.setText(String.valueOf(javaCalcResult));


    }

    private void logResult(String java, String go, String c, int input){
        Log.d("RESULTAT", "NY KÖRNING \n" + input + "\n" + java + "\n" + go + "\n" + c);
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

    private int IntegerMultiplication(int n) {
        int result = 0;
        int i;
        int j;

        for (i = 0; i < n; i = i + 1) {
            for (j = 0; j < n; j = j + 1) {
                result = j*(j+2) - j*(j+1) + i;
            }
        }

        return result;
    }

    private double FloatMultiplication(double n) {
        double result = 0;
        double i;
        double j;

        for (i = 0; i < n; i = i + 1) {
            for (j = 0; j < n; j = j + 1) {
                result = j*(j+1.123456789) - j*(j+0.987654321) + i;
            }
        }

        return result;
    }

    private int CreateArray(int n){
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = n-i;
        }
        return array[n-1];
    }

    private int BubbleSort(int n){

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n-i;
        }

        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[0];
    }
}

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

//Importerar mitt "clibrary"

public class MainActivity extends AppCompatActivity {
    public int numRekurs = 0;

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
        EditText numrunsInput = (EditText) findViewById(R.id.numRuns1);

        int nint = Integer.parseInt(nInput.getText().toString());
        int numruns = Integer.parseInt(numrunsInput.getText().toString());

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

        // Skapa en ny instans av C-biblioteket
        MainNative mainnative = new MainNative();

        for (int i = 0; i < numruns ; i++) {
            numRekurs = 0;
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            long goCalcResult = Golib.IntegerFibonacci(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callIntegerFibonacci(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            int javaCalcResult = integerFibonacci(nint);
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
        javaTimeResult.setText(String.valueOf(formatter.format(javaSum / numruns)));
        goTimeResult.setText(String.valueOf(formatter.format(goSum / numruns)));
        cTimeResult.setText(String.valueOf(formatter.format(cSum / numruns)));

        String javaRes = String.valueOf(javaSum / numruns);
        String goRes = String.valueOf(goSum / numruns);
        String cRes = String.valueOf(cSum / numruns);
        copyToClip(javaRes, goRes, cRes, nint);


        javaResult.setText(String.valueOf(formatter.format(numRekurs)));

        cResult.setText(String.valueOf(cCalcResult));







        // Printa resultatet
//        javaResult.setText(String.valueOf(javaCalcResult));


    }

    // Klicka på Calc4-knappen
    public void onClickCalcBtn4(View view) {
        EditText nInput = (EditText) findViewById(R.id.n4);
        EditText numrunsInput = (EditText) findViewById(R.id.numRuns4);

        int nint = Integer.parseInt(nInput.getText().toString());
        int numruns = Integer.parseInt(numrunsInput.getText().toString());

        executeAlgorithm4(numruns, nint);
    }


    public void executeAlgorithm4(int numruns, int n) {
        int nint = n;
        long nlong = n;

        long goSum = 0;
        long cSum = 0;
        long javaSum = 0;

        // Skapa en ny instans av C-biblioteket


        double goCalcResult = 0;
        double cCalcResult = 0;
        double javaCalcResult = 0;
        for (int i = 0; i < numruns ; i++) {
            numRekurs = 0;

            MainNative mainnative = new MainNative();
            // Anropar Go-biblioteket
            long goStartTime = System.nanoTime();
            goCalcResult = Golib.FloatFibonacci(nlong);
            goSum += System.nanoTime() - goStartTime;

            // Anropar C-biblioteket
            long cStartTime = System.nanoTime();
            cCalcResult = mainnative.callFloatFibonacci(nlong);
            cSum += System.nanoTime() - cStartTime;

            // Anropar Java-metoden
            long javaStartTime = System.nanoTime();
            javaCalcResult = FloatFibonacci(nint);
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
        copyToClip(javaRes, goRes, cRes, nint);

        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));
        javaResult.setText(String.valueOf(javaCalcResult));

        javaResult.setText(String.valueOf(formatter.format(numRekurs)));

    }


    // Klicka på Calc2-knappen
    public void onClickCalcBtn2(View view) {
        EditText nInput = (EditText) findViewById(R.id.n2);
        EditText numrunsInput = (EditText) findViewById(R.id.numRuns2);

        int nint = Integer.parseInt(nInput.getText().toString());
        int numruns = Integer.parseInt(numrunsInput.getText().toString());

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
        copyToClip(javaRes, goRes, cRes, nint);


        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));
        javaResult.setText(String.valueOf(javaCalcResult));


    }

    // Klicka på Calc3-knappen
    public void onClickCalcBtn3(View view) {
        EditText nInput = (EditText) findViewById(R.id.n3);
        EditText numrunsInput = (EditText) findViewById(R.id.numRuns3);

        int nint = Integer.parseInt(nInput.getText().toString());
        int numruns = Integer.parseInt(numrunsInput.getText().toString());

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
        copyToClip(javaRes, goRes, cRes, nint);


        goResult.setText(String.valueOf(goCalcResult));
        cResult.setText(String.valueOf(cCalcResult));
        javaResult.setText(String.valueOf(javaCalcResult));


    }

    private void copyToClip(String java,String go,String c, int input){
        String csvResult = java + ", " + go + ", " + c;
//        ClipboardManager clipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//        android.content.ClipData clip = android.content.ClipData.newPlainText("tag",csvResult);
        Log.d("RESULTAT", "NY KÖRNING \n" +  input + "\n" +java + "\n" + go + "\n" + c);
//        clipMan.setPrimaryClip(clip);
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

    private int integerFibonacci(int n) {
        if(n < 2) {
            return 1;
        } else {
            numRekurs++;
            return (integerFibonacci(n - 1) * integerFibonacci(n - 2));
        }
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
                    numRekurs++;
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[0];
    }

    private double FloatFibonacci(double n){
//        if(n < 2) {
//            return 1;
//        } else {
//            numRekurs++;
//            return (FloatFibonacci(n - 1.1) * FloatFibonacci(n - 2.1));
//        }
        if(n < 2.0) {
            return 1.0;
        } else {
            numRekurs++;
            return (0.99999999999998 * FloatFibonacci(n - 1.0));
        }
    }

//    private int MemoryAllocation(int n){
////        int size = 4000*n;
////        byte[] s = new byte[size];
////        s[9] = 1;
////        return s[9];
//
//        int size = 4000*n;
//        byte[] array = new byte[size];
//
//        for (int i = 0; i < size; i++) {
//            array[i] = 127;
//        }
//
//        return array[n-1];
//    }
}

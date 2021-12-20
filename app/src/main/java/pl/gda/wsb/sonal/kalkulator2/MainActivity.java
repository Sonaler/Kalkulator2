package pl.gda.wsb.sonal.kalkulator2;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String str){
        String old = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String left = old.substring(0, cursorPos);
        String right = old.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(str);
            display.setSelection(str.length());
        }else{
            display.setText(String.format("%s%s%s", left, str, right));
            display.setSelection(cursorPos+1);
        }


    }

    public void buttonZero(View view){
        updateText("0");
    }

    public void buttonOne(View view){
        updateText("1");
    }

    public void buttonTwo(View view){
        updateText("2");
    }

    public void buttonThree(View view){
        updateText("3");
    }

    public void buttonFour(View view){
        updateText("4");
    }

    public void buttonFive(View view){
        updateText("5");
    }

    public void buttonSix(View view){
        updateText("6");
    }

    public void buttonSeven(View view){
        updateText("7");
    }

    public void buttonEight(View view){
        updateText("8");
    }

    public void buttonNine(View view){
        updateText("9");
    }

    public void buttonClear(View view){
       display.setText("");
    }

    public void buttonPercentage(View view){
        String userExpresion = display.getText().toString();

        userExpresion = userExpresion.replaceAll("÷", "/");
        userExpresion = userExpresion.replaceAll("×", "*");

        Expression exp = new Expression(userExpresion);

        Double percentage = exp.calculate()/100;
        String result = String.valueOf(percentage);

        display.setText(result);
        display.setSelection(result.length());
    }

    public void buttonBackspace(View view){
        int curPos = display.getSelectionStart();
        int textLength = display.getText().length();

        if(curPos != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(curPos -1, curPos, "");
            display.setText(selection);
            display.setSelection(curPos-1);
        }
    }

    public void buttonOneOverX(View view){
        String userExpresion = display.getText().toString();

        userExpresion = userExpresion.replaceAll("÷", "/");
        userExpresion = userExpresion.replaceAll("×", "*");

        Expression exp = new Expression(userExpresion);


        Double oneOverX = 1/exp.calculate();
        String result = String.valueOf(oneOverX);
        display.setText(result);
        display.setSelection(result.length());
    }

    public void buttonSquared(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText("^");
        }
    }

    public void buttonSqrt(View view){
        String userExpresion = display.getText().toString();

        userExpresion = userExpresion.replaceAll("÷", "/");
        userExpresion = userExpresion.replaceAll("×", "*");

        Expression exp = new Expression(userExpresion);


        Double result = Math.sqrt(Double.parseDouble(String.valueOf(exp.calculate())));
        String SquareRoot = String.valueOf(result);
        display.setText(SquareRoot);
        display.setSelection(SquareRoot.length());

    }

    public void buttonTimes(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText("×");
        }

    }

    public void buttonDivision(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText("÷");
        }
    }

    public void buttonAdd(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText("+");
        }
    }

    public void buttonSub(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText("-");
        }
    }

    public void buttonPlusMinus(View view){
        String userExpresion = display.getText().toString();

        userExpresion = userExpresion.replaceAll("÷", "/");
        userExpresion = userExpresion.replaceAll("×", "*");

        Expression exp = new Expression(userExpresion);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

        if(display.getText().toString().length() > 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            String str = display.getText().toString();
            if(str.charAt(0) == '-')selection.replace(0,1, "");
            else selection.insert(0, "-");
        }
    }

    public void buttonPoint(View view){
        int curPos = display.getSelectionStart();
        String old = display.getText().toString();
        if(display.getText().length()>0){
            if(old.charAt(curPos - 1) != '×' && old.charAt(curPos - 1) != '÷' && old.charAt(curPos - 1) != '+' && old.charAt(curPos - 1) != '-' && old.charAt(curPos - 1) != '.' && old.charAt(curPos -1) != '^')updateText(".");
        }
    }

    public void buttonEquals(View view){
        String userExpresion = display.getText().toString();

        userExpresion = userExpresion.replaceAll("÷", "/");
        userExpresion = userExpresion.replaceAll("×", "*");

        Expression exp = new Expression(userExpresion);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
}
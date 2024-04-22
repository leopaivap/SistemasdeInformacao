package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private String expression = "";
    private Button buttonEqual;
    private TextView textViewResult;
    private TextView textViewLastExpression;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonSum, buttonMinus, buttonDivide, buttonMultiply, buttonPorcent, buttonD, buttonC, buttonDot;

    private boolean haveDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResultadoID);
        textViewLastExpression = findViewById(R.id.textViewUltimaExpressaoID);

        buttonD = findViewById(R.id.buttonDeleteID);
        buttonC = findViewById(R.id.buttonResetID);

        buttonEqual = findViewById(R.id.buttonIgualID);
        buttonSum = findViewById(R.id.buttonSomaID);
        buttonMinus = findViewById(R.id.buttonSubtracaoID);
        buttonMultiply = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivide = findViewById(R.id.buttonDivisaoID);
        buttonPorcent = findViewById(R.id.buttonPorcentoID);
        buttonDot = findViewById(R.id.buttonVirgulaID);

        button0 = findViewById(R.id.buttonZeroID);
        button1 = findViewById(R.id.buttonUmID);
        button2 = findViewById(R.id.buttonDoisID);
        button3 = findViewById(R.id.buttonTresID);
        button4 = findViewById(R.id.buttonQuatroID);
        button5 = findViewById(R.id.buttonCincoID);
        button6 = findViewById(R.id.buttonSeisID);
        button7 = findViewById(R.id.buttonSeteID);
        button8 = findViewById(R.id.buttonOitoID);
        button9 = findViewById(R.id.buttonNoveID);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    if (!notTwoOperators(expression.charAt(expression.length() - 1)))
                        expression = expression.substring(0, expression.length() - 1);

                    avaliadorExpressao = new ExpressionBuilder(expression).build();

                    Double resultado = avaliadorExpressao.calculate();

                    expression = "";
                    textViewLastExpression.setText(expression);
                    textViewResult.setText(String.format("%.2f", resultado));
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.isEmpty())
                        continueExpression('+');

                    if (notTwoOperators(expression.charAt(expression.length() - 1))) {
                        expression += "+";
                        textViewLastExpression.setText(expression);
                        haveDot = false;
                    } else {
                        if (!(expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '+' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '/' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '*'
                        )) {
                            expression = expression.substring(0, expression.length() - 1);
                            expression += "+";
                            textViewLastExpression.setText(expression);
                        }
                    }

                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.isEmpty())
                        continueExpression('-');
                    if (expression == "" || (expression.charAt(expression.length() - 1)) != '-' || notTwoOperators(expression.charAt(expression.length() - 1))) {
                        expression += "-";
                        textViewLastExpression.setText(expression);
                        haveDot = false;
                    }

                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.isEmpty())
                        continueExpression('*');

                    if (notTwoOperators(expression.charAt(expression.length() - 1))) {
                        expression += "*";
                        textViewLastExpression.setText(expression);
                        haveDot = false;
                    } else {
                        if (!(expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '+' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '/' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '*'
                        )) {
                            expression = expression.substring(0, expression.length() - 1);
                            expression += "*";
                            textViewLastExpression.setText(expression);
                        }

                    }
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.isEmpty())
                        continueExpression('/');
                    if (notTwoOperators(expression.charAt(expression.length() - 1))) {
                        expression += "/";
                        textViewLastExpression.setText(expression);
                        haveDot = false;
                    } else {
                        if (!(expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '+' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '/' ||
                                expression.charAt(expression.length() - 1) == '-' && expression.charAt(expression.length() - 2) == '*'
                        )) {
                            expression = expression.substring(0, expression.length() - 1);
                            expression += "/";
                            textViewLastExpression.setText(expression);
                        }
                    }
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonPorcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.isEmpty())
                        continueExpression('%');

                    if (notTwoOperators(expression.charAt(expression.length() - 1))) {
                        expression += "%";
                        textViewLastExpression.setText(expression);
                        haveDot = false;
                    }
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression.charAt(expression.length() - 1) == '.')
                        haveDot = false;

                    expression = expression.substring(0, expression.length() - 1);
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (expression == "") {
                        textViewResult.setText("0");
                    }
                    expression = "";
                    textViewLastExpression.setText(expression);
                    haveDot = false;
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (notTwoOperators(expression.charAt(expression.length() - 1)) && !haveDot) {
                        expression += '.';
                        textViewLastExpression.setText(expression);
                        haveDot = true;
                    }
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 0;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 1;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 2;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 3;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 4;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 5;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 6;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 7;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 8;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    expression += 9;
                    textViewLastExpression.setText(expression);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

    public boolean notTwoOperators(char lastChar) {
        if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == '*' || lastChar == '%' || lastChar == '.')
            return false;
        return true;
    }

    public void continueExpression(char operator) {
        expression += textViewResult.getText();
        expression += operator;
        textViewLastExpression.setText(expression);
        textViewResult.setText('0');
        haveDot = false;
    }
}
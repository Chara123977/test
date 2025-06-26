package Calculate;

import javax.swing.*;

public class Calculator {
    public static void GetText(JTextArea jta) {
        String text = jta.getText();
        Double result = 0.0;
        String regex0 = "(\\+)|(\\-)|(\\*)|(\\/)",
                regex1 = "[0-9]+|[0-9]+\\.[0-9]";
        String[] calculator = text.split(regex0),
                split = text.split(regex1);
        String str[] = new String[split.length];
        int j = 0;
        for(int i = 0; i < split.length; ++i) {
            if(split[i].equals("."));
            else
                str[j++] = split[i];
        }
        for (int i = 0; i < calculator.length; ++i) {
            if (i == 0) {
                result = Double.parseDouble(calculator[i]);
            }else {
                //判断进行什么操作
                if (str[i].equals("+"))
                    result += Double.parseDouble(calculator[i]);
                else if (str[i].equals("-"))
                    result -= Double.parseDouble(calculator[i]);
                else if (str[i].equals("*"))
                    result *= Double.parseDouble(calculator[i]);
                else if (str[i].equals("/"))
                    result /= Double.parseDouble(calculator[i]);
            }
        }
        if(result % 1 == 0)
            jta.setText(Integer.toString(result.intValue()));
        else
            jta.setText(Double.toString(result));
    }
}

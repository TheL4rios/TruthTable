package operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author larios
 */
public class Evaluator {
    
    private final DefaultTableModel model;
    private final String expression;
    private final ArrayList<ArrayList<String>> matrix;
    private final ArrayList<String> stack;
    private final ArrayList<Map<String, String>> values;
    private final ArrayList<String[]> valueStack;
    
    public Evaluator(DefaultTableModel model, String expression) {
        this.model = model;
        this.expression = expression;
        this.matrix = new ArrayList<>();
        this.stack = new ArrayList<>();
        this.values = new ArrayList<>();
        this.valueStack = new ArrayList<>();
    }
    
    public void resolve(){
        generateValues();
        loadTable();
        String newExpression = getNewExpression();
        if (newExpression != null) {
            String lexeme;
            // stack.clear();
            valueStack.clear();
            
            for (int i = 0; i < matrix.size(); i++) {
                StringTokenizer token = new StringTokenizer(newExpression, "^∨→↔¬()pqr", true);
                
                while(token.hasMoreElements()) {
                    lexeme = token.nextToken();

                    if (lexeme.equals("p") || lexeme.equals("q") || lexeme.equals("r")) {
                        // stack.add(lexeme);
                        valueStack.add(new String[] {lexeme, values.get(i).get(lexeme), "O"});
                    } else {
                        switch(lexeme) {
                            case "¬": operationNot(i); break;
                            case "^": operationAnd(i); break;
                            case "∨": operationOr(i); break;
                            case "↔": operationIfOnlyIf(i); break;
                            case "→": operationThen(i);
                        }
                    }
                }
            }
            
            refreshTable();
        }
    }
    
    private boolean getValueBoolean(String value) {
        return value.equals("1");
    }
    
    private String getValueNumber(boolean value) {
        if (value) return "1";
        return "0";
    }
    
    private void addColumn(String name, int index, String value) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(name)) {
                loadColumn(index, value, model.getColumnCount() - 1);
                return;
            }
        }
        
        model.addColumn(name);
        loadColumn(index, value);
    }
    
    private void loadColumn(int index, String value, int columnIndex) {
        if (matrix.get(index).size() - 1 >= columnIndex)
            matrix.get(index).set(columnIndex, value);
        else
            matrix.get(index).add(value);
    }
    
    private void loadColumn(int index, String value) {
        matrix.get(index).add(value);
    }
    
    private void refreshTable() {
        model.setRowCount(0);
        
        for(int i = 0; i < matrix.size(); i++) {
            model.addRow(matrix.get(i).toArray());
        }
    }
    
    private void operationNot(int index) {
        // String temp = stack.get(stack.size() - 1);
        
        if (valueStack.get(valueStack.size() - 1)[2].equals("O")) {
            String temp = valueStack.get(valueStack.size() - 1)[0];
            boolean value = getValueBoolean(values.get(index).get(temp));
            value = !value;
            // values.get(index).replace(temp, getValueNumber(!value), getValueNumber(value));
            valueStack.get(valueStack.size() - 1)[0] = "(¬" + temp + ")";
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(value);
            valueStack.get(valueStack.size() - 1)[2] = "M";

            addColumn("(¬" + temp + ")", index, getValueNumber(value));
            return;
        }
        
        String temp = valueStack.get(valueStack.size() - 1)[0];
        boolean value = getValueBoolean(valueStack.get(valueStack.size() - 1)[1]);
        value = !value;
        // values.get(index).replace(temp, getValueNumber(!value), getValueNumber(value));
        valueStack.get(valueStack.size() - 1)[0] = "(¬" + temp + ")";
        valueStack.get(valueStack.size() - 1)[1] = getValueNumber(value);
        valueStack.get(valueStack.size() - 1)[2] = "M";

        addColumn("(¬" + temp + ")", index, getValueNumber(value));
    }
    
    private void operationAnd(int index) {
        String temp;
        String temp2;
        
        if (valueStack.size() < 2) return;
        
        if (valueStack.get(valueStack.size() - 1)[2].equals("M")) {
            temp = valueStack.get(valueStack.size() - 1)[0];

            boolean result = getValueBoolean(valueStack.get(valueStack.size() - 1)[1]) && getValueBoolean(valueStack.get(valueStack.size() - 2)[1]);
            valueStack.remove(valueStack.size() - 1);
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

            addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "^" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        if (valueStack.get(valueStack.size() - 2)[2].equals("O")) {
            temp = valueStack.remove(valueStack.size() - 1)[0];
            temp2 = valueStack.get(valueStack.size() - 1)[0];
            
            boolean result = getValueBoolean(values.get(index).get(temp)) && getValueBoolean(values.get(index).get(temp2));
            valueStack.get(valueStack.size() - 1)[0] = "(" + temp2 + "^" + temp + ")";
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);
            valueStack.get(valueStack.size() - 1)[2] = "M";
            
            addColumn("(" + temp2 + "^" + temp + ")", index, getValueNumber(result));
            
            return;
        } 
        
        temp = valueStack.remove(valueStack.size() - 1)[0];

        boolean result = getValueBoolean(values.get(index).get(temp)) && getValueBoolean(valueStack.get(valueStack.size() - 1)[1]);
        valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

        addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "^" + temp + ")", index, getValueNumber(result));
    }
    
    private void operationOr(int index) {
        String temp;
        String temp2;
        
        if (valueStack.size() < 2) return;
        
        if (valueStack.get(valueStack.size() - 1)[2].equals("M")) {
            temp = valueStack.get(valueStack.size() - 1)[0];

            boolean result = getValueBoolean(valueStack.get(valueStack.size() - 1)[1]) || getValueBoolean(valueStack.get(valueStack.size() - 2)[1]);
            valueStack.remove(valueStack.size() - 1);
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

            addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "∨" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        if (valueStack.get(valueStack.size() - 2)[2].equals("O")) {
            temp = valueStack.remove(valueStack.size() - 1)[0];
            temp2 = valueStack.get(valueStack.size() - 1)[0];
            
            boolean result = getValueBoolean(values.get(index).get(temp)) || getValueBoolean(values.get(index).get(temp2));
            valueStack.get(valueStack.size() - 1)[0] = "(" + temp2 + "∨" + temp + ")";
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);
            valueStack.get(valueStack.size() - 1)[2] = "M";
            
            addColumn("(" + temp2 + "∨" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        temp = valueStack.remove(valueStack.size() - 1)[0];

        boolean result = getValueBoolean(values.get(index).get(temp)) || getValueBoolean(valueStack.get(valueStack.size() - 1)[1]);
        valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

        addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "∨" + temp + ")", index, getValueNumber(result));
    }
    
    private void operationIfOnlyIf(int index) {
        String temp;
        String temp2;
        
        if (valueStack.size() < 2) return;
        
        if (valueStack.get(valueStack.size() - 1)[2].equals("M")) {
            temp = valueStack.get(valueStack.size() - 1)[0];

            boolean result = getValueBoolean(valueStack.get(valueStack.size() - 1)[1]) == getValueBoolean(valueStack.get(valueStack.size() - 2)[1]);
            valueStack.remove(valueStack.size() - 1);
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

            addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "↔" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        if (valueStack.get(valueStack.size() - 2)[2].equals("O")) {
            temp = valueStack.remove(valueStack.size() - 1)[0];
            temp2 = valueStack.get(valueStack.size() - 1)[0];
            
            boolean result = getValueBoolean(values.get(index).get(temp)) == getValueBoolean(values.get(index).get(temp2));
            valueStack.get(valueStack.size() - 1)[0] = "(" + temp2 + "↔" + temp + ")";
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);
            valueStack.get(valueStack.size() - 1)[2] = "M";
            
            addColumn("(" + temp2 + "↔" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        temp = valueStack.remove(valueStack.size() - 1)[0];

        boolean result = getValueBoolean(values.get(index).get(temp)) == getValueBoolean(valueStack.get(valueStack.size() - 1)[1]);
        valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

        addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "↔" + temp + ")", index, getValueNumber(result));
    }
    
    private void operationThen(int index) {
        String temp;
        String temp2;
        
        if (valueStack.size() < 2) return;
        
        if (valueStack.get(valueStack.size() - 1)[2].equals("M")) {
            temp = valueStack.get(valueStack.size() - 1)[0];

            boolean result = !((getValueBoolean(valueStack.get(valueStack.size() - 1)[1]) == false) && (getValueBoolean(valueStack.get(valueStack.size() - 2)[1]) == true));
            valueStack.remove(valueStack.size() - 1);
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

            addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "→" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        if (valueStack.get(valueStack.size() - 2)[2].equals("O")) {
            temp = valueStack.remove(valueStack.size() - 1)[0];
            temp2 = valueStack.get(valueStack.size() - 1)[0];
            
            boolean result = !((getValueBoolean(values.get(index).get(temp)) == false) && (getValueBoolean(values.get(index).get(temp2)) == true));
            valueStack.get(valueStack.size() - 1)[0] = "(" + temp2 + "→" + temp + ")";
            valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);
            valueStack.get(valueStack.size() - 1)[2] = "M";
            
            addColumn("(" + temp2 + "→" + temp + ")", index, getValueNumber(result));
            
            return;
        }
        
        temp = valueStack.remove(valueStack.size() - 1)[0];

        boolean result = !((getValueBoolean(valueStack.get(valueStack.size() - 1)[1]) == false) && (getValueBoolean(valueStack.get(valueStack.size() - 2)[1]) == true));
        valueStack.get(valueStack.size() - 1)[1] = getValueNumber(result);

        addColumn("(" + valueStack.get(valueStack.size() - 1)[0] + "→" + temp + ")", index, getValueNumber(result));
    }
    
    private void generateValues() {
        int totalColumns = getVariables().length();
        int total = (int) Math.pow(2, totalColumns);
        values.clear();
        
        for (int i = 0; i < total; i++) {
            String number = Long.toBinaryString(i);
            convertToFormat(number, totalColumns);
        }
    }
    
    private void convertToFormat(String number, int total) {
        ArrayList<String> binary = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String variables = getVariables();
        
        switch(total) {
            case 1:
                binary.add(number.charAt(0) + "");
                map.put(variables, number.charAt(0) + "");
                break;
            case 2:
                if (number.length() == 1) {
                    binary.add("0");
                    binary.add(number.charAt(0) + "");
                    
                    map.put(variables.charAt(0) + "", "0");
                    map.put(variables.charAt(1) + "", number.charAt(0) + "");
                } else {
                    binary.add(number.charAt(0) + "");
                    binary.add(number.charAt(1) + "");
                    
                    map.put(variables.charAt(0) + "", number.charAt(0) + "");
                    map.put(variables.charAt(1) + "", number.charAt(1) + "");
                }
                break;
            default:
                switch (number.length()) {
                    case 1:
                        binary.add("0");
                        binary.add("0");
                        binary.add(number.charAt(0) + "");
                        
                        map.put(variables.charAt(0) + "", "0");
                        map.put(variables.charAt(1) + "", "0");
                        map.put(variables.charAt(2) + "", number.charAt(0) + "");
                        break;
                    case 2:
                        binary.add("0");
                        binary.add(number.charAt(0) + "");
                        binary.add(number.charAt(1) + "");
                        
                        map.put(variables.charAt(0) + "", "0");
                        map.put(variables.charAt(1) + "", number.charAt(0) + "");
                        map.put(variables.charAt(2) + "", number.charAt(1) + "");
                        break;
                    default:
                        binary.add(number.charAt(0) + "");
                        binary.add(number.charAt(1) + "");
                        binary.add(number.charAt(2) + "");
                        
                        map.put(variables.charAt(0) + "", number.charAt(0) + "");
                        map.put(variables.charAt(1) + "", number.charAt(1) + "");
                        map.put(variables.charAt(2) + "", number.charAt(2) + "");
                        break;
                }

        }
        values.add(map);
        matrix.add(binary); 
    }
    
    private void loadTable() {
        String letters = getVariables();
        Object[] letterArray = new Object[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            letterArray[i] = letters.charAt(i);
        }
        
        model.setColumnIdentifiers(letterArray);
        
        for (int i = 0; i < matrix.size(); i++) {
            model.addRow(matrix.get(i).toArray());
        }
    }
    
    private String getVariables() {
        String letters = "";
        String p = "", q = "", r = "";
        
        for(int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case 'p':
                    p = "p";
                    break;
                case 'q':
                    q = "q";;
                    break;
                case 'r':
                    r = "r";
                    break;
                default:
                    break;
            }
        }
        
        return p + q + r;
    }
    
    private String getNewExpression() {
        String newExpression = "";
        StringTokenizer token = new StringTokenizer(expression, "^∨→↔¬()pqr", true);
        String lexeme;
        String last;
        boolean letter = false;
        boolean parenthesisO = false;
        
        while(token.hasMoreElements()) {
            lexeme = token.nextToken();
            // System.out.println(lexeme);
            
            if (lexeme.equals("(")) {
                parenthesisO = true;
                stack.add(lexeme);
                letter = false;
            } else if (lexeme.equals("p") || lexeme.equals("q") || lexeme.equals("r")) {
                if (letter) {
                    JOptionPane.showMessageDialog(null, "Sintaxis incorrecta");
                    return null;
                }
                
                newExpression += lexeme;
                letter = true;
            } else if (lexeme.equals(")")) {
                letter = false;
                if (parenthesisO) {
                    last = stack.remove(stack.size() - 1);
                    while(!last.equals("(")) {
                        newExpression += last;
                        last = stack.remove(stack.size() - 1);
                    }
                    parenthesisO = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Sintaxis incorrecta");
                    return null;
                }
            } else {
                letter = false;
                if (!stack.isEmpty()) {
                    if (getPrecedence(lexeme) > getPrecedence(stack.get(stack.size() - 1))) {
                        stack.add(lexeme);
                    } else {
                        last = stack.remove(stack.size() - 1);
                        
                        if(stack.isEmpty() && !last.equals("(")) {
                            newExpression += last;
                        } else {
                            while(!last.equals("(") && !stack.isEmpty()) {
                                newExpression += stack.remove(stack.size() - 1);
                            }
                        }

                        stack.add(lexeme);
                    }
                } else {
                    stack.add(lexeme);
                }
            } 
        }
        
        if (!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                last = stack.remove(stack.size() - 1);
                
                if (!last.equals("(")) 
                    newExpression += last;
                else {
                    JOptionPane.showMessageDialog(null, "Sintaxis incorrecta");
                    return null;
                }   
            }
        }
        
        System.out.println(newExpression);
        return newExpression;
    }
    
    private int getPrecedence(String operator) {
        switch(operator) {
            case "¬": return 5;
            case "^": return 4;
            case "∨": return 3;
            case "→": return 2;
            case "↔": return 1;
            default: return 0;
        }
    }
}


class ProcessingExpression {

    private String input;
    private boolean flag;

    public ProcessingExpression(String input) {
        this.input = input;
    }

    public String[] splitInput() {
        return input.split(" ");
    }

    // Метод преобразования римского числа в арабское
    public int converterRomanToArabic(String romanNumber) {
        if (romanNumber.equals("I")) {
            return 1;
        } else if (romanNumber.equals("II")) {
            return 2;
        } else if (romanNumber.equals("III")) {
            return 3;
        } else if (romanNumber.equals("IV")) {
            return 4;
        } else if (romanNumber.equals("V")) {
            return 5;
        } else if (romanNumber.equals("VI")) {
            return 6;
        } else if (romanNumber.equals("VII")) {
            return 7;
        } else if (romanNumber.equals("VIII")) {
            return 8;
        } else if (romanNumber.equals("IX")) {
            return 9;
        } else if (romanNumber.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }

    // Метод преобразования арабского числа в римское
    public String converterArabicToRoman(int arabicNumber) {
        String[] romanNumberMain = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        if (arabicNumber < 1) {    // Исключение, если римское число получилось меньше 1
            throw new NullPointerException("throws Exception");
        } else if (arabicNumber < 11) {
            return romanNumberMain[arabicNumber];
        } else if (arabicNumber < 21) {
            return "X" + romanNumberMain[arabicNumber - 10];
        } else if (arabicNumber < 31) {
            return "XX" + romanNumberMain[arabicNumber - 20];
        } else if (arabicNumber < 40) {
            return "XXX" + romanNumberMain[arabicNumber - 30];
        } else if (arabicNumber < 50) {
            return "XL" + romanNumberMain[arabicNumber - 40];
        } else if (arabicNumber < 61) {
            return "L" + romanNumberMain[arabicNumber - 50];
        } else if (arabicNumber < 71) {
            return "LX" + romanNumberMain[arabicNumber - 60];
        } else if (arabicNumber < 81) {
            return "LXX" + romanNumberMain[arabicNumber - 70];
        } else if (arabicNumber < 90) {
            return "LXXX" + romanNumberMain[arabicNumber - 80];
        } else if (arabicNumber < 100) {
            return "XC" + romanNumberMain[arabicNumber - 90];
        } else if (arabicNumber < 111) {
            return "C" + romanNumberMain[arabicNumber - 100];
        }
        return null;
    }

    // Метод определения правильности записи числа операнда и вывод его значения
    public int determiningNumber(String number) {
        if (converterRomanToArabic(number) == -1) {      // Исключение - либо арабское число, либо римское выходит за диаппазон допустимых (до 10)
            try {  // Исключения если выходит за диапазон входных значений (до 10)
                Integer.parseInt(number);  // Исключение, если римское число больше 10
            } catch (Exception e) {
                throw new NullPointerException("throws Exception");
            }
            flag = false;                         // Флажок - арабское число
            int num = Integer.parseInt(number);
            if ((num <= 10) && (num >= 1)) {
                return num;
            } else {
                throw new NullPointerException("throws Exception");
            }

        } else {
            flag = true;     // Флажок - римское число
            return converterRomanToArabic(number);
        }
    }

    // Метод выделения операндов, проверка на правильность записи выражения и вычисление выражения
    public String Calculate() {
        if (splitInput().length != 3) {   // Исключение, если кол-во операндов не 2
            throw new NullPointerException("throws Exception");
        }
        int operand1 = determiningNumber(splitInput()[0]);
        boolean flag1 = flag;
        int operand2 = determiningNumber(splitInput()[2]);
        boolean flag2 = flag;
        if (flag1 != flag2) {                // Исключение, если один операнд написан римским числом, а другой - арабским
            throw new NullPointerException("throws Exception");
        } else {
            int result = 0;
            String operator = splitInput()[1];
            if (operator.equals("+")) {
                result = operand1 + operand2;
            } else if (operator.equals("-")) {
                result = operand1 - operand2;
            } else if (operator.equals("*")) {
                result = operand1 * operand2;
            } else if (operator.equals("/")) {
                result = operand1 / operand2;
            }

            if (flag1) {    // Если вычисление римских чисел, то значение преобразовываем в римское число
                return converterArabicToRoman(result);
            } else {
                return Integer.toString(result);
            }
        }
    }

}

package itproger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример в формате: ");
        System.out.println("цифровое значение знак цифровое значение (пример: 4/2)");
        System.out.print("Ввод: ");
        String input = scanner.nextLine();
        String sum = calc(input);
        System.out.println(sum);


    }

    public static String calc(String input) throws Exception {
        String[] roman_numerals = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
        "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
        "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
        "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
        "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
        "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
        "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
        "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int sum = 0;
        String[] str = input.split("[\\+\\-\\/\\*]");
        if((str[0].contains("0") || str[0].contains("1") || str[0].contains("2") || str[0].contains("3") ||
        str[0].contains("4") || str[0].contains("5") || str[0].contains("6") || str[0].contains("7") ||
        str[0].contains("8") || str[0].contains("9")) && (str[1].contains("0") || str[1].contains("1") || str[1].contains("2") || str[1].contains("3") || str[1].contains("4") || str[1].contains("5") || str[1].contains("6") || str[1].contains("7") ||
        str[1].contains("8") || str[1].contains("9"))) {
            if(Integer.parseInt(str[0]) > 10 || Integer.parseInt(str[1])>10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }
            if(input.contains("+")) {
                int num1 = Integer.parseInt(str[0]);
                int num2 = Integer.parseInt(str[1]);
                sum = num1 + num2;
                return Integer.toString(sum);
            } else if(input.contains("-")) {
                int num1 = Integer.parseInt(str[0]);
                int num2 = Integer.parseInt(str[1]);
                sum = num1 - num2;
                return Integer.toString(sum);
            } else if(input.contains("*")) {
                int num1 = Integer.parseInt(str[0]);
                int num2 = Integer.parseInt(str[1]);
                sum = num1 * num2;
                return Integer.toString(sum);
            } else if(input.contains("/")) {
                int num1 = Integer.parseInt(str[0]);
                int num2 = Integer.parseInt(str[1]);
                if (num2 == 0){
                    throw new Exception("На ноль делить нельзя");
                } else {
                    sum = num1 / num2;
                    return Integer.toString(sum);
                }
            } else {
                throw new Exception("Вы ввели некоректное значение");
            }
        } else if(toReam(str)) {
            String[] str2 = new  String[2];
            str2[0] = str[0];
            str2[1] = str[1];
            int[] num = rim(str2);
            int num1 = num[0];
            int num2 = num[1];
            if(num1 > 10 || num2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }
            if(input.contains("+")) {
                sum = num1 + num2;
                return roman_numerals[sum];
            } else if(input.contains("-")) {
                sum = num1 - num2;
                return roman_numerals[sum];
            } else if(input.contains("*")) {
                sum = num1 * num2;
                return roman_numerals[sum];
            } else if(input.contains("/")) {
                if (num2 == 0){
                    throw new Exception("На ноль делить нельзя");
                } else {
                    sum = num1 / num2;
                    return roman_numerals[sum];
                }
            } else {
                throw new Exception("Вы ввели некоректное значение");
            }

        } else {
            throw new Exception("Вы ввели некоректное значение");
        }
    }


    public static int[] rim(String[] str) {
        int[] value = new int[2];
        HashMap<String, Integer> cpo = new HashMap<>();
        cpo.put("I", 1);
        cpo.put("II", 2);
        cpo.put("III", 3);
        cpo.put("IV", 4);
        cpo.put("V", 5);
        cpo.put("VI", 6);
        cpo.put("VII", 7);
        cpo.put("VIII", 8);
        cpo.put("IX", 9);
        cpo.put("X", 10);

        for(int i = 0; i < str.length; i++) {
            String num1 = str[i];
            int kj = cpo.get(num1);
            value[i] = kj;

        }
        return value;

    }

    public static boolean toReam(String[] str) throws Exception {

        String[] roman_numerals = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean bool =  Arrays.asList(roman_numerals).contains(str[0]);
        if(Arrays.asList(roman_numerals).contains(str[0]) && Arrays.asList(roman_numerals).contains(str[1])) {
            return true;
        } else {
            throw new Exception("Вы ввели недопустимое значение");
        }

    }

}






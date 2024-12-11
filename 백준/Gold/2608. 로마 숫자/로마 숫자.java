import java.util.*;

public class Main{
    // 로마 숫자 -> 아라비아 숫자 변환을 위한 맵
    private static final Map<Character, Integer> romanToArabic = new HashMap<>();
    static {
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        String roman1 = sc.nextLine();
        String roman2 = sc.nextLine();

        // 로마 숫자를 아라비아 숫자로 변환
        int num1 = romanToArabic(roman1);
        int num2 = romanToArabic(roman2);

        // 두 수의 합 계산
        int sum = num1 + num2;

        // 합을 다시 로마 숫자로 변환
        String romanSum = arabicToRoman(sum);

        // 결과 출력
        System.out.println(sum);
        System.out.println(romanSum);

        sc.close();
    }

    // 로마 숫자를 아라비아 숫자로 변환하는 함수
    private static int romanToArabic(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanToArabic.get(roman.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }

    // 아라비아 숫자를 로마 숫자로 변환하는 함수
    private static String arabicToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        // 값과 로마 숫자의 매핑
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}

/*
    TODO:
     1. Запустите код проекта IntegerExperiments. Найдите ошибку, исправьте её заменой Integer на int.
     2. Реализуйте статический метод sumDigits, чтобы он считал сумму цифр в числе и возвращал сумму в результате своей работы.
     3.	Изучите методы класса Character, найдите метод получения int из char.
     4.	Напишите метод sumDigitsChar() в котором используйте метод класса Character.

*/

public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(container.count));
        System.out.println(sumDigitsChar(container.count));

    }

    public static Integer sumDigits(Integer number)
    {
        int sum = 0;
        String str = number.toString();
        for (int idx = 0; idx < str.length() ; idx++){
            sum += Integer.parseInt(String.valueOf(str.charAt(idx)));
        }

        return sum;
    }

    public static Integer sumDigitsChar(Integer number)
    {
        int sum = 0;
        for (int idx=0; idx < number.toString().length() ;idx++){
            sum += Character.getNumericValue(number.toString().charAt(idx));
        }

        return sum;
    }
}

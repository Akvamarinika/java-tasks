/*
    TODO:
     1. Запустите код проекта IntegerExperiments. Найдите ошибку, исправьте её заменой Integer на int.
     2. Реализуйте статический метод sumDigits, чтобы он считал сумму цифр в числе и возвращал сумму в результате своей работы.
*/

public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(container.count));

    }

    public static Integer sumDigits(Integer number)
    {
        int sum = 0;
        String str = number.toString();
        for (int idx = 0; str.length() > idx; idx++){
            sum += Integer.parseInt(String.valueOf(str.charAt(idx)));
        }

        return sum;
    }
}

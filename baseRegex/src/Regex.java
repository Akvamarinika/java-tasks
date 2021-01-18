import java.util.Scanner;
/*TODO:
   Внесите изменения в проект StringExperiments, чтобы суммы заработка каждого человека извлекались из текста регулярным выражением,
   а в конце программы рассчитывалась и распечатывалась общая сумма заработка людей.
 */
public class Regex {
    public static void main(String[] args){
            String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
            System.out.println(text);
            System.out.println("Всего заработали: " + earnings(text));




        }

        public static int earnings(String str){
            int sum = 0;
            str = str.replaceAll("[^0-9]+", " ").trim();
            String[] nums = str.split("\\s+");
            for (String num : nums){
                sum += Integer.parseInt(num);
            }
            return sum;
        }







}

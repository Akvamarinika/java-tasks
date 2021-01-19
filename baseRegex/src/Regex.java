import java.util.Scanner;
/*TODO:
    Измените программу, написанную в уроке №4.5: вводимая строка с фамилией, именем и отчеством должна разбиваться
    с использованием регулярного выражения.
 */
public class Regex {
    public static void main(String[] args){
            String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
            System.out.println(text);
            System.out.println("Всего заработали: " + earnings(text));
            splitText();

            System.out.println("\nВведите ФИО: ");
            String input = new Scanner(System.in).nextLine();
            printFullName(input);




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

        public  static void printFullName(String str){
            str = str.trim().replaceAll("[^A-Za-zА-Яа-яЁё\\s]+", "");
            System.out.println(str);
            String[] arrStr = str.split("\\s+");
            String firstName = "";
            String surname = "";
            String patronymic = "";
            if (arrStr.length >= 2) {
                if (arrStr.length == 2) {
                    firstName = arrStr[0];
                    surname = arrStr[1];
                } else {
                    firstName = arrStr[0];
                    surname = arrStr[1];
                    patronymic = arrStr[2];
                }
            }else {
                System.out.println("Error: Некорректный ввод ФИО");
            }

            if (!firstName.isEmpty() && !surname.isEmpty()){
                System.out.println("Фамилия: " + firstName);
                System.out.println("Имя: " + surname);
            }

            if (!patronymic.isEmpty()){
                System.out.println("Отчество: " + patronymic);
            }

        }

        public static void splitText(){
            String txt = "Following the violence, reports emerged online of some Bumble users switching the filter to find those who had taken part - and report them to authorities.\n" +
                    "\n" +
                    "Bumble said it had noticed people using the filter in a way that was \"contrary to our terms and conditions\".\n" +
                    "\n" +
                    "But it faced a backlash online from users unhappy with its decision.\n" +
                    "\n" +
                    "The feature enables people to display their chosen political views - such as conservative or liberal - and filter their matches accordingly.\n" +
                    "\n" +
                    "Some app users claimed on social media that they had deliberately changed their political preferences in order to attract rioters and then report them.\n" +
                    "\n" +
                    "Some accused the company of \"protecting\" those who had carried out violent acts by disabling the filter.\n" +
                    "\n" +
                    "Others said they needed the filter to make sure their matches shared their political outlook - and many tweeted to the company to say they were cancelling their accounts as a result.\n" +
                    "\n" +
                    "\n" +
                    "The BBC is not responsible for the content of external sites.\n" +
                    "View original tweet on Twitter\n" +
                    "Bumble said it had restored the function within 24 hours of suspending it.\n" +
                    "\n" +
                    "In a statement it also said it was blocking people who had been using the platform to \"spread insurrectionist content\".\n" +
                    "\n" +
                    "Match Group, whose brands include Tinder, Hinge, OKCupid and Plenty of Fish, told the Washington Post it had banned \"any users wanted by the FBI in connection with domestic terrorism\" from all of its platforms.\n" +
                    "\n" +
                    "Related Topics\n" +
                    "Dating apps\n" +
                    "More on this story\n" +
                    "Capitol riots: Who has the FBI arrested so far?\n" +
                    "\n" +
                    "Published2 hours ago\n" +
                    "Top Stories\n" +
                    "Putin critic Alexei Navalny to be kept in custody\n" +
                    "\n" +
                    "It follows his dramatic return to Russia, five months after a nerve agent attack almost killed him.\n" +
                    "\n" +
                    "Published56 minutes ago\n" +
                    "Capitol security scare ahead of Biden inauguration\n" +
                    "\n" +
                    "Published1 hour ago\n" +
                    "The policeman in a MAGA hat. What’s the real story? VideoThe policeman in a MAGA hat. What’s the real story?\n" +
                    "\n" +
                    "Published16 hours ago\n" +
                    "Features\n" +
                    "One in, one out: How the White House changes hands\n" +
                    "\n" +
                    "A composition image of Joe Biden and Donald Trump\n" +
                    "How ordinary women became SS torturers\n" +
                    "\n";
            String[] arrayWords = txt.split("\\s+\\-\\s+|\\s+\"|\"?[.:,\"?]?\\s+");
            for (String word : arrayWords){
                System.out.println(word);
            }
        }





}

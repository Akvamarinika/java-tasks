import java.util.Scanner;
/*TODO:
    Изменить метод String searchAndReplaceDiamonds(String text, String placeholder),
    который будет заменять в переданной строке String text всё содержимое скобок <> и сами скобки
    на переданную строку в String placeholder, используя регулярные выражения.

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

            System.out.println(checkMobileNumber("+7 909 123-45-67"));
            System.out.println(checkMobileNumber("+7 (909) 1234567"));
            System.out.println(checkMobileNumber("8 (950) 123-45-67"));
            System.out.println(checkMobileNumber("8-905-1234567"));
            System.out.println(checkMobileNumber("9-453-1234567"));
            System.out.println(checkMobileNumber("8-905-123"));
            System.out.println(checkMobileNumber("905-45623-11"));
            System.out.println(checkMobileNumber("905-1234567"));
            System.out.println(checkMobileNumber("8-905-12345672342"));

            String txt = "Номер кредитной карты <4008 1234 5678> 8912, номер кредитной карты <1548 1258 1452> 4580";
            System.out.println(searchAndReplaceDiamonds(txt, "***"));





        }

    public static String searchAndReplaceDiamonds(String text, String placeholder){
        text = text.replaceAll("<[0-9 \\s]+>", placeholder);
        return text;

    }

    public  static  String checkMobileNumber(String number){
        number = number.replaceAll("[^\\+0-9]+", "" );
        //System.out.println(number);
        if (number.matches("(\\+7|8?)(\\d{10})")){
            number = number.replaceAll("^8|\\+7", "+7 ");
            number = number.replaceAll("^9", "+7 9");
            StringBuilder num = new StringBuilder(number);
            num.insert(6," ").insert(10,"-").insert(13, "-");
            return num.toString();
        }else {
            return "Неверный формат номера!";
        }

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

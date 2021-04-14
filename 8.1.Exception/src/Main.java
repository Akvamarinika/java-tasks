import java.util.Scanner;
/*TODO: Программа должна выбрасывать исключения (Exception) при неверном формате
    •	команды (количество элементов в команде),
    •	номера телефона,
    •	email.
*/

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if(tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                }
                else if(tokens[0].equals("list")) {
                    executor.listCustomers();
                }
                else if(tokens[0].equals("remove"))
                {
                    executor.removeCustomer(tokens[1]);
                }
                else if(tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                }
                else if(tokens[0].equals("help")) {
                    System.out.println(helpText);
                }
                else {
                    System.out.println(commandError);
                }
            } catch (IllegalArgumentException e) {
                e.getMessage();
            } catch (IndexOutOfBoundsException e){
                System.out.println("Wrong count args!;");
            }catch (WrongEmailException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getEmail());
            } catch (WrongPhoneNumberException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getPhone());
            }catch (NotFoundUserException e){
                System.out.println(e.getMessage() + " " + e.getUser());
            }
        }
    }
}

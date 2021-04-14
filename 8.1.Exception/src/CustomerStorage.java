import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {

            String[] components = data.split("\\s+");
            if(components.length != 4){
                throw new IndexOutOfBoundsException("Wrong command! Available command examples: \n"  +
                        "add Василий Петров " +
                        "vasily.petrov@gmail.com +79215637722");
            }

            if(!components[2].matches("^\\w+\\.?\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}$")){
                throw new WrongEmailException(components[2], "Wrong e-mail! Available command examples: \n"  +
                        "add Василий Петров " +
                        "vasily.petrov@gmail.com +79215637722");
            }

            if(!components[3].matches("^\\+7\\d{10}$")){
                throw new WrongPhoneNumberException(components[3], "Wrong phone number! Available command examples: \n"  +
                        "add Василий Петров " +
                        "vasily.petrov@gmail.com +79215637722");
            }
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));

    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)){
            throw new NotFoundUserException(name, "User not found!");
        }

        storage.remove(name);

    }

    public int getCount()
    {
        return storage.size();
    }
}

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String emailRegex = "\\D+@\\D+\\.\\D+";
        String phoneNumberRegex = "8\\d{10}||\\+7\\d{10}";
        String[] components = data.split("\\s+");
        if (components.length > 4) {
            throw new AddCustomerException();
        }
        if (!components[INDEX_EMAIL].matches(emailRegex)) {
            throw new EmailFormatException();
        }
        if (!components[INDEX_PHONE].matches(phoneNumberRegex)) {
            throw new PhoneNumberException();
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    static class AddCustomerException extends RuntimeException {
        public AddCustomerException(){
            System.out.println("Неверный формат добавления");
        }
    }

    static class PhoneNumberException extends RuntimeException {
        public PhoneNumberException(){
            System.out.println("Неверный формат телефона");
        }
    }
    static class EmailFormatException extends RuntimeException {
        public EmailFormatException() {
            System.out.println("Неверный формат email");
        }
    }
}
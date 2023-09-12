import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Store {
    private String name;
    private String address;
    private List<String> phones;
    private String specialization;
    private String workingHours;

    public Store(String name, String address, String specialization, String workingHours) {
        this.name = name;
        this.address = address;
        this.specialization = specialization;
        this.workingHours = workingHours;
        this.phones = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }

    @Override
    public String toString() {
        return "Store(" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phones=" + phones +
                ", specialization='" + specialization + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ')';
    }
}

class StoreDirectory<T> {
    private List<T> stores;

    public StoreDirectory() {
        stores = new ArrayList<>();
    }

    public void addStore(T store) {
        stores.add(store);
    }

    public void removeStore(T store) {
        stores.remove(store);
    }

    public List<T> getStores() {
        return stores;
    }

    public void displayStores() {
        for (T store : stores) {
            System.out.println(store.toString());
        }
    }

    public void sortByName() {
        Collections.sort(stores, Comparator.comparing(store -> ((Store) store).getName()));
    }

    public void sortByAddress() {
        Collections.sort(stores, Comparator.comparing(store -> ((Store) store).getAddress()));
    }

    public void sortBySpecialization() {
        Collections.sort(stores, Comparator.comparing(store -> ((Store) store).getSpecialization()));
    }
}

public class Main {
    public static void main(String[] args) {
        StoreDirectory<Store> storeDirectory = new StoreDirectory<>();

        Store store1 = new Store("Store A", "Address A", "Grocery", "Mon-Fri: 9:00-17:00:");
        store1.addPhone("380456785890");
        store1.addPhone("380654553210");

        Store store2 = new Store("Store B", "Address B", "Electronics", "Mon-Fri: 10:00-18:00");
        store2.addPhone("380111222335");


        Store store3 = new Store("Store C", "Address C", "Books", "Mon-Sun: 8:00-20:00");
        store3.addPhone("380581222335");
        store3.addPhone("380225645337");


        storeDirectory.addStore(store1);
        storeDirectory.addStore(store2);
        storeDirectory.addStore(store3);


        System.out.println("All Stores:");
        storeDirectory.displayStores();


        storeDirectory.sortByName();
        System.out.println("\nStores sorted by name:");
        storeDirectory.displayStores();


        storeDirectory.sortByAddress();
        System.out.println("\nStores sorted by address:");
        storeDirectory.displayStores();


        storeDirectory.sortBySpecialization();
        System.out.println("\nStores sorted by specialization:");
        storeDirectory.displayStores();
    }
}


public class SampleCode {
    /**
    * @param args
    */
    public static void main(String[] args) {
                    reader();
    }

    public static void reader() {
                    ArrayList<Person> people = new ArrayList<>();
                    try {
                                    Scanner scanner = new Scanner(new File("username.txt"));

                                    String line = scanner.nextLine();
                                    while (scanner.hasNext()) {
                                                    line = scanner.nextLine();
                                                    String[] parts = line.split(";");
                                                    String userName = parts[0];
                                                    long id = Long.parseLong(parts[1]);
                                                    if (id < 0) {
                                                                    id = 0;
                                                    }
                                                    String fname = parts[2];
                                                    if (parts[2].equalsIgnoreCase("N/A")) {
                                                                    fname = "none";
                                                    }
                                                    String lname = parts[3];
                                                    people.add(new Person(userName, id, fname, lname));
                                                    System.out.format("%s  %d  %s  %s\n", userName, id, fname, lname);
                                    }
                    } catch (FileNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }

                    System.out.println("Total amount of people read: " + people.size());

    }

}

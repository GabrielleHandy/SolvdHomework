import java.util.ArrayList;


class Genre{
    private String name;

    public Genre(String name){
        this.name = name;
    }
}

class Book{
    String name;
    String author;
    int copies;
    Genre genre;

    public Book(String name, String author, int copies, Genre genre){
        this.name = name;
        this.author = author;
        this.copies = copies;
        this.genre = genre;

    }

    public void getName(){
        System.out.println(this.name);
    }
    public void getAuthor(){
        System.out.println(this.author);
    }

    public void getCopies(){
        System.out.println(this.copies + " Available");
    }

    public void addCopy(){
        this.copies++;
    }

    public void removeCopy(){
        this.copies--;
    }

    public void info(){
        System.out.println(this.name + " " + "by " + this.author);
    }


}

class Floor{
    private int number;
    private Genre genre;

    public Floor(int number, Genre genre){
        this.number = number;
        this.genre = genre;
        
        
    }

    

}

class Event{
    private String name;
    private String summary;
    private String day;
    
    public Event(String name, String summary, String day){
        this.name = name;
        this.summary = summary;
        this.day = day;
    }

    public void info(){
        this.getName();
        this.getSummary();
        this.getDay();
        System.out.println();
    }

    public void getSummary(){
        System.out.println(this.summary);
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public void getDay(){
        System.out.println("On " + this.day +"s!");
    }

    public void setDay(String day){
        this.day = day;
    }

    public void getName(){
        System.out.println(this.name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String name(){
        return this.name;
    }

}

class Staff{
    private String first;
    private String last;
    private String job;
    private int id;

    public Staff(String first, String last, String job, int id){
        this.first = first;
        this.last = last;
        this.job = job;
        this.id = id;
    }

    public int id(){
        return this.id;
    }

    public void getName(){
        System.out.println("Name: " + this.first + " " + this.last);
    }

    public void setFirst(String first){
        this.first = first;
    }

    public void setLast(String last){
        this.last = last;
    }

    public void getJob(){
        System.out.println("Job position: " + this.job);
    }

    public void setJob(String job){
        this.job = job;
    }

    public void info(){
        this.getName();
        this.getJob();
        System.out.println();
    }
    

    public void lookupPatron(Patron patron){
        patron.info();
    }
}

class Donor{
    private String first;
    private String last;
    private int donated;

    public Donor(String first, String last, int donation){
        this.first = first;
        this.last = last;
        this.donated = donation;
    }

    public void getName(){
        System.out.println("Name: " + this.first + " " + this.last);
    }

    public void setFirst(String first){
        this.first = first;
    }

    public void setLast(String last){
        this.last = last;
    }

    public void getDonated(){
        System.out.println("Total Donated: " + this.donated);
    }

    public void addDonation(int amount){
        this.donated += amount;
        System.out.println("Donation accepted");
        this.getDonated();
    }


    public void info(){
        this.getName();
        this.getDonated();
        System.out.println();
    }
}

class Patron{
    private String first;
    private String last;
    private int cardNum;
    private ArrayList<Book>  books = new ArrayList<>();

    public Patron(String first, String last, int cardNum){
        this.first = first;
        this.last = last;
        this.cardNum = cardNum;
    }

    public void getName(){
        System.out.println("Name: " + this.first + " " + this.last);
    }

    public void setFirst(String first){
        this.first = first;
    }

    public void setLast(String last){
        this.last = last;
    }

    public void getCardNum(){
        System.out.println("Card Number: " + this.cardNum);

    }

    public void setCardNum (int cardNum){
        this.cardNum = cardNum;
    }
    
    public void getBooks(){
        System.out.println("Total checked out: " + this.books.size());
        System.out.println();

        for (int i = 0; i < this.books.size(); i++){
            System.out.print((i + 1) + ". ");
            books.get(i).info();

            System.out.println();
            
        }
    }

    public void checkIn(Book book){
        for (int i = 0; i < this.books.size(); i++){
            if (this.books.get(i).name == book.name){
                this.books.remove(i);

                book.addCopy();

                System.out.println("Book sucessfully checked in!");
            }
        }
    }

    public void checkOut(Book book){
        if (book.copies > 0){
            this.books.add(book);
            book.removeCopy();

            System.out.println("Book sucessfully checked out!");
        }
        else{
            System.out.println("Sorry! There are no copies available.");
        }
    }
    public void info(){
        this.getName();
        this.getCardNum();
        this.getBooks();
    }
}

class Library {
    private String name;
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Donor> donors = new ArrayList<>();

    public Library(String name, ArrayList<Floor> floors, ArrayList<Event> events, 
        ArrayList<Staff> staff, ArrayList<Donor> donors){
        
        this.name = name;
        this.floors = floors;
        this.events = events;
        this.staff = staff;
        this.donors = donors;
    }
    public Library(String name) {
        this.name = name;
    }

    public void getFloors(){
        System.out.println("Floors: "+ this.floors.size());
    }
    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    public void getEvents(){
        for(Event event : this.events){
            event.info();
        }
    }

    public void addEvent(Event event){
        this.events.add(event);
    }

    public void removeEvent(Event rmEvent){

        for (int i = 0; i < this.events.size(); i++){
            if (this.events.get(i).name() == rmEvent.name()){
                this.events.remove(i);
                System.out.println("Event sucessfully removed");
            }
        }

    }

    public void getStaff(){
        for(Staff employee : this.staff){
            employee.info();
        }
    }

    public void addStaff(Staff employee){
        this.staff.add(employee);
        System.out.println("Successfully added!");
    }

    public void removeStaff(Staff employee){
        for (int i = 0; i < this.staff.size(); i++){
            if (this.staff.get(i).id() == employee.id()){
                this.events.remove(i);
                System.out.println("Sucessfully removed!");
            }
        }
    }

    public void getDonors(){
        for (Donor donor : this.donors){
            donor.info();
        }
    }
    public void addDonor(Donor donor){
        this.donors.add(donor);
    }
}






class  Main {
    public static void main(String[] args ) {
        Library East = new Library("East");


        Staff Jess = new Staff("Jess","Rabbit", "Librarian", 257);
        Staff Mark = new Staff("Mark", "Myers", "Security", 986);
        
        East.addStaff(Jess);
        East.addStaff(Mark);

        Patron Sarah = new Patron("Sarah", "Connor", 555555);
        Patron Howl = new Patron("Howl","Pendragon", 222222);


        Genre Romance = new Genre("Romance");
        Genre romCom = new Genre("Romantic Comedy");
        Genre Horror = new Genre("Horror");

        Book Hello = new Book("Hello", "J.J Jones", 6, Romance);
        Book Goodbye = new Book("Goodbye", "Leon Kennedy", 2, Horror);

        Sarah.checkOut(Goodbye);
        Howl.checkOut(Goodbye);
        Howl.checkOut(Hello);


        Event readAloud = new Event("Read Aloud", "Come read with everyone!", "Tuesday");
        East.addEvent(readAloud);
        
        Floor one = new Floor(1, Romance);
        Floor two = new Floor(2, Horror);

        East.addFloor(one);
        East.addFloor(two);
        
        Donor Rich = new Donor("Richie", "Rich", 2000);
        East.addDonor(Rich);
    }
}
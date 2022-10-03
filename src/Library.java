
import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Library {
    private Vector<Book> vector;

    Library(){
        vector = new Vector<Book>();
    }

    public int choice(){
        int sec;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try
        {
            // именно здесь String преобразуется в int
            sec = Integer.parseInt(str.trim ());
            if(sec >= 0 && sec <= vector.size())
                return sec;
            else{
                System.out.print("Ошибка! Повторите ввод: ");
                return choice();
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.print("Ошибка! Повторите ввод: ");
            return choice();
        }
    }

    public static int priceEnter(){
        int sec;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try
        {
            // именно здесь String преобразуется в int
            sec = Integer.parseInt(str.trim ());
            if(sec >= 0)
                return sec;
            else{
                System.out.print("Цена должна быть больше нуля!");
                return priceEnter();
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.print("Повторите ввод: ");
            return priceEnter();
        }

    }

    private void sortName() {
        Comparator<Book> comparator = Comparator.comparing(obj -> (obj.getName()));
        vector.sort(comparator);
    }

    public void print() {
        StringBuilder str = new StringBuilder();
        str.append("+-----+------------------+---------------+-------------+\n");
        str.append("|  №  |     Название     |     Автор     |     Цена    |\n");
        str.append("+-----+------------------+---------------+-------------+\n");
        for (int i = 0; i < vector.size(); i++)
        {
            int j = i+1;
            str.append("|").append(String.format("%3d",j)).append(". |")
                    .append(String.format("%17s", vector.elementAt(i).getName())).append(" |")
                    .append(String.format("%14s", vector.elementAt(i).getAuthor())).append(" |")
                    .append(String.format("%12d", vector.elementAt(i).getPrice())).append(" |\n");
            str.append("+-----+------------------+---------------+-------------+\n");
        }
        System.out.print(str.toString());
    }

    public void add(String name, String author, int publishingYear) throws IOException {
        Book buf = new Book(name, author, publishingYear);
        vector.add(buf);
        sortName();
    }

    public void add(){
        String name;
        String author;
        int publishingYear;
        Scanner scanner = new Scanner((System.in));
        System.out.print("Введите название книги: ");
        name = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        author = scanner.nextLine();
        System.out.print("Введите цену книги: ");
        publishingYear = priceEnter();
        Book buf = new Book(name, author, publishingYear);
        vector.add(buf);
        sortName();
        System.out.print("Книга успешно добавлена!");
    }

    public void remove(int i){
        vector.remove(i);
    }

    public void remove(){
        int i;
        print();
        System.out.print("Введите номер книги для удаления или 0 для отмены: ");
        i = choice();
        if( i!= 0) {
            vector.remove(i - 1);
            System.out.println("Удаление прошло успешно");
        }
        else
            System.out.println("Удаление отменено");
    }

    void searchName(String name) {
        StringBuilder str = new StringBuilder();
        boolean isFound = false;

        for (int i = 0; i < vector.size(); i++) {
            if (Objects.equals(name, vector.elementAt(i).getName())) {
                if (!isFound) {
                    str.append("+-----+------------------+---------------+-------------+\n");
                    str.append("|  №  |     Название     |     Автор     | Год выпуска |\n");
                    str.append("+-----+------------------+---------------+-------------+\n");
                }
                isFound = true;
                str.append("|").append(String.format("%3d", i + 1)).append(". |")
                        .append(String.format("%17s", vector.elementAt(i).getName())).append(" |")
                        .append(String.format("%14s", vector.elementAt(i).getAuthor())).append(" |")
                        .append(String.format("%12d", vector.elementAt(i).getPrice())).append(" |\n");
                str.append("+-----+------------------+---------------+-------------+\n");
            }
        }
        if(!isFound){
            str.append("Ничего не найдено!\n");
        }
        System.out.println(str.toString());
    }

    void searchAuthor(String author) {
        StringBuilder str = new StringBuilder();
        boolean isFound = false;

        for (int i = 0; i < vector.size(); i++) {
            if (Objects.equals(author, vector.elementAt(i).getAuthor())) {
                if (!isFound) {
                    str.append("+-----+------------------+---------------+-------------+\n");
                    str.append("|  №  |     Название     |     Автор     |     Цена    |\n");
                    str.append("+-----+------------------+---------------+-------------+\n");
                }
                isFound = true;
                str.append("|").append(String.format("%3d", i + 1)).append(". |")
                        .append(String.format("%17s", vector.elementAt(i).getName())).append(" |")
                        .append(String.format("%14s", vector.elementAt(i).getAuthor())).append(" |")
                        .append(String.format("%12d", vector.elementAt(i).getPrice())).append(" |\n");
                str.append("+-----+------------------+---------------+-------------+\n");
            }
        }
        if(!isFound){
            str.append("Ничего не найдено!\n");
        }
        System.out.println(str.toString());
    }

    void searchPublishingYear(int publishingYear) {
        StringBuilder str = new StringBuilder();
        boolean isFound = false;

        for (int i = 0; i < vector.size(); i++) {
            if (publishingYear == vector.elementAt(i).getPrice()) {
                if (!isFound) {
                    str.append("+-----+------------------+---------------+-------------+\n");
                    str.append("|  №  |     Название     |     Автор     |     Цена    |\n");
                    str.append("+-----+------------------+---------------+-------------+\n");
                }
                isFound = true;
                str.append("|").append(String.format("%3d", i + 1)).append(". |")
                        .append(String.format("%17s", vector.elementAt(i).getName())).append(" |")
                        .append(String.format("%14s", vector.elementAt(i).getAuthor())).append(" |")
                        .append(String.format("%12d", vector.elementAt(i).getPrice())).append(" |\n");
                str.append("+-----+------------------+---------------+-------------+\n");
            }
        }
        if(!isFound){
            str.append("Ничего не найдено!\n");
        }
        System.out.println(str.toString());
    }

    public int size(){
        return  vector.size();
    }

    Book getBook(int i){ return vector.elementAt(i-1); };
}


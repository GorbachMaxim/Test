import java.util.Scanner;
import java.util.Vector;

public class Order {
    private Vector<Book> order;

    Order(){
        order = new Vector<Book>();
    }

    public int choice(){
        int sec;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try
        {
            // именно здесь String преобразуется в int
            sec = Integer.parseInt(str.trim ());
            if(sec >= 0 && sec <= order.size())
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

    public void add(Library library){
        library.print();
        if(library.size() == 0)
            return;
        System.out.print("Выберите книгу или 0 для отмены: ");
        int choice = library.choice();
        if (choice <= 0 || choice > library.size()){
            System.out.print("Добавление отменено");
            return;
        }
        order.add(library.getBook(choice));
    }

    public void print(){
        StringBuilder str = new StringBuilder();
        int totalCost = 0;
        str.append("+-----+------------------+---------------+-------------+\n");
        str.append("|  №  |     Название     |     Автор     |     Цена    |\n");
        str.append("+-----+------------------+---------------+-------------+\n");
        for (int i = 0; i < order.size(); i++)
        {
            int j = i+1;
            totalCost += order.elementAt(i).getPrice();
            str.append("|").append(String.format("%3d",j)).append(". |")
                    .append(String.format("%17s", order.elementAt(i).getName())).append(" |")
                    .append(String.format("%14s", order.elementAt(i).getAuthor())).append(" |")
                    .append(String.format("%12d", order.elementAt(i).getPrice())).append(" |\n");
            str.append("+-----------------------------------------------------+\n");
        }
        str.append("|     Общая стоимость    |").append(String.format("%28d", totalCost)).append(" |\n");
        str.append("+------------------------+-----------------------------+\n");
        System.out.print(str.toString());
    }

    public int size(){
        return  order.size();
    }

    public void remove(){
        int i;
        print();
        System.out.print("Введите номер книги для удаления или 0 для отмены: ");
        i = choice();
        if( i!= 0) {
            order.remove(i - 1);
            System.out.println("Удаление прошло успешно");
        }
        else
            System.out.println("Удаление отменено");
    }
}

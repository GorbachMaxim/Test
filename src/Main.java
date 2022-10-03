import java.util.Scanner;

public class Main {
    public static int secureInt(){
        int sec;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try
        {
            // именно здесь String преобразуется в int
            sec = Integer.parseInt(str.trim ());
            return sec;
        }
        catch (NumberFormatException nfe)
        {
            System.out.print("Ошибка! Повторите ввод: ");
            return secureInt();
        }
    }

    public static void main(String[] args) {

        boolean cycle = true;
        Order order = new Order();
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice, publishingYear;
        String name, author;

        while (cycle) {
            System.out.println(" - Библиотека - ");
            System.out.println("1. Просмотр книг");
            System.out.println("2. Добавление новой книги");
            System.out.println("3. Удаление выбранной книги");
            System.out.println("4. Поиск по названию");
            System.out.println("5. Поиск по автору");
            System.out.println("6. Поиск по цене");
            System.out.println("7. Добавить в заказ");
            System.out.println("8. Удалить из заказа");
            System.out.println("9. Показать заказ");
            System.out.println("0. Выход");
            System.out.print("   Ваш выбор << ");
            choice = secureInt();

            switch (choice) {
                case 1:
                    if (lib.size() != 0) {
                        lib.print();
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 2:
                    lib.add();
                    break;
                case 3:
                    if (lib.size() != 0) {
                        lib.remove();
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 4:
                    if (lib.size() != 0) {
                        System.out.println("Введите название: ");
                        name = scanner.nextLine();
                        lib.searchName(name);
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 5:
                    if (lib.size() != 0) {
                        System.out.println("Введите автора: ");
                        author = scanner.nextLine();
                        lib.searchAuthor(author);
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 6:
                    if (lib.size() != 0) {
                        System.out.println("Введите цену: ");
                        publishingYear = secureInt();
                        lib.searchPublishingYear(publishingYear);
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 7:
                    if (lib.size() != 0) {
                        order.add(lib);
                    } else
                        System.out.println("Библиотека пуста");
                    break;
                case 8:
                    if (order.size() != 0) {
                        order.remove();
                    } else
                        System.out.println("Заказ пуст!");
                    break;
                case 9:
                    if (order.size() != 0) {
                        order.print();
                    } else
                        System.out.println("Заказ пуст!");
                    break;
                case 0:
                    cycle = false;
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.print("\n\n");

        }

    }
}

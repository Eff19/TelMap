import javax.print.DocFlavor;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TelMap {
    public static void main(String[] args){

        System.out.println("Телефонный справочник\n");
        System.out.println("Команды: \n" +
                "list - отображение данных в справочнике.\n"+
                "delete - очистка справочника.\n");
        TreeMap<String,String> telList = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите данные в следующем формате: \n" +
                "имя владельца - номер телефона");
        for (;;) {
            String a = scanner.nextLine();



            String num = a.replaceAll("[^0-9]", "");
            String text = a.replaceAll("[^A-z]", "");

            //telList.put(text, num);        // одновременный ввод имени и числа
            //System.out.println(telList);


            if (!telList.containsKey(text)){              // добавление ключа (текста)
                telList.put(text, scanner.nextLine());
                System.out.println(telList);
            }





            if (a.equalsIgnoreCase("DELETE")){
                telList.clear();
                continue;
            }

            if(a.equalsIgnoreCase("LIST")){
                System.out.println("Телефонный справочник");
                printMAP(telList);
                continue;
            }

        }
    }
    private static void printMAP(Map<String,String> map){
        for (String key : map.keySet()){
            System.out.println(key + " == " + map.get(key));
        }
    }
    private static void printvalue(Map<String,String> map1){
        for (String key : map1.keySet()){
            System.out.println(map1.get(key));
        }
    }

    private static void delete(Map<String,String> map){
        map.clear();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HmSol {

    private static final String WARNING = "Чтобы остановить ввод, введите \"exit\"";
    public static final String INTEGER_REQUIRED = "Нужно ввести целое число";
    private static final String LINE = "____________________________________________";

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("Введите пары значений");

        while(true) {

            System.out.println(WARNING);

            try{
                Scanner console = new Scanner(System.in);
                String key = console.next();
                if (key.equalsIgnoreCase("exit")) {
                    System.out.println(LINE);
                    break;
                }
                Integer value = console.nextInt();
                map.put(key, value);
                System.out.println(LINE);
            }
            catch(Exception e){
                System.out.println(INTEGER_REQUIRED);
            }
        }

        System.out.println("Ваши пары значений: ");

        for (String key: map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " --> " + value);
        }

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        ArrayList<Integer> values = new ArrayList<>(map.values());

        map.clear();

        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                if(IsSmaller(keys.get(i), keys.get(j))){
                    keys.add(keys.get(i));
                    keys.remove(i);
                    j = i;
                }
            }
            for (int j = i + 1; j < values.size(); j++) {
                if(values.get(i) < values.get(j)){
                    values.add(values.get(i));
                    values.remove(i);
                    j = i;
                }
            }
        }

//        for (int i = 0; i < keys.size(); i++) {
//            map.put(keys.get(i), values.get(i));
//        }

        PrintHashMap(keys, values);
        System.out.println(LINE);
//        PrintHashMap(map);
    }

     private static boolean IsSmaller(String str1, String str2){

             return str1.compareTo(str2) >= 0;

     }

    private static void PrintHashMap(ArrayList<String> keys, ArrayList<Integer> values){

        PrintResult();

        for (int i = 0; i < keys.size(); i++) {
            if(i == keys.size() - 1){
                System.out.println(keys.get(i) + " " + values.get(i) + ". ");
            }
            else {
                System.out.print(keys.get(i) + " " + values.get(i) + ", ");
            }
        }
    }

    private static void PrintResult(){

        System.out.println(LINE);
        System.out.println("Результат работы программы:");

    }

//    private static void PrintHashMap(HashMap<String, Integer> map) {
//
//        for (String key: map.keySet()) {
//            Integer value = map.get(key);
//            System.out.print(key + " " + value + ", ");
//        }
//
//    }
}
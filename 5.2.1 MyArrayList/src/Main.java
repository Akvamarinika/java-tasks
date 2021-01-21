public class Main {
    public  static  void main(String[] args){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Ivan");
        arrayList.add("Igor");
        arrayList.add("Mixail");
        arrayList.add("Nik");
        arrayList.add("Mike");
        arrayList.add("Alex");
        arrayList.add("Lev");
        arrayList.add("Artem");

        printList(arrayList);

        System.out.println(arrayList.size());
        arrayList.remove("Mixail");
        arrayList.remove(3);
        printList(arrayList);
        System.out.println(arrayList.size());

     /*   for (int j =0; j < 100; j++ ){
            arrayList.add("employee " + j);
        }*/

        arrayList.add(3, "Mixail");
        arrayList.add(5, "Petr");
        arrayList.add(2, "Sergey");
        arrayList.add(7, "Victor");
        arrayList.add(0, "Yaroslav");
        printList(arrayList);
        System.out.println(arrayList.size());


    }

    public static void printList(MyArrayList list){
        for (int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

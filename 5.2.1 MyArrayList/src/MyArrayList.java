public class MyArrayList {
    private static int sizeArray = 0;
    private static String[] array;

    public MyArrayList(){
        array = new String[10];
    }

    public MyArrayList(int count){
        array = new String[count];
    }

    public int size(){
        return sizeArray;
    }

    private void toExpandArray(){
        if (sizeArray == array.length){
            String[] tmp = new String[array.length * 2];
            for (int i = 0; i < sizeArray; i++){
                tmp[i] = array[i];
            }
            array = tmp;
        }
    }

    public void add(String elem){
        toExpandArray();
        array[sizeArray] = elem;
        sizeArray++;
    }

    public void  add(int index, String elem){
        toExpandArray();

        if (index < sizeArray){
            String[] tmp = new String[array.length + 1];
            tmp[index] = elem;
            for (int i = 0; i < index; i++){
                    tmp[i] = array[i];
            }
            for (int i = index; i < sizeArray + 1; i++){
                tmp[i+1] = array[i];
            }
            sizeArray++;
            array = tmp;
        }

    }

    public void remove(int index){
        if (index < sizeArray){
            for (int i = index; i < sizeArray; i++){
                array[i] = array[i+1];
            }
            sizeArray--;
        }else {
            System.out.println("Error: элемент не найден");
        }

    }

    public void remove(String elem){
        for (int i = 0; i < sizeArray; i++){
            if (elem.equals(get(i))){
                remove(i);
                break;
            }
        }

    }

    public String get(int index){
        if (index < sizeArray){
            return array[index];
        }
        return "Error: элемент не найден";
    }



}

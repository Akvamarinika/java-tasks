public class Director {
    String force(Worker worker, int count){
        for (int i = 0; i< count; i++ ){
            worker.work();
        }

        return "Successes!";
    }
}

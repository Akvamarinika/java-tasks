public class Cycles {
    public static void main(String[] args){
        /* TODO 1.	Напишите код, используя цикл for, который будет последовательно распечатывать в консоли
            номера билетов от 200 000 до 210 000 и от 220 000 до 235 000.
            2.	Распечатайте такие же номера билетов, используя цикл while.
 */
        for (int numberTicket=200000; numberTicket <= 235000; numberTicket++){
            if (numberTicket > 210000 && numberTicket < 220000) {
                continue;
            }
            System.out.println(numberTicket);
        }

        int numberTicket = 200000;
        while (numberTicket <= 235000){
            if (numberTicket > 210000 && numberTicket < 220000) {
                numberTicket++;
                continue;
            }
            System.out.println(numberTicket);
            numberTicket++;
        }
    }
}

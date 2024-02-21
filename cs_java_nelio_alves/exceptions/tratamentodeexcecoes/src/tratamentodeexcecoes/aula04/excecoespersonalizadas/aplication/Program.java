package tratamentodeexcecoes.aula04.excecoespersonalizadas.aplication;

/*
 * Fazer um programa para ler os dados de uma reserva de hotel(número do quarto, data de entrada e data de saída) e
 * mostrar os dados da reserva, inclusive sua duração em dias. Em seguida, ler novas datas de entrada e saída, atualizar
 * a reserva, e mostrar novamente a reserva com os dados atualizados. O programa não deve aceitar dados inválidos para
 * a reserva, conforme as seguintes regras:
 * - A data de saída deve ser maior que a data de entrada.
 * - Alterações de reserva só podem ocorrer para as datas futuras.
 * */

import tratamentodeexcecoes.aula04.excecoespersonalizadas.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        /*
         * Demonstração de uma solução muito ruim.
         * */

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int numberRoom;
        Date checkIn, checkOut;
        int option;

        System.out.println("**** Welcome to Hotel ****");

        System.out.println("Room number: ");
        numberRoom = scanner.nextInt();

        System.out.println("Check-in date (dd/MM/yyyy)");
        checkIn = simpleDateFormat.parse(scanner.next());

        System.out.println("Check-out date (dd/MM/yyyy)");
        checkOut = simpleDateFormat.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Do you want to update date ?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");

            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Check-in date (dd/MM/yyyy)");
                checkIn = simpleDateFormat.parse(scanner.next());

                System.out.println("Check-out date (dd/MM/yyyy)");
                checkOut = simpleDateFormat.parse(scanner.next());

                Date current = new Date();

                if (checkIn.before(current) || checkOut.before(current)) {
                    System.out.println("Error in reservation: Dates for update must be future.");
                } else if (!checkOut.after(checkIn)) {
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                } else {
                    reservation.updateDates(checkIn, checkOut);
                    System.out.println("Reservation: " + reservation);
                }
            }

            if (option == 2) {
                System.out.println("Thanks you for use system of Hotel");
            }
        }
    }
}

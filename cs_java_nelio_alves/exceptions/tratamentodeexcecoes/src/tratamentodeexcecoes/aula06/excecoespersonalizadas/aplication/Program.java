package tratamentodeexcecoes.aula06.excecoespersonalizadas.aplication;

/*
 * Fazer um programa para ler os dados de uma reserva de hotel(número do quarto, data de entrada e data de saída) e
 * mostrar os dados da reserva, inclusive sua duração em dias. Em seguida, ler novas datas de entrada e saída, atualizar
 * a reserva, e mostrar novamente a reserva com os dados atualizados. O programa não deve aceitar dados inválidos para
 * a reserva, conforme as seguintes regras:
 * - A data de saída deve ser maior que a data de entrada.
 * - Alterações de reserva só podem ocorrer para as datas futuras.
 * */

import tratamentodeexcecoes.aula06.excecoespersonalizadas.model.entities.Reservation;
import tratamentodeexcecoes.aula06.excecoespersonalizadas.model.exceptions.DomainReservationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        /*
         * Demonstração de uma solução boa.
         * */

        Scanner scanner = new Scanner(System.in);

        try {
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

                reservation.updateDates(checkIn, checkOut);

                System.out.println("Reservation: " + reservation);
            }

            if (option == 2) {
                System.out.println("Thanks you for use system of Hotel");
            }
        }

        /*
        * Tratando a exception ParseException.
        */
        catch (ParseException e) {
            System.out.println("Invalid date format.");
        }

        /*
         * Tratando a exception IllegalArgumentException.
         */
        catch (IllegalArgumentException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }

        /*
         * Tratando a exception DomainReservationException.
         */
        catch (DomainReservationException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }

        /*
         * Tratando a exception RuntimeException, ou seja, qualquer outro tipo de exceção.
         * que venha acontecer.
         */
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
        scanner.close();
    }
}

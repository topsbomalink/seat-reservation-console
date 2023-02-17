package org.example;

import java.util.*;

public class Reservation {
    private static Map<String, Person> seatAllocationMap = new HashMap<>();
    public static void main(String[] args) {
        List<String> seats = getSeats();
        while (true) {
            System.out.println("Make seat reservation by inputting in the format below: ");
            System.out.println("SeatNumber::FullName::Age, Sample A2::ade ojo::20");
            System.out.println("Enter 'Quit' to exit application");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("Quit")) {
                int totalSeatReserved = seatAllocationMap.size();
                System.out.println("Total Seat Reserved: " + totalSeatReserved);
                seatAllocationMap.entrySet().stream().forEach(s -> {
                    System.out.println("Reservation: " + s.getKey() + " : " + s.getValue().toString());
                });
                System.out.println("Thanks for using our reservation application");
                return;
            }
            String[] inputArray = input.split("::");
            String seatNo = inputArray[0];
            if (!seats.contains(seatNo)) {
                System.out.println("Sorry you entered an invalid seat number, kindly try again!");
            }else {
                Person person = new Person(UUID.randomUUID().toString(), inputArray[1], Integer.parseInt(inputArray[2]));
                allocateSeat(seatNo, person);
                System.out.println("================================================================");
            }

        }

    }

    private static void allocateSeat(String seatNumber, Person person) {
        if (seatAllocationMap.get(seatNumber) != null) {
            System.out.println("Oh sorry! Seat already taken, try to book another seat!");
            return;
        }
        seatAllocationMap.put(seatNumber, person);
        System.out.println("Reservation Confirmed:: Next Reservation please!");
    }

    private static List<String> getSeats() {
        List<String> listOfSeats = new ArrayList<>();
        char[] seatChar = new char[]{'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < seatChar.length; i++) {
            for (int j = 1; j <= 12; j++) {
                String seat = String.format("%s%s", seatChar[i], j);
                listOfSeats.add(seat);
            }
        }
        return listOfSeats;
    }
}
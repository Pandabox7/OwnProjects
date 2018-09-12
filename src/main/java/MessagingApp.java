

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessagingApp {


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        LocalDateTime timeStamp = LocalDateTime.now();
        User user = new User();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(" Welcome to Messenger please choose what you want to do: ");
        System.out.println("1, Sign up");
        System.out.println("2, Login");
        int checkedMessage = 0;

        String userChoice = input.nextLine();

        switch (userChoice) {
            case "1":
                System.out.println(" Please choose your name:");
                String name = input.nextLine();
                System.out.println(" Please write your email to create a new account:");
                String email = input.nextLine();

                System.out.println(" Please write your password to open your account:");
                String password = input.nextLine();

                System.out.println(" Please write your age:");
                int age = input.nextInt();
                input.nextLine();


                try {
                    // creates a file with email as name
                    FileWriter fileWriter = new FileWriter(email + ".txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.print(name);
                    printWriter.print(email);
                    printWriter.print(password);
                    printWriter.print(age);

                    printWriter.close();

                } catch (IOException e) {
                }
                break;
            case "2":

                System.out.println("Please input your email: ");
                String userEmail = input.nextLine();
                System.out.println("Please input your password: ");
                String userPassword = input.nextLine();


                List<String> lines = Files.readAllLines(Paths.get(userEmail + ".txt"));

                user = new User(lines.get(0),
                        lines.get(1),
                        Integer.valueOf(lines.get(3)),
                        lines.get(2),
                        LocalDateTime.parse(lines.get(lines.size() - 1), formatter));
                FileOutputStream fileWriter = new FileOutputStream(new File(user.getEmail() +  ".txt"), true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String stringToWrite = "\n" + timeStamp.format(formatter);
                printWriter.append(stringToWrite);
                printWriter.close();

                while (true) {


                    if (lines.get(1).equals(userEmail) && lines.get(2).equals(userPassword)) {
                        System.out.println("Welcome " + lines.get(1));
                        System.out.println("What would you like to do?");
                        System.out.println("1, Chat");
                        System.out.println("2, View new messages ");
                        System.out.println("3, Exit chat");


                        int chat = input.nextInt();
                        input.nextLine();
//                        Thread thread = new Thread(() -> {
//                            try {
//                                Thread.sleep(1000);
//                                ioUtils.checkNewMessages(userEmail);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        });
//                        thread.start();
                        // start Thread to see any new emails

                        switch (chat) {
                            case 1:

                                System.out.println("To whom do you want to chat?");
                                String secondUser = input.nextLine();

                                if (Files.exists(Paths.get(secondUser + ".txt"))) {
                                    System.out.println("Write your message");
                                    String message = input.nextLine();
                                    FileOutputStream fileWriter1 = new FileOutputStream(new File(userEmail + "to" + secondUser + ".txt"), true);
                                    PrintWriter printWriter1 = new PrintWriter(fileWriter1);
                                    String timeStampString = timeStamp.format(formatter);
                                    printWriter1.append("\n").append(timeStampString + " " + message);
                                    printWriter1.close();

                                } else {
                                    System.out.println("User doesn't exist");
                                }

                                break;
                            case 2:

                                System.out.println("Enter email of first user");
                                String firstUser = input.nextLine();
                                System.out.println("Enter email of second user");
                                String secondUserEmail = input.nextLine();


                                List<String> strings = Files.readAllLines(Paths.get(firstUser + "to" + secondUserEmail + ".txt"));

                                List<String> newMessages = new ArrayList<>();

                                for(int i = 0; i < strings.size(); i++){
                                    String currentElement = strings.get(i);
                                    String[] stringAfterSplit = currentElement.split("%");
                                    String datesString = stringAfterSplit[0].trim();
                                    LocalDateTime date = LocalDateTime.parse(datesString, formatter);
                                    if(date.isAfter(user.getLastLoginTime())){
                                        newMessages.add(strings.get(i));
                                    }
                                }

                                for (int i = 0; i < newMessages.size(); i++) {
                                    System.out.println(newMessages.get(i));

//                                    if (checkedMessage > strings.size()) {
//                                        System.out.println(strings);
//                                    }
//                                    checkedMessage = strings.size();
//
//
//                                    String message = input.nextLine();
//                                    FileOutputStream fileWriter = new FileOutputStream(new File(+checkedMessage + userEmail + ".txt"), true);
//                                    PrintWriter printWriter = new PrintWriter(fileWriter);
//                                    printWriter.append("\n").append(message);
//                                    printWriter.close();


//                                        if () {
//                                            for (int j = 0; j < checkedMessage; j++) {
//                                                System.out.println(checkedMessage);
//                                            }


                                }


                                System.out.println("Email or password doesnt exist");
                            case 3:

                        }


                    }


                }


        }
    }
}














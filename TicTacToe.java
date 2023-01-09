package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {
    static char[][] box = new char[3][3];
    static String Player1 = "", Player2 = "";
    static boolean Player1win = false;
    static boolean Player2win = true;
    static boolean Draw = false;
    static boolean Pending = false;
    static int count = 0;
    static HashSet <Integer> display = new HashSet <>();
    static HashSet <Integer> set = new HashSet <>();
    public static void main(String[] args) {

            for (int i = 1; i <= 9; i++) {
                display.add(i);
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Player 1 Name : ");
            String FirstPlayer = sc.nextLine();
            System.out.print("Enter Player 2 Name : ");
            String SecondPlayer = sc.nextLine();


            char[] Symbol = {'X', 'O'};

            System.out.println();System.out.println("Game Rules : \n" + "Choose Symbol 'X' or 'O' only\n" + "Choose Location only from " + display);

            Intial();
            System.out.println();

            int index1 = 0, index2 = 0;
            int start, Pos;


            do {
                System.out.print("Enter '1' to " + FirstPlayer + " start the Game " +  "or Enter '2' to " + SecondPlayer + " start the Game : ");
                start = sc.nextInt();
                if (start == 1 || start == 2) break;
                if (start != 1 || start != 2) System.out.println("Choose Only 1 or 2");
                System.out.println();

            } while (start != 1 && start != 2);

            System.out.println();

            if (start == 1) {

                while (!Player1.equalsIgnoreCase("X") && !Player1.equalsIgnoreCase("O")) {
                    System.out.print(FirstPlayer + " Choose Your Symbol ['X' or 'O'] : ");
                    Player1 = sc.next();
                    if (Player1.equalsIgnoreCase("x") || Player1.equalsIgnoreCase("O")) break;
                    if (!Player1.equalsIgnoreCase("x") || !Player1.equalsIgnoreCase("O")) ;
                    System.out.println("Choose Only 'X' or 'O' ");
                    System.out.println();
                }
                if (Player1.equalsIgnoreCase("X")) {
                    Player1 = "X";
                    Player2 = "O";
                } else {
                    Player1 = "O";
                    Player2 = "X";
                }
            }

            if (start == 2) {

                while (!Player2.equalsIgnoreCase("X") && !Player2.equalsIgnoreCase("O")) {
                    System.out.print(SecondPlayer + " Choose Your Symbol ['X' or 'O'] : ");
                    Player2 = sc.next();
                    if (Player2.equalsIgnoreCase("x") || Player2.equalsIgnoreCase("O")) break;
                    if (!Player2.equalsIgnoreCase("x") || !Player2.equalsIgnoreCase("O")) ;
                    System.out.println("Choose Only 'X' or 'O' ");
                    System.out.println();
                }

                if (Player2.equalsIgnoreCase("X")) {
                    Player2 = "X";
                    Player1 = "O";
                } else {
                    Player2 = "O";
                    Player1 = "X";
                }
            }

            System.out.println();

            if (start == 1) {
                if (Player1.equalsIgnoreCase("X")) {
                    System.out.println(FirstPlayer + " Choosed " + "'" + Player1 + "'");
                    System.out.println("So, " + SecondPlayer + " Symbol is "+ "'" + Player2 + "'");
                }
                if (Player1.equalsIgnoreCase("O")) {
                    System.out.println(FirstPlayer + " Choosed " + "'" + Player1 + "'");
                    System.out.println("So, " + SecondPlayer + " Symbol is "+ "'" + Player2 + "'");
                }
            }

            if (start == 2) {
                if (Player2.equalsIgnoreCase("X")) {
                    System.out.println(SecondPlayer + " Choosed " + "'" + Player2 + "'");
                    System.out.println("So, " + FirstPlayer + " Symbol is " + "'" + Player1 + "'");
                }
                if (Player2.equalsIgnoreCase("O")) {
                    System.out.println(SecondPlayer + " Choosed " + "'" + Player2 + "'");
                    System.out.println("So, " + FirstPlayer + " Symbol is " + "'" + Player1 + "'");
                }
            }

            setBox();
            System.out.println();

            while (Player1win == false && Player2win == true && Draw == false) {

                if (start == 1) {

                    char current = Player1.charAt(0);

                    do {
                        System.out.println(FirstPlayer + " " + "'" + Player1 + "'" + " Turn");
                        System.out.print(FirstPlayer + ", Choose Your Location to Place " + " " + "'" + Player1 + "'" + " : ");
                        Pos = sc.nextInt();

                        if (Pos < 1 || Pos > 9) {
                            System.out.println(FirstPlayer + " You Can Only Choose From this Numbers --> " + display);
                            System.out.println();
                        }
                        if (set.contains(Pos)) {
                            System.out.println();
                            System.out.println(FirstPlayer + "! This Location is Already taken, So Choose Another Location :)");
                            System.out.println("Available Locations ");
                            System.out.println(display);
                            System.out.println();
                        }
                    } while (Pos != 1 && Pos != 2 && Pos != 3 && Pos != 4 && Pos != 5 && Pos != 6 && Pos != 7 && Pos != 8 && Pos != 9 && !set.contains(Pos));

                    display.remove(Pos);

                    if (!set.contains(Pos)) set(Pos, current);
                    if (!set.contains(Pos)) setBox();
                    if (!set.contains(Pos)) count++;


                    winner();

                    if (Player1win == true) {
                        System.out.println("Aaayie, " + FirstPlayer + " '" + Player1 + "'" + " Win's the Game ");
                        break;
                    }
                    if (count == 9 && Player1win == false) {
                        System.out.println(FirstPlayer + " and " + SecondPlayer + " !!!!");
                        System.out.println("It's Draw, 'X' --- 'O' ");
                        break;
                    }
                    if (!set.contains(Pos)) {
                        set.add(Pos);
                        start = 2;
                    }
                } else {
                    char present = Player2.charAt(0);

                    do {
                        System.out.println(SecondPlayer + " " + "'" + Player2 + "'" + " Turn");
                        System.out.print(SecondPlayer + ", Choose Your Location to Place " + " " + "'" + Player2 + "'" + " : ");
                        Pos = sc.nextInt();
                        if (Pos < 1 || Pos > 9) {
                            System.out.println(SecondPlayer + " You Can Only Choose From this Numbers --> " + display);
                            System.out.println();
                        }
                        if (set.contains(Pos)) {
                            System.out.println();
                            System.out.println(SecondPlayer + "! This Location is Already taken, So Choose Another Location :)");
                            System.out.println("Available Locations ");
                            System.out.println(display);
                            System.out.println();
                        }
                    } while (Pos != 1 && Pos != 2 && Pos != 3 && Pos != 4 && Pos != 5 && Pos != 6 && Pos != 7 && Pos != 8 && Pos != 9 && !set.contains(Pos));

                    display.remove(Pos);

                    if (!set.contains(Pos)) set(Pos, present);
                    if (!set.contains(Pos)) setBox();
                    if (!set.contains(Pos)) count++;


                    winner();

                    if (Player2win == false) {
                        System.out.println("Aaayie, " + SecondPlayer + " '" + Player2 + "'" + " Win's the Game ");
                        break;
                    }
                    if (count == 9 && Player1win == false) {
                        System.out.println(FirstPlayer + " and " + SecondPlayer + " !!!!");
                        System.out.println("It's Draw, 'X' --- 'O' ");
                        break;
                    }

                    if (!set.contains(Pos)) {
                        set.add(Pos);
                        start = 1;
                    }
                }
        }
    }

    static void set (int n, char Char) {

        if (n == 1) box[0][0] = Char;
        if (n == 2) box[0][1] = Char;
        if (n == 3) box[0][2] = Char;
        if (n == 4) box[1][0] = Char;
        if (n == 5) box[1][1] = Char;
        if (n == 6) box[1][2] = Char;
        if (n == 7) box[2][0] = Char;
        if (n == 8) box[2][1] = Char;
        if (n == 9) box[2][2] = Char;
    }
    static boolean winner () {

        int check1 = 0, check2 = 0;

        if (box[0][0] == Player1.charAt(0) && box[0][1] == Player1.charAt(0) && box[0][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[1][0] == Player1.charAt(0) && box[1][1] == Player1.charAt(0) && box[1][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[2][0] == Player1.charAt(0) && box[2][1] == Player1.charAt(0) && box[2][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[0][0] == Player1.charAt(0) && box[1][0] == Player1.charAt(0) && box[2][0] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[0][1] == Player1.charAt(0) && box[1][1] == Player1.charAt(0) && box[2][1] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[0][2] == Player1.charAt(0) && box[1][2] == Player1.charAt(0) && box[2][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[0][0] == Player1.charAt(0) && box[1][1] == Player1.charAt(0) && box[2][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;
        if (box[2][0] == Player1.charAt(0) && box[1][1] == Player1.charAt(0) && box[0][2] == Player1.charAt(0)) check1++; if (check1 == 1) return Player1win = true;

        if (box[0][0] == Player2.charAt(0) && box[0][1] == Player2.charAt(0) && box[0][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[1][0] == Player2.charAt(0) && box[1][1] == Player2.charAt(0) && box[1][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[2][0] == Player2.charAt(0) && box[2][1] == Player2.charAt(0) && box[2][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[0][0] == Player2.charAt(0) && box[1][0] == Player2.charAt(0) && box[2][0] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[0][1] == Player2.charAt(0) && box[1][1] == Player2.charAt(0) && box[2][1] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[0][2] == Player2.charAt(0) && box[1][2] == Player2.charAt(0) && box[2][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[0][0] == Player2.charAt(0) && box[1][1] == Player2.charAt(0) && box[2][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;
        if (box[2][0] == Player2.charAt(0) && box[1][1] == Player2.charAt(0) && box[0][2] == Player2.charAt(0)) check2++; if (check2 == 1) return Player2win = false;

       if (check1 == 0 && check2 == 0) {
           return Draw == true;
       }
       return Pending = true;
    }
    static void setBox () {

        System.out.println (" ___________");

                System.out.println("| " + box[0][0] + " | " + box[0][1] + " | " + box[0][2] + " | ");
                System.out.println("|-----------|");
                System.out.println("| " + box[1][0] + " | " + box[1][1] + " | " + box[1][2] + " | ");
                System.out.println("|-----------|");
                System.out.println("| " + box[2][0] + " | " + box[2][1] + " | " + box[2][2] + " | ");

        System.out.println (" -----------");
    }

    static void Intial () {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[i][j] = ' ';
            }
        }
    }
}

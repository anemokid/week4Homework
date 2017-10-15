package com.company;
import java.util.*;
import java.util.Scanner;
import java.util.LinkedList;

public class EditHistory {

  Scanner scanner = new Scanner(System.in);
        private String lastLine;// What the last element of the list will be. // for undo method
        //private String user;//Where the user's input for undo will be stored.

        private String userInput;// For user input.
        private static LinkedList<String> userStack = new LinkedList<>();
        public static void addToEditHistory(String word) {
            userStack.add(word);
//            for(String s : userStack) {
//                System.out.println(s + " is in your list.");
//            }
            System.out.println(userStack);
        } // ends addToEditHistory

        public void copy(){
            lastLine = userStack.getLast();
            userStack.add(lastLine);
            System.out.println(userStack);
        }
        static String lastWord;

        public static void delete(){
            try{
                lastWord = userStack.getLast();
                userStack.remove(lastWord);
                System.out.println(userStack);
            } catch (NoSuchElementException e) {
                System.out.println("List is empty");
            }
        }

        public static void undo(){
            userStack.add(lastWord);
            System.out.println(userStack);
        }

        public static void quit(String word){
            while(word.equals("quit")){
                System.exit(0);
                System.out.println("Bye bye!");
            }
        }

        public void startProgram() {
            while (userStack.size() < 10) {
                System.out.println("Please enter a word!");
                System.out.println("Either enter a word to save to your edit history");
                System.out.println("OR: ");
                System.out.println("COPY");
                System.out.println("DELETE");
                System.out.println("UNDO");
                System.out.println("QUIT");
                String userInput = scanner.next().toLowerCase();
                switch (userInput) {
                    case "copy":
                        copy();
                        break;
                    case "delete":
                        delete();
                        break;
                    case "undo":
                        undo();
                        break;
                    case "quit":
                        quit(userInput);
                        break;
                    default:
                        addToEditHistory(userInput);
                        break;
                } //ends switch
            } //ends while loop
        } //ends Start Program
    } // ends editHistory class


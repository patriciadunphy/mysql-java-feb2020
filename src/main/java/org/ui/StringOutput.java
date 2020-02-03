package org.ui;


public class StringOutput {
    public void typeLastName() {
        System.out.println("Skriv in efternamn");

    }
    public void typeFirstName() {
        System.out.println("Skriv in förnamn");
    }
    public void typeOldLastName() {
        System.out.println("Skriv in efternamn på den person du vill ändra");

    }
    public void typeOldFirstName() {
        System.out.println("Skriv in förnamn på den person du vill ändra");

    }
    public void typeNewLastName() {
        System.out.println("Skriv in nytt efternamn på den person du vill ändra");
    }
    public void typeNewFirstName() {
        System.out.println("Skriv in nytt förnamn på den person du vill ändra");
    }
    public void insertSuccess() {
        System.out.println("Insert update lyckades!");
    }
    public void updateSuccess() {
        System.out.println("Uppdatering genomförd!");
    }
    public void insertActorSuccess() {
        System.out.println("Skådespelaren har lagts till!");
    }
    public void deleteActorSucess() {
        System.out.println("Skådespelaren har raderats från databasen!");
    }
    public void findActorinFilmsSuccess() {
        System.out.println("Skådespelaren medverkar i följande filmer:");
    }
    public void printResult() {
        System.out.println("Följande hittades i databasen: \r");
    }

}
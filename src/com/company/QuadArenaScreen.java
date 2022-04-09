package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuadArenaScreen {

    //maybe accept Player object here?
    public void updateGymnast(String gymnast, int teamNumb){
        if (teamNumb == 1){
            name1.setText(gymnast);
            //change major
            //year
            //etc
        }
        else if (teamNumb == 2){
            name2.setText(gymnast);
        }
        else if (teamNumb == 3){
            name3.setText(gymnast);
        }
        else if (teamNumb == 4){
            name4.setText(gymnast);
        }
    }
    public void updateRotation(int rotationNumb){
        rotationLabel.setText("Rotation " + rotationNumb);
    }
    public void updateEvent(String event, int teamNumb){
        if(teamNumb == 1){
            event1.setText(event);
        }
        else if (teamNumb == 2){
            event2.setText(event);
        }
        else if (teamNumb == 3){
            event3.setText(event);
        }
        else if (teamNumb == 4){
            event4.setText(event);
        }
    }
    public void updateScore(){

    }

    //all of these clock functions are really redundant, will change later
    public void clock1(int mySeconds){

        seconds1 = mySeconds;
        seconds1--; //to account for second delay of timer start, should probably be changed in the future

        //update timer every 1000ms aka 1 second
        timer1 = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                time1 = String.format("%02d:%02d", seconds1 /60, seconds1 % 60);
                clockLabel1.setText(time1);

                if (seconds1 <= 0){
                    resetClock1();
                }
                else {
                    seconds1--;
                }
            }
        });
        timer1.start();
    }

    public void clock2(int mySeconds){

        seconds2 = mySeconds;
        seconds2--; //to account for second delay of timer start, should probably be changed in the future

        //update timer every 1000ms aka 1 second
        timer2 = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                time2 = String.format("%02d:%02d", seconds2 /60, seconds2 % 60);
                clockLabel2.setText(time2);

                if (seconds2 <= 0){
                    resetClock2();
                }
                else {
                    seconds2--;
                }
            }
        });
        timer2.start();
    }
    public void clock3(int mySeconds){

        seconds3 = mySeconds;
        seconds3--; //to account for second delay of timer start, should probably be changed in the future

        //update timer every 1000ms aka 1 second
        timer3 = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                time3 = String.format("%02d:%02d", seconds3 /60, seconds3 % 60);
                clockLabel3.setText(time3);

                if (seconds3 <= 0){
                    resetClock2();
                }
                else {
                    seconds3--;
                }
            }
        });
        timer3.start();
    }
    public void clock4(int mySeconds){

        seconds4 = mySeconds;
        seconds4--; //to account for second delay of timer start, should probably be changed in the future

        //update timer every 1000ms aka 1 second
        timer4 = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                time4 = String.format("%02d:%02d", seconds4 /60, seconds4 % 60);
                clockLabel4.setText(time4);

                if (seconds4 <= 0){
                    resetClock2();
                }
                else {
                    seconds4--;
                }
            }
        });
        timer4.start();
    }

//    public void clock(int seconds, int selectedClock){
//        switch (selectedClock){
//            case 1:
//                seconds1 = seconds;
//                startClock(timer1, seconds1, time1, clockLabel1);
//                break;
//            case 2:
//                startClock(timer2, seconds2, time2, clockLabel2);
//                break;
//            case 3:
//                startClock(timer3, seconds3, time3, clockLabel3);
//                break;
//            case 4:
//                startClock(timer4, seconds4, time4, clockLabel4);
//                break;
//        }
//    }

//    public void startClock(Timer timer, int seconds, String time, JLabel clockLabel){
//
//        timer = new Timer(1000, new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                time = String.format("%02d:%02d", seconds /60, seconds % 60);
//                clockLabel.setText(time2);
//
//                if (seconds <= 0){
//                    resetClock2();
//                }
//                else {
//                    seconds--;
//                }
//            }
//        });
//        timer.start();
//    }


//really redundant, will change later

    public void resetClock1(){
        try{
            timer1.stop();
            clockLabel1.setText("00:00");
        } catch (Exception e) {
            System.out.println("Error, timer probably hasn't been started yet.");
        }
    }

    public void resetClock2(){
        try{
            timer2.stop();
            clockLabel2.setText("00:00");
        } catch (Exception e) {
            System.out.println("Error, timer probably hasn't been started yet.");
        }
    }
    public void resetClock3(){
        try{
            timer3.stop();
            clockLabel3.setText("00:00");
        } catch (Exception e) {
            System.out.println("Error, timer probably hasn't been started yet.");
        }
    }
    public void resetClock4(){
        try{
            timer4.stop();
            clockLabel4.setText("00:00");
        } catch (Exception e) {
            System.out.println("Error, timer probably hasn't been started yet.");
        }
    }

    public QuadArenaScreen(GuiCreator gC){
        frame = new JFrame ("Arena Screen Prototype");
        frame.setContentPane(arenaScreenPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
    }


    public final JFrame getFrame(){
        return frame;
    }


    //Timer variables
    public Timer timer1;
    String time1;
    int seconds1;

    public Timer timer2;
    String time2;
    int seconds2;

    public Timer timer3;
    String time3;
    int seconds3;

    public Timer timer4;
    String time4;
    int seconds4;

    //frame
    private final JFrame frame;




    private JPanel arenaScreenPanel;
    public JLabel name1;
    public JLabel major1;
    public JLabel year1;
    public JLabel clockLabel1;
    public JLabel major2;
    public JLabel year2;
    public JLabel score2;
    public JLabel clockLabel2;
    public JLabel teamName1;
    public JLabel teamName2;
    public JLabel name2;
    public JLabel rotationLabel;
    public JLabel overall1;
    public JLabel overall2;
    public JLabel event1;
    public JLabel event2;
    public JLabel clockLabel3;
    public JLabel clockLabel4;
    public JLabel name3;
    public JLabel name4;
    public JLabel major3;
    public JLabel major4;
    public JLabel year3;
    public JLabel year4;
    public JLabel score3;
    public JLabel score4;
    public JLabel overall3;
    public JLabel overall4;
    public JLabel pic1;
    public JLabel pic2;
    public JLabel pic3;
    public JLabel pic4;
    public JLabel event3;
    public JLabel event4;
    public JLabel appAvg1;
    public JLabel score1;
    public JLabel appAvg3;
    public JLabel appAvg2;
    public JLabel appAvg4;
}
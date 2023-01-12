package com.sb.ip;

import java.util.Arrays;

/*
Problem description:
teamA = [1,2,3]
teamB = [2,4]

Find the number of teamA scores that are less than or equal to each of teamB's scores, return the list
 */
public class FootballScoresProblem1 {


    public static void main(String[] args) {
        int[] teamA = {8, 3, 1, 2, 3, 4, 5, 6};
        int[] teamB = {2, 4, 6};
        int[] returnArray = new int[teamB.length];
        Arrays.sort(teamA);

//        //Option-1
//        for (int i = 0; i < teamB.length; i++) {
//            int countOfTeamAScoresLessThanOrEqualToTeamBScore = 0;
//            for (int j = 0; j < teamA.length; j++) {
//                System.out.println("Option-1 :  teamB[i]=" + teamB[i] + " teamA[j]=" + teamA[j]);
//                if (teamA[j] <= teamB[i]) {
//                    countOfTeamAScoresLessThanOrEqualToTeamBScore++;
//                } else {
//                    break;
//                }
//            }
//            System.out.println("teamB[i]=" + teamB[i] + " countOfTeamAScoresLessThanOrEqualToTeamBScore=" + countOfTeamAScoresLessThanOrEqualToTeamBScore);
//            returnArray[i] = countOfTeamAScoresLessThanOrEqualToTeamBScore;
//        }
//        System.out.println(Arrays.toString(returnArray));

        //Option-2
        for (int i = 0; i < teamB.length; i++) {
            int teamBScore = teamB[i];
            int low = 0;
            int high = teamA.length - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (teamA[mid] > teamBScore) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                System.out.println("Option-2 :" + " i=" + i + " low=" + low + " high =" + high + " mid =" + mid);
            }
            returnArray[i] = low;
        }
        System.out.println(Arrays.toString(returnArray));
    }
}


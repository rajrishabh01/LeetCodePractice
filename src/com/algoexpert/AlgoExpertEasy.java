package com.algoexpert;

import java.util.*;

public class AlgoExpertEasy {
    public static void main(String[] args) {
        //1 Validate Subsequence
        int[] valSubseqIp1 = {5,1,4,5,6,7};
        int[] valSubseqIp2 = {1,4,7};

        System.out.println("The 2nd array is subsequence of 1st - " + validateSubsequence(valSubseqIp1, valSubseqIp2));

        //2 Tournament winner
        List<List<String>> competition = List.of(
                List.of("HTML", "C#"),
                List.of("C#", "Python"),
                List.of("Python", "HTML")
        );

        List<Integer> results = List.of(0,1,1);
        
        System.out.println("The winner of the tournament is " + tournamentWinner(competition, results));

    }

    private static String tournamentWinner(List<List<String>> competition, List<Integer> results) {
        String winner = "";
        int resultIdx = 0;
        Map<String,Integer> points = new HashMap<>();
        points.put(winner,0);
        for(List<String> match : competition){
            String homeTeam = match.get(0);
            String awayTeam = match.get(1);

            int result = results.get(resultIdx++);

            String currentBestTeam = null;
            if(result == 1){
                points.put(homeTeam, points.get(homeTeam)!=null?points.get(homeTeam)+1:1);
                currentBestTeam = homeTeam;

            } else if(result == 0){
                points.put(awayTeam, points.get(awayTeam)!=null?points.get(awayTeam)+1:1);
                currentBestTeam = awayTeam;

            }

            if(points.get(currentBestTeam) > points.get(winner)){
                winner = currentBestTeam;
            }

        }

        return winner;
    }

    private static boolean validateSubsequence(int[] input, int[] subseq) {
        int ip = 0, sub=0;
        while(ip<input.length && sub < subseq.length){
            if(input[ip] == subseq[sub]){
                sub++;
            }
            ip++;
        }

        return sub == subseq.length-1;
    }
}

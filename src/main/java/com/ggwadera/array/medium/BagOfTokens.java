package com.ggwadera.array.medium;

import java.util.Arrays;

/**
 * Solution for <a href="https://leetcode.com/problems/bag-of-tokens/">948. Bag of Tokens</a>
 */
public class BagOfTokens {

    /**
     * You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokens[i].
     * <p>
     * Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):
     * <ul>
     * <li>Face-up: If your current power is at least tokens[i], you may play tokens[i], losing tokens[i] power and gaining 1 score.</li>
     * <li>Face-down: If your current score is at least 1, you may play tokens[i], gaining tokens[i] power and losing 1 score.</li>
     * </ul>
     * Return the maximum possible score you can achieve after playing any number of tokens.
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int low = 0, high = tokens.length - 1;
        while (low <= high) {
            if (tokens[low] <= power) {
                // Play tokens until there's no more power
                power -= tokens[low];
                score++;
                low++;
            } else if (score > 0 && high - low > 1) {
                // If there's score and more than one token remaining,
                // play the highest token to regain power
                power += tokens[high];
                score--;
                high--;
            } else {
                // There's no score or power to do anything,
                // so exit the loop and return
                break;
            }
        }
        return score;
    }

}

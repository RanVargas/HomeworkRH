import java.util.Arrays;
import java.util.Locale;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, //Main method
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output
        int counter = 0;

        // your code ~ you will be invoking getOpinionOnFeature		
        for (String[] features :
                featureSet) {
            for (String feature :
                    features) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0){
                    featureOpinions[counter] = opinion;
                    break;
                }
            }
            counter++;
        }
        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        // your code
        int result = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (result == 0){
            result = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return result;

    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        boolean patternFound = false;

        // your code
        for (String positiveOpinion:
             posOpinionWords) {
            String positivePattern = pattern + positiveOpinion;
            patternFound = review.contains(positivePattern);
            if (patternFound){
                return ++opinion;
            }
        }
        for (String negativeOpinion :
                negOpinionWords) {
            String negativePattern = pattern + negativeOpinion;
            patternFound = review.contains(negativePattern);
            if (patternFound){
                return --opinion;
            }
        }
        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;
        
        // your code for processing each sentence. You can return if opinion is found in a sentence
        // (no need to process subsequent ones)
        for (String sentence :
                sentences) {
            for (String positiveOpinion :
                    posOpinionWords) {
                String comment = positiveOpinion + " " + feature.toLowerCase(Locale.ROOT);
                if (sentence.toLowerCase(Locale.ROOT).contains(comment)){
                    return ++opinion;
                }
            }
            for (String negativeOpinion :
                    negOpinionWords) {
                String comment = negativeOpinion + " " + feature.toLowerCase(Locale.ROOT);
                if (sentence.toLowerCase(Locale.ROOT).contains(comment)){
                    return --opinion;
                }
            }
        }

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious!" +
                " Definetly will be a frequent flyer! Francisco was very attentive";

        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude.
        // The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
        int[] otherfeatureOpinions = detectProsAndCons("Fantastic service", featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(otherfeatureOpinions));
    }
}
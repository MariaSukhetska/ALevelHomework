package ua.zhdanova.hw3;

public class Task2 {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        String[] words = str.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (isValidWord(word)) {
                count++;
            }
        }

        System.out.println("Count: " + count);
    }

    private static boolean isValidWord(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
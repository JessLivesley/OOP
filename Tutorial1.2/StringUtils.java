public class StringUtils {

    public static int countVowels(String text) {
        if (text == null || text.isEmpty()) return 0;
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    public static String reverseString(String text) {
        if (text == null) return "";
        return new StringBuilder(text).reverse().toString();
    }

    public static boolean isPalindrome(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    public static int wordCount(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        return text.trim().split("\\s+").length;
    }

    // Test cases
    public static void main(String[] args) {
        String sample = "Hi, My name is Jess";

        System.out.println("Text: \"" + sample + "\"");
        System.out.println("Vowels: " + countVowels(sample));
        System.out.println("Reversed: " + reverseString(sample));
        System.out.println("Is palindrome: " + isPalindrome(sample));
        System.out.println("Word count: " + wordCount(sample));
    }
}

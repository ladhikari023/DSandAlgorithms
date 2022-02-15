package DynamicProgramming;

public class goldmanSachs {
    public static void main(String[] args) {
    }


    public static String longestKInterspaceSubstring(String word, int k) {
        String longest = "";
        String buffer = "";
        for (int i = 0; i < word.length(); i++) {
            char start = word.charAt(i);
            char end = start;
            buffer = String.valueOf(start);
            for (int j = i+1; j < word.length(); j++) {
                char current = word.charAt(j);
                System.out.println("diff "+ start + " " + current + " " + Math.abs(current - start));
                int kFromStart = start - current;
                int kFromEnd = current - end;

                if (kFromStart < 0)
                    if (kFromStart > k && kFromEnd > k) {
                        break;
                    }
                buffer = buffer + current;
                System.out.println(buffer + "   " + longest);
                if (buffer.length() > longest.length()){
                    longest = buffer;
                }
            }
        }
        return longest;
    }

}
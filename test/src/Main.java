import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        arrayOfStrings.add("");
        arrayOfStrings.add(" our STRING");
        arrayOfStrings.add("break3ing news5:");
        arrayOfStrings.add("1A 1circle is round!");
        arrayOfStrings.add("eat;sleep;repeat");

        System.out.println(arrayOfStrings);
        System.out.println(createSingleString(arrayOfStrings));
    }

    public static String createSingleString(ArrayList<String> arrayOfStrings) {
        if (!arrayOfStrings.isEmpty()) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < arrayOfStrings.size(); i++) {
                if (!arrayOfStrings.get(i).equals("")) {
                    strBuilder.append(arrayOfStrings.get(i));
                    if (i != arrayOfStrings.size() - 1 && !arrayOfStrings.get(i).matches("[0-9]+")) {
                        strBuilder.append(" ");
                    }
                }
            }
            String title = strBuilder.toString();
            title = removeAllNumeric(title);
            if (title.charAt(0) == ' ') {
                title = title.substring(1);
            }
            title = title.replaceAll("( )+", " ");
            title = capitalize(title);
            return title;
        }
        return null;
    }

    public static String removeAllNumeric(String str) {
        str = str.replaceAll("[\\d.]", "");
        return str;
    }

    public static String capitalize(String str) {
        Set<Character> set = new HashSet<Character>(3);
        Collections.addAll(set, ' ', ',', ';');
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                strBuilder.append(str.charAt(i));
                strBuilder.append(Character.toUpperCase(str.charAt(i+1)));
                i++;
            } else {
                if(!set.contains(str.charAt(i)) && i == 0){
                    strBuilder.append(Character.toUpperCase(str.charAt(i)));
                }else {
                    strBuilder.append(str.charAt(i));
                }
            }
        }
        return strBuilder.toString();
    }
}


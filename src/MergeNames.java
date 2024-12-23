import java.util.HashSet;
import java.util.Set;

public class MergeNames
{
    
    public static String[] uniqueNames2(String[] names1, String[] names2) {
        String[] temp = new String[names1.length + names2.length];
        int index = 0;

        // Add all names from the first array
        for (String name : names1) {
            if (!contains(temp, name, index)) {
                temp[index++] = name;
            }
        }

        // Add all names from the second array
        for (String name : names2) {
            if (!contains(temp, name, index)) {
                temp[index++] = name;
            }
        }

        // Create a result array with the exact size
        String[] result = new String[index];

        System.out.println(String.join(", ",temp));
        System.out.println(String.join(", ",result));

        System.arraycopy(temp, 0, result, 0, index);

        return result;

    }

    private static boolean contains(String[] array, String value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> set = new HashSet<>();

        // Add all names from the first array
        for (String name : names1) {
           set.add(name);
        }

        // Add all names from the second array
        for (String name : names2) {
            set.add(name);
        }


        return set.toArray(new String[0]);

    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
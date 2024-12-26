import java.util.HashSet;
import java.util.Set;

// 实现uniqueNames 方法。当传递两个名称数组时，它将返回一个数组，其中包含出现在其中一个或两个数组中的名称。返回的数组应该没有重复项。
// 例如，调用MergeNames.unigueNames(new string[lf'Ava, "Emma, 'olivia'j, new string[/{olivia'Sophia;Emma})应该返回一个 包含 Ava、Emma、Olivia 和 Sophia 的数组，顺序任意。

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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
            // Set to store the results
            Set<String> result = new HashSet<>();

            // Remove XML declaration if present
            xml = xml.trim();
            if (xml.startsWith("<?xml")) {
                xml = xml.substring(xml.indexOf('>') + 1).trim();
            }
    
            // Parse the XML manually
            parseFolder(xml, startingLetter, result);
    
            return result;
    }

    private static void parseFolder(String xml, char beginningLetter, Set<String> result) {
        Pattern pattern = Pattern.compile("<folder\\s+name=\"([^\"]+)\"\\s*/>");
        Matcher matcher = pattern.matcher(xml);

        while (matcher.find()) {
            String name = matcher.group(1); // 提取 name 属性值
            if (Character.toLowerCase(name.charAt(0)) == Character.toLowerCase(beginningLetter)) {
                result.add(name);
            }
        }

        // 查找嵌套的非自闭合 folder 标签
        while (!xml.isEmpty()) {
            int startTagStart = xml.indexOf("<folder");
            if (startTagStart == -1) break;

            int startTagEnd = xml.indexOf('>', startTagStart);
            if (startTagEnd == -1) break;

            int endTagStart = xml.indexOf("</folder>", startTagEnd);
            if (endTagStart == -1) break;

            String innerXml = xml.substring(startTagEnd + 1, endTagStart);
            parseFolder(innerXml, beginningLetter, result);

            xml = xml.substring(endTagStart + 9).trim();
        }
}
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";
  

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
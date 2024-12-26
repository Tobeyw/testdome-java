// 用户界面包含两种类型的用户输入控件:Textinput，接受所有字符;Numericinput，仅接受数字。实现包含以下内容的Textinput类:
// ·公共方法void add(char c)-将给定字符添加到当前值
// 。公共方法String getValue0- 返回当前值
// 实现Numericinput类:
// 继承自 Textinput.
// 覆盖添加方法，以便忽略每个非数字字符
// 例如，以下代码应输出“10”:


public class UserInput {
    // 继承
    public static class TextInput {
        private StringBuilder value;

        public TextInput() {
            this.value = new StringBuilder();
        }

        public void add(char c) {
            value.append(c);
        }

        public String getValue() {
            return value.toString();
        }

    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                super.add(c);
            }
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
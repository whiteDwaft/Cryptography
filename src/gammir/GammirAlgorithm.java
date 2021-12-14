package gammir;

public class GammirAlgorithm {

    char[] characters = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ',
            'Э', 'Ю', 'Я', ' ', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0'};

    public String encode(String input, String keyword) {
        input = input.toUpperCase();
        keyword = keyword.toUpperCase();

        StringBuilder result = new StringBuilder();

        int keyword_index = 0;

        for (Character symbol : input.toCharArray()) {
            int c = (new String(characters).indexOf(symbol) +
                    new String(characters).indexOf(keyword.charAt(keyword_index))) % 33;

            result.append(characters[c]);

            keyword_index++;

            if ((keyword_index + 1) == keyword.length())
                keyword_index = 0;
        }

        return result.toString();
    }

    public String decode(String input, String keyword) {
        input = input.toUpperCase();
        keyword = keyword.toUpperCase();

        StringBuilder result = new StringBuilder();

        int keyword_index = 0;

        for (Character symbol : input.toCharArray()) {
            int p = (new String(characters).indexOf(symbol) + 33 -
                    new String(characters).indexOf(keyword.charAt(keyword_index))) % 33;

            result.append(characters[p]);

            keyword_index++;

            if ((keyword_index + 1) == keyword.length())
                keyword_index = 0;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GammirAlgorithm gammirAlgorithm = new GammirAlgorithm();
        System.out.println(gammirAlgorithm.encode("Борис Акунин турецкий гамбит", "нет"));
        System.out.println(gammirAlgorithm.decode(gammirAlgorithm.encode("Борис Акунин турецкий гамбит", "нет"), "нет"));

    }
}

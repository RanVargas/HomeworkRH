
import java.text.MessageFormat;


public class APIResponseParser {

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        String startRule = "<title>";
        //String title = String.valueOf(parse(response, startRule, endRule));
        //book.setTitle(title);

        // Your code
        String[] fieldsValue = new String[6];
        int counter = 0;
        String[][] fieldsToSearch = {{"title"}, {"name"},
                {"original_publication_year type=\"integer\"", "original_publication_year"},
                {"average_rating"}, {"ratings_count type=\"integer\"", "ratings_count"}, {"image_url"}};
        for (String[] field :
                fieldsToSearch) {
            String firstRule = " ";
            String secondRule = " ";
            if (field.length == 2){
                firstRule = MessageFormat.format("<{0}>", field[0]);
                secondRule = MessageFormat.format("</{0}>", field[1]);
            }else {
                firstRule = MessageFormat.format("<{0}>", field[0]);
                secondRule = MessageFormat.format("</{0}>", field[0]);
            }

            fieldsValue[counter] = parse(response, firstRule,secondRule);

            counter++;
        }
        for (int i = 0; i < fieldsToSearch.length; i++){
            switch (i) {
                case 0:
                    book.setTitle(fieldsValue[i]);
                    break;
                case 1:
                    book.setAuthor(fieldsValue[i]);
                    break;
                case 2:
                    book.setPublicationYear(Integer.parseInt(fieldsValue[i]));
                    break;
                case 3:
                    book.setAverageRating(Double.parseDouble(fieldsValue[i]));
                    break;
                case 4:
                    book.setRatingsCount(Integer.parseInt(fieldsValue[i].replaceAll("[^0-9.]", "")));
                    break;
                case 5:
                    book.setImageUrl(fieldsValue[i]);
                    break;
            }


        }
        return book;
    }

    public static String parse(String response, String initialRule, String endRule) {
        String taggedResult = response.substring(response.indexOf(initialRule), response.indexOf(endRule));
        String finalResult = taggedResult.replaceAll("<.*?>", "");
        return  finalResult;

    }

    // write overloaded parse method with the 3 parameters response, startRule, endRule

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +//
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +//
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +//
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +//
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +//
                "</author>" +
                "<image_url>" +//
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";


        Book myBook = APIResponseParser.parse(response);
        System.out.println(myBook.toString());

    }
}
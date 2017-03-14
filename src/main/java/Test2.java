import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
//import java.net.CookieManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Iman on 3/13/2017.
 */
public class Test2 {
    public static HashMap<Integer, HashMap<Integer, Integer>> city_place = new HashMap<Integer, HashMap<Integer, Integer>>();

    public static void main(String[] s) {
        final Connection connection = getMySqlConnection();
//        if (false) {
//            String a = "[{\"text\":\"آذربایجان شرقی\",\"value\":\"Azerbaijan, East\"},{\"text\":\"آذربایجان غربی\",\"value\":\"Azerbaijan, West\"},{\"text\":\"اردبیل\",\"value\":\"Ardabil\"},{\"text\":\"اصفهان\",\"value\":\"Isfahan\"},{\"text\":\"البرز\",\"value\":\"Alborz\"},{\"text\":\"ایلام\",\"value\":\"Ilam\"},{\"text\":\"بوشهر\",\"value\":\"Bushehr\"},{\"text\":\"تهران\",\"value\":\"Tehran\"},{\"text\":\"چهارمحال و بختیاری\",\"value\":\"Chahar Mahaal and Bakhtiari\"},{\"text\":\"خراسان جنوبی\",\"value\":\"Khorasan, South\"},{\"text\":\"خراسان رضوی\",\"value\":\"Khorasan, Razavi\"},{\"text\":\"خراسان شمالی\",\"value\":\"Khorasan, North\"},{\"text\":\"خوزستان\",\"value\":\"Khuzestan\"},{\"text\":\"زنجان\",\"value\":\"Zanjan\"},{\"text\":\"سمنان\",\"value\":\"Semnan\"},{\"text\":\"سیستان و بلوچستان\",\"value\":\"Sistan and Baluchestan\"},{\"text\":\"فارس\",\"value\":\"Fars\"},{\"text\":\"قزوین\",\"value\":\"Qazvin\"},{\"text\":\"قم\",\"value\":\"Qom\"},{\"text\":\"کردستان\",\"value\":\"Kurdistan\"},{\"text\":\"کرمان\",\"value\":\"Kerman\"},{\"text\":\"کرمانشاه\",\"value\":\"Kermanshah\"},{\"text\":\"کهگیلویه و بویر احمد\",\"value\":\"Kohgiluyeh and Boyer-Ahmad\"},{\"text\":\"گلستان\",\"value\":\"Golestan\"},{\"text\":\"گیلان\",\"value\":\"Gilan\"},{\"text\":\"لرستان\",\"value\":\"Lorestan\"},{\"text\":\"مازندران\",\"value\":\"Mazandaran\"},{\"text\":\"مرکزی\",\"value\":\"Markazi\"},{\"text\":\"هرمزگان\",\"value\":\"Hormozgan\"},{\"text\":\"همدان\",\"value\":\"Hamadan\"},{\"text\":\"یزد\",\"value\":\"Yazd\"}]";
//            JSONArray d = new JSONArray(a);
//            for (int i = 0; i < d.length(); i++) {
//                JSONObject jsonObject = d.getJSONObject(i);
//                System.out.print("\"" + jsonObject.getString("text") + "\",\"");
//                System.out.println(jsonObject.getString("value") + "\",");
//
//
//            }
//        }

//        readCity(connection);
        readPlaceSummery(connection);
//        String s1="'ربع رشیدی | Rob'e Rashidi";
//        String s2=s1.replace("'","\\'");
//        System.out.println(s2);


    }

    static int index;

    private static void readPlaceSummery(final Connection connection) {
//        final ArrayList<Integer> city_id = new ArrayList<Integer>();
//
//
//        try {
//            Statement statement2 = connection.createStatement();
//            String query = "select * from city s where s.main=1";
//
//
////            System.out.println(query);
//            ResultSet resultSet = statement2.executeQuery(query);
//            while (resultSet.next()) {
////                String value1 = "http://hamgardi.com/list/City-" + resultSet.getString("value");
//                city_id.add(resultSet.getInt("value"));
//            }
//            statement2.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        int city[][] = new int[][]{{120, 3},
                {303, 3},
                {163, 3},
                {211, 3},
                {126, 3},
                {314, 4},
                {102, 3},
                {379, 4},
                {126, 5},
                {109, 4},
                {204, 5},
                {379, 6},
                {314, 6},
                {258, 6},
                {175, 7},
                {433, 6},
                {458, 6},
                {388, 6},
                {444, 6},
                {254, 8},
                {458, 9},
                {466, 8},
                {388, 8},
                {175, 12},
                {303, 4},
                {290, 11},
                {329, 7},
                {268, 8},
                {197, 9},
                {268, 9},
                {55, 13},
                {35, 12},
                {466, 12},
                {249, 11},
                {81, 15},
                {223, 12},
                {329, 15},
                {24, 19},
                {24, 20},
                {24, 21},
                {35, 21},
                {223, 22},
                {223, 23},
                {81, 37},
                {81, 38},
                {1, 31},
                {1, 40},
                {1, 43},
                {1, 48},
                {1, 49},
                {1, 51},
                {1, 60},
                {1, 61},
                {1, 69},
                {1, 71},
                {1, 72},
                {1, 79},
                {1, 82},
                {1, 88},
                {1, 95},
                {1, 97}};
        for (index = 0; index < city.length; index++) {
            readPlaceSummery1(connection, city[index][0],city[index][1]);


        }

    }

    private static void readPlaceSummery1(final Connection connection, final int index, final int page) {
        new Thread(new Runnable() {
            public void run() {

                String query = null;


                try {

                    String s = parsHtml(index, page);
                    if (s != null || s.trim().length() != 0) {

                        query = "INSERT INTO `place` (`city_id`,`link`, `path`,`name`,`image_src` ) VALUES" + s.substring(0, s.length() - 2);
//                            System.out.println(s.substring(0, s.length() - 1));
                        Statement statement2 = connection.createStatement();
//                            System.out.println(query);
                        statement2.executeUpdate(query);
                        statement2.close();
                    }
                } catch (HttpStatusException e) {

                } catch (Exception e) {
                    System.out.println("--------------" + e);
                    String url = "http://hamgardi.com/list/City-" + index + "/page-" + page;
                    System.out.println(url);
//                        System.out.println(query);

                }


            }
        }).start();
    }

    private static void readPlaceSummery(final Connection connection, final int index) {
        new Thread(new Runnable() {
            public void run() {

                String query = null;

                int page = 0;
                while (page < 100) {
                    try {
                        page++;
                        String s = parsHtml(index, page);
                        if (s == null || s.trim().length() == 0)
                            break;
                        query = "INSERT INTO `place` (`city_id`,`link`, `path`,`name`,`image_src` ) VALUES" + s.substring(0, s.length() - 2);
//                            System.out.println(s.substring(0, s.length() - 1));
                        Statement statement2 = connection.createStatement();
//                            System.out.println(query);
                        statement2.executeUpdate(query);
                        statement2.close();
                    } catch (HttpStatusException e) {
                        break;
                    } catch (Exception e) {
                        System.out.println("--------------" + e);
                        String url = "http://hamgardi.com/list/City-" + index + "/page-" + page;
                        System.out.println(url);
//                        System.out.println(query);

                    }
                }

            }
        }).start();
    }


    ////                    String string = resultSet.getString("");
//                    String s1 = "http://hamgardi.com/AjaxPages/list/AjaxList.aspx/GetItems";
//                    DefaultHttpClient httpClient = new DefaultHttpClient();
//                    HttpPost getRequest = new HttpPost(s1);
//                    getRequest.addHeader("accept", "application/json, text/javascript, */*; q=0.01");
//                    getRequest.addHeader("Content-Type", "application/json; charset=UTF-8");
//                    getRequest.addHeader("Referer", "http://hamgardi.com/list/Province-Khorasan, Razavi/City-136/Country-1/");
//                    getRequest.setHeader("Host", "accounts.google.com");
//                    getRequest.setHeader("User-Agent", "Mozilla/5.0");
//
//                    getRequest.setHeader("Accept-Language", "en-US,en;q=0.5");
//                    getRequest.setHeader("Connection", "keep-alive");
////                    getRequest.setHeader("Referer", "https://accounts.google.com/ServiceLoginAuth");
////                    getRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
//
//
//                    HttpResponse response = httpClient.execute(getRequest);
//
//                    if (response.getStatusLine().getStatusCode() != 200) {
//                        continue;
//                    }
//
//                    BufferedReader br = new BufferedReader(
//                            new InputStreamReader((response.getEntity().getContent())));
//
//                    StringBuilder data = new StringBuilder();
//                    String output;
//
//                    while ((output = br.readLine()) != null) {
//                        data.append(output);
//                    }
//                    JSONObject object = new JSONObject(data.toString());


    public static String parsHtml(int args, int page) throws IOException {
//        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = "http://hamgardi.com/list/City-" + args + "/page-" + page;
//        print("Fetching %s",url);

        Document doc = Jsoup.connect(url).get();
        Elements links;

        String values = "";
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                links = doc.select("div#TopMainContent_TopMainContent_ctl0" + i + "_itemDiv");
            } else {
                links = doc.select("div#TopMainContent_TopMainContent_ctl" + i + "_itemDiv");

            }
            if (links.size() == 0)
                break;
            Element element = links.get(0);
            Element img = element.select("IMG").first();
            String image_src = img.attr("src");
            Element linkimage = element.select("a").first();
            String href = linkimage.attr("href");
            try {
                int i1 = Integer.parseInt(href.replace("/place/", ""));
                HashMap<Integer, Integer> integerIntegerHashMap = city_place.get(args);

                if (integerIntegerHashMap != null && integerIntegerHashMap.containsKey(i1))
                    return null;
                else if (integerIntegerHashMap != null) {
                    integerIntegerHashMap.put(i1, null);
                } else {
                    HashMap<Integer, Integer> integerIntegerHashMap1 = new HashMap<Integer, Integer>();
                    integerIntegerHashMap1.put(i1, null);
                    city_place.put(args, integerIntegerHashMap1);
                }
            } catch (Exception e) {

            }


            linkimage.tagName();
            linkimage.attributes();
            Elements span = element.select("span");
            String text = span.first().text();
            String path = span.get(9).text();
            values += ("(" + args + ",'" + href + "','" + text.replace("'", "") + "','" + path.replace("'", "") + "','" + image_src + "'),\n");
//            System.out.println(text);

        }
        return values;


//        print("\nImports: (%d)", imports.size());
//        for (Element link : imports) {
//            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
//        }
//
//        print("\nLinks: (%d)", links.size());
//        for (Element link : links) {
//            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//        }
    }


    private static void readCity(Connection connection) {
        String province[] = new String[]{
                "آذربایجان شرقی", "Azerbaijan, East",
                "آذربایجان غربی", "Azerbaijan, West",
                "اردبیل", "Ardabil",
                "اصفهان", "Isfahan",
                "البرز", "Alborz",
                "ایلام", "Ilam",
                "بوشهر", "Bushehr",
                "تهران", "Tehran",
                "چهارمحال و بختیاری", "Chahar Mahaal and Bakhtiari",
                "خراسان جنوبی", "Khorasan, South",
                "خراسان رضوی", "Khorasan, Razavi",
                "خراسان شمالی", "Khorasan, North",
                "خوزستان", "Khuzestan",
                "زنجان", "Zanjan",
                "سمنان", "Semnan",
                "سیستان و بلوچستان", "Sistan and Baluchestan",
                "فارس", "Fars",
                "قزوین", "Qazvin",
                "قم", "Qom",
                "کردستان", "Kurdistan",
                "کرمان", "Kerman",
                "کرمانشاه", "Kermanshah",
                "کهگیلویه و بویر احمد", "Kohgiluyeh and Boyer-Ahmad",
                "گلستان", "Golestan",
                "گیلان", "Gilan",
                "لرستان", "Lorestan",
                "مازندران", "Mazandaran",
                "مرکزی", "Markazi",
                "هرمزگان", "Hormozgan",
                "همدان", "Hamadan",
                "یزد", "Yazd"
        };
        for (int i = 0; i < province.length; i++) {
            if (i % 2 == 0)
                continue;
            String url = "http://hamgardi.com/AjaxPages/list/AjaxList.aspx/GetCity";
            try {

                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost getRequest = new HttpPost(url);
                getRequest.addHeader("accept", "application/json, text/javascript, */*; q=0.01");
                getRequest.addHeader("Content-Type", "application/json; charset=UTF-8");

                String xml = "{ProvinceName: \"" + province[i] + "\"}";
                HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
                getRequest.setEntity(entity);
                HttpResponse response = httpClient.execute(getRequest);

                if (response.getStatusLine().getStatusCode() != 200) {
                    continue;
                }

                BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

                StringBuilder data = new StringBuilder();
                String output;

                while ((output = br.readLine()) != null) {
                    data.append(output);
                }
                JSONObject object = new JSONObject(data.toString());
                Object d = object.get("d");
                JSONArray data1 = new JSONArray(d.toString());


                for (int j = 0; j < data1.length(); j++) {
                    JSONObject jsonObject = data1.getJSONObject(j);
                    String text = jsonObject.getString("text");
                    String value = jsonObject.getString("value");
                    Statement statement2 = connection.createStatement();
                    String query = ("INSERT INTO `city` (`text`, `value`, `p_text`,`p_value`)" +
                            " VALUES ('" + text + "', '" + value + "', '" + province[i] + "', '" + province[i - 1] + "');");
                    System.out.println(query);
                    statement2.executeUpdate(query);
                    statement2.close();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1) + ".";
        else
            return s;
    }

    private static Connection getMySqlConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gardeshgari?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "root", "qazzaq123");

            return connection;
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_fanoos?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "admin_fanoos", "5nEziv6W8");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_fanoos?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "root", "qazzaq123");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}

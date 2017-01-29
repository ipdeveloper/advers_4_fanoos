/**
 * Created by Iman on 12/11/2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
    private Connection currentConection;
    static Connection connection = null;


    private static void openConexion() {

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_fanoos?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "root", "qazzaq123");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_fanoos?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "admin_fanoos", "5nEziv6W8");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_fanoos?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "root", "qazzaq123");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    static String area[] = new String[]{
            "%D8%A7%D8%B1%D8%A7%DA%A9",
            "%D8%A7%D8%B1%D8%AF%D8%A8%DB%8C%D9%84",
            "%D8%A7%D8%B1%D9%88%D9%85%DB%8C%D9%87",
            "%D8%A7%D8%B3%D9%84%D8%A7%D9%85%20%D8%B4%D9%87%D8%B1",
            "%D8%A7%D8%B5%D9%81%D9%87%D8%A7%D9%86",
            "%D8%A7%D9%87%D9%88%D8%A7%D8%B2",
            "%D8%A2%D9%85%D9%84",
            "%D8%A8%D8%A7%D8%A8%D9%84",
            "%D8%A8%D8%A7%D8%A8%D9%84%D8%B3%D8%B1",
            "%D8%A8%D8%B1%D9%88%D8%AC%D8%B1%D8%AF",
            "%D8%A8%D9%86%D8%AF%D8%B1%20%D8%B9%D8%A8%D8%A7%D8%B3",
            "%D8%A8%D9%87%D8%A7%D8%B1%D8%B3%D8%AA%D8%A7%D9%86",
            "%D8%A8%D9%88%D9%85%D9%87%D9%86",
            "%D9%BE%D8%B1%D8%AF%DB%8C%D8%B3",
            "%D8%AA%D8%A8%D8%B1%DB%8C%D8%B2",
            "%D8%AA%D9%86%D9%83%D8%A7%D8%A8%D9%86",
            "%D8%AA%D9%87%D8%B1%D8%A7%D9%86",
            "%DA%86%D8%A7%D9%84%D9%88%D8%B3",
            "%D8%AE%D9%85%DB%8C%D9%86%DB%8C%20%D8%B4%D9%87%D8%B1",
            "%D8%B1%D8%B4%D8%AA",
            "%D8%B2%D9%86%D8%AC%D8%A7%D9%86",
            "%D8%B3%D8%A7%D8%B1%DB%8C",
            "%D8%B3%D9%85%D9%86%D8%A7%D9%86",
            "%D8%B3%D9%86%D9%86%D8%AF%D8%AC",
            "%8%B4%D8%A7%D9%87%DB%8C%D9%86%20%D8%B4%D9%87%D8%B1",
            "%D8%B4%D9%87%D8%B1%20%D8%AC%D8%AF%DB%8C%D8%AF%20%D8%A7%D9%86%D8%AF%DB%8C%D8%B4%D9%87",
            "%D8%B4%D9%87%D8%B1%DB%8C%D8%A7%D8%B1",
            "%D8%B4%DB%8C%D8%B1%D8%A7%D8%B2",
            "%D9%81%D8%B1%D9%8A%D8%AF%D9%88%D9%86%D9%83%D9%86%D8%A7%D8%B1",
            "%D9%82%D8%A7%D8%A6%D9%85%20%D8%B4%D9%87%D8%B1",
            "%D9%82%D8%AF%D8%B3",
            "%D9%82%D8%B2%D9%88%DB%8C%D9%86",
            "%D9%82%D8%B4%D9%85",
            "%D9%82%D9%85",
            "%DA%A9%D8%B1%D8%AC",
            "%DA%A9%D8%B1%D9%85%D8%A7%D9%86",
            "%DA%A9%D8%B1%D9%85%D8%A7%D9%86%D8%B4%D8%A7%D9%87",
            "%DA%AF%D8%B1%DA%AF%D8%A7%D9%86",
            "%D9%84%D8%A7%D9%87%D9%8A%D8%AC%D8%A7%D9%86",
            "%D9%84%D9%88%D8%A7%D8%B3%D8%A7%D9%86",
            "%D9%85%D8%B4%DA%A9%DB%8C%D9%86%20%D8%AF%D8%B4%D8%AA",
            "%D9%85%D8%B4%D9%87%D8%AF",
            "%D9%85%D9%84%D8%A7%DB%8C%D8%B1",
            "%D9%86%D9%88%D8%B1",
            "%D9%86%D9%88%D8%B4%D9%87%D8%B1",
            "%D9%87%D9%85%D8%AF%D8%A7%D9%86",
            "%D9%8A%D8%A7%D8%B3%D9%88%D8%AC",
            "%DB%8C%D8%B2%D8%AF"};


    public static void main(String[] args) {
        openConexion();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {

                try {
                    String url = "http://ibartar.com/api/v1.1/page/search?page=" + j + "&area=" + area[i] + "&chanel=main";
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet getRequest = new HttpGet(url);
                    getRequest.addHeader("accept", "application/json");
                    HttpResponse response = httpClient.execute(getRequest);

                    if (response.getStatusLine().getStatusCode() != 200) {
                        continue;
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((response.getEntity().getContent())));

                    StringBuilder data = new StringBuilder();
                    String output;
                    System.out.println("--------- " + url);
                    while ((output = br.readLine()) != null) {
                        data.append(output);
                    }
                    try {
                        parsData(i, data.toString());
                    } catch (Exception e) {
                        System.out.println(":::::" + url);
                        e.printStackTrace();
                    }


                    httpClient.getConnectionManager().shutdown();

                } catch (ClientProtocolException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

        }
    }


    private static void parsData(int city, String data) throws Exception {
        PreparedStatement preparedStatement;


        JSONObject dataO = new JSONObject(data);
        JSONArray data1 = dataO.getJSONArray("data");
        for (int i = 0; i < data1.length(); i++) {
            JSONObject jsonObject = data1.getJSONObject(i);
            JSONObject logo = jsonObject.getJSONObject("logo");
            preparedStatement = connection.prepareStatement("INSERT INTO `advers` " +
                    "(`id`, `uuid`, `title`, `address`, `description`, `tel_1`, `FullSize`, `Small`, `slugged_title`, `lng`, `slogan`, `lat`,`cityid`)  VALUES (?, ?,?,?,?,?,?,?, ?,?,?,?,?)");
            preparedStatement.setInt(1, jsonObject.getInt("id"));
            preparedStatement.setString(2, unescape_perl_string(jsonObject.getString("uuid")));
            preparedStatement.setString(3, unescape_perl_string(jsonObject.getString("title")));
            preparedStatement.setString(4, unescape_perl_string(jsonObject.getString("address")));
            String desc="";

            try {
                desc = logo.getString("description");
            } catch (Exception e) {
//                e.printStackTrace();
            }
            preparedStatement.setString(5, desc);
            preparedStatement.setString(6, unescape_perl_string(jsonObject.getString("tel_1")));
            String fff = "";
            try {
                fff = logo.getString("FullSize");
            } catch (Exception e) {
//                e.printStackTrace();
            }
            preparedStatement.setString(7,fff );
            preparedStatement.setString(8, logo.getString("Small"));
            preparedStatement.setString(9, unescape_perl_string(jsonObject.getString("slugged_title")));
            preparedStatement.setString(10, "" + jsonObject.getDouble("lng"));
            preparedStatement.setString(11, unescape_perl_string(jsonObject.getString("slogan")));
            preparedStatement.setString(12, "" + jsonObject.getDouble("lat"));
            preparedStatement.setInt(13, city);
            preparedStatement.executeUpdate();

        }


    }


    public final static String unescape_perl_string(String oldstr) {

    /*
     * In contrast to fixing Java's broken regex charclasses,
     * this one need be no bigger, as unescaping shrinks the string
     * here, where in the other one, it grows it.
     */

        StringBuffer newstr = new StringBuffer(oldstr.length());

        boolean saw_backslash = false;

        for (int i = 0; i < oldstr.length(); i++) {
            int cp = oldstr.codePointAt(i);
            if (oldstr.codePointAt(i) > Character.MAX_VALUE) {
                i++; /****WE HATES UTF-16! WE HATES IT FOREVERSES!!!****/
            }

            if (!saw_backslash) {
                if (cp == '\\') {
                    saw_backslash = true;
                } else {
                    newstr.append(Character.toChars(cp));
                }
                continue; /* switch */
            }

            if (cp == '\\') {
                saw_backslash = false;
                newstr.append('\\');
                newstr.append('\\');
                continue; /* switch */
            }

            switch (cp) {

                case 'r':
                    newstr.append('\r');
                    break; /* switch */

                case 'n':
                    newstr.append('\n');
                    break; /* switch */

                case 'f':
                    newstr.append('\f');
                    break; /* switch */

            /* PASS a \b THROUGH!! */
                case 'b':
                    newstr.append("\\b");
                    break; /* switch */

                case 't':
                    newstr.append('\t');
                    break; /* switch */

                case 'a':
                    newstr.append('\007');
                    break; /* switch */

                case 'e':
                    newstr.append('\033');
                    break; /* switch */

            /*
             * A "control" character is what you get when you xor its
             * codepoint with '@'==64.  This only makes sense for ASCII,
             * and may not yield a "control" character after all.
             *
             * Strange but true: "\c{" is ";", "\c}" is "=", etc.
             */
                case 'c': {
                    if (++i == oldstr.length()) {
                        die("trailing \\c");
                    }
                    cp = oldstr.codePointAt(i);
                /*
                 * don't need to grok surrogates, as next line blows them up
                 */
                    if (cp > 0x7f) {
                        die("expected ASCII after \\c");
                    }
                    newstr.append(Character.toChars(cp ^ 64));
                    break; /* switch */
                }

                case '8':
                case '9':
                    die("illegal octal digit");
                      /* NOTREACHED */

    /*
     * may be 0 to 2 octal digits following this one
     * so back up one for fallthrough to next case;
     * unread this digit and fall through to next case.
     */
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    --i;
                      /* FALLTHROUGH */

            /*
             * Can have 0, 1, or 2 octal digits following a 0
             * this permits larger values than octal 377, up to
             * octal 777.
             */
                case '0': {
                    if (i + 1 == oldstr.length()) {
                    /* found \0 at end of string */
                        newstr.append(Character.toChars(0));
                        break; /* switch */
                    }
                    i++;
                    int digits = 0;
                    int j;
                    for (j = 0; j <= 2; j++) {
                        if (i + j == oldstr.length()) {
                            break; /* for */
                        }
                    /* safe because will unread surrogate */
                        int ch = oldstr.charAt(i + j);
                        if (ch < '0' || ch > '7') {
                            break; /* for */
                        }
                        digits++;
                    }
                    if (digits == 0) {
                        --i;
                        newstr.append('\0');
                        break; /* switch */
                    }
                    int value = 0;
                    try {
                        value = Integer.parseInt(
                                oldstr.substring(i, i + digits), 8);
                    } catch (NumberFormatException nfe) {
                        die("invalid octal value for \\0 escape");
                    }
                    newstr.append(Character.toChars(value));
                    i += digits - 1;
                    break; /* switch */
                } /* end case '0' */

                case 'x': {
                    if (i + 2 > oldstr.length()) {
                        die("string too short for \\x escape");
                    }
                    i++;
                    boolean saw_brace = false;
                    if (oldstr.charAt(i) == '{') {
                        /* ^^^^^^ ok to ignore surrogates here */
                        i++;
                        saw_brace = true;
                    }
                    int j;
                    for (j = 0; j < 8; j++) {

                        if (!saw_brace && j == 2) {
                            break;  /* for */
                        }

                    /*
                     * ASCII test also catches surrogates
                     */
                        int ch = oldstr.charAt(i + j);
                        if (ch > 127) {
                            die("illegal non-ASCII hex digit in \\x escape");
                        }

                        if (saw_brace && ch == '}') {
                            break; /* for */
                        }

                        if (!((ch >= '0' && ch <= '9')
                                ||
                                (ch >= 'a' && ch <= 'f')
                                ||
                                (ch >= 'A' && ch <= 'F')
                        )
                                ) {
                            die(String.format(
                                    "illegal hex digit #%d '%c' in \\x", ch, ch));
                        }

                    }
                    if (j == 0) {
                        die("empty braces in \\x{} escape");
                    }
                    int value = 0;
                    try {
                        value = Integer.parseInt(oldstr.substring(i, i + j), 16);
                    } catch (NumberFormatException nfe) {
                        die("invalid hex value for \\x escape");
                    }
                    newstr.append(Character.toChars(value));
                    if (saw_brace) {
                        j++;
                    }
                    i += j - 1;
                    break; /* switch */
                }

                case 'u': {
                    if (i + 4 > oldstr.length()) {
                        die("string too short for \\u escape");
                    }
                    i++;
                    int j;
                    for (j = 0; j < 4; j++) {
                    /* this also handles the surrogate issue */
                        if (oldstr.charAt(i + j) > 127) {
                            die("illegal non-ASCII hex digit in \\u escape");
                        }
                    }
                    int value = 0;
                    try {
                        value = Integer.parseInt(oldstr.substring(i, i + j), 16);
                    } catch (NumberFormatException nfe) {
                        die("invalid hex value for \\u escape");
                    }
                    newstr.append(Character.toChars(value));
                    i += j - 1;
                    break; /* switch */
                }

                case 'U': {
                    if (i + 8 > oldstr.length()) {
                        die("string too short for \\U escape");
                    }
                    i++;
                    int j;
                    for (j = 0; j < 8; j++) {
                    /* this also handles the surrogate issue */
                        if (oldstr.charAt(i + j) > 127) {
                            die("illegal non-ASCII hex digit in \\U escape");
                        }
                    }
                    int value = 0;
                    try {
                        value = Integer.parseInt(oldstr.substring(i, i + j), 16);
                    } catch (NumberFormatException nfe) {
                        die("invalid hex value for \\U escape");
                    }
                    newstr.append(Character.toChars(value));
                    i += j - 1;
                    break; /* switch */
                }

                default:
                    newstr.append('\\');
                    newstr.append(Character.toChars(cp));
           /*
            * say(String.format(
            *       "DEFAULT unrecognized escape %c passed through",
            *       cp));
            */
                    break; /* switch */

            }
            saw_backslash = false;
        }

    /* weird to leave one at the end */
        if (saw_backslash) {
            newstr.append('\\');
        }

        return newstr.toString();
    }

    private static final void die(String foa) {
        throw new IllegalArgumentException(foa);
    }

    private static final void say(String what) {
        System.out.println(what);
    }
}
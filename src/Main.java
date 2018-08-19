import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;



public class Main {

    public static void main(String[] args) throws IOException {
        java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);
        java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(java.util.logging.Level.FINEST);

        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");

//        Connection  connection = Jsoup.connect("https://direct.dnb.com/Authentication/V2.0/").ignoreContentType(true);
        Connection  connection = Jsoup.connect("https://direct.dnb.com/v5.0/").ignoreContentType(true);

        //Connection  connection = Jsoup.connect("http://localhost:8000/as/token.oauth2").ignoreContentType(true);
        String username = "12341234";
        String password = "2134234";

        String login = username + ":" + password;
        String base64login = new String(Base64.encode(login.getBytes()));

        //connection.header("Authorization", "Basic " + base64login);
        /*connection.requestBody("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://services.dnb.com/CompanyServiceV2.0\">\n" +
                "   <soapenv:Header>\n" +
                "      <wsse:Security soapenv:mustUnderstand=\"0\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "         <wsse:UsernameToken wsu:Id=\"UsernameToken-11\">\n" +
                "            <wsse:Username>MyUserName</wsse:Username>\n" +
                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">MyPassword</wsse:Password>\n" +
                "         </wsse:UsernameToken>\n" +
                "      </wsse:Security>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <com:MatchRequest ServiceVersionNumber=\"{version}\">\n" +
                "         <MatchRequestDetail>\n" +
                "            <InquiryDetail>\n" +
                "               <DUNSNumber>804735132</DUNSNumber>\n" +
                "            </InquiryDetail>\n" +
                "            <MatchSpecification>\n" +
                "               <MatchTypeText>Basic</MatchTypeText>\n" +
                "            </MatchSpecification>\n" +
                "         </MatchRequestDetail>\n" +
                "      </com:MatchRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");*/
        //connection.header("x-dnb-user","P20000084E51ECEB4A0409890A116A57");
        //connection.header("x-dnb-pwd","132412341234");

        connection.method(Connection.Method.POST);

        System.out.println(connection.ignoreHttpErrors(true));
        Connection.Response r = connection.execute();
        System.out.println("Status code: " + r.statusCode());
        Document doc = r.parse();
                String title = doc.title();
        System.out.println(title);
        System.out.println(connection.request().data());

        r.headers().forEach((k,v)->System.out.println(k + " - " + v));
        System.out.println("*********");
        System.out.println(doc.html());


	// write your code here
    }
}

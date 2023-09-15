import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainController {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {

            String fileName = "C:/syy/title.txt";
            FileWriter fw = new FileWriter(fileName, true); // 추가모드
            PrintWriter out = new PrintWriter(fw, true);

            String URL = "https://www.g2b.go.kr:8340/body.do?kwd=LMS&category=LSB&subCategory=ALL&detailSearch=false&sort=R&reSrchFlag=false&pageNum=1&srchFd=ALL&date=&startDate=&endDate=&startDate2=&endDate2=&orgType=balju&orgName=&orgCode=&swFlag=Y&dateType=&area=&gonggoNo=&preKwd=&preKwds=&body=yes&orgSrchFlag=false";
            // 2021-2023 총 11페이지
            String params = "?page="
                    + "kwd=LMS&category=LSB&subCategory=ALL&detailSearch=false&reSrchFlag=false&pageNum=1&sort=R&srchFd=ALL&date=&startDate=&endDate=&year=&orgType=balju&orgName=&orgCode=&swFlag=&dateType=&area=&gonggoNo=&preKwd=&preKwds=&orgSrchFlag=";
            Document doc = Jsoup.connect(URL + params).get();

            Elements elements = doc.select("ul.search_list");
            for (Element element : elements) {
                out.println(element.text());
            } // for end
            System.out.println("title.txt 파일 완성!");
        } catch (Exception e) {
            System.out.println("크롤링 실패 : " + e);
        } // end

    } // main() end
}
// class end
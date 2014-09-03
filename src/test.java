import java.net.URL;
import java.util.Collections;
import java.util.List;

//import com.newsapp.boilerpipe.image.Image;
//import com.newsapp.boilerpipe.image.ImageExtractor;

import de.l3s.boilerpipe.BoilerpipeExtractor;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;


/**
 * Created by konka on 14-9-3.
 * <p/>
 * public static void main(String[] args) throws Exception {
 * String url = "http://finance.people.com.cn/money/n/2014/0903/c42877-25591413.html";
 * TextDocument doc = new BoilerpipeSAXInput(new InputSource(new URL(url).openStream()))
 * .getTextDocument();
 * BoilerpipeExtractor extractor = CommonExtractors.ARTICLE_EXTRACTOR;
 * extractor.process(doc);
 * System.out.println("title:" + doc.getTitle());
 * System.out.println("content:" + doc.getContent());
 * <p/>
 * }
 */
public class test {
    public static void main(String args[]) throws Exception {
        System.out.println("test");


        try {
            //String url = "http://www.36kr.com/p/215052.html";
            //String url = "http://finance.people.com.cn/bank/n/2014/0903/c202331-25592292.html";
            //NG String url = "http://www.edu.cn/jiu_ye_xin_wen_11362/20140902/t20140902_1170350.shtml";
            String url = "http://www.edu.cn/focus_1658/20140702/t20140702_1145087.shtml";


            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(url));
            final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            String title = doc.getTitle();
            System.out.println(title);

            String content = ArticleExtractor.INSTANCE.getText(doc);
            System.out.println(content);
            //TextDocument doc = new BoilerpipeSAXInput(new InputSource(new URL(url).openStream())).getTextDocument();
            //BoilerpipeExtractor extractor = CommonExtractors.ARTICLE_EXTRACTOR;
            //extractor.process(doc);
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            throw e;
        }finally {
            System.out.println("error");
        }

        //System.out.println("content:" + doc.getContent());
    }
}

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * https://www.cnblogs.com/pxblog/p/14617688.html
 * @author yvioo。
 */

public class AsposeUtilTest {

    /**
     * 验证License 若不验证则转化出的pdf文档会有水印产生
     * @return
     */
    public  boolean getLicense() {
        boolean result = false;
        try {
            InputStream is =this.getClass().getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * java -jar  JavaLearn.jar "D:/project_new/crm_standalone/target/new400.docx" "D:/project_new/crm_standalone/target/new400-222.pdf"
     * java -jar JavaLearn.jar "/home/java/new400.docx"  "/home/java/new400.pdf"
     *  @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        for (String a : args){
            System.out.println(a);
        }
        String input = args[0];
        String output = args[1];
        AsposeUtilTest bean = new AsposeUtilTest();
//        bean.word2Pdf2("D:\\project_new\\crm_standalone\\target\\new400——11111111.docx","D:\\project_new\\crm_standalone\\target\\new400——11111111.pdf");
        bean.word2Pdf2(input, output);
    }

    /**
     * word转pdf
     * inpath: 输入word的路径
     * outpath: 输出pdf的路径
     */
    public  void word2Pdf2(String inpath,String outpath) throws Exception {
        if (!getLicense()) {
            System.out.println("非法------------");
            return;
        }

        long old = System.currentTimeMillis();
        File file = new File(outpath);

        FileOutputStream os = new FileOutputStream(file);

        //解决乱码
        //如果是windows执行，不需要加这个
        //TODO 如果是linux执行，需要添加这个*****
        //FontSettings.setFontsFolder("/usr/share/fonts",true);

        Document doc = new Document(inpath);

        //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        doc.save(os, SaveFormat.PDF);
        long now = System.currentTimeMillis();
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
    }


    /**
     * word转pdf
     * @param path      pdf输出路径
     * @param wordInput word输入流
     * @param wordName  word文档的名称
     */
    public  void word2pdf(String path, InputStream wordInput, String wordName) throws FileNotFoundException {
        if (!getLicense()) {
            System.out.println("非法");
            return;
        }

        //新建一个空白pdf文档
        long old = System.currentTimeMillis();
        File file = new File(path + wordName + ".pdf");
        FileOutputStream os = new FileOutputStream(file);

        //Address是将要被转化的word文档
        Document doc = null;
        try {
            doc = new Document(wordInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long now = System.currentTimeMillis();
        //转化用时
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
    }
}

import java.io.IOException;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcifs.util.Base64;


//import sun.misc.BASE64Encoder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros
 */
public class TestPortalEros {
    
    
    public static void main(String ... args){
        
        
//                System.out.println(RegexUtils.getStringFromStringBySeparator("localhost:8080/portal/","|","|")); 
        
        
//        String url = "paralalise.portal/";
        
//        LabUsuario usu = OracleHelper.getLabUsuario("EROS", "DAFTPUNK");
//        System.out.println("Usuario: "+usu.getUsuStCodigo());
        
        
//        Pattern p = Pattern.compile("[,\\s]+\\[]");
        // Split input with the pattern
//        String[] result = 
//                p.split(url);
//                 p.split("one,two, three   four ,  five");
                
//        for (int i=0; i<result.length; i++)
//            System.out.println(result[i]);
        
        
//        String str = "This is String , split by StringTokenizer, created by mkyong";
//		StringTokenizer st = new StringTokenizer(url);
//                                     String strDBName = "padrao";
//		System.out.println("---- Split by space ------");
//		while (st.hasMoreElements()) {
//			System.out.println(st.nextElement());
//		}
// 
//		System.out.println("---- Split by comma ',' ------");
//		StringTokenizer st2 = new StringTokenizer(url, ",");
// 
//		while (st2.hasMoreElements()) {
//			System.out.println(st2.nextElement());
//		}
//                
//                
//                                    System.out.println("---- Split by point ':' ------");
                                    
//		StringTokenizer st3 = new StringTokenizer(url, ".");
//		while (st3.hasMoreElements()) {
////			System.out.println(st3.nextElement());
//                                                        strDBName = st3.nextElement().toString();
//                                                        break;
//		}
//                            System.out.println(strDBName);
        
//        String log = null;
//        
//    Random randomGenerator = new Random();
//    for (int idx = 1; idx <= 10; ++idx){
//      long randomInt = randomGenerator.nextLong();
//      log = "Generated : " + randomInt;
//    }
//        
//        System.out.println(log);
        
//        IFrameHolder ih = new IFrameHolder();
//        
//        IFramePage iFramePage1 = new IFramePage("00067", "../../WEB-INF/reports/producao/relatorio_producao.xhtml", "ui-icon-document", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00067", iFramePage1);
//        IFramePage iFramePage2 = new IFramePage("00111", "../../WEB-INF/reports/exame_lote/relatorio_exame_lote.xhtml", "ui-icon-document", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00111", iFramePage2);
//        IFramePage iFramePage3 = new IFramePage("00082", "../../WEB-INF/reports/exame_requisicao/relatorio_exame_requisicao.xhtml", "ui-icon-document", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00082", iFramePage3);
//        IFramePage iFramePage4 = new IFramePage("00093", "../../WEB-INF/reports/exame_prontuario/relatorio_exame_prontuario.xhtml", "ui-icon-document", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00093", iFramePage4);
//        IFramePage iFramePage5 = new IFramePage("00114", "../../WEB-INF/reports/pendencia/relatorio_pendencia.xhtml", "ui-icon-document", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00114", iFramePage5);
//        IFramePage iFramePage6 = new IFramePage("00062", "../../WEB-INF/charts/monitorfaturamento.xhtml", "ui-icon-image", "estatisticafaturamentoViewBean",false,true);
//        ih.getMapIFramePages().put("00062", iFramePage6);
//        IFramePage iFramePage7 = new IFramePage("00022", "../../under.xhtml", "ui-icon-image", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00022", iFramePage7);
//        IFramePage iFramePage8 = new IFramePage("00010", "../../under.xhtml", "ui-icon-image", "estatisticafaturamentoViewBean",true,true);
//        ih.getMapIFramePages().put("00010", iFramePage7);
//        
//        
//        
//        XStream xstream = new XStream();
//        String xml =xstream.toXML(ih);
//        IOUtils.saveStringToFile(ArrayItems.strURLPdfPath+"iframeholder.xml", xml);
//        
//        xstream = new XStream();
//        xstream.alias("iframeHolder", IFrameHolder.class);
////        System.out.println(xml);
//        IFrameHolder  iframeHolder = (IFrameHolder) xstream.fromXML(xml);
//        System.out.println(iframeHolder.toString());
        
        
//        String helloEncode = "Hello world";
        String hello = "SGVsbG8gV29ybGQ=";
 
        //
        // Decode a previously encoded string using decodeBase64 method and
        // passing the byte[] of the encoded string.
        //
        byte[] decoded = Base64.decode(hello);
 
        //
        // Print the decoded array
        //
//        System.out.println(Arrays.toString(decoded));
//        System.out.println(Base64.encode(helloEncode.getBytes()));
        //
        // Convert the decoded byte[] back to the original string and print
        // the result.
        //
        String decodedString = new String(decoded);
//        System.out.println(hello + " = " + decodedString);
        
        String primeiroEncode = "LISNETSISTEMAS|geslab|TCHORT";
        
        primeiroEncode = Base64.encodeString(primeiroEncode);
        primeiroEncode = Base64.encodeString(primeiroEncode);
        
        
        System.out.println(primeiroEncode);
//        String strR = "report.pdf";
//        System.out.println(strR.substring(strR.length()-1,strR.length()));
        

//        VelocityContext context = new VelocityContext();
//        context.put("name", "Mark");
//        context.put("invoiceNumber", "42123");
//        context.put("dueDate", "June 6, 2009");
//
//        String template = "Hello $name. Please find attached invoice" +
//                          " $invoiceNumber which is due on $dueDate.";
//        StringWriter writer = new StringWriter();
//        try {
//            Velocity.evaluate(context, writer, "TemplateName", template);
//        } catch (ParseErrorException ex) {
//            Logger.getLogger(TestPortalEros.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MethodInvocationException ex) {
//            Logger.getLogger(TestPortalEros.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ResourceNotFoundException ex) {
//            Logger.getLogger(TestPortalEros.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(TestPortalEros.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(writer);
        
        
        String msg = "http://{0}.lisnet.com.br/lisupdate/auditoria";
        String[] values = {"paranalise"};
        System.out.println(MessageFormat.format(msg, (Object[]) values));
        
        
    }
    
}

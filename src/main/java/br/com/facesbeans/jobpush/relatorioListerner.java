///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.facesbeans.jobpush;
//
//import br.com.facesbeans.jobpush.RelatorioStorage;
//import br.com.facesbeans.utils.JSFHelper;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.jws.WebService;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//
///**
// *
// * @author eros
// */
//@WebService(serviceName = "relatorioListerner")
//public class relatorioListerner {
//    
//    
//
//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "relUpdate")
//    public String relUpdate(@WebParam(name = "strUser") String strUser, @WebParam(name = "strPass") String strPass, 
//    @WebParam(name = "strRelCodigo") String strRelCodigo, @WebParam(name = "strStatus") String strStatus, 
//    @WebParam(name = "strUsuarioDemanda") String strUsuarioDemanda,   @WebParam(name = "strDbName") String strDbName) {
////        System.out.println("strUser: "+strUser+" strPass: "+strPass+"  strRelInCodigo: "+strRelCodigo);
//        if(strUser != null && strPass != null && strRelCodigo != null){
////            System.out.println("It's not null... at alll..........dude");
//            if(strUser.equalsIgnoreCase("EROS") && strPass.equalsIgnoreCase("DAFTPUNK")){
////                System.out.println("Validaded....dude");
//                strRelCodigo = strRelCodigo.replaceAll("\\D", "");
////                System.out.println("strRelCodigo done: "+strRelCodigo);
//                if(!strRelCodigo.isEmpty()){
////                    RelStorageKey relkey = new RelStorageKey(strUser.toUpperCase(), strDbName.toUpperCase());
//                    if(RelatorioStorage.updateRelatorioDados(strRelCodigo,strUsuarioDemanda,strDbName.toUpperCase())){
//                        return "atualizado";
//                    }else{
//                         System.out
//                                 .println("relatorioListener:   RelatorioStorage.updateRelatorioDados(strRelCodigo,relkey)   strUsuarioDemanda.toUpperCase():  "
//                                 +strUsuarioDemanda.toUpperCase()+"   strDbName.toUpperCase():  "+strDbName.toUpperCase()   );
//                    }
//                }else{
//                    System.out.println("relatorioListener:   strUser.equalsIgnoreCase(EROS) && strPass.equalsIgnoreCase(DAFTPUNK)   !strRelCodigo.isEmpty()");
//                }
//                
//            }else{
//                System.out.println("relatorioListener:   strUser.equalsIgnoreCase(EROS) && strPass.equalsIgnoreCase(DAFTPUNK)");
//            }
//        }else{
//            System.out.println("relatorioListener:   strUser != null && strPass != null && strRelCodigo != null");
//        }
//        return "pipocou";
//    }
//}

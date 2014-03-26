/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.utils.OracleHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eros
 */
@WebServlet(name = "pdfstreamer", urlPatterns = {"/PdfStreamer"})
public class PdfStreamer extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            pdfGiver(request, response);
        } finally {
        }
    }

    private void pdfGiver(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {


//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Inside pdfGiver.......>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String strRelInCodigo = (String) request.getParameter("relincodigo");
        String strDbName = (String) request.getParameter("dbname");
        if (strRelInCodigo != null) {
            LabRelatorios lr = null;
             lr = (LabRelatorios) OracleHelper.getObject(LabRelatorios.class, new Long(strRelInCodigo.replaceAll("\\D", "")),strDbName.toUpperCase());
            
            if (lr != null) {
//                System.out.println("LabRelatorio  is not null.........");
//                    String contextPath = getServletContext().getRealPath(File.separator);
                    File pdfFile = new File(ArrayItems.strURLPdfPath+lr.getRelStPdfNome());//(contextPath +pdfFileName);

                    if (pdfFile.exists()) {
//                        System.out.println("Pdf file  is not null.........");
                        if(lr.getRelStPdfNome().substring(lr.getRelStPdfNome().length()-1, lr.getRelStPdfNome().length()).toString().equalsIgnoreCase("f")){
                            response.setContentType("application/pdf");
                            response.addHeader("Content-Disposition", "filename=" + lr.getRelStPdfNome());
                        }else{  
                            response.setContentType("application/xls");
                            response.addHeader("Content-Disposition", "attachment; filename=" + lr.getRelStPdfNome());
                        }

                        


                        response.setContentLength((int) pdfFile.length());
                        FileInputStream fileInputStream = new FileInputStream(pdfFile);
                        OutputStream responseOutputStream = response.getOutputStream();


                        int bytes;

                        while ((bytes = fileInputStream.read()) != -1) {
                            responseOutputStream.write(bytes);
                        }
                        responseOutputStream.flush();
                        responseOutputStream.close();
                        
                        if(lr.getRelChNew().toString().equalsIgnoreCase("S")){
                            lr.setRelChNew('N');
                            OracleHelper.updateObject(lr,strDbName);
//                            RelStorageKey relkey = new RelStorageKey(lr.getUsuStCodigo(), strDbName);
//                            RelatorioStorage.updateRelatorioDados(lr.getRelInCodigo().toString(),lr.getUsuStCodigo(),strDbName.toUpperCase());
                        }
                        
                        
                    }else{
                        System.out.println("Pdf file  is null.........");
                    }
            }else{
                System.out.println("LabRelatorio  is null.........");
            }
        }else{
            System.out.println("reincodigo is null................");
        }



    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

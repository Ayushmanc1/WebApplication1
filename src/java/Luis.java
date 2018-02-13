/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author AChauhan4
 */
public class Luis extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void QNA(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        LuisGetRequest luis = new LuisGetRequest();
        String Req = request.getParameter("TextBox1");
        HttpSession s = request.getSession(false);
        String Sessiondata=  s.getAttribute("Chat").toString();
         String ResponceQNA=  luis.QNA(Req);
         Sessiondata+=";"+Req;
                           if(ResponceQNA.toLowerCase().contains("resourcenotfound"))
                           {
                            Sessiondata+=";"+"Network issue QNA maker"+ResponceQNA; 
                            s.setAttribute("Chat", Sessiondata);  
                            response.sendRedirect("ChatBot POC.jsp");
                            return;
                           }    
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Req = request.getParameter("TextBox1");
            LuisGetRequest luis = new LuisGetRequest();
            HttpSession s = request.getSession(false);
           String Sessiondata=  s.getAttribute("Chat").toString();
           Sessiondata+= ";"+Req;
                double d=0;
           //Sessiondata+= ":"+luis.main(Request);
           //out.println(luis.main(Req));
           String resp =luis.main(Req);
           if(resp.contains("Get rr"))
           {
               String SkillSet="",RRID="",Vendor="";
               String subres[] = resp.split(",");
                for(int i = 0;i<subres.length;i++)
                {
                    String sub[] = subres[i].split(":");
                    if(sub[0].contains("score"))
                    {
                        String ss = sub[1].replace('}', ' ');
                    d=  Double.parseDouble(ss);                   
                        if(d==1 || d>0.60)
                        {
                            
               String getdata[] = Req.split(" ");
               for(int count =0;count<getdata.length;count++)
               {
                   if(getdata[count].equalsIgnoreCase("SkillSet"))
                   {
                       SkillSet=getdata[count+1];
                   }
                   else if(getdata[count].equalsIgnoreCase("Vendor"))
                   {
                       Vendor= getdata[count+1];
                   }
                   else if(getdata[count].equalsIgnoreCase("rrid"))
                   {
                       RRID = getdata[count+1];
                   }
                   else if(getdata[count].equalsIgnoreCase("all"))
                   {
                    RR rr = new RR();
                   Sessiondata+=";"+ rr.RR();
                   s.setAttribute("Chat", Sessiondata);  
             response.sendRedirect("ChatBot POC.jsp");
             return;
                   }
                   else
                   {
                       if(RRID==""&SkillSet==""&Vendor==""& !getdata[count].equalsIgnoreCase("get") && !getdata[count].equalsIgnoreCase("all")&& !getdata[count].equalsIgnoreCase("rr"))
                       {
                         BufferedReader brS = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/SkillSet"));
                         BufferedReader brV = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/POC/Vendor"));
                         String coreVendor = brV.readLine();
                         String Coreskill = brS.readLine();
                         brV.close();
                         brS.close();
                         if(coreVendor.toLowerCase().contains(getdata[count].toLowerCase()))
                         {
                             Vendor = getdata[count];
                         }
                         else if(Coreskill.toLowerCase().contains(getdata[count].toLowerCase()))
                         {
                             SkillSet= getdata[count];
                         }
                         else
                         {
             //s.setAttribute("Chat", "Not able to get vendor and skillset.</br>Kindly add Skillset/Vender or add them in Vender& SkillSet DB ");  
             //response.sendRedirect("ChatBot POC.jsp");
                         }
                       }
                   }
               }
               if(RRID !="")
               {
                   RR rr = new RR();
                   Sessiondata+=";"+ rr.RR(RRID);
                   s.setAttribute("Chat", Sessiondata);  
             response.sendRedirect("ChatBot POC.jsp");               
             return;
               }
               else if(Vendor !="" && SkillSet!="")
               {
                   RR rr = new RR();
                   Sessiondata+=";"+ rr.RR(Vendor,SkillSet);
                   s.setAttribute("Chat", Sessiondata);  
             response.sendRedirect("ChatBot POC.jsp");               
             return;
               }
               else if(Vendor != "")
               {
                   RR rr = new RR();
                   Sessiondata+=";"+ rr.RRVendor(Vendor);
                   s.setAttribute("Chat", Sessiondata);  
             response.sendRedirect("ChatBot POC.jsp");               
             return;
               }
               else if(SkillSet !="")
               {
                   RR rr = new RR();
                   Sessiondata+=";"+ rr.RRSkillSet(SkillSet);
                   s.setAttribute("Chat", Sessiondata);  
             response.sendRedirect("ChatBot POC.jsp");               
             return;
               }
               else
               {    
                   String ResponceQNA=  luis.QNA(Req);
                           if(ResponceQNA.toLowerCase().contains("resourcenotfound"))
                           {
                            Sessiondata+=";"+"Network issue QNA maker"+ResponceQNA; 
                            s.setAttribute("Chat", Sessiondata);  
                            response.sendRedirect("ChatBot POC.jsp");
                            return;
                           }
               }   
                        }
                        else 
                        {
                            QNA(request, response);
                        }
                    } 
            }
           }
           else if(resp.contains("thankyou"))
           {
               String subres[] = resp.split(",");
                for(int i = 0;i<subres.length;i++)
                {
                    String sub[] = subres[i].split(":");
                    if(sub[0].contains("score"))
                    {
                        String ss = sub[1].replace('}', ' ');
                    d=  Double.parseDouble(ss);                   
                        if(d==1 || d>0.60)
                        {
               RR rr = new RR();
               Sessiondata +=";" + rr.Thankyou(Req,"thankyou");
                 s.setAttribute("Chat", Sessiondata);  
               response.sendRedirect("ChatBot POC.jsp");
               return;
                        }
                        else
                        {
                            QNA(request, response);
                        }
                    }
                }
           }
           else if(resp.contains("create rr"))
           {
               String subres[] = resp.split(",");
                for(int i = 0;i<subres.length;i++)
                {
                    String sub[] = subres[i].split(":");
                    if(sub[0].contains("score"))
                    {
                        String ss = sub[1].replace('}', ' ');
                    d=  Double.parseDouble(ss);                   
                        if(d==1 || d>0.60)
                        {
                            
                        }
                        else
                        {
                            QNA(request, response);
                        }
                    }
                }
           }
           else if(resp.contains("greetings"))
           {
               String subres[] = resp.split(",");
                for(int i = 0;i<subres.length;i++)
                {
                    String sub[] = subres[i].split(":");
                    if(sub[0].contains("score"))
                    {
                        String ss = sub[1].replace('}', ' ');
                    d=  Double.parseDouble(ss);                   
                        if(d==1 || d>0.60)
                        {
               RR rr = new RR();
               Sessiondata +=";" + rr.Thankyou(Req,"greetings");
                 s.setAttribute("Chat", Sessiondata);  
               response.sendRedirect("ChatBot POC.jsp");
               return;
                        }
                        else
                    {
                        QNA(request, response);
                    }   
                    }
                }
           }
           else 
           {
                        QNA(request, response);
           }
           //
           //response.sendRedirect("ChatBot POC.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

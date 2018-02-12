<%-- 
    Document   : ChatBot POC
    Created on : Feb 11, 2018, 6:17:33 PM
    Author     : AChauhan4
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head >
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>GIMIS</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    
    <style type="text/css">
    .chat
{
    list-style: none;
    margin: 0;
    padding: 0;
}

.chat li
{
    margin-bottom: 10px;
    padding-bottom: 5px;
    border-bottom: 1px dotted #B3A9A9;
    grid-auto-rows:auto;
}

.chat li.left .chat-body
{
    margin-left: 60px;
}

.chat li.right .chat-body
{
    margin-right: 60px;
}


.chat li .chat-body p
{
    margin: 0;
    color: #777777;
}

.panel .slidedown .glyPlaceHolder1icon, .chat .glyPlaceHolder1icon
{
    margin-right: 5px;
}

.panel-body
{
    overflow-y: scroll;
    overflow:scroll;
    height: 430px;
}

::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

    </style>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function () { };
        var defaultCSS = document.getElementById('bootstrap-css');
        function WebChatGoToBottom() {
            var divChat = document.getElementById('panel-body');
            divChat.scrollTop = divChat.scrollHeight;
        }
        function changeCSS(css) {
            if (css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="' + css + '" type="text/css" />');
            else $('head > link').filter(':first').replaceWith(defaultCSS);
        }
        $(document).ready(function () {
            window.setInterval(function () {
            var iframe_height = parseInt($('html').height());
            window.parent.postMessage(iframe_height, 'https://bootsnipp.com');
        });
    </script>
</head>
<body style="background-image: url('assets/images/iStock_19158844_MEDIUM.jpg')" onload="WebChatGoToBottom();">
            <form id="form1" action="Luis" method="POST">
	<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyPlaceHolder1icon glyPlaceHolder1icon-comment"></span> <strong><i>GAssist</i> </strong>- GMIS Conversional BOT
                    <div class="btn-group pull-right">
                        
                        <ul class="dropdown-menu slidedown">
                            <li><a href="#"><span class="glyPlaceHolder1icon glyPlaceHolder1icon-refresh">
                            </span>Refresh</a></li>
                            <li><a href="#"><span class="glyPlaceHolder1icon glyPlaceHolder1icon-ok-sign">
                            </span>Available</a></li>
                            <li><a href="#"><span class="glyPlaceHolder1icon glyPlaceHolder1icon-remove">
                            </span>Busy</a></li>
                            <li><a href="#"><span class="glyPlaceHolder1icon glyPlaceHolder1icon-time"></span>
                                Away</a></li>
                            <li class="divider"></li>
                            <li><a href="#"><span class="glyPlaceHolder1icon glyPlaceHolder1icon-off"></span>
                                Sign Out</a></li>
                        </ul>
                    </div>
                </div>
                
                <div class="panel-body">
                    <ul class="chat">
                        <% int i = 0;//System.currentTimeMillis();
                            String data = "";
                            if (i >= 0 & i <= 11)
                            {
                                data = "Good Mooring";
                            }
                            else if (i >= 12 & i <= 16)
                            {
                                data = "Good Afternoon";
                            }
                            else if (i >= 17 & i <= 20)
                            {
                                data = "Good Evening";
                            }
                            else
                            {
                                data = "Good Evening";
                            }
                            if (session.getAttribute("Chat") == null)
                            {
                                session.setAttribute("Chat","Hi," + data + " Prakash ZALKIKAR I am <b>GAssist</b> and I am here to assist you with any questions related to Resource Requisition and Leave module of GIMS system. I also can help you to quickly create new Resource Requisition request and see the status of all your Resource Requisitions.Let's get started...");
                            }

                            if (session.getAttribute("Chat") != null)
                            {
                                String[] chat = session.getAttribute("Chat").toString().split(";");
                                for (int ii = 0; ii < chat.length;ii++)
                                {
                                    if (chat[ii] != "")
                                    {
                                        try
                                        {
                                            if (ii % 2 != 0)
                                            {%>
                                        <li class="right clearfix">
                                                   <span class="chat-img pull-right">
                                <img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle" />
                            </span>
			<span class="chat-img pull-left">
                        </span>
                            <div class="chat-body clearfix">
                                <div class='header'>
                                </div>
                                <p>
                                   <%=chat[ii] %>
                                </p>
                            </div>
                        </li>
                                    <%
                                        }
                                        else {
                                            %>
                        <li class="left clearfix">
                                                   <span class="chat-img pull-left">
                                <img src="assets/images/Bot.jpg" style="height:50px;width:50px" alt="User Avatar" class="img-circle" />
                            </span>
			<span class="chat-img pull-left">
                        </span>
                            <div class="chat-body clearfix">
                                <div class='header'>
                                </div>
                                <p>
                                   <%=chat[ii] %>
                                </p>
                            </div>
                        </li>

                                    <%}
                                }
                                catch (Exception ex)
                                {%>

                        <li class="left clearfix">
                                                   <span class="chat-img pull-left">
                                <img src="assets/images/Bot.jpg" alt="User Avatar" class="img-circle" />
                            </span>
			<span class="chat-img pull-left">
                        </span>
                            <div class="chat-body clearfix">
                                <div class='header'>
                                </div>
                                <p>
                                   <%=chat[ii] %>
                                </p>
                            </div>
                        </li>
                                <%}
                                %>
                     
                        <%
                                    }
                                }
                            }

                            %>

                        
                        
                    </ul>
                </div>
                    
                <div class="panel-footer">
                    <div class="input-group">
                        <input type="text" name="TextBox1" value="" AutoCompleteType="Disabled" class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <input type="submit" value="Send" class="btn btn-warning btn-sm"/>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

	<script type="text/javascript">
</script>
            </form>     
</body>
</html>


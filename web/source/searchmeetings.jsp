<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %><html>
    <head>
<meta http-equiv="content-type" content="text/html";charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
    <s:debug/>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong>admin</strong>
                <a href="changepassword.jsp">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索会议
                </div>
                <form action="getAllMeetingByWord.action">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" name="meetingName" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" name="roomName" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" name="reservername" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" name="berforeReserve" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" name="AfterReserve" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" name="beforeEnd" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" name="afterEnd" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">${count}</span>条结果，
                            分成<span class="info-number">${page}</span>页显示，
                            当前第<span class="info-number">${currentPage}</span>页
                        </div>
                        <div class="header-nav">
                            <a href="getAllMeetingByWord.action?meetingName=${meetingName}&roomName=${roomName}&reservername=${reservername}&berforeReserve=${berforeReserve}&AfterReserve=${AfterReserve}&beforeEnd=${beforeEnd}&afterEnd=${afterEnd}&offset=0" class="clickbutton">首页</a>
                            <a href="getAllMeetingByWord.action?meetingName=${meetingName}&roomName=${roomName}&reservername=${reservername}&berforeReserve=${berforeReserve}&AfterReserve=${AfterReserve}&beforeEnd=${beforeEnd}&afterEnd=${afterEnd}&offset=${offset-5}" class="clickbutton">上页</a>
                            <a href="getAllMeetingByWord.action?meetingName=${meetingName}&roomName=${roomName}&reservername=${reservername}&berforeReserve=${berforeReserve}&AfterReserve=${AfterReserve}&beforeEnd=${beforeEnd}&afterEnd=${afterEnd}&offset=${offset+5}" class="clickbutton">下页</a>
                            <a href="getAllMeetingByWord.action?meetingName=${meetingName}&roomName=${roomName}&reservername=${reservername}&berforeReserve=${berforeReserve}&AfterReserve=${AfterReserve}&beforeEnd=${beforeEnd}&afterEnd=${afterEnd}&offset=${page*5-4}" class="clickbutton">末页</a>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>会议室名称</th>
                        <th>预定者</th>
                        <th>会议名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="o" var="os" >

                    <tr>
                        <td><s:property value="#os[0]"/> </td>
                        <td><s:property value="#os[1]"/></td>
                        <td><s:property value="#os[2]"/></td>
                        <td><s:property value="#os[3]"/></td>
                        <td><s:property value="#os[4]"/></td>
                        <td><s:property value="#os[5]"/></td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.jsp">查看详情</a>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>
package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.service.MeetingService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.orm.jpa.vendor.OpenJpaDialect;

import java.util.List;

/**
 * Created by wei on 15/6/8.
 */
public class MeetingAction extends ActionSupport {
    private MeetingService meetingService;
    private List<Object[]> day7;
    private List<Object[]> canceled;
    private List<Object[]> reserved;
    private List<Object[]> invited;
    private List<Object[]> Meetingemployees;

    public List<Object[]> getMeetingemployees() {
        return Meetingemployees;
    }

    public void setMeetingemployees(List<Object[]> meetingemployees) {
        Meetingemployees = meetingemployees;
    }

    public List<Object[]> getDay7() {
        return day7;
    }

    public void setDay7(List<Object[]> day7) {
        this.day7 = day7;
    }

    public List<Object[]> getCanceled() {
        return canceled;
    }

    public void setCanceled(List<Object[]> canceled) {
        this.canceled = canceled;
    }

    public List<Object[]> getReserved() {
        return reserved;
    }

    public void setReserved(List<Object[]> reserved) {
        this.reserved = reserved;
    }

    public List<Object[]> getInvited() {
        return invited;
    }

    public void setInvited(List<Object[]> invited) {
        this.invited = invited;
    }

    public void setMeetingService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    //寻找7天内的会议
    public String find7DayMeetings() {
        day7 = meetingService.find7DayMeetings();
        canceled = meetingService.findCanceledMeetings();
        return SUCCESS;
    }

    //寻找已经取消的会议
    public String findCanceledMeetings() {
        canceled = meetingService.findCanceledMeetings();
        return SUCCESS;
    }

    //通过用户的id来寻找用户所注册的会议
    public String findMeetingsById(){
        ActionContext actionContext = ActionContext.getContext();
        Integer id = (Integer) actionContext.getSession().get("id");
        reserved = meetingService.findMeetingsById(id);
        return SUCCESS;
    }

    //通过用户的id来寻找邀请用户参加的会议
    public String findAttendMeeting(){
        ActionContext actionContext = ActionContext.getContext();
        Integer id = (Integer) actionContext.getSession().get("id");
        invited = meetingService.findAttendMeeting(id);
        return SUCCESS;
    }
}

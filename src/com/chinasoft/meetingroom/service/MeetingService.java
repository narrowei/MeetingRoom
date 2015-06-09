package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.MeetingDao;

import java.util.List;

/**
 * Created by wei on 15/6/8.
 */
public class MeetingService {
    private MeetingDao meetingDao;

    public void setMeetingDao(MeetingDao meeting) {
        this.meetingDao = meeting;
    }

    public List<Object[]> find7DayMeetings() {
        return meetingDao.find7DayMeetings();
    }

    public List<Object[]> findCanceledMeetings() {
        return meetingDao.findCanceledMeetings();
    }

    public List<Object[]> findMeetingsById(int id) {
        return meetingDao.findMeetingsById(id);
    }

    public List<Object[]> findAttendMeeting(int id) {
        return meetingDao.findAttendMeeting(id);
    }

}

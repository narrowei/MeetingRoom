package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.MeetingParticipantsDao;
import sun.nio.cs.ext.ISCII91;

import java.util.List;

/**
 * Created by wei on 15/6/9.
 */
public class meetingparticipantsService {
    private MeetingParticipantsDao meetingParticipantsDao;

    public void setMeetingParticipantsDao(MeetingParticipantsDao meetingParticipantsDao) {
        this.meetingParticipantsDao = meetingParticipantsDao;
    }

    public List<Object[]> getEmployeesByMeetingId(int id) {
        return meetingParticipantsDao.getEmployeesByMeetingId(id);
    }
}

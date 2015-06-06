package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.MeetingRoomDao;
import com.chinasoft.meetingroom.model.EmployeeEntity;
import com.chinasoft.meetingroom.model.MeetingEntity;
import com.chinasoft.meetingroom.model.MeetingRoomEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wei on 15/6/6.
 */
public class MeetingRoomService {

    private MeetingRoomDao meetingRoomDao;

    public void setMeetingRoomDao(MeetingRoomDao meetingRoomDao) {

        this.meetingRoomDao = meetingRoomDao;
    }

    public List<MeetingRoomEntity> findAllMeetingRoom() {
        return meetingRoomDao.findall(MeetingRoomEntity.class);
    }

    public void deleteMeetingRoom(MeetingRoomEntity meetingRoomEntity) {
        meetingRoomDao.delete(meetingRoomEntity);
    }

    public Serializable saveMeetingRoom(MeetingRoomEntity meetingRoomEntity) {
       return meetingRoomDao.save(meetingRoomEntity);
    }

    public void updateMeetingRoom(MeetingRoomEntity meetingRoomEntity) {
        meetingRoomDao.update(meetingRoomEntity);
    }

    public MeetingRoomEntity findMeetingRoom(Serializable Id) {
        return meetingRoomDao.get(MeetingRoomEntity.class, Id);
    }
}

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

    public List<Object[]> findMeetingRoomByWord(int offset, int length, String meetingName, String roomName,
                                                String reservername, String berforeReserve, String AfterReserve, String beforeEnd, String afterEnd) {

        if(meetingName.equals("")&&roomName.equals("")&&reservername.equals("")&&berforeReserve.equals("")&&beforeEnd.equals("")&&AfterReserve.equals("")&&afterEnd.equals("")){
            meetingName="%%";
            roomName = "%%";
            reservername = "%%";
        }
        if(!meetingName.equals(""))
            meetingName = "%" + meetingName + "%";
        if(!roomName.equals(""))
            roomName = "%" + roomName + "%";
        if(!reservername.equals(""))
            reservername = "%" + reservername + "%";
        return meetingRoomDao.findMeetingRoomByWords(offset, length, meetingName, roomName, reservername, berforeReserve, AfterReserve, beforeEnd, afterEnd);
    }

    public long getMeetingsSize(String meetingName, String roomName,
                                String reservername, String berforeReserve, String AfterReserve, String beforeEnd, String afterEnd) {

        if(meetingName.equals("")&&roomName.equals("")&&reservername.equals("")&&berforeReserve.equals("")&&beforeEnd.equals("")&&AfterReserve.equals("")&&afterEnd.equals("")){
            meetingName="%%";
            roomName = "%%";
            reservername = "%%";
        }
        if(!meetingName.equals(""))
            meetingName = "%" + meetingName + "%";
        if(!roomName.equals(""))
            roomName = "%" + roomName + "%";
        if(!reservername.equals(""))
            reservername = "%" + reservername + "%";
        return meetingRoomDao.getMeetingsSize(meetingName, roomName, reservername, berforeReserve, AfterReserve, beforeEnd, afterEnd);
    }
}

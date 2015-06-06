package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.dao.EmployeeDao;
import com.chinasoft.meetingroom.model.MeetingRoomEntity;
import com.chinasoft.meetingroom.service.MeetingRoomService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.scenario.animation.shared.PulseReceiver;

import java.util.List;

/**
 * Created by wei on 15/6/6.
 */
public class MeetingRoomAction extends ActionSupport {
    private MeetingRoomService meetingRoomService;
    private int id;
    private String roomnumber;
    private String capacity;
    private int roomcapacity;
    private int status;
    private String description;
    private MeetingRoomEntity meetingRoom;

    public void setMeetingRoom(MeetingRoomEntity meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getRoomcapacity() {
        return roomcapacity;
    }

    public void setRoomcapacity(int roomcapacity) {
        this.roomcapacity = roomcapacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MeetingRoomEntity> meetingRooms;

    public List<MeetingRoomEntity> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoomEntity> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public void setMeetingRoomService(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    public String showAllMeetingRoom() {
        meetingRooms = meetingRoomService.findAllMeetingRoom();
        return SUCCESS;
    }

    public String SaveMeetingRoom() {
        MeetingRoomEntity meetingRoomEntity = new MeetingRoomEntity(roomnumber, capacity, roomcapacity, status, description);
        meetingRoomService.saveMeetingRoom(meetingRoomEntity);
        return SUCCESS;
    }

    public String updateMeetingRoom() {
        MeetingRoomEntity meetingRoomEntity = meetingRoomService.findMeetingRoom(id);
        meetingRoomEntity.setDescription(description);
        meetingRoomEntity.setRoomCode(roomnumber);
        meetingRoomEntity.setRoomName(capacity);
        meetingRoomEntity.setRoomStatus(status);
        meetingRoomEntity.setRoomCapacity(roomcapacity);
        meetingRoomService.updateMeetingRoom(meetingRoomEntity);
        return SUCCESS;
    }

    public String readMeetingRoom() {
        meetingRoom = meetingRoomService.findMeetingRoom(id);
        return SUCCESS;
    }


}

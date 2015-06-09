package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.dao.EmployeeDao;
import com.chinasoft.meetingroom.model.MeetingRoomEntity;
import com.chinasoft.meetingroom.service.MeetingRoomService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.scenario.animation.shared.PulseReceiver;

import java.security.PrivateKey;
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
    private int offset;
    private int length;
    private String meetingName;
    private String roomName;
    private String reservername;
    private String berforeReserve;
    private String AfterReserve;
    private String beforeEnd;
    private String afterEnd;
    private List<Object[]> o;
    private int pagenum;
    private long count;
    private int currentPage;
    private int page;

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Object[]> getO() {
        return o;
    }

    public void setO(List<Object[]> o) {
        this.o = o;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getReservername() {
        return reservername;
    }

    public void setReservername(String reservername) {
        this.reservername = reservername;
    }

    public String getBerforeReserve() {
        return berforeReserve;
    }

    public void setBerforeReserve(String berforeReserve) {
        this.berforeReserve = berforeReserve;
    }

    public String getAfterReserve() {
        return AfterReserve;
    }

    public void setAfterReserve(String afterReserve) {
        AfterReserve = afterReserve;
    }

    public String getBeforeEnd() {
        return beforeEnd;
    }

    public void setBeforeEnd(String beforeEnd) {
        this.beforeEnd = beforeEnd;
    }

    public String getAfterEnd() {
        return afterEnd;
    }

    public void setAfterEnd(String afterEnd) {
        this.afterEnd = afterEnd;
    }

    public MeetingRoomEntity getMeetingRoom() {
        return meetingRoom;
    }

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

    public String finalMeetingRoomByWord() { if(pagenum!=0){
        offset = (int) (pagenum * 5 - 4);
        o = meetingRoomService.findMeetingRoomByWord(offset, 6, meetingName, roomName,
                reservername, berforeReserve, AfterReserve, beforeEnd, afterEnd);        pagenum = 0;
        return SUCCESS;

    }else {
        count = meetingRoomService.getMeetingsSize(meetingName, roomName,
                reservername, berforeReserve, AfterReserve, beforeEnd, afterEnd);
        if (count <= 5) {
            page = 1;
        } else {
            page = (int) Math.ceil(count / 5.0);
        }
        currentPage = (int) (offset / 5 + 1);
        o = meetingRoomService.findMeetingRoomByWord(offset, 6, meetingName, roomName,
                reservername, berforeReserve, AfterReserve, beforeEnd, afterEnd);
        return SUCCESS;
    }
    }





}

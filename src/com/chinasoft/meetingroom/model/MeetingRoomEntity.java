package com.chinasoft.meetingroom.model;

/**
 * Created by wei on 15/5/29.
 */
public class MeetingRoomEntity {
    private Integer roomId;
    private String roomCode;
    private String roomName;
    private Integer roomCapacity;
    private Integer roomStatus;
    private String description;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingRoomEntity that = (MeetingRoomEntity) o;

        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (roomCode != null ? !roomCode.equals(that.roomCode) : that.roomCode != null) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (roomCapacity != null ? !roomCapacity.equals(that.roomCapacity) : that.roomCapacity != null) return false;
        if (roomStatus != null ? !roomStatus.equals(that.roomStatus) : that.roomStatus != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (roomCode != null ? roomCode.hashCode() : 0);
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (roomCapacity != null ? roomCapacity.hashCode() : 0);
        result = 31 * result + (roomStatus != null ? roomStatus.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

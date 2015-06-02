package com.chinasoft.meetingroom.model;

import java.sql.Timestamp;

/**
 * Created by wei on 15/5/29.
 */
public class MeetingEntity {
    private Integer meetingId;
    private String meetingName;
    private Integer roomId;
    private Integer reservationistId;
    private Integer numOfParticipants;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Timestamp reservationTime;
    private Timestamp canceledTime;
    private Integer meetingStatus;
    private String description;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getReservationistId() {
        return reservationistId;
    }

    public void setReservationistId(Integer reservationistId) {
        this.reservationistId = reservationistId;
    }

    public Integer getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(Integer numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Timestamp getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(Timestamp canceledTime) {
        this.canceledTime = canceledTime;
    }

    public Integer getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(Integer meetingStatus) {
        this.meetingStatus = meetingStatus;
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

        MeetingEntity that = (MeetingEntity) o;

        if (meetingId != null ? !meetingId.equals(that.meetingId) : that.meetingId != null) return false;
        if (meetingName != null ? !meetingName.equals(that.meetingName) : that.meetingName != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (reservationistId != null ? !reservationistId.equals(that.reservationistId) : that.reservationistId != null)
            return false;
        if (numOfParticipants != null ? !numOfParticipants.equals(that.numOfParticipants) : that.numOfParticipants != null)
            return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (reservationTime != null ? !reservationTime.equals(that.reservationTime) : that.reservationTime != null)
            return false;
        if (canceledTime != null ? !canceledTime.equals(that.canceledTime) : that.canceledTime != null) return false;
        if (meetingStatus != null ? !meetingStatus.equals(that.meetingStatus) : that.meetingStatus != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = meetingId != null ? meetingId.hashCode() : 0;
        result = 31 * result + (meetingName != null ? meetingName.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (reservationistId != null ? reservationistId.hashCode() : 0);
        result = 31 * result + (numOfParticipants != null ? numOfParticipants.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (reservationTime != null ? reservationTime.hashCode() : 0);
        result = 31 * result + (canceledTime != null ? canceledTime.hashCode() : 0);
        result = 31 * result + (meetingStatus != null ? meetingStatus.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

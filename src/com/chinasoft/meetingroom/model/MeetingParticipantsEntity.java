package com.chinasoft.meetingroom.model;

/**
 * Created by wei on 15/6/2.
 */
public class MeetingParticipantsEntity {
    private Integer mpId;
    private Integer meetingId;
    private Integer participantId;

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingParticipantsEntity that = (MeetingParticipantsEntity) o;

        if (mpId != null ? !mpId.equals(that.mpId) : that.mpId != null) return false;
        if (meetingId != null ? !meetingId.equals(that.meetingId) : that.meetingId != null) return false;
        if (participantId != null ? !participantId.equals(that.participantId) : that.participantId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mpId != null ? mpId.hashCode() : 0;
        result = 31 * result + (meetingId != null ? meetingId.hashCode() : 0);
        result = 31 * result + (participantId != null ? participantId.hashCode() : 0);
        return result;
    }
}

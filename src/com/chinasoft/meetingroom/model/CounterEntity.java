package com.chinasoft.meetingroom.model;

/**
 * Created by wei on 15/5/29.
 */
public class CounterEntity {
    private Integer visitcount;

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CounterEntity that = (CounterEntity) o;

        if (visitcount != null ? !visitcount.equals(that.visitcount) : that.visitcount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return visitcount != null ? visitcount.hashCode() : 0;
    }
}

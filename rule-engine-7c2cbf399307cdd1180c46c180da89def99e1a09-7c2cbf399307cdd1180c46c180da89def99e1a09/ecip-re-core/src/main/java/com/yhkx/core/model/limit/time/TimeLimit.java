package com.yhkx.core.model.limit.time;

/**
 * @author LiSs
 * @date on 2018/7/6
 */
public class TimeLimit {
    private Long expTime;
    private Long duration;

    public TimeLimit() {
    }

    public TimeLimit(Long expTime, Long duration) {
        this.expTime = expTime;
        this.duration = duration;
    }

    public Long getExpTime() {
        return expTime;
    }

    public void setExpTime(Long expTime) {
        this.expTime = expTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}

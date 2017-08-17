package com.suis.logistics;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateDto {
	private Integer id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime currentDate;

	public DateDto(Integer id, LocalDateTime currentDate) {
		super();
		this.id = id;
		this.currentDate = currentDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}



}

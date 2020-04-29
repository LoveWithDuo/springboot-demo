package com.example.demo.redisTest;

public class User {
	private Long UserId;
	
	private Long rank;
	
	private Long score;

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	
	
}

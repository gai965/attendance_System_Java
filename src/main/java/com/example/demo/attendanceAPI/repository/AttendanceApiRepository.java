package com.example.demo.attendanceAPI.repository;

import java.io.IOException;

import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.attendanceAPI.data.Clocks;

@Repository
public class AttendanceApiRepository {

	public Clocks[] getEmployeeAttendance(int employeeId) throws IOException {
		RestTemplate rest = new RestTemplate();

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/clock?employeeId={employeeId}";

		ResponseEntity<String> response = rest.getForEntity(url, String.class, employeeId);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Clocks[] employeeAttendance = mapper.readValue(json, Clocks[].class);

		return employeeAttendance;
	}

	public void registerAttendance(int employeeId, String type, String fdate) throws IOException {
		// RestTemplateのインスタンスを作成
		RestTemplate rest = new RestTemplate();
		// 勤怠情報GETのURL
		String getUrl = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/clock?employeeId={employeeId}";
		// GETリクエストの送信
		ResponseEntity<Clocks[]> response = rest.getForEntity(getUrl, Clocks[].class, employeeId);
		// レスポンスの取得
		Clocks[] json = response.getBody();
		// レスポンスの配列から0番目を取得してclocksに代入
		Clocks clocks = json[0];

		// クリックしたボタンによって登録箇所を決める
		switch (type) {
		case "clockIn":
			clocks.setClockIn(fdate);
			break;
		case "breakStart":
			clocks.setBreakStart(fdate);
			break;
		case "breakEnd":
			clocks.setBreakEnd(fdate);
			break;
		case "clockOut":
			clocks.setClockOut(fdate);
			break;
		}

		ObjectMapper mapper = new ObjectMapper();
		// JavaオブジェクトをJSON文字列に変換
		String jsonString = mapper.writeValueAsString(json);
		// 変換確認用
		// System.out.println(jsonString);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> requestEntity = new HttpEntity<>(jsonString, headers);

		ResponseEntity<String> responseEntity = rest.postForEntity(
				"https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/clock",
				requestEntity, String.class);

		// 登録が上手くいっているのか確認 
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("上手くいってます");
		} else {
			System.out.println("失敗してます");
		}
	}
}
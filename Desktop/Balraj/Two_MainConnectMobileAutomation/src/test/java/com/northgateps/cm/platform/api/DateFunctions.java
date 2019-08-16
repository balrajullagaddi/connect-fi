package com.northgateps.cm.platform.api;

//DATE RELATED FUNCTIONS FOR GETTING THE RELATIVE DATES

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class DateFunctions {

	public DateFunctions() throws Exception {
		System.out.println(this.getClass().getName() + " is running..");
	}

	public static String GetTodayDate() {
		// Create Today Date from system date/Time
		// Today Date
		String TodayDateX1 = null;
		Date TodayDate = new Date();
		String TodayDateX = FormatDate(TodayDate, TodayDateX1);

		return TodayDateX;
	}

	public static String GetAdjustedDate(int Days) {
		// Adjust Date by number of days sent in.
		String AdjDateX1 = null;
		Date TodayDate = new Date();
		Date AdjDate = addDays(TodayDate, Days);
		String AdjDateX = FormatDate(AdjDate, AdjDateX1);

		return AdjDateX;
	}

	public static String GetYear(int Years, String InputDate) throws ParseException {
		// Adjust Date by number of days sent in.
		String AdjDateX1 = null;
		Date TDate = new SimpleDateFormat("dd/MM/yyyy").parse(InputDate);
		Date AdjDate = addYears(TDate, Years);
		String AdjDateX = FormatDate(AdjDate, AdjDateX1);

		return AdjDateX;
	}

	public static String GetAdjustedDate_Months(int Months) {
		// Adjust Date by number of Months sent in.
		String AdjDateX1 = null;
		Date TodayDate = new Date();
		Date AdjDate = addMonth(TodayDate, Months);
		String AdjDateX = FormatDate(AdjDate, AdjDateX1);

		return AdjDateX;
	}

	public static String GetAdjustedDate_Years(int Years) {
		// Adjust Date by number of Years sent in.
		String AdjDateX1 = null;
		Date TodayDate = new Date();
		Date AdjDate = addYears(TodayDate, Years);
		String AdjDateX = FormatDate(AdjDate, AdjDateX1);

		return AdjDateX;
	}

	public static String convertToDate_yyyyMMdd(String inputdate) throws ParseException {
		Date TDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate);
		String TDate_string = new SimpleDateFormat("yyyy-MM-dd").format(TDate);
		return TDate_string;
	}

	public static String convertToShortDate(String inputdate) throws ParseException {
		Date date_short = new SimpleDateFormat("dd/MM/yy").parse(inputdate);
		String date_shortString = new SimpleDateFormat("dd/MM/yy").format(date_short);
		return date_shortString;
	}

	public static String GetDate_2(int Days, String InputDate) throws ParseException {
		// Adjust Date by number of days sent in.
		String AdjDateX1 = null;
		Date TDate = new SimpleDateFormat("dd/MM/yyyy").parse(InputDate);
		Date AdjDate = addDays(TDate, Days);
		String AdjDateX = FormatDate(AdjDate, AdjDateX1);

		return AdjDateX;
	}
	
	public static String FormatDate(Date date, String FormatDate) {
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		FormatDate = sdf.format(date);
		return FormatDate;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, +days);
		return cal.getTime();
	}

	public static Date addYears(Date date, int Years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// Convert Years to Days
		Years = (Years * 365);
		cal.add(Calendar.DATE, +Years);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int Months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// Convert Years to Days
		Months = (Months * 30);
		cal.add(Calendar.DATE, +Months);
		return cal.getTime();
	}
	
	public static String getCurrentTime() {
		String currTime = "";
		Date date = new Date();
		String strTimeFormat = "hh:mm";
		DateFormat timeFormat = new SimpleDateFormat(strTimeFormat);
		currTime= timeFormat. format(date);
		return currTime;
	}
	
	

}

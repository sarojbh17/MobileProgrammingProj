package com.example.cam;

import java.util.ArrayList;

import com.example.cam.bean.AttendanceBean;
import com.example.cam.bean.AttendanceSessionBean;
import com.example.cam.bean.FacultyBean;
import com.example.cam.bean.StudentBean;
import com.example.cam.db.DBAdapter;
import com.example.cam.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity {

	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_main);
		
		submit=(Button)findViewById(R.id.button1);
		
		
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				DBAdapter dbAdapter = new DBAdapter(TestActivity.this);
				AttendanceSessionBean attendanceSessionBean = new AttendanceSessionBean();
				
				
				attendanceSessionBean.setAttendance_session_faculty_id(1);
				attendanceSessionBean.setAttendance_session_program("BCA");
				attendanceSessionBean.setAttendance_session_semester("6");
				attendanceSessionBean.setAttendance_session_date("15/04/2022");
				attendanceSessionBean.setAttendance_session_subject("DataBase");
				
				dbAdapter.addAttendanceSession(attendanceSessionBean);
				Log.d("add", "inserted");
				
				/*AttendanceSessionBean bean = new AttendanceSessionBean();
				bean=dbAdapter.getAttendance();
				Log.d("AsessionId", bean.getAttendance_session_id()+"");
				Log.d("fId", bean.getAttendance_session_faculty_id()+"");
				Log.d("class", bean.getAttendance_session_class());
				Log.d("dept", bean.getAttendance_session_department());
				Log.d("fId", bean.getAttendance_session_faculty_id()+"");
				Log.d("status", bean.getAttendance_session_class());
				
				FacultyBean facultyBean = new FacultyBean();
				
				facultyBean.setFaculty_firstname("Abc");
				facultyBean.setFaculty_lastname("a");
				facultyBean.setFaculty_mobilenumber("9898989898");
				facultyBean.setFaculty_address("pune");
				facultyBean.setFaculty_username("a");
				facultyBean.setFaculty_password("Abc123");
				
				dbAdapter.addFaculty(facultyBean);
				
				StudentBean studentBean = new StudentBean();
				
				studentBean.setStudent_firstname("b");
				studentBean.setStudent_lastname("b");
				studentBean.setStudent_mobilenumber("8989898988");
				studentBean.setStudent_address("pune");
				studentBean.setStudent_department("CSE");
				studentBean.setStudent_class("BE");
				
				dbAdapter.addStudent(studentBean);*/
				
				
				
				ArrayList<AttendanceSessionBean> attendanceSessionBeanList = dbAdapter.getAllAttendanceSession();
				
				for(AttendanceSessionBean sessionBean : attendanceSessionBeanList)
				{
					Log.d("for", "in for loop");
					int aid = sessionBean.getAttendance_session_id();
					int fid = sessionBean.getAttendance_session_faculty_id();
					String ssem = sessionBean.getAttendance_session_semester();
					String program = sessionBean.getAttendance_session_program();
					String date=  sessionBean.getAttendance_session_date();
					String sub= sessionBean.getAttendance_session_subject();
					Log.d("id", aid+"");
					Log.d("fid", fid+"");
					Log.d("ssem", ssem);
					Log.d("program",program);
					Log.d("date", date);
					Log.d("sub", sub);
				}
			}
		});
		
		
		
		
		
		
		
		
		
	}

	

}

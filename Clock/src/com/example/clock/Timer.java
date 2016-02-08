package com.example.clock;


public class Timer {
	
	private String class_name;
	
	protected int starting_hour;
	protected int starting_minute;
	protected int starting_second;
	
	protected int current_hour;
	protected int current_minute;
	protected int current_second;
	
	protected int num_times_display =0;
	
	protected boolean mode12hour =false;
	
	
	
	
	
	public Timer(int second, int minute, int hour) {
		
		class_name = getClass().getName();
		
		starting_second = second;
		starting_minute = minute;
		starting_hour = hour;
		
		current_second = second;
		current_minute = minute;
		current_hour = hour;
		
	}
	
	
	public int[] updateTime(int previous_seconds, int previous_minutes, int previous_hour) {
		
		int[] my_time_array = new int[3];
		
		int next_seconds = previous_seconds;
		
		int next_minutes = previous_minutes;
		
		int next_hour = previous_hour;
		
		if(previous_seconds!= 59) {
			
			next_seconds = previous_seconds +1;
		}
		
		else if (previous_seconds ==59) {
			
			next_seconds = 0;
			
			if(previous_minutes!= 59) {
				next_minutes = previous_minutes +1;
			}
			
			else if(previous_minutes == 59) {
				next_minutes =0;
				
				if(mode12hour == true) {
					
					if(previous_hour!=12) {
						
						next_hour = previous_hour +1;
					}
					
					else if (previous_hour ==12) {
						
						next_hour = 1;
					}
					
				}
					
				
				else if (mode12hour ==false) {
					
					if(previous_hour!=23) {
						
						next_hour = previous_hour +1;
					}
					
					else if (previous_hour ==23) {
						
						next_hour = 0;
					}
				}
					
				
			}
			
		}
		
		my_time_array[0] = next_seconds;
		my_time_array[1] = next_minutes;
		my_time_array[2] = next_hour;
		
		return(my_time_array);
	
	
	}

	
	public String display()  {
		
		String display;
		
		
		
		if(num_times_display == 0) {
			
			display = String.format("%d", current_hour) + ":" + String.format("%02d", current_minute) + ":" + String.format("%02d", current_second);
			num_times_display =1;
			
		}
		
		else {
			
			int[] my_time_array = new int[3];
			
			my_time_array = updateTime(current_second,current_minute,current_hour);
			
			current_second = my_time_array[0];
			current_minute = my_time_array[1];
			current_hour = my_time_array[2];
			
			display = String.format("%d", current_hour) + ":" + String.format("%02d", current_minute) + ":" + String.format("%02d", current_second);
			
		}
		
		
		
		
		
		
		
		return(display);
		
		
	}
	
	
}
package companies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Nitin Agrawal
 * @Date 03-Apr-2020
 */
public class DelphixData {

	private String input = "";
	private Map<Integer, List<Station>> records = null;
	private Set<Integer> times = null;
	private String address = "";
	private String currentTime = null;

	public DelphixData(String address) {
		records = new HashMap<>();
		times = new HashSet<>();
		this.address = address;
	}

	public static void main(String[] args) {
		try {
			String address = "http://api.bart.gov/api/etd.aspx?cmd=etd&orig=MONT&key=MW9S-E7SL-26DU-VV8V&json=y&pretty=true";
			DelphixData delphixData = new DelphixData(address);
			delphixData.processData();
			
			// Case1 : TrainCount = 10
			System.out.println("==============Case1(Trains:10)==============");
			delphixData.printData(10);

			// Case2 : TrainCount = 5
			System.out.println("\n==============Case2(Trains:5)==============");
			delphixData.printData(5);

			// Case3 : TrainCount = 1
			System.out.println("\n==============Case3(Trains:1)==============");
			delphixData.printData(1);

			// Case4 : TrainCount = 0
			System.out.println("\n==============Case4(Trains:0)==============");
			delphixData.printData(0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Process the received JSON data to store in required Data structures.
	 * @throws IOException
	 */
	private void processData() throws IOException {
		List<Station> stations = null;
		ArrayList<String> statements = getData().parseData();
		currentTime = getTime(statements);
		String destination = "";
		Integer time = 0;
		for(String line : statements) {
			if(line.contains("destination")) {
				destination = line.split("destination\":")[1].trim().split("\"")[1];
			} else if(line.contains("minutes")) {
				if(!line.contains("Leaving"))						
					time = Integer.parseInt(line.split("minutes\":")[1].trim().split("\"")[1]);
				else
					time = 0;
			} else if(line.contains("platform")) {
				int platform = Integer.parseInt(line.split("platform\":")[1].trim().split("\"")[1]);
				if((stations = records.get(time)) == null)
					stations = new ArrayList<>();
				stations.add(new Station(destination, platform));
				times.add(time);
				records.put(time, stations);
			}
		}
	}

	/**
	 * Prints the data in the given format.
	 */
	private void printData(int trainCount) {
		System.out.println("--------------------------------");
		System.out.println("Montgomery St.    " + currentTime);
		System.out.println("--------------------------------");
		if(times.size() == 0) {
			System.out.println("No trains are scheduled yet.");
			return;
		}
		System.out.println(String.format("%-17s %-17s %-1s", "Leaving In","To Station"," From Platform #"));
		System.out.println("--------------------------------");
		if(trainCount < 1)
			return;
		ArrayList<Integer> timesList = new ArrayList<>(times);
		Collections.sort(timesList);
		for(int time : timesList) {
			List<Station> stationList = records.get(time);
			Collections.sort(stationList);
			for(Station station : stationList) {
				if(trainCount < 1)
					return;
				System.out.println(String.format("%-17s %-23s %-4d", (time+" min"), station.name, station.platform));
				trainCount--;
			}
		}
	}

	/**
	 * @param address
	 * @return JSON data received from the given URL
	 * @throws IOException
	 */
	private DelphixData getData() throws IOException {
		URL url = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output = null;
		while ((output = br.readLine()) != null) {
			input = input + output + "\n";
		} 
		conn.disconnect();
		return this;
	}

	/**
	 * Splits the JSON string into required pieces.
	 * @return ArrayList of processed Strings
	 */
	private ArrayList<String> parseData() {
		String[] lines = input.split(",");
		ArrayList<String> statements = new ArrayList<>();
		for(String line : lines) {
			String[] rows = line.split("\r\n");
			for(String row : rows) {
				statements.add(row);
			}
		}
		return statements;
	}

	/**
	 * @param statements
	 * @return the time given in JSON data else returns the local time.
	 */
	private String getTime(ArrayList<String> statements) {
		String time = "";
		int len = statements.size();

		for(int i = 0; i < len; i++) {
			String line = statements.get(i);
			if(line.contains("time")) {
				time = line.split(":\"")[1].trim().split("\"")[0];
				break;
			} else if (line.contains("destination")) {
				break;
			} else {
				statements.remove(i);
				i--;
			}
		}
		if(time.isEmpty()) {
			time = getLocalTime();
		}
		return time;
	}

	/**
	 * @return Current local time as String
	 */
	private static String getLocalTime() {
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);
		return formattedDate;
	}
	
	class Station implements Comparable<Station>{
		String name;
		int platform;
		
		public Station(String name, int platform) {
			this.name = name;
			this.platform = platform;
		}
		
		@Override
		public int compareTo(Station stn) {
			return this.name.compareTo(stn.name);
		}
	}
}
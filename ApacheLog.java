package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ApacheLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* String input[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };*/
		String input[] = new String[] {
			        "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
			        "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
			        "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
			        "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
			        "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234", };
        String result = findTopIpaddress(input);
        System.out.println(result);
	}
	public static String findTopIpaddress(String[] inputs) {
		// using java 8
		/*Arrays.stream(inputs).forEach((line)->{
			String ipAddress = line.split(" ")[0];
		    Integer count = hm.getOrDefault(ipAddress, 0);
		    hm.put(ipAddress, count + 1);	
		});
		
		StringJoiner sj = new StringJoiner(",");
	    Integer max = hm.entrySet().stream()
	        .max((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).get()
	        .getValue();
	        
	    hm.entrySet().stream().filter(p -> max == p.getValue())
	        .sorted((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1)
	        .forEach(p -> sj.add(p.getKey()));
	    return sj.toString();
	    */
		HashMap<String,Integer> hm= new HashMap<>();
		for(int i=0;i<inputs.length;i++) {
			String tmp=inputs[i].split(" ")[0];
			if(hm.containsKey(tmp)) {
				Integer xx=hm.get(tmp);
				hm.put(tmp, xx+1);
			}else{
				hm.put(tmp, 1);
			}
		}
		
		int maxValue=Integer.MIN_VALUE;
		for(Entry<String,Integer> hh: hm.entrySet()) {
			if(hh.getValue()>maxValue)
				maxValue=hh.getValue();
		}
		//System.out.println(maxValue);
		List<String> topIp= new ArrayList<>();
		for(Entry<String,Integer> hh1: hm.entrySet()) {
			if(hh1.getValue() == maxValue ) {
				topIp.add(hh1.getKey());
			}
		}
		Collections.sort(topIp);
		return String.join(",", topIp);
    }

}	

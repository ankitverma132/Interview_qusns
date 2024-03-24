//Convert String to Map<String,String>


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMap {

	public static void main(String[] args) {
		
		String utilMapString = "a-1,b-2,c-3,d-4";
		
		Map<String, String> reconstructedUtilMap = Arrays.stream(utilMapString.split(","))
	            										 .map(s -> s.split("-"))
	            										 .collect(Collectors.toMap(s -> s[0], s -> s[1]));
		
		reconstructedUtilMap.entrySet()
							.forEach(entry -> {
												System.out.println(entry.getKey() + " " + entry.getValue());
											  });
	}
}
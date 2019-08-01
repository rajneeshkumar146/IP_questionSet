package june1;

import java.util.HashMap;

public class encode_decode_tiny_URL {

	
	
	HashMap<Integer, String> map = new HashMap<>();

	public String encode(String longUrl) {
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyurl.com/" + longUrl.hashCode();
	}

	public String decode(String shortUrl) {
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}

}

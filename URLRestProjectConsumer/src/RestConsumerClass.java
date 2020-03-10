import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestConsumerClass {
	public static void main(String[] args) {
		String line;
		StringBuilder stringBuilder = new StringBuilder();
		//Solution-1:
		//Solution for 2nd Challenge from test:
		//Read URL output as inputStream and processed as string parsing using Regex:		
		System.out.println("\n\nSolution for 2nd Problem in challenge using solution-1:");
		try {
			URL url1 = new URL("http://localhost:8081/customers");
			InputStream inputStream = (InputStream) url1.openStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			while((line = bufferedReader.readLine()) != null)
			{
				stringBuilder.append(line);
			}
			
			String s = stringBuilder.toString();
			Matcher m= Pattern.compile("\\[.*\\]").matcher(s);

			while(m.find())
			{
				String machedString = m.group(0);
				//System.out.println(machedString);
				String[] hobbies = machedString.split(",");
				List<String> hobbiesList = Arrays.asList(hobbies).stream().map(a->a.replace("[", ""))
				.map(b->b.replace("\"", ""))
				.map(c->c.replace("]", ""))
				.collect(Collectors.toList());
				hobbiesList.stream().forEach(System.out::println);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//=======================================================================
//Solution-2
//Solution for 2nd Challenge from test:
//Using ObjectMapper
		System.out.println("\n\nSolution for 2nd Problem in challenge using solution-2:");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			URL url = new URL("http://localhost:8081/customers");
			Customer customer = objectMapper.readValue(url, Customer.class);
			System.out.println(customer);
			customer.getHobbies().forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//===================================================
//Solution-3
//Solution for 3rd Challenge from test:
//Read URL output as inputStream and processed as string parsing using Regex and objectMapper:	
		System.out.println("\n\nSolution for 3rd Problem in challenge using solution-1:");
		try {
			URL url2 = new URL("http://localhost:8081/getData");
			KeyValue keyValue = objectMapper.readValue(url2, KeyValue.class);
			String[] stringArray = keyValue.getData().split(",");
			Pattern pattern = Pattern.compile("(age=)(.+?)");
			
			List<Integer> age = Arrays.stream(stringArray)
					.filter(pattern.asPredicate())
					.map(s-> s.replaceAll("\\s*(age=)*",""))
					.map(s-> new Integer(Integer.parseInt(s)))
					.filter(s-> s>50)
					.collect(Collectors.toList());
			System.out.println("Number of records with age>50 = " + age.size());
			//age.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

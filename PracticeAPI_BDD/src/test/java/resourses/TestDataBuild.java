package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.LocationPojo;
import pojo.MainPojo;

public class TestDataBuild {
	
	public MainPojo addplacepayload() {
		
		MainPojo M=new MainPojo();
		M.setAccuracy(50);
		M.setAddress("30, side layout, cohen 09");
		M.setLanguage("French-IN");
		M.setPhone_number("(+91) 983 893 3937");
		M.setWebsite("http://google.com");
		M.setName("Frontline house");
		
		List<String> MyList=new ArrayList<String>();
		MyList.add("shoe park");
		MyList.add("shop");
		M.setTypes(MyList);
		
		LocationPojo l=new LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		M.setLocation(l);
		return M;
	}

}

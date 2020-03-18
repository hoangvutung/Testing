package testing.task2;

public enum SECONDPAGE_DATA {
	TITLE("Metal and Colors"),
    SUM(new String[] {"1","3","5","7","2","4","6","8"}),
    ELEMENTS(new String[] {"Water","Earth","Wind","Fire"}),
    COLORS(new String[] {"Colors","Red","Green","Blue","Yellow"}),
    METALS(new String[] {"Col","Gold","Silver","Bronze","Selen"}),
    VEGETABLES(new String[] {"Cucumber","Tomato","Salad","Onion"}),
    RESULT(new String[] {"Summary: 3\n" + 
    		"Color: Colors\n" + 
    		"Metal: Col\n" + 
    		"Vegetables: Salad",
    		"Summary: 7\n" + 
    	    "Color: Colors\n" + 
    	    "Metal: Col\n" + 
    	    "Vegetables: Salad"});
    String[] strArr;
    public String str;
    Integer i;
    SECONDPAGE_DATA(String str){
        this.str = str;
    }
    SECONDPAGE_DATA(String[] strArr){
        this.strArr = strArr;
    }
}
